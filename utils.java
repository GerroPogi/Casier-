import java.util.Scanner;

public class utils {
    public static void typewriter(String text, int milliseconds) throws InterruptedException {
        for(int i = 0; i<text.length(); i++){
            System.out.print(text.charAt(i));
            Thread.sleep(milliseconds);
        }
        System.out.println();
    }
    public static String getStringInput(String text, int milliseconds) throws InterruptedException {
        typewriter(text, milliseconds);
        return new Scanner(System.in).nextLine();
    }
    public static void cls(){
        System.out.print("\f");
    }
    public static void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}
