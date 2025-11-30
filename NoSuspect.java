// generic no suspect enum for default state
public enum NoSuspect implements Suspect {
    NONE("No suspect chosen yet (Enter) to proceed", "N/A");

    private final String fullName;
    private final String role;

    NoSuspect(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "None";
    }

    public String getRole() {
        return role;
    }
}