FROM openjdk:11-jre-slim
# Add curl and jq
RUN DEBIAN_FRONTEND=noninteractive apt-get update && apt-get install -y curl jq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# Add user/group and create /opt/krish
RUN addgroup --system --gid 2000 krish && \
    adduser --system --uid 2000 --gid 2000 --disabled-password --disabled-login --home /opt/krish krish

# Set working directory
WORKDIR /opt/krish

# Set user/group to run as
USER krish:krish

# Allow ability to override JVM_ARGS
ENV JVM_ARGS=""

# Copy jar file to /opt/krish
COPY build/libs/*.jar /opt/krish/app.jar

EXPOSE 8080

# Arguments can be passed via CMD
ENTRYPOINT java -server -XshowSettings -XX:MaxRAMPercentage=75 -Djava.security.egd=file:/dev/./urandom $JVM_ARGS -jar /opt/krish/app.jar
