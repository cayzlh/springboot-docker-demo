FROM openjdk:8-jdk-alpine

MAINTAINER chenanyu antchenanyu@163.com

VOLUME /tmp

ADD target/springboot-docker-demo-0.0.3.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]