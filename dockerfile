FROM java:8
EXPOSE 8888
ADD /target/virtusaconfigserverdocker-0.0.1-SNAPSHOT.jar virtusaconfigserverdocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","virtusaconfigserverdocker-0.0.1-SNAPSHOT.jar"]
