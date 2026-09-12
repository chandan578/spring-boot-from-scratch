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

## 6. BeanScope -> BeanScope
In this project, we will explore the concept of bean scope in Spring. Bean scope defines the lifecycle and visibility of a bean within the Spring container. We will learn about the different types of bean scopes available in Spring, including `singleton`, `prototype`, `request`, `session`, and `application`. We will also learn how to configure bean scopes using Annotation-based configuration.
**Singleton scope** is the default scope in Spring, which means that only one instance of a bean is created per Spring container. **Prototype scope** creates a new instance of a bean every time it is requested.

## 7. BeanInitialization -> BeanInitialization
In this project, we will explore the concept of bean initialization in Spring. Bean initialization refers to the process of creating and configuring a bean before it is used in the application. 
There are mostly two way to initialize a bean in Spring:
1. **Eager Initialization**: In this approach, the bean is created and initialized at the time of application startup. This means that the bean is created and configured before it is used in the application. Eager initialization is the default behavior in Spring. By default, Spring creates and initializes all singleton beans at the time of application startup. This is called eager initialization. 
2. **Lazy Initialization**: In this approach, the bean is created and initialized only when it is requested for the first time. This means that the bean is not created and configured until it is actually needed in the application. Lazy initialization can be useful in situations where a bean is not always required, or when the initialization process is expensive and can be deferred until it is actually needed. This is done by using the `@Lazy` annotation on the bean definition. It is usages in both Singleton and Prototype scope. In Singleton scope, the bean is created only once and shared across the application, while in Prototype scope, a new instance of the bean is created every time it is requested.

## 8. Bean Lifecycle -> BeanLifecycle
In this project, we will explore the concept of bean lifecycle in Spring. Bean lifecycle refers to the various stages that a bean goes through during its existence in the Spring container. We will learn about the different stages of the bean lifecycle, including instantiation, initialization, and destruction. We will also learn how to customize the bean lifecycle using various methods, such as implementing the `InitializingBean` and `DisposableBean` interfaces, or using the `@PostConstruct` and `@PreDestroy` annotations.

## 9. XML Based Configuration -> XMLBasedConfig
XML-based configuration is a way of configuring Spring beans using XML files. In this project, we will explore how to configure beans using XML-based configuration. We will learn about the different elements and attributes available in the Spring XML schema, and how to use them to define beans, set properties, and configure dependencies. We will also learn how to use the `ApplicationContext` interface to load the XML configuration file and retrieve beans from the Spring container.
This is a legacy way of configuring Spring beans, and it is not recommended for new projects. However, it is still widely used in many existing applications, and it is important to understand how it works.

## 10. Spring Boot -> SpringCore, SpringBootCoreInitializer
In this project, we will explore the concept of Spring Boot and how it simplifies the process of building and deploying Spring applications. We will learn about the different features of Spring Boot, including auto-configuration, embedded servers, and starter dependencies. We will also learn how to create a Spring Boot application using the Spring Initializer and how to run it using the embedded server. 

## 11. Springboot Application Properties -> SpringBootApplicationProperties
In this project, we will explore the concept of Spring Boot application properties and how to configure them using the `application.properties` file. We will learn about the different types of properties available in Spring Boot, including server properties, database properties, and logging properties. We will also learn how to customize the application properties using various methods, such as using the `@Value` annotation or creating a custom configuration class.
And also explore some interfaces like ApplicationRunner and CommandLineRunner to run some code after the application has started. These interfaces can be used to perform tasks such as initializing data, setting up resources, or executing background tasks.

## 12. CRUD Operations -> CrudApplication
In this project, we will explore the concept of CRUD (Create, Read, Update, Delete) operations in Spring Boot. We will learn how to create a RESTful API that allows us to perform CRUD operations on a database using Spring Data JPA. We will also learn how to use the `@RestController` annotation to create RESTful endpoints and how to use the `@RequestMapping` annotation to map HTTP requests to controller methods. Additionally, we will explore how to handle exceptions and return appropriate HTTP status codes in our API responses.

## 13. Servlet -> ServletCrud
In this project, we will explore the concept of Servlets in Java and how to use them to create a simple CRUD application. We will learn about the different types of Servlets available in Java, including `HttpServlet`, `GenericServlet`, and `ServletContext`. We will also learn how to create a Servlet that handles HTTP requests and responses, and how to use the `doGet` and `doPost` methods to handle GET and POST requests. Additionally, we will explore how to use JSP (JavaServer Pages) to create dynamic web pages that interact with our Servlet-based CRUD application.