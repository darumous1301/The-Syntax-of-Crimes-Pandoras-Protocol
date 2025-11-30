//ChemistryLabMurder.java
class ChemistryLabMurder extends Case {
    private Suspect suspect;

    public ChemistryLabMurder() {
        super(
                6602,
                "\u001B[36m The Chemistry Lab Murder \u001B[36m",
                "Isaac Santiago, Grade 12 and president of the Chemistry Club, is found dead in the Chemistry Lab, stabbed in the side with a broken graduated cylinder. His body is still warm, suggesting he died less than an hour before discovery. Before dying, Isaac sent identical threatening text messages to three people: \"I know what you're doing. Meet me at the Chem Lab during lunch time if you don't want others to find out.\" He left a dying message written in blood: the numbers 32-10-14-16.",
                "Henry Chua (Vice President, Chemistry Club):\n-Claims he was in the 5th floor bathroom with diarrhea during the time of murder\n-(No witnesses) has no alibi\n-Did NOT hear the school bell\n\nGenesis Mendez (Officer, Chemistry Club)\n-Claims he was on the rooftop smoking a cigarette\nRooftop is restricted area due to attempted suicide the day before - alone, no witnesses\n-CLAIMED he heard the school bell at 1:00 PM\n\nJohn Bautista (Secretary, Chemistry Club):\n-Claims he was at the stone benches reviewing Algebra notes for a quiz\n-Weak alibi - other students were nearby but may not remember seeing him\n-Did NOT hear the school bell(had his headphones on)",
                "Dying message: Numbers written in blood: 32-10-14-16\nMissing chemicals: Some bottles of chemical compounds are missing from the lab cabinet\n");
        this.suspect = NoSuspect.NONE;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    @Override
    public void displayCaseInfo() {
        System.out.println("====== The Chemistry Lab Murder ======");
        System.out.println("Case ID: " + getCaseID());
        System.out.println();
        System.out.println("Case Name: " + getCaseName());
        System.out.println();
        System.out.println("Case Description: \n" + getCaseDescription());
        System.out.println();
        System.out.println("====== Suspects' Alibi ======\n" + getSuspectAlibi());
        System.out.println();
        System.out.println("Evidences: \n" + getEvidences());
        System.out.println();
        System.out.println("Suspect: " + suspect.getFullName());
    }

    @Override
    public void analyzeCaseClues() {
        System.out.println("\n\033[33m╔═══════════════════════════════════════╗\033[0m");
        System.out.println("\033[33m║      THE CHEMISTRY LAB MURDER - ANALYSIS       ║\033[0m");
        System.out.println("\033[33m╚═══════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("TIMELINE:");
        System.out.println("   The school bell malfunctioned and didn't ring at 1:00 PM that day");
        System.out.println("   Time of death: Between 12:30 PM and 1:00 PM");
        System.out.println();
        System.out.println("CRITICAL CLUE:");
        System.out.println("   Dying message: Numbers written in blood: 32-10-14-16");
        System.out.println("   Elements of Periodic Table: Germanium-Neon-Silicon-Sulfur");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("   Isaac discovered that someone with access to the Chemistry Lab was stealing chemical compounds...");
        System.out.println();
    }

    @Override
    public boolean isCaseSolved() {
        return suspect == ChemistryLabMurderSuspects.GENESIS_MENDEZ;
    }
}
