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
                    System.out.println("Vilken typ? 1=Student 2=Premium 3=PT");
                    int typ = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Namn: ");
                    String nyttNamn = scanner.nextLine();
                    System.out.print("Medlemsnummer: ");
                    int nyttNummer = scanner.nextInt();
                    System.out.print("Ålder: ");
                    int nyÅlder = scanner.nextInt();

                    if (typ == 1) {
                        medlemmar.add(new StudentMedlem(nyttNamn, nyttNummer, nyÅlder));
                    } else if (typ == 2) {
                        medlemmar.add(new PremiumMedlem(nyttNamn, nyttNummer, nyÅlder));
                    } else if (typ == 3) {
                        System.out.print("Tränarens namn: ");
                        String tränare = scanner.nextLine();
                        medlemmar.add(new PTMedlem(nyttNamn, nyttNummer, nyÅlder, tränare));
                    } else {
                        System.out.println("Ogiltig typ.");
                    }
                    break;
                case 2:
                    System.out.println("Nuvarande medlemmar:");
                    for (int i = 0; i < medlemmar.size(); i++) {
                        medlemmar.get(i).visaInfo(); }

                    System.out.print("Vilket medlemsnummer ska tas bort? ");
                    int nummerAttTaBort = scanner.nextInt();

                    for (int i = 0; i < medlemmar.size(); i++) {
                        if (medlemmar.get(i).getMedlemsnummer() == nummerAttTaBort) {
                            medlemmar.remove(i);
                            System.out.println("Medlem borttagen.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nuvarande medlemmar:");
                    for (int i = 0; i < medlemmar.size(); i++) {
                        medlemmar.get(i).visaInfo();
                    }

                    System.out.print("Vilket medlemsnummer vill du söka efter? ");
                    int nummerAttSöka = scanner.nextInt();
                    boolean hittad = false;

                    for (int i = 0; i < medlemmar.size(); i++) {
                        if (medlemmar.get(i).getMedlemsnummer() == nummerAttSöka) {
                            medlemmar.get(i).visaInfo();
                            hittad = true;
                            break;
                        }
                    }

                    if (!hittad) {
                        System.out.println("Ingen medlem med det numret hittades.");
                    }
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