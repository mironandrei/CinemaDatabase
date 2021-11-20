## **CinemaDatabase**  

### **Description** 

In that project I use ***MVC design pattern*** and ***SOLID design principles***.

The application aims to manage a cinema with 9 halls, each of them with a maximum capacity of 20 people. And for that you can login as a client and as a cinema staff.

If a person want to reservate a ticket for a film, he need to make a user account. In order to make the account, it is necessary to choose a username and a password.  

In the database there not be two users with the same name and the password need to contain at least one digit and a special characte (***for example ?, *, ], !***) 

The user can perform the following commands:
- ***rezervare*** (to reservate a ticket)(you need to specify the name of the movie you want, the hall and the date for the reservation , but the date can't be less than the current date)
- ***afisareRezervari*** (display all of user's reservations)
- ***stergeRezervare*** (delete reservation)

The staff can perform the following commands:
- ***verificareCapacitate*** (return users who have booked for a hall and how many seats are free in that hall)
- ***stergeRezervare*** (delete reservation of a client)
- ***stergeUtilizator*** (delete a client from database)
- ***verificareRezervari*** (display all of the reservations for a client)

### **How to use**

First of all you need to have the following tables in the database:
- ***useri*** (id, username, password)
- ***rezervariUseri*** (id, username, sala, film, data)
- ***personalCinematograf*** (id, username, password)

This project was made using ***[IntelliJ IDEA]***(https://www.jetbrains.com/idea/).
In addition to the source files, you need to add at external libraryes ***[my-sql-connector]***(https://mvnrepository.com/artifact/mysql/mysql-connector-java)(I use the version 8.0.11) because you need to connect your application to the database (I create the database with ***phpMyAdmin*** in which I connected with ***Xampp Controller***).
After you have all of that you can run the project using IntelliJ IDEA.



