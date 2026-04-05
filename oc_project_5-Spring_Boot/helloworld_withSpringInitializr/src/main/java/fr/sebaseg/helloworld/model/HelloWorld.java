package fr.sebaseg.helloworld.model;

public class HelloWorld {
    String value = "Hello World!";

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
