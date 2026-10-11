public class PTMedlem extends Medlem {
    private String personligTränare;

    public PTMedlem(String namn, int medlemsnummer, int ålder, String personligTränare) {
        super(namn, medlemsnummer, ålder);
        this.personligTränare = personligTränare;
    }

    public String getPersonligTränare() {
        return personligTränare;
    }

    @Override
    public double beräknaMånadsavgift() {
        return 800;
    }

    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (PT-medlem, tränare: " + getPersonligTränare() + ")");
    }
}