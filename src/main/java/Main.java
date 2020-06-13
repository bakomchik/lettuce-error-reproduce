import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.TransactionResult;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.ByteArrayCodec;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RedisURI redisURI = RedisURI.create("redis://127.0.0.1:6379");
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<byte[], byte[]> connect = redisClient.connect(new ByteArrayCodec());
        byte[] value1MB=  new byte[1024*1204];
        Random random = new Random();
        while(!Thread.currentThread().isInterrupted()){
            RedisCommands<byte[], byte[]> sync = connect.sync();
            sync.multi();
            random.nextBytes(value1MB);
            sync.lpush("key".getBytes(),value1MB);
            TransactionResult exec = sync.exec();
            System.out.println(exec);
        }

    }
}
