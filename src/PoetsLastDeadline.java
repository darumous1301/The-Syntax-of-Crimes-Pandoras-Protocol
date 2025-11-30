//poetslastdeadline.java
class PoetsLastDeadline extends Case {
    private Suspect suspect;

    public PoetsLastDeadline() {
        super(
                6601,
                "\u001B[36m Case of Poet's Last Deadline \u001B[36m",
                "Oliver Grant, a relentless investigative journalist, was found dead inside his cluttered flat in London where he was about to submit his written piece to his boss. He was working on an exposé about political corruption involving three potential whistleblowers whom are now suspects. Pinned to Oliver's chest was a handwritten poem, torn from a notebook\nTHE POEM\nIn shadows deep where truth may hide, A voice was sparked but quickly died.\nThose who seek the whispered lie,\nWill fall beneath a watching eye.\nFor silence keeps the world in peace,\nTill prying minds at last shall cease.\n A Keeper of Quiet, R.M.S.. at first, the police think it's a suicide note.",
                "Rebecca Moore:\n-Oliver\'s assistant and last person to speak to him\n-helped oliver gather insider political info.\n-claims she warned him to stop digging\n-denies writing the poem\ninitial: R.M.\n\nMichael Sanders:\n-friend of Oliver that worked at a competing newspaper.\n-says he was home writing at the time.\n-initial: M.S.\n\nSamuel Reeves (Data Analyst/ Whistleblower):\n-provided Oliver with leaked documents\n-terrified of being exposed\n-claims Oliver was pushing too hard.\n-initial: S.R.",
                "1. Handwritten poem pinned to chest\nTHE POEM\nIn shadows deep where truth may hide, A voice was sparked but quickly died.\nThose who seek the whispered lie,\nWill fall beneath a watching eye.\nFor silence keeps the world in peace,\nTill prying minds at last shall cease.\n– A Keeper of Quiet, R.M.S.\n\n2. Notebook with torn page(some pages does not match with the poem\'s handwriting)\n3. Political corruption files\n4. Three whistleblower contacts");
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
        System.out.println("====== Case of Poet's Last Deadline ======");
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
        System.out.println("\033[33m║     POET'S LAST DEADLINE - ANALYSIS    ║\033[0m");
        System.out.println("\033[33m╚═══════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("THE POEM SIGNATURE:");
        System.out.println("   Signature 'R.M.S.' could match:");
        System.out.println("   Rebecca Moore (R.M.)");
        System.out.println("   Michael Sanders (M.S.)");
        System.out.println("   Samuel Reeves (S.R.)");
        System.out.println();
        System.out.println("KEY CLUE:");
        System.out.println("   The poem shows literary skill and poetic style.");
        System.out.println("   He is known for 'poetic flair' in writing.");
        System.out.println();
        System.out.println("MOTIVE:");
        System.out.println("   He had professional rivalry with Oliver.");
        System.out.println("   Oliver consistently beat him to major stories.");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("   Evidence points to him.");
        System.out.println();
    }

    @Override
    public boolean isCaseSolved() {
        return suspect == PoetsLastDeadlineSuspects.MICHAEL_SANDERS;
    }
}
