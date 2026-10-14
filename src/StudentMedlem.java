// Subclass representing a student member. Extends Medlem (inheritance) to reuse shared fields and getters.
public class StudentMedlem extends Medlem {

    // Constructor calls the superclass constructor with super() to set the shared fields
    public StudentMedlem(String namn, int medlemsnummer, int ålder) {
        super(namn, medlemsnummer, ålder);
    }

    // Overridden: students pay a reduced monthly fee
    @Override
    public double beräknaMånadsavgift() {
        return 150;
    }

    // Overridden: shows student-specific info
    @Override
    public void visaInfo() {
        System.out.println(getNamn() + " (Student, medlem #" + getMedlemsnummer() + ")");
    }
}