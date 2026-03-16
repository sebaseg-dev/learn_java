package ej;

public class Main {
    public static void main(String[] args) {
        Bloc exampleBloc0 = new Bloc(4, 2, 1);
        Bloc exampleBloc1 = new Bloc(40, 20, 10);
        
        System.out.println(
            "J'ai créé un premier bloc de dimension (L = " + 
            exampleBloc0.getLongueur() +
            " x l = " +
            exampleBloc0.getLargeur() +
            " x h = " +
            exampleBloc0.getHauteur() +
            ")"
        );
        
        System.out.println(
            "J'ai créé un second bloc de dimension (L = " + 
            exampleBloc1.getLongueur() +
            " x l = " +
            exampleBloc1.getLargeur() +
            " x h = " +
            exampleBloc1.getHauteur() +
            ")"
        );
    }
}