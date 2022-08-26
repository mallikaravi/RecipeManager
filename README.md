
# Recipemanager

## Build and Generate the JAR file (compile the source code)
```bash
$ mvn clean package test  
$ java -jar target/recipe-manager-0.0.1.jar

# Run the recipe manager application, assets folder and jar file should be in same path.
.
├── ...
    ├──asets
    ├──recipemanager.jar
```
# Table of Contents
<!--ts-->
   * [Prerequisites](#prerequisites)
   * [About](#about)
   * [Project SetUp](#project-setup)
   * [Implementation And Design](#implementation-and-design)
      * [Define a simple Maven Build](#define-a-simple-maven-build)
        * [Dependencies](#dependencies)
        * [Class Diagram](#class-diagram)
        * [UseCase Diagram](#usecase-diagram)
   *  [Tool Used For Project Management](#tool-used-for-project-management)

        
<!--te-->


Prerequisites
============
* Install Maven

About
============
Recipe Manager is a terminal based application.There will be two persons using this application.

They are:

1.User
2.Dietician

  ## User
  In the application,when we switch to user,the user can perform the following tasks
    List all the weeks
    view aRecipies
    Generate a Recipe Week
    view Recipies
    
   ## Dietician   
   In the application,when we switch to dietician,he can perform the following tasks
     Create a Recipie
     View Recipe
     Update Recipe
    view all Recipies
  

Project setUp
============
First you’ll need to setup a Java project for Maven to build. 

Implementation and Design
============

Technology
============
The following technologies are used in designing and developing the recipe manager application.

1. Java – Coding language for implementing the Recipe Manager application
2. Eclipse - IDE Purpose 
3. Visual Paradigm - UML Diagram tool
4.Install Maven

Define a simple Maven Build
============
1.You need to create a Maven project definition.
2.Maven projects are defined with an XML file named pom.xml.
3.Among other things, this file gives the project’s name, version, and dependencies that it has on external libraries.
4.Create a file named pom.xml at the root of the project.

Dependencies
============
* pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>recipe-manager</groupId>
	<artifactId>recipe-manager</artifactId>
	<version>0.0.1</version>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>17</release>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-assembly-plugin</artifactId>
				<configuration>
					<descriptorRefs>
						<descriptorRef>jar-with-dependencies</descriptorRef>
					</descriptorRefs>
					<archive>
						<manifest>
							<mainClass>com.novare.recipe.RecipeManagerApp</mainClass>
						</manifest>
					</archive>
				</configuration>
				<executions>
					<execution>
						<goals>
							<goal>single</goal>
						</goals>
						<phase>package</phase>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	
	<dependencies>
		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
			<version>4.0.0</version>
		</dependency>

	</dependencies>

</project>

This is the simplest possible pom.xml file necessary to build a Java project. It includes the following details of the project configuration:

*  modelVersion- POM model version (always 4.0.0).
*  groupId -  Group or organization that the project belongs to. Often expressed as an inverted domain name.
*  artifactId - Name to be given to the project’s library artifact (for example, the name of its JAR or WAR file).
*  version  -  Version of the project that is being built.

UseCase Diagram
============
 ### Link -https://github.com/mallikaravi/recipe-manager/blob/main/design/UseCaseDiagram.png


Class Diagram
============

Tool used for project management
============
JIRA tool is used for this project
### Link -


