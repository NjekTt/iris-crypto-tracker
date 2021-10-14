FROM openjdk:8 AS builder

ARG APP_HOME=/tmp/app

COPY src $APP_HOME/src

COPY --from=intersystemsdc/jgw:latest /jgw/*.jar $APP_HOME/jgw/

WORKDIR $APP_HOME/jar/
ADD https://repo1.maven.org/maven2/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar .
ADD https://repo1.maven.org/maven2/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar .
ADD https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar .
ADD https://repo1.maven.org/maven2/org/json/json/20160810/json-20160810.jar .

WORKDIR $APP_HOME/src

RUN javac -classpath $APP_HOME/jar/*:$APP_HOME/jgw/* Crypto/rmq/CryptoService.java && \
    jar -cvf $APP_HOME/jar/CryptoService.jar Crypto/rmq/CryptoService.class

FROM intersystemsdc/jgw:latest

COPY --from=builder /tmp/app/jar/*.jar $GWDIR/
