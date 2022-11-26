FROM jenkins/jenkins:2.332.3-jdk11

USER root

RUN apt-get update && apt-get install -y lsb-release

RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg

RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list

RUN wget -O- https://apt.releases.hashicorp.com/gpg | \
    gpg --dearmor | \
    sudo tee /usr/share/keyrings/hashicorp-archive-keyring.gpg
	
RUN echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] \
    https://apt.releases.hashicorp.com $(lsb_release -cs) main" | \
    sudo tee /etc/apt/sources.list.d/hashicorp.list

RUN apt-get update && apt-get install -y docker-ce-cli && \
    apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common && \
	apt-get install -qqy docker-ce 

RUN apt-get install terraform
	
RUN usermod -aG docker jenkins && \
    chown -R jenkins:jenkins $JENKINS_HOME/ && \
    touch /var/run/docker.sock && \
    chown -R jenkins:jenkins /var/run/docker.sock && \
    chmod 666 /var/run/docker.sock

USER jenkins

VOLUME [$JENKINS_HOME, "/var/run/docker.sock"]

RUN jenkins-plugin-cli --plugin-file /plugins.txt  --plugins "blueocean:1.25.3 docker-workflow:1.28" deployit-plugin 