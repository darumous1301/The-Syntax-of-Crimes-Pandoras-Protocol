// CaseOfBackwardClockSuspects.java
public enum CaseOfBackwardClockSuspects implements Suspect {
    MADELINE_FROST("Madeline Frost", "Wealthy Collector"),
    VICTOR_STERLING("Victor Sterling", "Business Partner"),
    THOMAS_WICKHAM("Thomas Wickham", "Apprentice");

    private final String fullName;
    private final String role;

    CaseOfBackwardClockSuspects(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "Case of Backward Clock";
    }

    public String getRole() {
        return role;
    }
}
