FROM openjdk:12-alpine
RUN addgroup -S grupoarpa && adduser -S admin -G grupoarpa
USER admin:grupoarpa
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ADD target/${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -Djava.security.egd=fiile:/dev/./urandom -jar /app.jar"]