FROM openjdk:11-jre-slim
RUN addgroup --system --gid 2000 krish && \
    adduser --system --uid 2000 --gid 2000 --disabled-password --disabled-login --home /opt/krish krish

WORKDIR /opt/krish
USER krish:krish
ENV JVM_ARGS=""
COPY build/libs/*.jar /opt/krish/app.jar
ENTRYPOINT java -server -XshowSettings -XX:MaxRAMPercentage=75 -Djava.security.egd=file:/dev/./urandom $JVM_ARGS -jar /opt/krish/app.jar