FROM openjdk:11

ADD target/alten-hotel.jar alten-hotel.jar

ENTRYPOINT ["java", "-jar", "alten-hotel.jar"]