# README.md
前段时间看了Docker文档。一直没有来得及实践一下。 

最近抽空搞了一下。

- [使用Docker部署SpringBoot项目](https://blog.cayzlh.com/2019/09/25/2019092501/)
- [使用Docker Compose](https://blog.cayzlh.com/2019/09/26/2019092601/)

----
### 20190928
加上nginx镜像。

```yaml
version: '3'
services:
  app:
    container_name: v-app
    restart: always
    build: .
    working_dir: /app
    volumes:
      - ./:/app
      - ~/.m2:/root/.m2
    expose:
      - "8080"
    depends_on:
      - nginx
      - redisserver
    command: mvn clean spring-boot:run -Dspring-boot.run.profiles=docker
  redisserver:
    restart: always
    container_name: v-redis
    image: "redis:alpine"
    ports:
      - 6379:6379
  nginx:
    container_name: v-nginx
    image: nginx:1.13
    restart: always
    ports:
      - 8081:80
      - 443:443
    volumes:
      - ./nginx:/etc/nginx/conf.d
```

在macOS中，非root用户是无法使用小于1024的常用端口的。如果开发中需要用到80端口, 就要设置端口转发。
这里就不想麻烦了，使用8081来做测试。