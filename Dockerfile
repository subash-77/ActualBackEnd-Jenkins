FROM openjdk:18
WORKDIR /app
COPY ./target/OnlineJewelleryManagementSystem1-0.0.1-SNAPSHOT.jar /app
EXPOSE 1225
CMD ["java", "-jar", "OnlineJewelleryManagementSystem1-0.0.1-SNAPSHOT.jar"]
