//ConductorsFinalNote.java
class ConductorsFinalNote extends Case {
    private Suspect suspect;

    public ConductorsFinalNote() {
        super(
                6604,
                "\u001B[36m The Case of the Conductor\'s Final Note \u001B[36m",
                "Maestro Alessandro Romano was found stabbed through the heart with his own silver baton in his soundproof rehearsal room at the Royal Opera House. The room was locked from inside with the key in his pocket. A damaged vinyl record played Beethoven's 5th on repeat: \"da-da-da-DUM, da-da-da-DUM.\" Alessandro planned to expose \"the truth behind the symphony\" at tomorrow's gala. Three people had rehearsals with him that evening.",
                "Isabella Moretti (First Violin):\n- Had 7 PM rehearsal, left at 7:45 PM\n- CCTV confirms she left building at 7:50 PM\n- Was having an affair with Alessandro\n- He promised to leave his wife but changed his mind that day\n- Known for violent temper\n\nDr. Philip Chen (Orchestra Doctor/Cellist):\n- Had 8 PM rehearsal, claims he left at 8:40 PM\n- Has medical knowledge\n- Alessandro discovered Philip was selling illegal prescription drugs\n- Threatened to report him to medical board\n- Left through side exit (no cameras)\n\nMarcus Webb (Stage Manager):\n- Had 9 PM meeting scheduled\n- Claims Alessandro cancelled via text at 8:55 PM\n- Has master keys to all rooms\n- Alessandro was blocking his promotion\n- Desperately needs money for mother\'s medical bills\n- Discovered the body at 10:30PM\n\n",
                "1. Room locked from inside, key in victim\'s pocket\n2. Beethoven\'s 5th playing on repeat - record deliberately scratched\n3. Four notes: \"da-da-da-DUM\"\n4. Time of death: 8:30 PM - 9:15 PM\n5. Alessandro\'s phone shows no text sent to Marcus at 8:55 PM\n6. Ventilation shaft - 18 inches wide\n7. Dark blue fabric (medical scrubs) caught on ventilation grate\n8. Baton wiped clean of fingerprints\n9. Alessandro\'s notes: \"Dr. Chen\'s illegal operation must be exposed\"\n10. Security log: Dr. Chen's ID accessed backstage at 9:05 PM (after he claimed to leave)\n");
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
        System.out.println("====== The Case of the Conductor\'s Final Note ======");
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
        System.out.println("\n\033[33m╔═══════════════════════════════════==════╗\033[0m");
        System.out.println("\033[33m║  THE CONDUCTOR\'S FINAL NOTE - ANALYSIS ║\033[0m");
        System.out.println("\033[33m╚══════════==═════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("TIMELINE:");
        System.out.println("8:40 PM - Someone claims they left");
        System.out.println("9:05 PM - Same person\'s ID card used backstage");
        System.out.println();
        System.out.println("THE FAKE TEXT");
        System.out.println("Alessandro\'s phone shows no text sent at 8:55 PM");
        System.out.println("Yet Marcus received cancellation text. Someone faked it to delay discovery.");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("Faced career destruction within 24 hours....");
        System.out.println();
    }

    @Override
    public boolean isCaseSolved() {
        return suspect == ConductorsFinalNoteSuspects.DR_PHILIP_CHEN;
    }
}
