FROM adoptopenjdk/openjdk8
ARG JAR_FILE=./build/libs/*.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ${JAR_FILE} ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]