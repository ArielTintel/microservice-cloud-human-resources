FROM openjdk:11
VOLUME /tmp
ADD ./target/api-worker-0.0.1-SNAPSHOT.jar api-worker.jar
ENTRYPOINT ["java","-jar","/api-worker.jar"]
