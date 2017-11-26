FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD incident.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT exec java -Xms724m -Xmx724m -XX:MaxPermSize128m -Djava.security.egd=file:/dev/./urandom -jar -jar /app.jar