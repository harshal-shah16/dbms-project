### Specifications of Software Used :

1. JavaFX Windows SDK - Version 11.0.2
   Download URL : https://gluonhq.com/products/javafx/
2. MySQL Java Connector (Platform Independent) - Version 8.0.22
   Download URL : https://dev.mysql.com/downloads/connector/j/
3. MySQL Workbench 8.0 Community Edition
4. Java Version 14.0.1
5. IDE - Intellij IDEA 2020.1.1
6. Windows 10 environment

### Steps for Running the application through Intellij Idea IDE

1. Download the project files, unzip and use Open Project option in IntelliJ
2. Import the dataexport file of the database into MySQL using Data Import from MySQLWorkbench
3. In Edit Configurations -- VM Options --- add the following
```
--module-path "filepath of JavaFX SDK on local computer"
--add-modules javafx.controls,javafx.fxml
```
For example, I have the following setup in my VM options:
```
--module-path "C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.1\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
--add-modules javafx.controls,javafx.fxml
```
Pl. refer screenshot "Intellij_VMoptionsSetupScreenshot" provided

4. In Edit Configurations - Environment Variables need to be set up for three variables defined in application
   to connect to the database

   - dbUser : This is the username for your database connection
   - dbPassword : This is the password for your database connection
   - dbURL : This is the URL for JDBC connection which connects to the database that will be used in the application

   An example of environment variables that I have setup for my application:

```
	dbUser=root
	dbPassword=Harshal123
	dbURL=jdbc:mysql://localhost:3306/shah_harshal_project
```
Pl. refer screenshot "Intellij_EnvironmentVariablesSetupScreenshot" provided

Replace the values of the three variables with your username, password and name of the database that would be used to connect to the application

5. Run Main. Login page would pop-up. Please use: username=root and password=123 to login into the application

### Steps for Running the application through JAR executable file submitted:

1. Import the dataexport file of the database into MySQL using Data Import from MySQLWorkbench
2. Open Command Line and change file location to where JAR file is located on your computer
3. Set environment variables (To input your database username/password and URL). 
	For examples commands that I executed: 
    - set dbUser=root (root is username of my db connection) 
    - set dbPassword=Harshal123 (Harshal123 is passoword of my db connection) 
    - set dbURL=jdbc:mysql://localhost:3306/shah_harshal_project (shah_harshal_project is the name of the database that would be connected)
   
   If you are using Mac machine instead of ‘set’ use ‘export’ keyword

4. After setting up working directory location and setting up environment variables as described above type in the following command:
   java --module-path "file path of JavaFX SKD" --add-modules javafx.controls,javafx.fxml -jar Project11Nov.jar
   For example the command that I use is :
   java --module-path "C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.1\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar Project11Nov.jar

Pl. refer screenshot "CommandLine_InstructionsScreenshot" provided

5. Login page would pop-up. Please use: username=root and password=123 to login into the application
