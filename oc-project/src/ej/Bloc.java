package ej;

public class Bloc {
    
    private int longueur;
    private int largeur;
    private int hauteur;
    
    public Bloc(final int longueur, final int largeur, final int hauteur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
    int getLongueur(){
        return this.longueur;
    }
    
    int getLargeur(){
        return this.largeur;
    }
    
    int getHauteur(){
        return this.hauteur;
    }
}