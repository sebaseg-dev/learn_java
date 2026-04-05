package fr.sebaseg.helloworld.service;

import fr.sebaseg.helloworld.model.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {
    public HelloWorld getHelloWorld() {
        return new HelloWorld();
    }
}
