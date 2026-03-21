package ej;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import ej.blocs.*;

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
    
    public void afficherIdees() {
        for(String mot : this.motClefs) {
            System.out.println(mot);
        }
    }
    
    public void afficherIdeesWithLambda() {
        this.motClefs.forEach(System.out::println);
    }
    
    public void afficherBlocsParType() {
        Map<String, Integer> blocsParType = new HashMap<>();
        for(IBloc bloc : this.blocs) {
            String type = bloc.getClass().getSimpleName();
            blocsParType.put(type, blocsParType.getOrDefault(type, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : blocsParType.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}