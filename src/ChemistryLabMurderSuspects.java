// Enum for Case 6602 - Chemistry Lab Murder
public enum ChemistryLabMurderSuspects implements Suspect {
    HENRY_CHUA("Henry Chua", "Vice President, Chemistry Club"),
    GENESIS_MENDEZ("Genesis Mendez", "Officer, Chemistry Club"),
    JOHN_BAUTISTA("John Bautista", "Secretary, Chemistry Club");

    private final String fullName;
    private final String role;

    ChemistryLabMurderSuspects(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "Chemistry Lab Murder";
    }

    public String getRole() {
        return role;
    }
}