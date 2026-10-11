public class PremiumMedlem extends Medlem implements Bokningsbar {
    public PremiumMedlem(String namn, int medlemsnummer, int ålder) {
        super(namn, medlemsnummer, ålder);
    }

    @Override
    public double beräknaMånadsavgift() {
        return 500;
    }

    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (Premium, medlem #" + getMedlemsnummer() + ")");
    }
    @Override
    public void boka() {
        System.out.println(getNamn() + " har bokat en gruppträning.");
    }
}