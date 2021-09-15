# Lab: 1
## Containerization:  As a developer, I can migrate an existing Java application into a Kubernetes cluster
Background:
Lots of organizations own and operate servers and applications. Most of them were 
Demonstrates Spring Boot Application Containerization
This is a starter spring boot project that can be used as a working example  demonstaring how  to :
Assumptions:
Prerequistes:
Before continuing, ensure tha the following tools are installed: 
- Java8 or better 
- Maven
- Docker
- Git
- kubectl
- Kind (Kubernetes In Docker)

## Part I:
1. Containerize the application
2. Run the spring boot application from a container image

## Part II
3. Deploy the application in a Kubernetes cluster
```

### Create  a directory in your home directory
cd ~
mkdir -p sblabs
cd  sblabs

### Clone an a sample Spring Boot application to mimic an existing Java application
git clone https://github.com/hmfula/sbac.git

mvn clean install

java -jar target/docker-demo.jar

ctl+c 

# Run the app as  a spring boot
mvn spring-boot:run

ctl+c # close the application

docker images -a|grep demo  # search for demo image. It should not exist at this point

docker build -t docker-demo .  # build a container image

docker tag docker-demo  <add-your-docker-registry-uername-here>/docker-demo
  
docker push  <add-your-docker-registry-uername-here>/docker-demo  

docker images -a|grep demo  # Optional: search for demo image. It should exist now (we just built it in the previous step)

docker ps  -a|grep demo  # Optional: before running the conatiner check that there is no stopped container with name docker-demo
   
docker run --rm  -p 8080:8080 docker-demo # Run the container (--rm ensures container is removed automatically after running) mapping from local port 8080 to container  port 8080 ( ie -p 8080:8080)  

 
localhost:8080/test-docker  # check the app in the browser 
ctl+c   # close  the app


 
mvn clean # optional: maven clen

# deploy the app in kubernetes

kubectl create deployment sbaik --image=<add-your-docker-registry-uername-here>/docker-demo:latest  # start a single instance of spring boot application in kubernetes (sbaik) 
```  



