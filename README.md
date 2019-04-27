# codeforum
## Overview Service and Port
    
 Service Name | Port | eureka
------------ | ------------- | -------------
codeforum_eureka     | 6868 | yes
codeforum_web        | 9112 | yes
codeforum_user       | 16001| yes
codeforum_message    | 16010| yes
codeforum_contract   | 16011| No


### Third Part Service:
#### Redis:
`docker run -di --name=coderiver_redis -p 6379:6379 redis`

`ps: 出现WARNING:IPv4解决办法:`
`echo 'net.ipv4.ip_forward=1' >> /etc/sysctl.conf`

#### RabbitMq:
`docker run -di --name=coderiver_rabbitmq -p 5671:5671 -p 5672:5672 -p 4369:4369 -p 15671:15671 -p 15672:15672 -p 25672:25672 rabbitmq:management`

`username: guest`

`password: guest`

#### MongoDB:
`docker run -di --name=coderiver_mongo -p 27017:27017 mongo`




