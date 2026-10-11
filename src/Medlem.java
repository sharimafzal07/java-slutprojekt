public class Medlem {
    private String namn;
    private int medlemsnummer;
    private int ålder;

    public Medlem(String namn, int medlemsnummer, int ålder) {
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
}
}