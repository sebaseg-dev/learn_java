public class Main {
    public static void main(String[] args) {
        String toDisplay = Main.concatenate("Hello World", "!");
        System.out.println(toDisplay);
    }
    
    public static String concatenate(final String phrase, final String punctuation){
        return phrase + punctuation;
    }
}