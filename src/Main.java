
// Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0; // user choice for menu

        displayAnimatedTitle(); // displays the game title animation

        TheChosenOne(sc); // display sherlock's acceptance letter

        System.out.print("\u001B[0m"); 

        System.out.print("\nWtsn_47: Congratulations! Please type your preferred codename: "); 

        String playerName = sc.nextLine();

        System.out.println("\nLET THE PROTOCOL BEGIN, " + playerName);

        Instructions(); // display game instructions

        System.out.print("ONCE YOU ARE READY, PRESS (ENTER) TO CONTINUE...");
        sc.nextLine();

        System.out.print("\u001B[0m");

        do {      
            MainMenu(); // display main menu
            System.out.print("\n» Enter your choice: ");

            
            while (!sc.hasNextInt()) { // (hasNextInt) Check for valid integer input
                System.out.print("\n\033[31mInvalid input! Please enter a number (1-4): \033[0m");
                sc.next(); 
            }
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {
                case 1: // Cases vault option
                    System.out.println("\n\033[33m Opening Cases Vault...\033[0m");
                    Case.casesVault();

                    try { // exception handling for invalid case number input
                        System.out.print("\n\n>> Investigate Case No.: ");
                        int caseNo = sc.nextInt();
                        sc.nextLine(); 

                        if (caseNo == 6601) { // Case of Poet's Last Deadline
                            PoetsLastDeadline case1 = new PoetsLastDeadline(); // default suspect NONE
                            case1.displayCaseInfo();

                            sc.nextLine();

                            // Sherlock insights (optional)
                            System.out.print("\nWould you like to contact Sherlock? (Y / enter(N)): ");
                            String analyzeChoice = sc.nextLine().trim().toLowerCase();
                            if (analyzeChoice.equals("yes") || analyzeChoice.equals("y")) {
                                case1.analyzeCaseClues();// call analysis method
                            }

                            System.out.print("Who's the suspect? (Enter name) : ");
                            String suspect = sc.nextLine().trim().toUpperCase().replace(" ", "_");

                            // Try to match with enum
                            Suspect matchedSuspect = null;
                            try { // Exception handling for invalid suspect name
                                matchedSuspect = PoetsLastDeadlineSuspects.valueOf(suspect);
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\033[31mInvalid suspect name. Please try again.\033[0m");
                                break;
                            }
                            case1.setSuspect(matchedSuspect);

                            if (matchedSuspect == PoetsLastDeadlineSuspects.MICHAEL_SANDERS) {
                                System.out.println(
                                        "\n\033[32m Congratulations! You've identified the correct suspect!\033[0m");
                                if (case1.isCaseSolved()) {
                                    System.out.println("\033[32m=============== Case Status: SOLVED===============\n\nClue: -\033[0m");
                                }
                            } else if (matchedSuspect == PoetsLastDeadlineSuspects.REBECCA_MOORE) {
                                System.out.println("\n\033[31mIncorrect! Rebecca Moore has an alibi.\033[0m");
                            } else if (matchedSuspect == PoetsLastDeadlineSuspects.SAMUEL_REEVES) {
                                System.out
                                        .println("\n\033[31mIncorrect! Samuel Reeves was out of the country.\033[0m");
                            }

                        } else if (caseNo == 6602) { // Case of Chemistry Lab Murder
                            ChemistryLabMurder case2 = new ChemistryLabMurder();// default suspect NONE
                            case2.displayCaseInfo();

                            sc.nextLine();

                            // Sherlock insights (optional)
                            System.out.print("\nWould you like to contact Shelock? (Y / enter(N)): ");
                            String analyzeChoice = sc.nextLine().trim().toLowerCase();
                            if (analyzeChoice.equals("yes") || analyzeChoice.equals("y")) {
                                case2.analyzeCaseClues(); // call analysis method
                            }

                            System.out.print("Who's the suspect? (Enter name) : ");
                            String suspect = sc.nextLine().trim().toUpperCase().replace(" ", "_");

                            // Try to match with enum
                            Suspect matchedSuspect = null;
                            try { // Exception handling for invalid suspect name
                                matchedSuspect = ChemistryLabMurderSuspects.valueOf(suspect);
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\033[31mInvalid suspect name. Please try again.\033[0m");
                                break;
                            }
                            case2.setSuspect(matchedSuspect); // set the suspect

                            if (matchedSuspect == ChemistryLabMurderSuspects.GENESIS_MENDEZ) {
                                System.out.println(
                                        "\n\033[32mCongratulations! You've identified the correct suspect!\033[0m");
                                if (case2.isCaseSolved()) {
                                    System.out.println("\033[32m=============== Case Status: SOLVED===============\n\nClue: .-\033[0m");
                                }
                            } else if (matchedSuspect == ChemistryLabMurderSuspects.HENRY_CHUA) {
                                System.out.println(
                                        "\n\033[31mIncorrect! Did NOT hear the school bell - His statement was consistent with reality\033[0m");
                            } else if (matchedSuspect == ChemistryLabMurderSuspects.JOHN_BAUTISTA) {
                                System.out.println(
                                        "\n\033[31mIncorrect! His alibi at the stone benches is weak but not disproven\033[0m");
                            }

                        } else if (caseNo == 6603) {
                            StolenFormula case3 = new StolenFormula();
                            case3.displayCaseInfo();

                            sc.nextLine();

                            // Sherlock helps
                            System.out.print("\nWould you like to contact Sherlock? (Y / enter(N)): ");
                            String analyzeChoice = sc.nextLine().trim().toLowerCase();
                            if (analyzeChoice.equals("yes") || analyzeChoice.equals("y")) {
                                case3.analyzeCaseClues();
                            }

                            System.out.print("Who's the suspect? (Enter name) : ");
                            String suspect = sc.nextLine().trim().toUpperCase().replace(" ", "_");

                            // Try to match with enum
                            Suspect matchedSuspect = null;
                            try { // Exception handling for invalid suspect name
                                matchedSuspect = StolenFormulaSuspects.valueOf(suspect);
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\033[31m✖ Invalid suspect name. Please try again.\033[0m");
                                break;
                            }
                            case3.setSuspect(matchedSuspect);

                            if (matchedSuspect == StolenFormulaSuspects.EDWARD_RAYNOR) {
                                System.out.println(
                                        "\n\033[32mCongratulations! You've identified the correct suspect!\033[0m");
                                if (case3.isCaseSolved()) {
                                    System.out.println("\033[32m=============== Case Status: SOLVED===============\n\nClue: --.\033[0m");
                                } 
                            } else if (matchedSuspect == StolenFormulaSuspects.LUCIA) {
                                System.out.println(
                                        "\n\033[31mIncorrect! She was framed by making her the visible 'server' while the poisoner is hiding.\033[0m");
                            } else if (matchedSuspect == StolenFormulaSuspects.DR_CARELLI) {
                                System.out.println(
                                        "\n\033[31mIncorrect! This Doctor had no direct access to poison Sir Claud's coffee\033[0m");
                            } else if (matchedSuspect == StolenFormulaSuspects.RICHARD) {
                                System.out.println(
                                        "\n\033[31mIncorrect! Tried to take blame only to protect Lucia\033[0m");
                            }

                        } else if (caseNo == 6604) { // Case of Backward Clock
                            CaseOfBackwardClock case4 = new CaseOfBackwardClock();// default suspect NONE
                            case4.displayCaseInfo();

                            sc.nextLine();

                            // Sherlock insights (optional)
                            System.out.print("\nWould you like to contact Shelock? (Y / enter(N)): ");
                            String analyzeChoice = sc.nextLine().trim().toLowerCase();
                            if (analyzeChoice.equals("yes") || analyzeChoice.equals("y")) {
                                case4.analyzeCaseClues(); // call analysis method
                            }

                            System.out.print("Who's the suspect? (Enter name) : ");
                            String suspect = sc.nextLine().trim().toUpperCase().replace(" ", "_");

                            // Try to match with enum
                            Suspect matchedSuspect = null;
                            try {
                                matchedSuspect = CaseOfBackwardClockSuspects.valueOf(suspect);
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\033[31mInvalid suspect name. Please try again.\033[0m");
                                break;
                            }
                            case4.setSuspect(matchedSuspect);

                            if (matchedSuspect == CaseOfBackwardClockSuspects.VICTOR_STERLING) {
                                System.out.println(
                                        "\n\033[32mCongratulations! You've identified the correct suspect!\033[0m");
                                if (case4.isCaseSolved()) {
                                    System.out.println("\033[32m=============== Case Status: SOLVED===============\n\nClue: ..-.\033[0m");
                                }
                            } else if (matchedSuspect == CaseOfBackwardClockSuspects.MADELINE_FROST) {
                                System.out.println(
                                        "\n\033[31mIncorrect! Has an alibi, lack of motive and evidence\033[0m");
                            } else if (matchedSuspect == CaseOfBackwardClockSuspects.THOMAS_WICKHAM) {
                                System.out.println(
                                        "\n\033[31mIncorrect! Has gambling debts of £45,000 but no strong motive to kill\033[0m");
                            }

                        } else if (caseNo == 6605) { // CASE OF CONDUCTOR'S FINAL NOTE
                            ConductorsFinalNote case5 = new ConductorsFinalNote();// default suspect NONE
                            case5.displayCaseInfo();

                            sc.nextLine();

                            // Sherlock insights (optional)
                            System.out.print("\nWould you like to contact Shelock? (Y / enter(N)): ");
                            String analyzeChoice = sc.nextLine().trim().toLowerCase();
                            if (analyzeChoice.equals("yes") || analyzeChoice.equals("y")) {
                                case5.analyzeCaseClues(); // call analysis method
                            }

                            System.out.print("Who's the suspect? (Enter name) : ");
                            String suspect = sc.nextLine().trim().toUpperCase().replace(" ", "_");

                            // Try to match with enum
                            Suspect matchedSuspect = null;
                            try {
                                matchedSuspect = ConductorsFinalNoteSuspects.valueOf(suspect);
                            } catch (IllegalArgumentException e) {
                                System.out.println("\n\033[31mInvalid suspect name. Please try again.\033[0m");
                                break;
                            }
                            case5.setSuspect(matchedSuspect);

                            if (matchedSuspect == ConductorsFinalNoteSuspects.DR_PHILIP_CHEN) {
                                System.out.println(
                                        "\n\033[32mCongratulations! You've identified the correct suspect!\033[0m");
                                if (case5.isCaseSolved()) {
                                    System.out.println("\033[32m===============  Case Status: SOLVED===============\n\nClue: .-.\033[0m");
                                }
                            } else if (matchedSuspect == ConductorsFinalNoteSuspects.ISABELLA_MORETTI) {
                                System.out.println(
                                        "\n\033[31mIncorrect! \033[0m");
                            } else if (matchedSuspect == ConductorsFinalNoteSuspects.MARCUS_WEBB) {
                                System.out.println(
                                        "\n\033[31mIncorrect! \033[0m");
                            }

                        } else {
                            throw new CaseNotFoundException(caseNo);
                        }

                    } catch (CaseNotFoundException e) { // custom exception for invalid case number
                        System.out.println("\n\033[31mERROR: " + e.getMessage() + "\033[0m");
                        System.out.println("\033[31mPlease select a valid case number from the vault.\033[0m");
                    } catch (InputMismatchException e) { // exception for non-integer input
                        System.out.println(
                                "\n\033[31mERROR: Invalid input. Please enter a numeric case number.\033[0m");
                        sc.nextLine(); // Clear the buffer
                    }

                    break;
                case 2:
                    System.out.println("\n\033[33mAccessing Pandora's Box...(Enter) to continue\033[0m");
                    sc.nextLine();

                    System.out.println("Username is given through this clue: ....- | ..... | ..--- ----- | ..... | ...-- | ..--- ----- | ----. | ..---..--- | ..... ");
                    System.out.println("Username hint: 9-letter word");
                    System.out.println("Password is a 5-letter word related to politics.");
                    System.out.println("You have 3 attempts to authenticate.\n");
                    
                    int attempts = 0;
                    int maxAttempts = 3;
                    boolean authenticated = false;

                    while (!authenticated && attempts < maxAttempts) { // authentication loop
                        System.out.println("Enter Username: ");
                        String username = sc.nextLine();
                        System.out.println("\nEnter Password: ");
                        String password = sc.nextLine();

                        if (authenticate(username, password)) { // correct credentials
                            authenticated = true;
                            System.out.println("\nAuthentication successful!");
                            System.out.println("Pandora's Box is now UNLOCKED...\n");
                            pandorasBox();
                            uploadSecrets(sc);


                            
                            break;
                        } else { 
                            attempts++;
                            System.out.println("\nThe password is incorrect");
                            if (attempts < maxAttempts) { // allow retry if attempts remain (thru try catch)
                                System.out.println("Attempts remaining: " + (maxAttempts - attempts) + "\n");
                                System.out.print("Do you wish to try again? (Y / N): ");
                                try {
                                    String retryChoice = sc.nextLine().trim().toLowerCase();
                                    if (retryChoice.equals("n") || retryChoice.equals("no")) {
                                        System.out.println("\nExiting Pandora's Box access...\n");
                                        break;
                                    }
                                } catch (NoSuchElementException e) { // exception for no input
                                    System.out.println("\n\033[31mInput error. Exiting Pandora's Box access...\033[0m\n");
                                    break;
                                }
                            } else {
                                System.out.println("Maximum attempts reached. Access denied.\n");
                            }
                        }
                    }

                    break;

                case 3:
                    System.out.println("\n\033[33mOpening Morse Code Decoder...\033[0m");
                    morseCodeDecoder(sc);
                    break;

                case 4:
                    System.out.println("\n\033[31mLeaving the game...\033[0m");
                    System.out.println("\033[31mThe shadows will remember you...\033[0m\n");
                    displayAnimatedTitle();
                    System.out.println("terminating pandora\'s protocol.......");
                    break;

                default:
                    System.out.println("\n\033[31mInvalid choice! Please select a valid case from 1-5.\033[0m");
                    break;
            }

        } while (choice != 4); 

        sc.close();

    }

    public static void MainMenu() {
        System.out.println("\n\033[36m╔═══════════════════════════════════════════════════╗\033[0m");
        System.out.println("\033[36m║                  MAIN MENU                        ║\033[0m");
        System.out.println("\033[36m╚═══════════════════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("[1] Cases Vault");
        System.out.println("[2] Pandora's Box");
        System.out.println("[3] Morse Code Decoder");
        System.out.println("[4] Leave Game");
    }

    public static void Instructions() {
        System.out.println("\n\033[36m╔═══════════════════════════════════════════════════╗\033[0m");
        System.out.println("\033[36m║         DETECTIVE'S MANUAL                        ║\033[0m");
        System.out.println("\033[36m╚═══════════════════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("1. Access the Cases Vault to view available cases.");
        System.out.println("2. Select a case by entering its case number.");
        System.out.println("3. Review the case details and decide if you want Sherlock's insights since he worked along with the police.");
        System.out.println("4. After analysis, guess the suspect by entering their name.");
        System.out.println("5. Decode clues gained from solved cases and use the Morse Code Decoder to reveal password.");
        System.out.println("6. Open Pandora's Box for secret files (requires authentication).");
        System.out.println("7. Leak the scandal files to expose corrupt politicians.");
        System.out.println("8. Exit the game anytime from the main menu.");
        System.out.println("Break a leg, detective!\n\n");
    }

    private static final String CORRECT_USERNAME = "DETECTIVE"; // fixed username
    private static final String CORRECT_PASSWORD = "GRAFT"; // fixed password

    static class ScandalFile { // inner class for secret files
        String filename;
        String politician;
        String scandal;
        String date;

        public ScandalFile(String filename, String politician, String scandal, String date) { // coomtructor for the
                                                                                              // iner class of scandal
                                                                                              // files
            this.filename = filename;
            this.politician = politician;
            this.scandal = scandal;
            this.date = date;
        }
    }

    public static void displayAnimatedTitle() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String[] lines = {
                "\n",
                "╔════════════════════════════════════════════════════════════════════╗",
                "║                                                                    ║",
                "║   _____ _            ____              _                           ║",
                "║  |_   _| |__   ___  / ___| _   _ _ __ | |_ __ ___  __             ║",
                "║    | | | '_ \\ / _ \\ \\___ \\| | | | '_ \\| __/ _` \\ \\/ /             ║",
                "║    | | | | | |  __/  ___) | |_| | | | | || (_| |>  <              ║",
                "║    |_| |_| |_|\\___| |____/ \\__, |_| |_|\\__\\__,_/_/\\_\\             ║",
                "║                            |___/                                   ║",
                "║                                                                    ║",
                "║              ___   __    ____      _                               ║",
                "║             / _ \\ / _|  / ___|_ __(_)_ __ ___   ___  ___          ║",
                "║            | | | | |_  | |   | '__| | '_ ` _ \\ / _ \\/ __|         ║",
                "║            | |_| |  _| | |___| |  | | | | | | |  __/\\__ \\         ║",
                "║             \\___/|_|    \\____|_|  |_|_| |_| |_|\\___||___/         ║",
                "║                                                                    ║",
                "╚════════════════════════════════════════════════════════════════════╝"
        };

        System.out.print("\033[93m");

        for (String line : lines) {
            System.out.println(line);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\033[0m");
    }

    public static void TheChosenOne(Scanner sc) {

        System.out.print("Wtsn_47 messaged you.\nPress (ENTER) to read the message...");
        sc.nextLine();

        System.out.println("Wtsn_47: Greetings! I am Dr. John H. Watson, ");
        System.out.println("an assistant and friend of the great Sherlock Holmes");
        System.out.println("\nWtsn_47: I messaged you to deliver a great news!,");
        System.out.println("Kindly open the attached file below\n");
        System.out.print("Do_Not_Open.pdf - (Enter to open)");
        sc.nextLine();

        System.out.print("\033[93m");

        System.out.println("  Dear Candidate,");
        System.out.println();
        System.out.println("  If you are reading this, then you have already taken the first");
        System.out.println("  step into a world from which there is no return. The shadows");
        System.out.println("  have eyes, and those eyes have been watching YOU. Enter to continue...");
        sc.nextLine();
        System.out.println("  I am assembling a team - not of ordinary individuals, but of those");
        System.out.println("  with EXCEPTIONAL minds. Those who can think three steps ahead.");
        System.out.println("  Those who understand that every detail matters. Those willing to");
        System.out.println("  risk everything to stop a monster hiding in plain sight. Enter to continue...");
        sc.nextLine();
        System.out.println("  YOU have been chosen...");
        sc.nextLine();
        System.out.println("  This is not an invitation it is a WARNING and an OPPORTUNITY.");
        System.out.println("  You will be trained in the art of deduction, strategy,");
        System.out.println("  and combat against the criminal underworld. You will see things");
        System.out.println("  that will haunt your dreams. You will face moral dilemmas that");
        System.out.println("  have no clean answers. Enter to continue...");
        sc.nextLine();
        System.out.println("  The game is afoot, and the clock is ticking. Enter to continue...");
        sc.nextLine();
        System.out.println("  Trust no one. Question everything. And remember: in this war");
        System.out.println("  between order and chaos, neutrality is not an option., ");
        System.out.println();
        System.out.println("                                          Yours in the shadows,");
        System.out.println();
        System.out.println("                                          [Signature: S.H.]");
        System.out.println();
        System.out.println("  P.S. - Delete this letter after reading. If Moriarty's network");
        System.out.println("         discovers you've been contacted, they will act swiftly.");
        System.out.println("         The spider is always listening...");
        System.out.println();
    }

    public static boolean authenticate(String username, String password) {
        return username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD);
    }

    public static String morseToLetter(String morse) {
        switch (morse) {
            case ".-":
                return "A";
            case "-...":
                return "B";
            case "-.-.":
                return "C";
            case "-..":
                return "D";
            case ".":
                return "E";
            case "..-.":
                return "F";
            case "--.":
                return "G"; 
            case "....":
                return "H";
            case "..":
                return "I";
            case ".---":
                return "J";
            case "-.-":
                return "K";
            case ".-..":
                return "L";
            case "--":
                return "M";
            case "-.":
                return "N";
            case "---":
                return "O";
            case ".--.":
                return "P";
            case "--.-":
                return "Q";
            case ".-.":
                return "R";
            case "...":
                return "S";
            case "-":
                return "T";
            case "..-":
                return "U";
            case "...-":
                return "V";
            case ".--":
                return "W";
            case "-..-":
                return "X";
            case "-.--":
                return "Y";
            case "--..":
                return "Z";

            // Numbers 0-9
            case "-----":
                return "0";
            case ".----":
                return "1"; 
            case "..---":
                return "2";
            case "...--":
                return "3";
            case "....-":
                return "4";
            case ".....":
                return "5";
            case "-....":
                return "6";
            case "--...":
                return "7";
            case "---..":
                return "8";
            case "----.":
                return "9";

            default:
                return "?";
        }
    }

    public static void morseCodeDecoder(Scanner sc) {
        System.out.println("\n\033[36m╔═══════════════════════════════════════════════════╗\033[0m");
        System.out.println("\033[36m║          MORSE CODE DECODER                       ║\033[0m");
        System.out.println("\033[36m╚═══════════════════════════════════════════════════╝\033[0m");
        System.out.println();
        System.out.println("Enter Morse code separated by spaces if phrases/ sentences : Morse corresponds to letters and numbers");
        System.out.println("   Example: .... . .-.. .-.. ---");
        System.out.println();
        System.out.print("» Morse Code: ");

        String morseInput = sc.nextLine().trim();

        if (!morseInput.isEmpty()) {
            StringBuilder result = new StringBuilder();
            String[] morseCodes = morseInput.split(" ");

            for (String morse : morseCodes) {// iterate through each morse code
                if (!morse.isEmpty()) {
                    result.append(morseToLetter(morse));
                }
            }

            System.out.println();
            System.out.println("\033[32mDecoded Word: " + result.toString() + "\033[0m");
            System.out.println();
        } else {
            System.out.println("\n\033[31mNo input provided.\033[0m\n");
        }
    }

    private static void pandorasBox() {
        System.out.println("\u001B[31m═══════════════════════════════════════════════════════════════════════");
        System.out.println("                        --- PANDORA'S BOX ---");
        System.out.println("               CLASSIFIED POLITICAL SCANDAL LEDGER");
        System.out.println("═══════════════════════════════════════════════════════════════════════\u001B[31m");
        System.out.println();

        // Politicians Scandal File
        List<ScandalFile> files = new ArrayList<>();
        files.add(new ScandalFile(
                "\u001B[31mscandal_001.txt",
                "Congressman Sandy Co",
                "Embezzlement of campaign funds",
                "2023-03-15\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_002.txt",
                "Senator Bob Richards",
                "Undisclosed offshore accounts",
                "2023-06-22\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_003.txt",
                "Mayor Alex Go",
                "Bribery and corruption charges",
                "2023-09-10\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_004.txt",
                "Congressman Davis",
                "Insider trading violations",
                "2024-01-05\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_005.txt",
                "Representative Martin Gomez",
                "Falsified financial disclosures",
                "2024-04-18\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_006.txt",
                "Senator Linda Park",
                "Misuse of public funds",
                "2024-05-30\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_007.txt",
                "Governor James Revilla",
                "Obstruction of justice",
                "2024-06-12\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_008.txt",
                "Mayor Susan Gomez",
                "Nepotism in city contracts",
                "2024-02-28\u001B[31m"));
        files.add(new ScandalFile(
                "\u001B[31mscandal_009.txt",
                "Representative Kevin De Castro",
                "Campaign finance violations",
                "2023-11-07\u001B[31m"));

        // Display files
        System.out.println("\u001B[31mCLASSIFIED FILES REVEALED:\u001B[31m");
        System.out.println("─────────────────────────────────────────────────────────────────────");

        for (int i = 0; i < files.size(); i++) {
            ScandalFile file = files.get(i);
            System.out.println("\n[FILE " + (i + 1) + "]");
            System.out.println("  Filename:   " + file.filename);
            System.out.println("  Subject:    " + file.politician);
            System.out.println("  Allegation: " + file.scandal);
            System.out.println("  Date:       " + file.date);
            System.out.println("  ─────────────────────────────────────────────");
        }

        System.out.println("\n\u001B[31m═══════════════════════════════════════════════════════════════════════\u001B[31m");
        System.out.println("WARNING: This information is highly classified!\u001B[31m");
        System.out.println("    Total files revealed: " + files.size());
        System.out.println("═══════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    public static void uploadSecrets(Scanner sc) { 
        System.out.print("Do you wish to leak these files to the public? (Y / N): ");
        
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("y") || choice.equals("yes")) {
            System.out.println("\n\033[32mLeaking files to the public...\033[0m");
            System.out.println("\033[32mFiles successfully leaked! Truth is out!\033[0m\n");
        } else {
            System.out.println("\n\033[33mYou chose not to leak the files. They remain classified.\033[0m\n");
        }
        
    }   

}