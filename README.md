Guide to setup the development environment

# JDK
Install Java 8 or higher as your default JDK environment.

# Database
Install Postgres to your local machine with port: 5432 by default.
Create a database, named it: [application_name]. Owner should be user/password for easy use. Update the application.properties under resource directory.

# Project
Import the project to your favourite IDE as Gradle project.
Refresh Gradle (build) to see the effect.

# How to run it?
Open java file MposApplication in Eclipse IDE. Right click -> Run as Java Application.
Open your favourite browser at: http://localhost:8081/

Every configuration is located under /src/main/resources/application.properties file.
