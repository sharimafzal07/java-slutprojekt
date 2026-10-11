public class StudentMedlem extends Medlem {
    public StudentMedlem(String namn, int medlemsnummer, int ålder) {
        super(namn, medlemsnummer, ålder);
    }


    @Override
    public double beräknaMånadsavgift() {
        return 150;
    }

    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (Student, medlem #" + getMedlemsnummer() + ")");
    }
}