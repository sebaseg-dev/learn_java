package ej;

public class Porte extends Bloc {
    private boolean verrouillee;
    
    public Porte(final int longueur, final int largeur, final int hauteur, boolean verrouillee) {
        super(longueur, largeur, hauteur);
        this.verrouillee = verrouillee;
        this.couleur = Couleur.BLEU;
    }
    
    public boolean estVerrouillee() {
        return this.verrouillee;
    }
    
    public void setVerrouillee(boolean verouillee) {
        this.verrouillee = verouillee;
    }
    
    @Override
    public boolean canPass() {
        return !this.verrouillee;
    }
    
    @Override
    public void afficherDescription() {
        String verrouilleeStr = this.verrouillee ? "est" : "n'est pas";
        System.out.println(String.format("Cette porte mesure %d x %d x %d et %s verrouillée.", this.longueur, this.largeur, this.hauteur, verrouilleeStr));
    }
}