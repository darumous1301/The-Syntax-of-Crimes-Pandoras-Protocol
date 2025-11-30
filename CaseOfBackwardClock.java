//CaseOfBackwardClock.java
class CaseOfBackwardClock extends Case {
    private Suspect suspect;

    public CaseOfBackwardClock() {
        super( //Super constructor for case class
                6605,
                "\u001B[36m The Case of the Backward Clock \u001B[36m",
                "Master clockmaker Heinrich Muller was found dead in his workshop at exactly 3:15 AM, surrounded by hundreds of ticking clocks. He had been strangled with a watch chain. The peculiar detail: every single clock in the workshop had been set to different times, and his prized grandfather clock was running backwards. Heinrich had recently discovered that someone was smuggling diamonds inside custom-made pocket watches he crafted for wealthy clients. He left a cryptic message carved into his workbench: \"The truth strikes at the thirteenth hour.\" Three people had appointments with him the day before his death.",
                "Madeline Frost (Wealthy Collector):- Commissioned an expensive pocket watch for her husband\'s birthday\n- Met Heinrich at 2 PM to discuss design specifications\n- Claims she left at 2:45 PM and went straight to her hotel\n- Hotel has no cameras, receptionist doesn\'t remember seeing her\n- Her watch collection includes 47 pieces worth over £2 million\n- Has connections to international auction houses\n\nVictor Sterling (Business Partner):\n- Co-owns the workshop and handles all international sales\n- Says he was at a dinner meeting with investors from 7 PM to 11 PM\n- Three witnesses confirm his presence at the restaurant\n- Has keys to the workshop and knows the alarm code\n- Heinrich recently questioned him about \"discrepancies\" in shipment records\n- Financial records show unexplained deposits totaling £850,000\n\nThomas Wickham (Apprentice):\n- Heinrich\'s student for 3 years, learning the craft\n- Claims he left work at 6 PM as usual\n- His landlady confirms he returned home at 6:30 PM\n- But his phone\'s GPS shows he returned to the workshop area at 2:47 AM\n- Recently denied a promotion and pay raise by Heinrich\n- Has gambling debts of £45,000)",
                "- Every clock set to different times - except 7 clocks all showing 11:30 PM\n- Grandfather clock running backwards\n-Message carved in workbench: \"The truth strikes at the thirteenth hour\"\n- Watch chain used as murder weapon - high-quality platinum, custom-made.\n- Heinrich\'s appointment book: \"V.S. - 11:30 PM - FINAL WARNING\" written for previous night\n- Hidden compartment in workbench containing photos of hollow pocket watches\n- Security footage erased from 11PM to 4AM\n- Victim\'s watch stopped at 3:15 AM (time of death)\n- Fresh wood shavings under the carved message - carved recently, not old.");
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
        System.out.println("====== The Case of the Backward Clock ======");
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
        System.out.println("\033[33m║    CASE OF BACKWARD CLOCK - ANALYSIS   ║\033[0m");
        System.out.println("\033[33m╚═══════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("TIMELINE:");
        System.out.println("Security footage deleted from 11 PM onwards");
        System.out.println("7 clocks frozen at 11:30 PM");
        System.out.println("Someone was there at 11:30 PM and tried to hide it");
        System.out.println();
        System.out.println("KEY QUESTIONS:");
        System.out.println("Who had access after 11 PM?");
        System.out.println("Who could delete security footage?");
        System.out.println("Who matches the appointment V.S. at 11:30 PM?");
        System.out.println();

        System.out.println();
    }

    @Override
    public boolean isCaseSolved() {
        return suspect == CaseOfBackwardClockSuspects.VICTOR_STERLING;
    }
}
