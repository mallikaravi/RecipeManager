
# Recipemanager

## Build and Generate the JAR file (compile the source code)
```bash
mvn clean package test  
$ java -jar target/recipe-manager-0.0.1-jar-with-dependencies.jar

### Run the Recipe manager application, assets folder is included with xml files used in the project.

Table of Contents
=================
<!--ts-->
   * [Installation](#installation)
   * [Usage](#usage)
      * [STDIN](#stdin)
      * [Local files](#local-files)
      * [Remote files](#remote-files)
      * [Multiple files](#multiple-files)
      * [Combo](#combo)
      * [Auto insert and update TOC](#auto-insert-and-update-toc)
      * [GitHub token](#github-token)
      * [TOC generation with Github Actions](#toc-generation-with-github-actions)
   * [Tests](#tests)
   * [Dependency](#dependency)
   * [Docker](#docker)
     * [Local](#local)
     * [Public](#public)
<!--te-->
