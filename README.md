Coverage: 38.7%
# Inventory Management System

An application to create, read, update and delete records for a phone store. It allows users to add customers, items and orders using for interactions in MySQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

A java runtime environment is required on your PC to run this along with a version of Maven to build the project. Having Eclipse would also be useful if you wish to edit or test the code, though other Java IDE's will work fine.

### Installing

Fork this repository to your own GitHub and then clone it to your PC. From there, the .jar file can be created using the command line.
Open your command line in the main directory of the project and run the following commands to get the program working, using Maven and Java. **Run each command one line at a time!**
'''
    mvn clean package
    cd target
    java -jar FelixMarley-SoftwareMarch16-jar-with-dependencies.jar
'''

## Running the tests

Running the tests can be done by opening the source code in an IDE and running the test codes as a JUnit application. Alternatively, opening your command line in the main directory and running the tests via maven will also work, with the command given below.
'''
    mvn clean test
'''

### Coding style tests

Building this application and pushing it forward to a computer or virtual machine hosting Sonarqube will allow the user to anylise the code for coding style issues, bugs and security issues.


## Deployment

The project has been deployed via multiple stages of a CI pipeline. It is first pushed to GitHub, before being retrieved by Jenkins. Jenkins utilises maven to run the unit tests and build the project before pushing it further ahead to both Sonarqube (for more testing) and Nexus, for artifact repositing and hosting the fully built application.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://jenkins.io/) - CI Pipeline scripter
* [Eclipse](https://www.eclipse.org/downloads/) - IDE
* [SonarQube](https://www.sonarqube.org/) - static analysis
* [Nexus](https://www.sonatype.com/product-nexus-repository/) - artifact repository
* [Trello](https://trello.com/) - planning, kanban
* [MySQL](https://www.mysql.com/) - database language
* [GCP](https://cloud.google.com/) - database host
* [JUnit](https://junit.org/junit5/) - Testing (see pom.xml)
* [Mockito](https://site.mockito.org/) - Testing (see pom.xml)

## Versioning

* [Git](https://git-scm.com/) - version control system
* [Github](http://github.com) - host of version control system

## Authors

**Felix Marley** - *Author* - [Femarleycode](https://github.com/Femarleycode)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

**Chris Perrins** - *Provided a basis for the project* - [christophperrins](https://github.com/christophperrins), basis can be found [here](https://github.com/christophperrins/ims-demo)


**Nicholas Johnson** - *Software trainer* - [nickstewarttds](https://github.com/nickrstewarttds)

**Jordan Harrison** - *Java trainer* - [JHarry444](https://github.com/JHarry444)

**Korbinian Ring** - *Help and idea generation* - [KMRRingQA](https://github.com/KMRRingQAfor) 

**Caroline Strasenburgh** - *Guidance and planning* - [CarolineS-QA](https://github.com/CarolineS-QA)

**Luke Conway** - *Provided help with Java syntax and readme setup instructions* - [ConwayQA](https://github.com/ConwayQA)

**Christian Redfern** - *Also provided help with Java* - [Chrisctr](https://github.com/Chrisctr)

**David Williams** - *Java support* - [DavidWilliamsQA](https://github.com/DavidWilliamsQA)

**Tawanda Siyamachira** - *Project management advice* - [TSiyamachiraQA](https://github.com/TSiyamachiraQA)

# Inventory Management System

