## Spring Board

### Introduction

  This is a implementation from chapter 13 of "Professional Java for Web Applications", which is a discussion and reply platform. user could send discussion to the web applications and other users could reply for the discussion. In this example,

### Configuration

  There are 3 distinct methods to configure spring framework, including pure XML, pure Java and hybrid (Java and XML), There are all be introduced in that book.

  However, the book points the disadvantage of XML configuration methods, which is XML is really hard to debug and Test because XML is not like Java could run on virtual machine.

  So, I just fixed the example and used pure Java to configure servlet and context. the configuration is almost constant. It is easy to configure your servlet and context with same code, it will provide basic functions that you need.

### Concept

  * Model - View - Controller

    MVC pattern is a standard design pattern for spring framework and it is good at web application. because it separates view layer and logic layer. Font end design could work for web page, respectively, background developer could focus on transaction logic.

  * Controller - Service - Repository

    Controller, Service and Repository is like a stack in spring framework. This stack represents the dependency of that three component. Controller depends service and service depends repository.

    1. Controller

      Controller is a component used to process the data and communicate with view page. Whatever user request will be sent to controller and it will decide which page will be rendered and shown.

    2. Service

      Service is middle ware between controller and repository, which provides different functions. in this example, the service provides interface that makes controller could get the discussion and reply content from memory.

    3. Repository

      Repository is low level component providing method to communicate data with database (that is stored in memory not hard disk in this example), like getting and storage.
