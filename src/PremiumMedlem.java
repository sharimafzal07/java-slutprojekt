public class PremiumMedlem extends Medlem {
    public PremiumMedlem(String namn, int medlemsnummer, int ålder) {
        super(namn, medlemsnummer, ålder);
    }

    @Override
    public double beräknaMånadsavgift() {
        return 500;
    }
}