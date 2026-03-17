package ej;

public class Porte extends Bloc {
    private boolean verrouillee;
    
    public Porte(final int longueur, final int largeur, final int hauteur, boolean verrouillee) {
        super(longueur, largeur, hauteur);
        this.verrouillee = verrouillee;
        this.couleur = Couleur.BLEU;
    }
    
    public boolean estVerouillee() {
        return this.verrouillee;
    }
    
    public void setVerouillee(boolean verouillee) {
        this.verrouillee = verouillee;
    }
    
    @Override
    public boolean canPass() {
        return !this.verrouillee;
    }
}