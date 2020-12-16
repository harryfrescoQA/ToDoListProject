# QA To-Do List Project

This To-Do List System uses a webpage to allow the user to perform CRUD operations on items in lists. A list can have many items. The back-end is served by Java using SpringBoot and a SQL Server.

## [Link to Jira](https://harryfrescotest.atlassian.net/secure/RapidBoard.jspa?rapidView=4&useStoredSettings=true&atlOrigin=eyJpIjoiNDg4MTY0ZDE2ZDZhNGFhOWEyMTQ3MzJmYjA5MTE4YjEiLCJwIjoiaiJ9)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
The Repo is split into 2 folders, MainProject and Selenium. Selenium contains the Seleniums test files which requires the MainProject to be running before.

### Prerequisites

What things you need to install the software and how to install them

```
Install: Spring Tool Suite

Install: Java Development Kit 14

Install: Maven

```

## Deployment

To run the .jar file from the command-line, navigate to the MainProject where the To-Do-List-Project-x.x.x-SNAPSHOT.jar_ file is and execute the following command:

Example:
```
java -jar To-Do-List-Project-0.0.1-SNAPSHOT.jar
```
Once running, in your browser, go to the URL:

```
localhost:9092
```

The webpage is then shown. This is where you can select the entities and then perform CRUD operations.



## Running in IDE

Once this repo has been downloaded or cloned, open the project (MainProject) in Spring Tool Suite. Then to run the program, you need to perform the following actions:

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
Selenium tests are also available in the folder 'Selenium'. These can be imported into the project workspace and then run, while the MainProject is running

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

### Selenium
Once the MainProject is running locally on port 9092, import the Selenium project, right-click Selenium/src/test/java, Run As -> JUnit Test.
This will then test the webpage by performing tasks on it.

At the moment, the tests are:
-Add List
-Add Item to the List
-Check if both are successful



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*
