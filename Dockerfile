FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY webapp/target/web-app.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp