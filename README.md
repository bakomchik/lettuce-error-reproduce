# Steps to reproduce
1) Configure redis Redis 6.0.5 (00000000/0) 64 bit with max memory 5mb
 ```
 maxmemory 5mb
 ```
2) build and run main class


****
Excpected: Message in exception is: OOM command not allowed when used memory > 'maxmemory'.'
**** 
Actual : Message in exception is : EXECABORT Transaction discarded because of previous errors.
