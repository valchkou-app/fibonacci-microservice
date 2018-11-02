FROM openjdk

ENV APP_HOME /opt/app
ENV JAR_NAME app.jar

EXPOSE 8080

RUN apt-get update && \
    apt-get -y install unzip curl jq uuid-runtime && \
    mkdir -p ${APP_HOME}

COPY run.sh ${APP_HOME}/run.sh
COPY ./build/libs/${JAR_NAME} ${APP_HOME}/${JAR_NAME}

RUN chmod a+x ${APP_HOME}/run.sh

ENTRYPOINT ["/opt/app/run.sh"]