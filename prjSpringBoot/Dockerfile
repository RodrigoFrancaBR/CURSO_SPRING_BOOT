FROM openjdk:8

ADD target/prjSpringBoot-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

expose 8080

#COPY ./target/prjSpringBoot-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
#CMD java -cp /usr/src/prjSpringBoot-0.0.1-SNAPSHOT.jar br.com.franca.Startup
#CMD ""