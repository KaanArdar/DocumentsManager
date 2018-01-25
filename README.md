# DocumentsManager

This is a document manager project by Kaan ARDAR. https://github.com/KaanArdar/DocumentsManager

Main ability of project is storing a document to redis and elastic search then getting document from where we stored.

This project was developed with spring boot. Java 8 is required. Documents was stored in ElasticSearch and Redis.

# These are the endpoints in project
  
- Get /news/{id}
- Post /news
- Delete /news/{id}
- Put /news/{id}

# Example Document

  https://github.com/KaanArdar/DocumentsManager/tree/master/documentsmanager/json

------------------------------------------------------------------
Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application
If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example:
$ java -jar target/documentsmanager-0.0.1-SNAPSHOT.jar
It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

2- Using the Maven plugin
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

$ mvn spring-boot:run
