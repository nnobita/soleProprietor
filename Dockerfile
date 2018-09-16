FROM openjdk:8-jre-alpine
MAINTAINER hosaka.nobuyuki
COPY target/soleProprietor-0.0.1-SNAPSHOT.jar /opt/spring-cloud/lib/
ENV SPRING_APPLICATION_JSON \ 
  '{"spring": {"cloud": {"config": {"server": \
  {"git": {"uri": "/var/lib/spring-cloud/config-repo", \
  "clone-on-start": true}}}}}}'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-cloud/lib/soleProprietor-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080