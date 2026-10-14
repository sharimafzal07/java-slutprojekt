// Subclass representing a personal-trainer member. Extends Medlem (inheritance) and implements Bokningsbar
// (interface), and also has its own extra field (personligTränare) that the other subclasses don't have.
public class PTMedlem extends Medlem implements Bokningsbar {
    private String personligTränare;

    public PTMedlem(String namn, int medlemsnummer, int ålder, String personligTränare) {
        super(namn, medlemsnummer, ålder);
        this.personligTränare = personligTränare;
    }

    public String getPersonligTränare() {
        return personligTränare;
    }

    // Overridden: PT members pay the highest monthly fee
    @Override
    public double beräknaMånadsavgift() {
        return 800;
    }

    // Overridden: shows PT-specific info, including the trainer's name
    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (PT-medlem, tränare: " + getPersonligTränare() + ")");
    }

    // Implements the Bokningsbar interface: PT members can book a session with their trainer
    @Override
    public void boka() {
        System.out.println(getNamn() + " har bokat en PT-session med " + getPersonligTränare() + ".");
    }
}