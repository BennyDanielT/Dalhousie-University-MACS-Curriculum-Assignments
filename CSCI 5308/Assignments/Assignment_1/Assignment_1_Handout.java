/*Develop a Java program using the TDD approach that provides the following functionality.

a) init command parameter

java -jar DbWrapper.jar init <csv file path>
for example,
java -jar DbWrapper.jar init Book.csv

When the "init" command is passed along with a CSV file, your program will create a new database "Assignment1" 
in the installed MySQL instance. It will also create a table Book (it must be the same as the name of the CSV file) 
in the newly created database. The schema of the table will be derived from the header of the provided CSV. 
For example, if the CSV file contains the following header: "ISBN, Title, Author, Publisher", then you need to create a table with fields
 ISBN, Title, Author, and Publisher (of course along with a primary key). You may assume that all fields except the primary key 
 are of type VARCHAR. You may assume primary key as an integer (not provided in the CSV file). 
 Finally, your program needs to insert all the records specified in the provided CSV file into the table (e.g. Book).

b) query command parameter

java -jar DbWrapper.jar query <database> <query>
For example:
java -jar DbWrapper.jar query Assignment1 "SELECT * FROM Book WHERE Author = 'Martin Fowler'"

Upon the query command, your program will connect the specified database (e.g. Assignment1) and execute the specified query. The result of the query must be stored in a CSV file (named results.csv) in the current directory.

Assumptions:
You may assume that your program is running on a machine with Java 11 or higher, and MySQL.

You may have a mix of unit tests and integration tests.

Constraints:

Keep the name of the database as Assignment1

Name the main class of your file as DbWrapper; there can be other classes as needed

Follow "test first" approach; all your production code must be covered by your tests

It should be a maven project; 'mvn clean install' should result in a single jar file (named DbWrapper.jar) in the target folder.

You must not use any third-party library or maven dependency for CSV file processing.

Keep all the DB credentials in a configuration file appropriately named so that we can change the credentials there and run your program on our machine.
Deliverable:

The final deliverable must include source code, test code, and maven pom file. 

You must deliver your assignments in the designated Gitlab repository for the assignment created for you
 (CSCI-5308 -> Assignments -> Assignment1 -> <your-username>). 
 Take a look at this repository and find a sub-project created for you. If you don't find the assignment
 repository for you, contact your TA immediately.

Rubric:

Build jar file successfully using maven + init command tests working fine = 2
Build jar file successfully using maven + query command tests working fine = 2 
Good quality unit tests = 1
Good quality integration tests (for database) = 1
Test coverage = 2*