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
            System.out.println("6. Boka");
            System.out.print("Välj alternativ: ");
            int val = -1;
            boolean giltigInmatning = true;

            try {
                val = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen.");
                giltigInmatning = false;
            }

            if (giltigInmatning) {
                switch (val) {
                    case 1:
                        System.out.println("Vilken typ? 1=Student 2=Premium 3=PT");
                        int typ = -1;
                        boolean giltigTyp = true;
                        try {
                            typ = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig inmatning för typ.");
                            giltigTyp = false;
                        }

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
                        double totalIntäkt = 0;
                        for (int i = 0; i < medlemmar.size(); i++) {
                            totalIntäkt = totalIntäkt + medlemmar.get(i).beräknaMånadsavgift();
                        }
                        System.out.println("Total månadsintäkt: " + totalIntäkt + " kr");
                        break;
                    case 5:
                        fortsätt = false;
                        break;
                    case 6:
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


