public class Main {
    public static void main(String[] args) {
        String toDisplay = Main.concatenate("Hello World", "!");
        System.out.println(toDisplay);
        
        // Exercise
        int[] initialValues = {26, 10, 1985, 0, 12, 11, 1955};
        System.out.println(howManyNuls(initialValues));
    }
    
    public static String concatenate(final String phrase, final String punctuation){
        return phrase + punctuation;
    }
    
    public static int howManyNuls(int[] initialValues) {
        int cpt = 0;
        
        for(int value : initialValues) {
            if(value == 0){
                cpt++;
            }
        }
        
        return cpt;
    }
}