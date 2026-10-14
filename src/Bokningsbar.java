// Interface: a contract that guarantees a boka() (book) method.
// Only member types that are allowed to make bookings (PremiumMedlem, PTMedlem) implement this —
// StudentMedlem does not, since students don't have booking rights.
public interface Bokningsbar {
    void boka();
}