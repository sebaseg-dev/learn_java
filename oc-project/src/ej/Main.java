package ej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ej.blocs.*;

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
        
        Porte porteDeverrouillee = new Porte(1, 1, 1, false);
        Porte porteVerrouillee = new Porte(1, 1, 1, true);
        System.out.println("\nEXERCICE sur les Exceptions");
        
        try {
            System.out.println("Je verrouille une porte déverouillée");   
            System.out.println("Est-ce qu'à l'instanciation la porte est verrouillée ? Réponse : " + porteDeverrouillee.estVerrouillee());
            porteDeverrouillee.verrouiller();
            System.out.println("La porte est maintenant verrouillée : " + porteDeverrouillee.estVerrouillee());
        } catch (PorteVerrouilleeException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            porteVerrouillee.verrouiller();
        } catch (PorteVerrouilleeException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nEXERCICE sur les Streams");
        Kit kit = new Kit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int choix = 0;
        
        do {
            try {
                System.out.println("Que souhaitez-vous afficher ?\n1 - Les idées de constructions.\n2 - Le nombre de blocs pour chaque type de blocs présent dans le kit");
                String input = reader.readLine();
                choix = Integer.parseInt(input);
            } catch (NumberFormatException | IOException e) {
                choix = 0;
                System.out.println("\nChoix invalide. Veuillez entrer 1 ou 2.\n");
            }
        } while(choix < 1 || choix > 2);
        
        switch(choix) {
            case 1:
                System.out.println("Les idées de constructions : ");
                kit.afficherIdees();
                break;
            case 2:
                System.out.println("Le nombre de blocs pour chaque type de blocs présent dans le kit : ");
                kit.afficherBlocsParType();
                break;
        }
        
        System.out.println("\nEXERCICE sur les Lambda");
        kit.afficherIdeesWithLambda();
        System.out.println("J'instancie une porte verrouillée:");
        Porte porteVerrou = new Porte(1, 1, 1, true);
        System.out.println("Ma porte est verrouillée : " + porteVerrou.estVerrouillee());
        porteVerrou.forcerSerrure((cle) -> {
            return cle == "Password123";
        });
        System.out.println("Ma porte est verrouillée : " + porteVerrou.estVerrouillee());
        
    }
}