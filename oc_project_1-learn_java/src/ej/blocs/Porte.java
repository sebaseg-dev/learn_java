package ej.blocs;

import ej.PorteVerrouilleeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.Predicate;

public class Porte extends Bloc {
    private static final Logger logger = LogManager.getLogger(Porte.class);
    
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
    
    public void verrouiller() throws PorteVerrouilleeException {
        if(this.verrouillee) {
            logger.error("Action impossible: la porte est déjà verrouillée!");
            throw new PorteVerrouilleeException("Action impossible: la porte est déjà verrouillée!");
        } else {
            this.verrouillee = true;
        }
    }
    
    public void forcerSerrure(Predicate<String> fonction) {
        String secret = "Password123";
        
        if(this.verrouillee) {
            if(fonction.test(secret)) {
                this.verrouillee = false;
            }
        }
    }
}