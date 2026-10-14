// Superclass for all gym members. Holds the data and behavior shared by every member type.
public class Medlem {
    // Private fields — encapsulation: data can only be accessed through getters, not directly from outside the class
    private String namn;
    private int medlemsnummer;
    private int ålder;

    // Constructor: validates input and sets the fields when a new member is created
    public Medlem(String namn, int medlemsnummer, int ålder) {
        // Throws an exception if age is invalid, caught later in Main (exception handling)
        if (ålder < 0) {
            throw new IllegalArgumentException("Ålder kan inte vara negativ");
        }
        this.namn = namn;
        this.medlemsnummer = medlemsnummer;
        this.ålder = ålder;
    }

    // Getters — controlled read access to the private fields
    public String getNamn() {
        return namn;
    }

    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    public int getÅlder() {
        return ålder;
    }

    // Default monthly fee. Overridden by each subclass (polymorphism).
    public double beräknaMånadsavgift() {
        return 300;
    }

    // Default info display. Overridden by each subclass (polymorphism).
    public void visaInfo() {
        System.out.println(namn + " (medlem #" + medlemsnummer + ")");
    }
}