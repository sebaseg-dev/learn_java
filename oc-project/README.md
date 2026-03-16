# Epicrafter's Journey

This is the project used by the OpenClassrooms' course [Apprenez à programmer en Java](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java)

## Configuration

Following the course, neither _Maven_ nor _Gradle_ is used for the project. Everything will be manual.

### Compile

```bash
javac -d bin src/ej/Main.java src/ej/Bloc.java
```

### Execute

```bash
java -cp bin ej.Main
```

## Exercises

### ✅ Create a first object

> Exercise from OpenClassrooms > Apprenez à programmer en Java > Prenez en main la programmation orientée objet > [Ecrivez votre première classe](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java/8440280-ecrivez-votre-premiere-classe)
>
> Create a `Bloc` class with private `length`, `width` and `height` properties and `getters`