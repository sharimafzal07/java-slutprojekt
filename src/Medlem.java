public class Medlem {
    private String namn;
    private int medlemsnummer;
    private int ålder;

    public Medlem(String namn, int medlemsnummer, int ålder) {
        if (ålder < 0) {
            throw new IllegalArgumentException("Ålder kan inte vara negativ");
        }
        this.namn = namn;
        this.medlemsnummer = medlemsnummer;
        this.ålder = ålder;
    }

    public String getNamn() {
        return namn;
    }

    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    public int getÅlder() {
        return ålder;
    }

    public double beräknaMånadsavgift() {
        return 300;
    }
    public void visaInfo() {
        System.out.println(namn + " (medlem #" + medlemsnummer + ")");
    }
}
