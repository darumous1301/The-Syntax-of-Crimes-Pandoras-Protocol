public abstract class Case { //base class for all cases
    private int caseID;
    private String caseName;
    private String caseDescription;
    private String suspectAlibi;
    private String evidences;

    public Case(int caseID, String caseName, String caseDescription, String suspectAlibi, String evidences) {
        this.caseID = caseID;
        this.caseName = caseName;
        this.caseDescription = caseDescription;
        this.suspectAlibi = suspectAlibi;
        this.evidences = evidences;
    }

    public Case() {
        this.caseID = 0;
        this.caseName = "";
        this.caseDescription = "";
        this.suspectAlibi = "";
        this.evidences = "";
    }

    public int getCaseID() {
        return caseID;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public String getSuspectAlibi() {
        return suspectAlibi;
    }

    public String getEvidences() {
        return evidences;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public void setSuspectAlibi(String suspectAlibi) {
        this.suspectAlibi = suspectAlibi;
    }

    public void setEvidences(String evidences) {
        this.evidences = evidences;
    }

    public void displayCaseInfo() {
        System.out.println("Case ID: " + caseID);
        System.out.println("Case Name: " + caseName);
        System.out.println("Case Description: " + caseDescription);
        System.out.println("Suspects Alibi: " + suspectAlibi);
        System.out.println("Evidences: " + evidences);
    }

    public abstract void analyzeCaseClues();

    public abstract boolean isCaseSolved();

    public static void casesVault() {
        System.out.println("\n\033[36m╔═══════════════════════════════════════════════════╗\033[0m");
        System.out.println("\033[36m║                  CASES VAULT                      ║\033[0m");
        System.out.println("\033[36m╚═══════════════════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("6601 - Poet\'s Last Deadline");
        System.out.println("6602 - The Chemistry Lab Murder");
        System.out.println("6603 - The Stolen Formula");
        System.out.println("6604 - Case of Backward Clock");
        System.out.println("6605 - Case of Conductor's Final Note");
    }

    
}
