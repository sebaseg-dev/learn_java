package ej;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Kit {
    private List<IBloc> blocs = new ArrayList<>();
    private Set<String> motClefs = new LinkedHashSet<>();
    
    public Kit() {
        blocs.add(new Mur(3, 2, 2, true));
        blocs.add(new Mur(3, 2, 2, true));
        blocs.add(new Mur(2, 1, 2, false));
        blocs.add(new Mur(2, 1, 2, false));
        blocs.add(new Porte(1, 2, 2, true));
        
        motClefs.add("Cabane");
        motClefs.add("Muraille");
    }
    
    public void afficherKit() {
        System.out.println("\nEXERCICE KIT: Contenu du kit\nLe kit est composé de " + blocs.size() + " blocs.");
        
        for (IBloc bloc : blocs) {
            bloc.afficherDescription();
        }
        
        System.out.println("Ils peuvent permettre de construire : " + String.join(", ", motClefs));
    }
}