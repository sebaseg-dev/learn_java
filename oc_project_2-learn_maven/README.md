# Using Maven for projects management

Playing with [Apache Maven](https://maven.apache.org/) while reading the OpenClassrooms' course [Organisez et packagez une application Java avec Apache Maven](https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven).

## Setting-up an environment

In the course, and I follow-up with these instructions, they use an old-fashioned way to set-up the envrionment (whithout using [SDKMAN!](https://sdkman.io/)) by using an unique directory to store and declare from depedancies. I set it up on my machine.

> Apache Maven 3.0.14
> Java version 26

## Creating the first structure

```bash
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5
>> 'groupeId': fr.sebaseg
>> 'artifactId': learn-java
>> 'version' (default)
>> 'package' (default)
```

## Compiling the first package

```bash
cd ./learn-java
mvn package
```

## Running compiled package

```bash
java -cp ./target/learn-java-1.0-SNAPSHOT.jar fr.sebaseg.App
```
