// Subclass representing a premium member. Extends Medlem (inheritance) and implements Bokningsbar (interface),
// since premium members are allowed to make bookings, unlike students.
public class PremiumMedlem extends Medlem implements Bokningsbar {

    public PremiumMedlem(String namn, int medlemsnummer, int ålder) {
        super(namn, medlemsnummer, ålder);
    }

    // Overridden: premium members pay a higher monthly fee
    @Override
    public double beräknaMånadsavgift() {
        return 500;
    }

    // Overridden: shows premium-specific info
    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (Premium, medlem #" + getMedlemsnummer() + ")");
    }

    // Implements the Bokningsbar interface: premium members can book a group training session
    @Override
    public void boka() {
        System.out.println(getNamn() + " har bokat en gruppträning.");
    }
}