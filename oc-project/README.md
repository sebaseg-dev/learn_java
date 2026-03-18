# Epicrafter's Journey

This is the project used by the OpenClassrooms' course [Apprenez à programmer en Java](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java)

## Configuration

Following the course, neither _Maven_ nor _Gradle_ is used for the project. Everything will be manual.

### Compile

```bash
javac -cp "lib/*" -proc:none -d bin src/ej/*.java
```

### Execute

```bash
java -cp "bin:lib/*" ej.Main
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