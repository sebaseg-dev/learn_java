# Epicrafter's Journey

This is the project used by the OpenClassrooms' course [Apprenez à programmer en Java](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java)

## Configuration

Following the course, neither _Maven_ nor _Gradle_ is used for the project. Everything will be manual.

### Compile

```bash
javac -cp "lib/*" -proc:none -d bin src/**/*.java
```

### Execute

```bash
java -cp "bin:src:lib/*" ej.Main
```

## Exercises

### ✅ Create a first object

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Ecrivez votre première classe](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8440280-ecrivez-votre-premiere-classe)
>
> Create a `Bloc` class with private `length`, `width` and `height` properties and `getters`

### ✅ Extends previous object

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Implémentez l'héritage](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8440662-implementez-l-heritage)
>
> Make `Bloc` an _abstract class_ and create 2 extended classes with their own properties `Mur` and `Porte`.

### ✅ Using Enums

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Optimisez votre code avec des classes particulières](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8441076-optimisez-votre-code-avec-des-classes-particulieres)
>
> Implementing a colour parameter with default for each object

### ✅ Create a collection

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Rassemblez vos données à l’aide des collections](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8441614-rassemblez-vos-donnees-a-l-aide-des-collections)
>
> Implementing a collection of blocs and keywords into a `Kit` object. Implementing interface IBloc.

### ✅ Implementing Exceptions

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Gérez les exceptions](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8441937-gerez-les-exceptions)
>
> Implementing Exceptions to throw errors when trying to lock an already locked door.

### ✅ Using Log4J

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Approfondissez votre maîtrise de Java > [Appliquez le logging à votre code](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8442187-appliquez-le-logging-a-votre-code)
>
> Reorganising packages and using Apache Log4J to log errors when an Exception is thrown and to log info when a bloc is instanciated with its type

### ✅ Streams (BufferedReader)

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Approfondissez votre maîtrise de Java > [Utilisez les flux en Java](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8442516-utilisez-les-flux-en-java)
>
> Asking the user an input to display one out of two kind of information. I adapt my code rather than cloning course's repo.

### ✅ Lambda

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Approfondissez votre maîtrise de Java > [Allégez l'écriture de votre code grâce au Lambda](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8442795-allegez-l-ecriture-de-votre-code-grace-au-lambda)
>
> Identify iterations made upon collections (I will refactor `afficherIdees()` only), enlighten it with lambda writing and implement `forcerSerrure()

### ✅ Concurrent programming

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Approfondissez votre maîtrise de Java > [Découvrez les Threads](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8443022-decouvrez-les-threads)
>
> To work with threads, we will introduce latency in the bloc's instanciation, then create several blocs at the same time.
> As a result, it took in the same execution: 10.051s to build 10 blocs sequentially vs. 1.035s to build 10 blocs concurrently using virtual threads.