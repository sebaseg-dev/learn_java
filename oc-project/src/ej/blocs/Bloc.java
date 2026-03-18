package ej.blocs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Bloc implements IBloc {
    
    protected int longueur;
    protected int largeur;
    protected int hauteur;
    protected Couleur couleur;
    
    private static Logger logger = LogManager.getLogger(Bloc.class);
    
    public Bloc(final int longueur, final int largeur, final int hauteur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        
        logger.info("Bloc créé: type de bloc = {}", this.getClass().getSimpleName());
    }
    
    public int getLongueur(){
        return this.longueur;
    }
    
    public int getLargeur(){
        return this.largeur;
    }
    
    public int getHauteur(){
        return this.hauteur;
    }
    
    public abstract boolean canPass();
    
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public Couleur getCouleur() {
        return this.couleur;
    }
}