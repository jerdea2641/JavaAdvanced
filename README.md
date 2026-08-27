Pet Adoption System

Project Overview
This system is a Java console app designed to manage pet adoption records. Administrators can add, 
view, update, and delete dog and cat records with all information saved in a SQLite database. This
project demonstrates object-oriented-programming concepts (abstraction, inheritance, polymorphism, 
composition, constructors, and access specifiers.

This provides admin with a simple way to organize and maintain pet adoption records. Using SQLite
database allows animal info to be stored and retrieved without having to manually track.

The application uses a console-based interface that allows admin to navigate the system through a
menu. Admin will enter info through a terminal, and the app displays the requested records and results
in terminal. It will loop back until exiting.

There is an animal abstract class as the base for the dog and cat classes. Inheritance and polymorphism
allows each type of animal to have its own properties, while constructors are used to create and initialize
animal objects. Composition is used to organize related objects and function within the app.

This app uses access specifiers such as public and private to control access to classes, methods, and data.
Private fields help protect object data, while public methods provide controlled access to app functionality.

This app uses the SQLite database to permanently store animal records. Admin is able to create, read, update,
and delete dog and cat records through the app. If a database has not been created, this app will automatically create
one to enable immediate use.

All files are organized in phase3Lecture tag with files and folders. You can find the java source files, SQLite database
components, and required library files needed to run the app.

In order to run this program, open the app in a java development environment and make sure the SQLite JDBC library
is in the lib folder and classpath. Run the app.java to start the app and use the terminal menu to manage the records.
