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

## Customising the project

We can add in the build process the manifest to declare the main class to run when jar is opened-up.

```bash
java -jar ./target/learn-java-1.0-SNAPSHOT.jar
```

We can use resources and profiles to configure build steps. As the course explains, I added a `TEST` and a `PROD` profile with filtered resources to use application's version from the Maven's `pom.xml` into the app itself.

```bash
mvn package -P <<prod|test>>
```

