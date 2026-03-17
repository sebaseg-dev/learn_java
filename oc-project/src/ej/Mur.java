package ej;

public class Mur extends Bloc {
    private boolean porteur;
    
    public Mur(final int longueur, final int largeur, final int hauteur, final boolean porteur) {
        super(longueur, largeur, hauteur);
        this.porteur = porteur;
    }
    
    public boolean estTraversable() {
        return !this.porteur;
    }
    
    @Override
    public int getHauteur() {
        return this.hauteur * 10;
    }
    
    @Override
    public boolean canPass() {
        return this.estTraversable();
    }
}