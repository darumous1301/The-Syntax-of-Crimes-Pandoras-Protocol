public class CaseNotFoundException extends Exception {
    private int invalidCaseNumber;

    public CaseNotFoundException(int caseNumber) {
        super("Case #" + caseNumber + " not found in the vault. Please check the case number.");
        this.invalidCaseNumber = caseNumber;
    }

    public int getInvalidCaseNumber() {
        return invalidCaseNumber;
    }
}