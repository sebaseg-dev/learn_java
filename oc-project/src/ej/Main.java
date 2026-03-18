package ej;

public class Main {
    public static void main(String[] args) {
        Bloc blocMur = new Mur(2,2,2,true);
        Bloc blocPorte = new Porte(0,1,2,false);
        Mur murPorteur = new Mur(2,2,2,true);
        Porte porteFermee = new Porte(0,1,2,true);
        Mur murNonPorteur = new Mur(2,2,2,false);
        Porte porteOuverte = new Porte(0,1,2,false);
        
        System.out.println(
            "En tant que type Bloc, je sais juste les dimensions du Mur : " +
            blocMur.getLongueur() + "x" +
            blocMur.getLargeur() + "x" +
            blocMur.getHauteur() +
            "(overridé par la classe Mur, donc affecte l'instance - hauteur = hauteur*10). Mais je ne sais pas si il est franchissable ou non. Seule la méthode abstraite canPass() peut me permettre de dire si je peux passer ou non = " +
            blocMur.canPass()
        );
        System.out.println(
            "En tant que type Bloc, je sais juste les dimensions de la Porte : " +
            blocPorte.getLongueur() + "x" +
            blocPorte.getLargeur() + "x" +
            blocPorte.getHauteur() +
            ". Mais je ne sais pas si elle est franchissable ou non. Seule la méthode abstraite canPass() peut me permettre de dire si je peux passer ou non = " +
            blocPorte.canPass()
        );
        System.out.println(murPorteur.estTraversable());
        System.out.println(porteFermee.estVerrouillee());
        System.out.println(murNonPorteur.estTraversable());
        System.out.println(porteOuverte.estVerrouillee());
        
        System.out.println("Ma porte est : " + porteOuverte.getCouleur());
        System.out.println("Mon mur est Porteur est : " + murPorteur.getCouleur());
        System.out.println("Mon mur est Non-Porteur est : " + murNonPorteur.getCouleur());
        
        murNonPorteur.setCouleur(Couleur.VERT);
        System.out.println("J'ai repeint mon mur non porteur en : " + murNonPorteur.getCouleur());
        
        Kit kitDeDemarrage = new Kit();
        kitDeDemarrage.afficherKit();
    }
}