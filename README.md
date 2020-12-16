# QA To-Do List Project

This To-Do List System uses a webpage to allow the user to perform CRUD operations on items in lists. A list can have many items. The back-end is served by Java using SpringBoot and a SQL Server.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Install: Spring Tool Suite

Install: Java Development Kit 14

Install: Maven

```

### Installing

Once this repo has been downloaded or cloned, open the project in Spring Tool Suite. Then to run the program you need to perform the following actions:

In the Boot Dashboard, under local, right-click To-Do_List_Project and then click (Re)start.

To open the webpage, in your browser, go to the URL:

```
localhost:9092
```

The webpage is then shown. This is where you can select the entities and then perform CRUD operations.

### Example

You can create a list, by clicking the Add a List button. Then you can perform CRUD operation on the list. 

To add items to the list, click the View button and this will allow you to perform CRUD operations on the items in that list.



## Running the tests
In this project, I have included JUnit and Mockito tests to ensure that the code is working to specifications by running these tests and making sure that they all pass. **The coverage of the project is 81.0%.**

### Unit Tests 

There are three main test suites in the project. These are stored under:

```
src/test/java
```

The test suites are: 
-Controllers
-DTO
-Domain
-Service


To run all of the tests, in the Package Explorer, right-click on the _src/test/java_ folder then Coverage As, then JUnit Test.

It usually takes 30 seconds to complete all tests. The coverage for src/test/java is 81.0%


## Deployment

To run the .jar file from the command-line, navigate to the directory that holds the _ims-x.x.x-jar-with-dependencies.jar_ file and execute the following command once you have ensured that a MySQL localhost Server is running on your machine:

Example:
```
java -jar ims-0.0.1-jar-with-dependencies.jar
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*
