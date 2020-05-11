FROM openjdk:8
ADD build/libs/br.com.koike.agendaong-0.0.1-SNAPSHOT.jar br.com.koike.agendaong-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "br.com.koike.agendaong-0.0.1-SNAPSHOT.jar" ]