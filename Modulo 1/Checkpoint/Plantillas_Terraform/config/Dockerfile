FROM jenkins/jenkins:2.375.1-jdk11

USER root

RUN apt-get update && apt-get install -y lsb-release && apt-get install -y wget

RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg

RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list

RUN wget -O- https://apt.releases.hashicorp.com/gpg | \
    gpg --dearmor | \
    tee /usr/share/keyrings/hashicorp-archive-keyring.gpg

RUN echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] \
    https://apt.releases.hashicorp.com $(lsb_release -cs) main" | \
        tee /etc/apt/sources.list.d/hashicorp.list

RUN apt-get update && apt-get install -y docker-ce-cli && \
    apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common && \
        apt-get install -qqy docker-ce

RUN apt-get install terraform

# Downloading and installing Maven
ARG MAVEN_VERSION=3.8.6
ARG USER_HOME_DIR="/root"
ARG SHA=f790857f3b1f90ae8d16281f902c689e4f136ebe584aba45e4b1fa66c80cba826d3e0e52fdd04ed44b4c66f6d3fe3584a057c26dfcac544a60b301e6d0f91c26
ARG BASE_URL=https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref
RUN echo "Downlaoding maven"
RUN curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz
RUN echo "Checking download hash"
RUN echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c -
RUN echo "Unziping maven"
RUN tar xzfv /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1
RUN echo "Cleaning and setting links"
RUN rm -f /tmp/apache-maven.tar.gz
RUN ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN usermod -aG docker jenkins && \
    chown -R jenkins:jenkins $JENKINS_HOME/ && \
    touch /var/run/docker.sock && \
    chown -R jenkins:jenkins /var/run/docker.sock && \
    chmod 666 /var/run/docker.sock

USER jenkins

VOLUME [$JENKINS_HOME, "/var/run/docker.sock"]

RUN jenkins-plugin-cli --plugins "blueocean:latest docker-workflow:latest deployit-plugin:latest git:latest github:latest pipeline-github:latest htmlpublisher:latest envinject:latest docker-plugin:latest blueocean-github-pipeline:latest blueocean-git-pipeline:latest" deployit-plugin