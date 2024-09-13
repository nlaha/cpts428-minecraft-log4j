FROM maven:3.6.3-jdk-11

COPY . /usr/src/app

# rogue-jndi
WORKDIR /usr/src/app/rogue-jndi
RUN mvn package
RUN cp target/RogueJndi-1.1.jar /app.jar

EXPOSE 8080
EXPOSE 1389

ENTRYPOINT ["java","-jar","/app.jar", "-n", "host.docker.internal", "-c", "echo Exploit Success!"]