//stolenFormula.java
public class StolenFormula extends Case {
    private Suspect suspect;

    public StolenFormula() {
        super(
                6603,
                "\u001B[36m The Stolen Formula \u001B[36m",
                "Scientist Sir Claudio discovers his formula for a new atomic explosive has been stolen from his safe. He calls Sherlock for help and gathers his household members, locking them in a room. He offers a deal: lights will go off for one minute, and whoever stole the formula should return it to the table with no questions asked. When the lights return, the envelope is on the table, but Sir Claudio is found dead in his chair and the envelope is empty. His coffee was poisoned with hyoscine.",
                "Lucia (Richard's Italian wife):\n-Daughter of Selma Goetz, an international spy\n-Served the coffee to Sir Claud\n-Admits to stealing hyoscine (intended for suicide)\n-Confesses to murder\n\nDr. Carelli (Lucia's old friend):\n-Was blackmailing Lucia to steal the documents\n-Made the duplicate safe key\n\nRichard (Sir Claud's son):\n-Claims he's guilty to protect Lucia\n-His wife served the poisoned coffee\n\nEdward Raynor (Secretary):\n-Had access to Sir Claud and the household\n-Served Sherlock whisky during investigation",
                "1. Poison timing: Sir Claud was already poisoned before he locked everyone in the room\n2.Duplicate key: Found for Sir Claud's safe\n3. Blackmail letters: Warning Sir Claud to stay away from Selma Goetz and her brood\n4. Torn formula: Found hidden in pieces inside a vase\n5. Second poisoning attempt: Sherlocks whisky is poisoned during the investigation");
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
        System.out.println("====== The Stolen Formula ======");
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
        System.out.println("\033[33m║      THE STOLEN FORMULA - ANALYSIS    ║\033[0m");
        System.out.println("\033[33m╚═══════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("TIMELINE:");
        System.out.println("   Sir Claudio was poisoned BEFORE the blackout.");
        System.out.println("   The poison was already in his coffee.");
        System.out.println();
        System.out.println("THE FALSE CONFESSION:");
        System.out.println("   Lucia confesses to murder");
        System.out.println("   She served the coffee (obvious suspect)");
        System.out.println("   Richard also confesses to protect her");
        System.out.println();
        System.out.println("CRITICAL CLUE:");
        System.out.println("   Sherlock's whisky was ALSO poisoned!");
        System.out.println("   He served that whisky.");
        System.out.println("   Only he had opportunity for BOTH poisonings.");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("   He framed Lucia using her stolen poison.");
        System.out.println();
    }

    @Override
    public boolean isCaseSolved() {
        return suspect == StolenFormulaSuspects.EDWARD_RAYNOR;
    }
}
