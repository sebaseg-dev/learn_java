package ej.blocs;

import ej.blocs.Mur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletionException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fabrique {
    
    private static Logger logger = LogManager.getLogger(Fabrique.class);
    
    public static List<IBloc> creerMurSequentiel(int quantite) {
        List<IBloc> liste = new ArrayList<>();
        
        for(int i = 0; i < quantite; i++) {
            liste.add(new Mur(1, 1, 1, false));
        }
        
        return liste;
    }
    
    public static List<IBloc> creerMur(int quantite) {
        List<IBloc> liste = new ArrayList<>();
        
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        
        List<Callable<IBloc>> tasks = new ArrayList<>();
        
        for(int i = 0; i < quantite; i++) {
            tasks.add(() -> { return new Mur(1, 1, 1, false); });
        }
        
        try {
            List<Future<IBloc>> results = executorService.invokeAll(tasks);
            results.forEach((result) -> {
                try {
                    liste.add(result.get());
                } catch(InterruptedException | ExecutionException e) {
                    logger.error("Erreur lors de création parallèle des blocs.");
                }
            });
        } catch(InterruptedException e) {
            logger.error("Erreur lors de création parallèle des blocs.");
        }
        
        return liste;
    }
}