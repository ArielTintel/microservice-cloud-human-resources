FROM openjdk:11
VOLUME /tmp
ADD ./target/api-payroll-0.0.1-SNAPSHOT.jar api-payroll.jar
ENTRYPOINT ["java","-jar","/api-payroll.jar"]