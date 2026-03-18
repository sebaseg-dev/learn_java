package ej.blocs;

public class Mur extends Bloc {
    private boolean porteur;
    
    public Mur(final int longueur, final int largeur, final int hauteur, final boolean porteur) {
        super(longueur, largeur, hauteur);
        this.porteur = porteur;
        this.couleur = Couleur.GRIS;
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
    
    @Override
    public void afficherDescription() {
        String porteurStr = this.porteur ? "est" : "n'est pas";
        System.out.println(String.format("Ce mur mesure %d x %d x %d et %s porteur.", this.longueur, this.largeur, this.hauteur, porteurStr));
    }
}