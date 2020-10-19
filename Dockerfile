FROM openjdk:11-jre-slim
MAINTAINER huisheng.jin "huisheng.jinge@gmail.com"
WORKDIR /opt/app
ARG APP_JAR=build/libs/*.jar
COPY ${APP_JAR} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
