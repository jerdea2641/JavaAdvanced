
Pet Adoption System
About

This repository contains a Java-based pet adoption application. The program uses a simple 
console menu to allow an administrator to manage dog records stored in a local SQLite database.

Getting Started
Prerequisites

Before running the application, make sure you have:

Java JDK installed
A Java development environment
SQLite JDBC driver added to the project libraries
Running the Program

Open the project in your Java development environment and run:

App.java

The application will connect to the SQLite database and display the main menu.

Using the Application

After starting the program, the administrator can select from the following options:

View Available Dogs – Displays dogs currently stored in the database.
Add a Dog – Allows the administrator to enter information for a new dog.
Update a Dog – Allows existing dog information to be changed.
Delete a Dog – Removes a dog record from the database.
Exit – Closes the application.

Dog information includes the dog's name, age, breed, traits, and adoption status.

Data Storage

Dog records are stored in a SQLite database named PetAdoption.db.

The program uses JDBC to communicate between the Java application and the database. 
Database operations include:

Creating the Dogs table
Inserting new records
Retrieving records
Updating records
Deleting records
Source Files
File	Purpose
App.java	Controls the application and user menu
Pet.java	Defines the abstract Pet class
Dog.java	Defines the Dog object
Cat.java	Defines an additional Pet type
Adoptable.java	Defines adoption-related behavior
AdoptionCenter.java	Maintains a collection of Pet objects
DogDb.java	Performs database operations
SQLiteDatabase.java	Establishes the database connection
Project Status

The application has been tested for its primary functionality, including adding, viewing, 
updating, and deleting dog records. Error handling was also added for invalid database IDs 
during update and delete operations.

Author

Jeremy Dean
