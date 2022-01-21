# Book-Tracker
Book Tracker is an Android application for searching books and keeping track of your reading list. You can add books to your personal reading list, mark them as completed and add notes for each book you're reading!

## High Level Architecture

On a high level, this system consists of an smartphone Android application which connects to Firebase - a backend as a service provided by Google.

The mobile application communicates with the backend for registering new users, login, create book lists and read those lists. The app can be extended for book recommendation using AI algorithms on the accumulated data sets.

![alt text](https://github.com/florinrm/Book-Tracker/blob/master/doc/high_level_architecture.png?raw=true)

## Project Structure
The ```Book-Tracker/app/src/main``` directory contains the application logic and frontend specification.

The ```res``` directory contains application resources such as layouts, fragments, menus, strings etc. Those resources are separated from the main application code to be easily updated. The resources are used to specify the UI for the rendering engine.

The main application code is located in ```java/com/example/booktracker/``` directory.

 
## Setup
Go to the Firebase console and create a new project. Register the application (com.example.booktracker), then download the configuration file and place it under *src* directory. Now you can compile the application. Enjoy!

## Prototype Idea
This section presents the application prototype. The app consists of multiple screens with different navigation options between the screens. Each section and navigation possibility will be described furtheron.

![alt text](https://github.com/florinrm/Book-Tracker/blob/master/doc/app_screens_prototype.png?raw=true)

