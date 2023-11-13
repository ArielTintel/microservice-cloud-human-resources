FROM openjdk:11
VOLUME /tmp
ADD ./target/user-0.0.1-SNAPSHOT.jar api-user.jar
ENTRYPOINT ["java","-jar","/api-user.jar"]