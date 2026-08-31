# Details Notes to go through this repo

## 1. Spring Initializer  -> Demo
Demo project is created using Spring Initializer with the following dependencies:
- Spring Web

## 2. Maven  -> MavenDemo
This project is built using Maven. The `pom.xml` file contains the necessary dependencies and plugins for building and running the application. 
And in this add two dependencies for testing purpose:
- MySQL Connector/J
- Hibernate Core


## 3. Core Concepts -> CoreDemo
In this project, we will explore dependency injection and IOC (Inversion of Control) concepts. We will create a simple application that demonstrates how to use these concepts effectively.

## 4. Spring Context -> SpringCoreDemo, SpringCoreDemo2
In this project, we will learn about the Spring Context and how to configure beans using Annotation. In addition, we will explore the different types of Annotation-based configuration options available in Spring.
Many Annotation-based configuration options are available in Spring, including `@Component`, `@Bean`, `@Configuration`, and `@ComponentScan`. We will also learn how to use the `@Autowired` annotation to inject dependencies into our beans.
**Beans** are the objects that form the backbone of a Spring application. They are managed by the Spring container and can be configured using various methods, including XML configuration, Java-based configuration, and Annotation-based configuration.

## 5. Circular Dependency -> CircularDependency
In this project, we will explore the concept of circular dependency in Spring. Circular dependency occurs when two or more beans depend on each other, creating a loop that can lead to issues during bean creation. We will learn how to identify and resolve circular dependencies using various techniques, such as setter injection, field injection, and the `@Lazy` annotation.
But Circular dependency is not a good practice in Spring, and it should be avoided whenever possible. It can lead to issues such as stack overflow errors, memory leaks, and performance problems. Therefore, it is essential to design your application in a way that avoids circular dependencies.