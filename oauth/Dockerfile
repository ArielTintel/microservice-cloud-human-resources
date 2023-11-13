FROM openjdk:11
VOLUME /tmp
ADD ./target/oauth-0.0.1-SNAPSHOT.jar api-oauth.jar
ENTRYPOINT ["java","-jar","/api-oauth.jar"]