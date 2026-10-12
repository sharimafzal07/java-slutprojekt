import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medlem> medlemmar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean fortsätt = true;

        while (fortsätt) {
            System.out.println("1. Lägg till medlem");
            System.out.println("2. Ta bort medlem");
            System.out.println("3. Sök medlem");
            System.out.println("4. Visa total månadsintäkt");
            System.out.println("5. Avsluta");
            System.out.print("Välj alternativ: ");
            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    fortsätt = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}