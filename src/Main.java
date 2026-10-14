import java.util.ArrayList;
import java.util.Scanner;

// Main class: runs the interactive console menu for the gym membership system.
// Holds the collection of members (ArrayList) and the menu loop with all user actions.
public class Main {
    public static void main(String[] args) {
        // Collection of all members, can contain any subclass of Medlem (polymorphism)
        ArrayList<Medlem> medlemmar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean fortsätt = true;

        // Menu loop: keeps running until the user chooses to exit (option 5)
        while (fortsätt) {
            System.out.println("1. Lägg till medlem");
            System.out.println("2. Ta bort medlem");
            System.out.println("3. Sök medlem");
            System.out.println("4. Visa total månadsintäkt");
            System.out.println("5. Avsluta");
            System.out.println("6. Boka");
            System.out.print("Välj alternativ: ");
            int val = -1;
            boolean giltigInmatning = true;

            // Exception handling: catches invalid (non-numeric) menu input instead of crashing
            try {
                val = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen.");
                giltigInmatning = false;
            }

            // Only run the menu action if the input was actually a valid number
            if (giltigInmatning) {
                switch (val) {
                    case 1:
                        // Add member: ask for type, then name/number/age, then create the right subclass
                        System.out.println("Vilken typ? 1=Student 2=Premium 3=PT");
                        int typ = -1;
                        boolean giltigTyp = true;
                        try {
                            typ = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig inmatning för typ.");
                            giltigTyp = false;
                        }

                        // Stop early if the type itself was invalid, instead of asking for more details
                        if (giltigTyp) {
                            System.out.print("Namn: ");
                            String nyttNamn = scanner.nextLine();
                            System.out.print("Medlemsnummer: ");
                            int nyttNummer = -1;
                            try {
                                nyttNummer = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Ogiltig inmatning för medlemsnummer.");
                            }

                            System.out.print("Ålder: ");
                            int nyÅlder = -1;
                            try {
                                nyÅlder = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Ogiltig inmatning för ålder.");
                            }

                            // Creates the right subclass based on the chosen type (StudentMedlem/PremiumMedlem/PTMedlem)
                            // Catches IllegalArgumentException thrown by Medlem's constructor if age is invalid
                            try {
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
                            } catch (IllegalArgumentException e) {
                                System.out.println("Fel: " + e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        // Remove member: lists all members (polymorphism via visaInfo()), then searches by member number
                        System.out.println("Nuvarande medlemmar:");
                        for (int i = 0; i < medlemmar.size(); i++) {
                            medlemmar.get(i).visaInfo();
                        }

                        System.out.print("Vilket medlemsnummer ska tas bort? ");
                        int nummerAttTaBort = -1;
                        try {
                            nummerAttTaBort = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig inmatning.");
                        }

                        for (int i = 0; i < medlemmar.size(); i++) {
                            if (medlemmar.get(i).getMedlemsnummer() == nummerAttTaBort) {
                                medlemmar.remove(i);
                                System.out.println("Medlem borttagen.");
                                break;
                            }
                        }
                        break;
                    case 3:
                        // Search member: finds a member by member number and shows their info
                        System.out.println("Nuvarande medlemmar:");
                        for (int i = 0; i < medlemmar.size(); i++) {
                            medlemmar.get(i).visaInfo();
                        }

                        System.out.print("Vilket medlemsnummer vill du söka efter? ");
                        int nummerAttSöka = -1;
                        try {
                            nummerAttSöka = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig inmatning.");
                        }
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
                        // Total monthly revenue: aggregates real data from the ArrayList.
                        // beräknaMånadsavgift() is polymorphic — same call, different result per subclass.
                        double totalIntäkt = 0;
                        for (int i = 0; i < medlemmar.size(); i++) {
                            totalIntäkt = totalIntäkt + medlemmar.get(i).beräknaMånadsavgift();
                        }
                        System.out.println("Total månadsintäkt: " + totalIntäkt + " kr");
                        break;
                    case 5:
                        // Exit: stops the menu loop
                        fortsätt = false;
                        break;
                    case 6:
                        // Book: finds a member by number, then checks if they implement Bokningsbar (interface)
                        // before allowing a booking. This is polymorphic use of the interface.
                        System.out.println("Nuvarande medlemmar:");
                        for (int i = 0; i < medlemmar.size(); i++) {
                            medlemmar.get(i).visaInfo();
                        }

                        System.out.print("Vilket medlemsnummer vill boka? ");
                        int nummerAttBoka = -1;
                        try {
                            nummerAttBoka = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig inmatning.");
                        }

                        for (int i = 0; i < medlemmar.size(); i++) {
                            Medlem m = medlemmar.get(i);
                            if (m.getMedlemsnummer() == nummerAttBoka) {
                                if (m instanceof Bokningsbar b) {
                                    b.boka();
                                } else {
                                    System.out.println("Den här medlemstypen kan inte boka.");
                                }
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            }
        }
    }
}