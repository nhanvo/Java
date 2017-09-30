# Spring Boot Web Application
##Connecting to Oracle

How to setup an JDBC connection to an Oracle database.

You can see the full blog post about connecting Spring Boot to Oracle at  [Spring Framework Guru](https://springframework.guru/)

1. Install ojdbc7.jar to maven repository:
  mvn install:install-file -Dfile=ojdbc7.jar  -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar
  
2.

