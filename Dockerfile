FROM jboss/wildfly:latest

MAINTAINER "okularnicy"

ADD webapp/target/web-app.war /opt/jboss/wildfly/standalone/deployments/

RUN wildfly/bin/add-user.sh admin admin --silent

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

