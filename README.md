# Multi-MyBatis-Demo
This is a simple Spring Boot project to demonstrate how to configure MyBatis with multiple mappers pointing to different databases.

It basically contains the [configuration files](https://github.com/Verdoso/multi-mybatis-demo/tree/master/src/main/java/org/greeneyed/multimybatisdemo/config) that set up two different connections to two different databases (an in-memory H2 instance and and in-memory HSQLDB instance), creates two datasources and configures two different mappers where each one uses a different database from the other.
I added a [simple controller](https://github.com/Verdoso/multi-mybatis-demo/blob/master/src/main/java/org/greeneyed/multimybatisdemo/controllers/DemoController.java) that queries each database with vendor specifig SQL to display the name and the version of the database to demonstrate that each mapper points fo a different database.

After you build and run this project, this is the result you should get when you point your browser to http://localhost:8080/test_mappers:

![enter image description here](https://raw.githubusercontent.com/Verdoso/multi-mybatis-demo/master/Screenshot.PNG)


This project was created as a hands-down demonstration of the tip explained in the blog entry "[Spring Boot, MyBatis, multiple datasources and multiple mappers, all together holding hands](https://medium.com/@d.lopez.j/spring-boot-mybatis-multiple-datasources-and-multiple-mappers-all-together-holding-hands-be74673c6a9f)"