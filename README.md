# 22AprEnable1, Inventory Management System Project

This is an Inventory Management System with the functions: Create, Read, Update and Delete, for 'Customers', 'Items' and 'Orders'

## Getting Started

To download this application, make an empty folder (for example "IMS")
Then, 'git bash' in the folder, 'git init' to make it a repository, and 'git clone (+ the SSH Key of this online repository)' to copy the project to your local system 
To run the app, navigate into the folder you made (e.g. "IMS") and run a command prompt in the \target\ subfolder
IN the command prompt, use the command 'java -jar "name of the jar-with-dependencies.jar where these quotation marks are"'
This should run the application through a command prompt

### Prerequisites

Git Bash is needed to download this repository
To download Git Bash for your system, follow this link: https://git-scm.com/downloads

For development and testing purposes, please install Eclipse for Java developers by following this link: https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers

### Installing

To install and edit this project, move the folder you made earlier (e.g. "IMS") into your \eclipse-workspace\
In Eclipse, navigate to File/Open Projects from File System and select your folder (e.g. "IMS")
This will create a development environment for this project

To run the project, navigate to the Runner object in src/main/java/com.qa.ims
Right-click the Runner, and 'Run As' as 'Java Application'

This will open the application in the console

## Running the tests

To run automated tests for this application, right-click the src/test/java folder and 'Run As' a 'JUnit Test'
These tests test the CRUD functionality of the application by testing the methods within CustomerController.java, ItemController.java, OrderController.java, CustomerDAO.java, ItemDAO.java and OrderDAO.java 

## Deployment

To ensure deployment on your local machine, make sure your environment is runnng the same Java Verison that is indicated in the pom.xml file

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thanks to Richard Mansworth and Cameron Guthrie for answering my endless questions
