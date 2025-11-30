// Enum for case 6604 
public enum ConductorsFinalNoteSuspects implements Suspect {
    ISABELLA_MORETTI("Isabella Moretti", "First Violin"),
    DR_PHILIP_CHEN("Dr. Philip Chen", "Orchestra Doctor/Cellist"),
    MARCUS_WEBB("Marcus Webb", "Stage Manager");

    private final String fullName;
    private final String role;

    ConductorsFinalNoteSuspects(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "The Conductor\'s Final Note";
    }

    public String getRole() {
        return role;
    }
}