// Enum for Case 6603 - Stolen Formula
public enum StolenFormulaSuspects implements Suspect {
    LUCIA("Lucia", "Richard's Italian Wife"),
    DR_CARELLI("Dr. Carelli", "Lucia's Old Friend"),
    RICHARD("Richard", "Sir Claud's Son"),
    EDWARD_RAYNOR("Edward Raynor", "Secretary");

    private final String fullName;
    private final String role;

    StolenFormulaSuspects(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "Stolen Formula";
    }

    public String getRole() {
        return role;
    }
}