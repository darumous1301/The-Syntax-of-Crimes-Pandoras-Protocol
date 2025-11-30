//poetsLastDeadlineSuspects.java
public enum PoetsLastDeadlineSuspects implements Suspect { // Enum for case 6603
    REBECCA_MOORE("Rebecca Moore", "Assistant"),
    MICHAEL_SANDERS("Michael Sanders", "Rival Journalist"),
    SAMUEL_REEVES("Samuel Reeves", "Data Analyst/Whistleblower");

    private final String fullName;
    private final String role;

    PoetsLastDeadlineSuspects(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "Poet's Last Deadline";
    }

    public String getRole() {
        return role;
    }
}
