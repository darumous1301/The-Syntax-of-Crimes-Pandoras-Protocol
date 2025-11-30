# 🚀 THE SYNTAX OF CRIMES: 

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/2dab0f25-4a94-4700-9bdd-b60c2aeefb47" />

<div align="center">
  
![Java](https://img.shields.io/badge/Java-11+-orange.svg)

**The Pandora's Box has been opened...**

</div>

---

# 📝 Description / Overview

A Java console-based detective game where players step into the shoes of an investigator tasked with solving a series of crimes. With the legendary Sherlock Holmes occupied with more pressing cases out of town, the pressure falls on you to crack each case and bring justice to the innocent victims. Complete all five cases to earn crucial clues needed to unlock the ultimate carrier of secrets - **[the Pandora's Box]**. In this digital era, where inequality plagues every nation and corruption, killings, and graft run rampant, the people deserve to know the truth. Your mission is to expose the crocodiles in high government positions who exploit the lives of the poor. Unlock Pandora's Box and, with just one click, reveal all their secrets to the world.

## ✨ Key Features
- **1**: Investigate crime cases by selecting case numbers in the Cases Vault.
- **2**: Analyze suspects and read their alibis, personal backgrounds, and motives.
- **3**: Examine evidence presented for each case to deduce the culprit.
- **4**: Identify the correct suspect by manually typing their name based on clues.
- **5**: Explore locked files inside Pandora’s Box through a login system (hidden scandals).
- **6**: Encounter game consequences, such as error messages (CaseNotFoundException) when choosing an invalid case.
---

## 🏛️ Program Structure
```
📂 The-Syntax-of-Crimes/
└── 📂 src/
    ├── Classes:
    │   ├── ☕ Main.java
    │   │   └── 📦 inner class: ScandalFile
    │   ├── ☕ Case.java (abstract)
    │   ├── ☕ PoetsLastDeadline.java (extends Case)
    │   ├── ☕ ChemistryLabMurder.java (extends Case)
    │   ├── ☕ StolenFormula.java (extends Case)
    |   ├── ☕ CaseOfBackwardClock.java (extends Case)
    │   ├── ☕ ConductorsFinalNote.java (extends Case)
    │   └── ☕ CaseNotFoundException.java (exception)
    │
    ├── Enums:
    │   ├── 📋 NoSuspect.java (implements Suspect)
    │   ├── 📋 PoetsLastDeadlineSuspects.java (implements Suspect)
    │   ├── 📋 ChemistryLabMurderSuspects.java (implements Suspect)
    |   ├── 📋 CaseOfBackwardClockSuspects.java (implements Suspect)
    │   ├── 📋 ConductorsFinalNoteSuspects.java (implements Suspect)
    │   └── 📋 StolenFormulaSuspects.java (implements Suspect)
    │
    └── Interface:
        └── 🔗 Suspect.java
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

# 🏗️ OOP Concepts Applied

This project demonstrates the core principles of Object-Oriented Programming:

- [Encapsulation](#1️⃣-encapsulation)
- [Inheritance](#2️⃣-inheritance)
- [Polymorphism](#3️⃣-polymorphism)
- [Abstraction](#4️⃣-abstraction)

## 1️⃣ Encapsulation
> 🔒 **Data Hiding & Protection**

Encapsulation was implemented to protect sensitive data and provide controlled access through getter and setter methods. Private attributes ensure that internal object states cannot be modified directly from outside the class.

```java
//preview from actual code
public abstract class Case {
    private int caseID;
    private String caseName;
    private String caseDescription;
    private String suspectAlibi;
    private String evidences;

    public int getCaseID() {return caseID;}
    public String getCaseName() {return caseName;}
    public void setCaseID(int caseID) {this.caseID = caseID;}

    public void setCaseName(String caseName) {this.caseName = caseName;}
}
```

**Implementation in Project:**
- Used private attributes in Case to protect internal data.
- Every case (Poet, Chemistry Lab, etc.) inherits these protected fields and accesses them through methods.
---

## 2️⃣ Inheritance
> 🌳 **Code Reusability & Hierarchy**

Inheritance promotes code reusability by creating parent-child relationships between classes. Child classes inherit properties and methods from parent classes while adding their own specific functionality.

```java
//PARENT CLASS FOR ALL CASES
//preview from actual code
public abstract class Case { 
```
```java
//CHILD CLASSES
class PoetsLastDeadline extends Case {
    private Suspect suspect;

    public PoetsLastDeadline() {
        super(6601, "\u001B[36m Case of Poet's Last Deadline \u001B[36m", ...);
        this.suspect = NoSuspect.NONE;
    }
}
```
```java
class ChemistryLabMurder extends Case {
    private Suspect suspect;

    public ChemistryLabMurder() {
        super(6602, "\u001B[36m The Chemistry Lab Murder \u001B[36m", ...);
        this.suspect = NoSuspect.NONE;
    }
}
```
```java
public class StolenFormula extends Case {
    private Suspect suspect;

    public StolenFormula() {
        super(6603, "\u001B[36m The Stolen Formula \u001B[36m", ...);
        this.suspect = NoSuspect.NONE;
    }
}
```
```java
class CaseOfBackwardClock extends Case {
    private Suspect suspect;

    public CaseOfBackwardClock() {
        super(6605, "\u001B[36m The Case of the Backward Clock \u001B[36m", ...);
        this.suspect = NoSuspect.NONE;
    }
}
```
```java
class ConductorsFinalNote extends Case {
    private Suspect suspect;

    public ConductorsFinalNote() {
        super(6604, "\u001B[36m The Case of the Conductor's Final Note \u001B[36m", ...);
        this.suspect = NoSuspect.NONE;
    }
}
```


**Implementation in Project:**
- The abstract class Case acts as the parent template for all crime cases.
- Each case class (PoetsLastDeadline, ChemistryLabMurder, etc.) extends Case, automatically inheriting: caseID, caseName, caseDescription, suspectAlibi, evidences, shared methods like displayCaseInfo()
- This reduces repeated code and creates a clear hierarchy for all case types.

---

## 3️⃣ Polymorphism
> 🎭 **Many Forms, One Interface**

Polymorphism allows objects to take multiple forms through method overriding and overloading, enabling flexible and dynamic behavior at runtime.
```java
@Override
//EXAMPLE PoetsLastDeadline.java
//preview from actual code
public void displayCaseInfo() {
    System.out.println("====== Case of Poet's Last Deadline ======");
    System.out.println("Case ID: " + getCaseID());
}

@Override
public void analyzeCaseClues() {
    System.out.println("\n\033[33m╔═══════════════════════════════════╗\033[0m");
    System.out.println("\033[33m║     POET'S LAST DEADLINE - ANALYSIS    ║\033[0m");
}

@Override
public boolean isCaseSolved() {
    return suspect == PoetsLastDeadlineSuspects.MICHAEL_SANDERS;
}
```
```java
//preview from actual code
PoetsLastDeadline case1 = new PoetsLastDeadline();
case1.displayCaseInfo();  // calls override method

Suspect matchedSuspect = PoetsLastDeadlineSuspects.valueOf(suspect);
case1.setSuspect(matchedSuspect);  // use interface from Suspect.java
```

**Implementation in Project:**
- All case classes override parent abstract methods: displayCaseInfo() - each case prints unique visuals, analyzeCaseClues() - each case has different clue analysis and isCaseSolved() - each case checks a different correct suspect.
- When calling methods (ex: case1.displayCaseInfo()), Java chooses the child’s version automatically.
- Enum suspects implement the same interface (Suspect), but return different names and roles depending on the case.
- This allows the system to process different cases and suspects using the same method calls.


---

## 4️⃣ Abstraction
> 🎨 **Hiding Complexity**

Abstraction hides complex implementation details and shows only the essential features of objects. This simplifies the interface and reduces complexity for users of the class.

```java
//ABSTACT CLASS Case.java
//preview from actual code
public abstract class Case {
    public void displayCaseInfo() {
        System.out.println("Case ID: " + caseID);
        // ...
    }

    public abstract void analyzeCaseClues();
    public abstract boolean isCaseSolved();
}
```
```java
//INTERFACE Suspect.java
public interface Suspect {
    String getFullName();
    String getCategory();
}
```
```java
//EXAMPLE IN ONE OF THE CASES
//ALL SUSPECT ENUMS IMPLEMENTS THE INTERFACE
public enum PoetsLastDeadlineSuspects implements Suspect {
    REBECCA_MOORE("Rebecca Moore", "Assistant"),
    MICHAEL_SANDERS("Michael Sanders", "Rival Journalist"),
    SAMUEL_REEVES("Samuel Reeves", "Data Analyst/Whistleblower");

    private final String fullName;
    private final String role;

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCategory() {
        return "Poet's Last Deadline";
    }
}
```
**Implementation in Project:**
- Used an abstract class (Case) to hide complex case-analysis logic and expose only essential methods like analyzeCaseClues() and isCaseSolved().
- Used a Suspect interface ensured all suspects provide simple, consistent methods without revealing how their information is stored behind the scenes.
- Each case and suspect enum fills in its own detailed logic, but other parts of the program only see the essential behaviors they provide. 

---

## 4️⃣ Exception Handling
> 🎨 **Handling Errors**

-Exception handling - Without proper exception handling and user prompt an invalid answer, then it will return a message that the whole game crash.

```java
//CaseNotFoundException.java
//preview from actual code
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
```
```java
//preview from actual code
try {
    System.out.print("\n\n>> Investigate Case No.: ");
    int caseNo = sc.nextInt();
    sc.nextLine();

    if (caseNo == 6601) {
        // Case handling
    } else if (caseNo == 6602) {
        // Case handling
    } else {
        throw new CaseNotFoundException(caseNo);
    }

} catch (CaseNotFoundException e) {
    System.out.println("\n\033[31mERROR: " + e.getMessage() + "\033[0m");
    System.out.println("\033[31mPlease select a valid case number from the vault.\033[0m");
}
```
```java
while (!sc.hasNextInt()) {
    System.out.print("\n\033[31mInvalid input! Please enter a number (1-4): \033[0m");
    sc.next(); 
}
choice = sc.nextInt();
```
```java
Suspect matchedSuspect = null;
try {
    matchedSuspect = PoetsLastDeadlineSuspects.valueOf(suspect);
} catch (IllegalArgumentException e) {
    System.out.println("\n\033[31mInvalid suspect name. Please try again.\033[0m");
    break;
}
```
```java
catch (InputMismatchException e) {
    System.out.println("\n\033[31mERROR: Invalid input. Please enter a numeric case number.\033[0m");
    sc.nextLine(); // Clear the buffer
}
```

```java
try {
    String retryChoice = sc.nextLine().trim().toLowerCase();
    // ...
} catch (NoSuchElementException e) {
    System.out.println("\n\033[31mInput error. Exiting Pandora's Box access...\033[0m\n");
    break;
}
```

**Implementation in Project:**
- Created a custom exception CaseNotFoundException to handle invalid case numbers cleanly.
- Used try–catch blocks to detect: Wrong input types (letters instead of numbers), Non-existing case numbers, Invalid suspect names, No input / input interruption
- Error messages are user-friendly and guide the player back to correct input.
- Prevents program crashes by catching and handling mistakes correctly.

## 📦 Main Classes and Their Roles

### **1. Main Class** 
🎯 **Role**: Acts as the entry point of the entire program. It handles all user interactions, displays the main menu, handles the features, and the one manages case selections.

**Key Methods:**
- `main()` - Program entry point
- `MainMenu()` - Shows user options from Main Menu
- `authenticate()` - Handles user commands
- `morseToLetter()` - Handles user commands
- `morseCodeDecoder()` - Handles user commands
- `pandorasBox()` - It handles Pandora’s Box login
- `uploadSecrets()` - Handles user commands
- `Instructions()` - Shows user options

---

### **2. Parent Class(Case.java)**
💾 **Role**: It serves as the blueprint for all crime cases. Every case shares the same basic parts, and this class defines them. 

**Key Methods:**
- `Case(...)` `Case()` - Default constructor and (with) Parameter Constructor
- `getCaseID()` `setCaseID(...)`  - 5 Getters and 5 Setters methods
- `displayCaseInfo()` - Displays basic case information
- `analyzeCaseClues()` `isCaseSolved()` - An abstract method and must be implemented by all child classes
- `casesVault()` - Displays all available cases in the vault

---

### **3. Child Classes (5 Cases)**
⚙️ **Role**: Each of the classes represents one full crime case in the program. All of them extend case.java and each provide their own story, suspects, and even evidence.

**Key Methods:**
- `PoetsLastDeadlineSuspects()` `ChemistryLabMurderSuspects()` `StolenFormulaSuspects()` `CaseOfBackwardClockSuspects()` `ConductorsLastNotSuspects()`- contains all details about the cases and its suspects.
- `getSuspect()` `setSuspect(...)` - Executes business operations
- `displayCaseInfo()` `analyzeCaseClues()` `isCaseSolved()` - Override methods
---

### **4. Enums (6 Enums)**
⚙️ **Role**: Contains core business rules and processing logic

**Key Methods:**
- `NoSuspect(...)`- Performs calculations
- `PoetsLastDeadlineSuspects()` `ChemistryLabMurderSuspects()` `StolenFormulaSuspects()` `CaseOfBackwardClockSuspects()` `ConductorsLastNotSuspects()`- Override methods
- `getFullName()` `GetCategory()` `GetRole()` - Executes business operations

---

### **5. Exception Handler**
⚙️ **Role**: It shows an error when the player enters a case number that does not exist. It makes the game safer and prevents crashing.

**Key Methods:**
- `CaseNotFoundException(...)` - Performs calculations
- `getInvalidCaseNumber()` - Executes business operations
- `getMessage()` `toString()` `printStackTrace()` - Inherited methods from exception class
---

### **6. The Interface (Suspect.java)**
⚙️ **Role**: Every Suspect is set to follow this “rule set”. The interface ensures all suspect enums have the same required methods. 

**Key Methods:**
- `getFullName()` - Performs calculations
- `getCategory()` - Executes business operations
---

## 🗺️ Class Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                              <<Main>>                               │──────────|
│                            Main.java                                │          |
└─────────────────────────────────────────────────────────────────────┘          |
                                │                                                |uses/throws
                                │ contains                                       |
                                ▼                                                |
                  ┌──────────────────────────────┐                               |
                  │    <<inner class>>           │                               |
                  │      ScandalFile             │                               |
                  └──────────────────────────────┘                               |
                                                                                 |
                                                                                 |
┌─────────────────────────────────────────────────────────────────────┐          |
│                             <<abstract>>                            │   uses   |
│                               Case.java                             │<─────────|
└─────────────────────────────────────────────────────────────────────┘          |
        ▲           ▲             ▲              ▲            ▲                  |
        │           │             │              │            │                  |
        │           │             │              │            │                  |
┌───────┴───┐ ┌─────┴──────┐ ┌────┴─────┐ ┌──────┴──────┐ ┌───┴───────────┐      |
│  Poets    │ │ Chemistry  │ │ Stolen   │ │   Backward  │ │   Conductor   │      |
│   Last    │ │    Lab     │ │ Formula  │ │    Clock    │ │   Final Note  │      |
│ Deadline  │ │   Murder   │ │          │ │             │ │               │      |
└───────────┘ └────────────┘ └──────────┘ └─────────────┘ └───────────────┘      |
     │             │              │              │                 │             |
     │uses         │uses          │uses          │uses             │uses         |
     ▼             ▼              ▼              ▼                 ▼             |
┌─────────┐ ┌──────────────┐ ┌────────┐ ┌─────────────┐ ┌─────────────────┐      |
│ Poets   │ │  Chemistry   │ │ Stolen │ │   Backward  │ │   Conductor     │      |
│  Last   │ │     Lab      │ │ Formula│ │    Clock    │ │   FinalNote     │      |
│Deadline │ │    Murder    │ │Suspects│ │   Suspects  │ │    Suspects     │      |
│Suspects │ │   Suspects   │ │<<enum>>│ │   <<enum>>  │ │    <<enum>>     │      |
│<<enum>> │ │  <<enum>>    │ └────────┘ └─────────────┘ └─────────────────┘      |
└─────────┘ └──────────────┘      │            │                 │               |
     │             │              │            │                 │               |
     │implements   │implements    │implements  │implements       │implements     |
     │             │              │            │                 │               |
     └─────────────┴──────────────┴────────────┴─────────────────┘               |
                                  |                                              |
                                  |                                              |
                                  ▼                                              |
                        ┌───────────────────────┐                                |
                        │     <<interface>>     │              uses              |
                        │        Suspect        │<───────────────────────────────|
                        └───────────────────────┘                                |
                                   ▲                                             |
                                   │ implements                                  |
                                   │                                             |
                        ┌───────────────────────┐                                |
                        │       NoSuspect       │                                |
                        │       <<enum>>        │                                |
                        └───────────────────────┘                                |
                                                                                 |
                                                                                 |
             ┌─────────────────────────────────────────────────┐                 |
             │                 <<exception>>                   │    throws       |
             │              CaseNotFoundException              │─────────────────|
             └─────────────────────────────────────────────────┘
```
# ▶️ How to Run the Program

## 📋 Prerequisites
- Java Development Kit (JDK) 11 or higher
- Command line terminal (CMD, PowerShell, or Terminal)

## 🚀 Step-by-Step Instructions

### **Step 1️⃣: Clone or Download the Repository**
```bash
git clone https://github.com/darumous1301/The-Syntax-of-Crimes-Pandoras-Protocol.git
cd The-Syntax-of-Crimes-Pandoras-Protocol
```

### **Step 2️⃣: Compile the Java Files**
```bash
# Compile all Java files in the directory
javac *.java

# OR compile specific files

```

### **Step 3️⃣: Run the Program**
```bash
java Main
```

### **Step 4️⃣: Follow On-Screen Instructions**
The program will display a menu or prompts. Enter your choices as directed by the interface.

---

# 💻 Sample Output

Here's what you can expect when running the program:

```
╔════════════════════════════════════════════════════════════════════╗
║                                                                    ║
║   _____ _            ____              _                           ║
║  |_   _| |__   ___  / ___| _   _ _ __ | |_ __ ___  __             ║
║    | | | '_ \ / _ \ \___ \| | | | '_ \| __/ _` \ \/ /             ║
║    | | | | | |  __/  ___) | |_| | | | | || (_| |>  <              ║
║    |_| |_| |_|\___| |____/ \__, |_| |_|\__\__,_/_/\_\             ║
║                            |___/                                   ║
║                                                                    ║
║              ___   __    ____      _                               ║
║             / _ \ / _|  / ___|_ __(_)_ __ ___   ___  ___          ║
║            | | | | |_  | |   | '__| | '_ ` _ \ / _ \/ __|         ║
║            | |_| |  _| | |___| |  | | | | | | |  __/\__ \         ║
║             \___/|_|    \____|_|  |_|_| |_| |_|\___||___/         ║
║                                                                    ║
╚════════════════════════════════════════════════════════════════════╝
Wtsn_47 messaged you.
Click here to view

Wtsn_47: Greetings! I am Dr. John H. Watson, 
an assistant and friend of the great Sherlock Holmes

Wtsn_47: I messaged you to deliver a great news!,
Kindly open the attached file below

chosenOne.pdf - view
  Dear Candidate,

  If you are reading this, then you have already taken the first
  step into a world from which there is no return. The shadows
  have eyes, and those eyes have been watching YOU.

...

```


## 📸 Output Screenshots

<p align="center">
  <img src="static/MainMenu.png" alt="App Screenshot" width="400"/><br>
  <em>Screenshot of the game's Main Menu along with the Case Vault Menu</em>
</p>
<p align="center">
  <img src="static/PandorasBoxContents.png" alt="App Screenshot" width="400"/><br>
  <em>Screenshot of the Pandora's Box</em>
</p>
<p align="center">
  <img src="static/MorseCodeDecoder.png" alt="App Screenshot" width="400"/><br>
  <em>Screenshot of the Morse Code Decoder</em>
</p>


---

# 👨‍💻 Author & Acknowledgements

##  ‧₊˚ ┊ Contributors

<table>
<tr>
    <th> &nbsp; </th>
    <th> Name </th>
    <th> Role </th>
</tr>
<tr>
    <td><img src="static/alyzza.png" width="100" height="100"> </td>
    <td><strong>Alyzza Monique Q. Aragon, BSCS</strong> <br/>
    <a href="https://github.com/darumous1301" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=yellow" alt="darumous1301's GitHub">
        </a>
    </td>
    <td>Git Manager & System Architect</td>
</tr>
<tr>
    <td><img src="static/irish.png" width="100" height="100"> </td>
    <td><strong>Irish M. Banaag, BSCS</strong> <br/>
    <a href="https://github.com/ciancrey" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=blue" alt="ciancrey's GitHub">
        </a>
    </td>
    <td>Content Writer & Documentation Head</td>
</tr>
<tr>
    <td><img src="static/anica.png" width="100" height="100"> </td>
    <td><strong>Baruel, Anica Kim D., BSCS</strong> <br/>
    <a href="https://github.com/Anicakim13" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=pink" alt="Anicakim13's GitHub">
        </a>
    </td>
    <td>Content Writer / Security & Error-Handling Specialist</td>
</tr>
</table>

---

## 🙏 Acknowledgements

We would like to express our gratitude to:

- **Ms. Fatima Marie M. Agdon** - for guiding us throughout the development of the project, and for teaching us on how to use each of them and what’s their purpose in the program. We've learned a lot from this whole semester, we didn't just learn how to code, but to understand the beauty of it, we hope we successfully integrated all of our learnings in this simple text-based detective game, We are truly grateful.
- **CS-2101** -  for sharing ideas, giving feedback, and helping solve coding problems.
- **Family and Friends** -  for giving insights and recommendations to better understand our game.
- **VS Code | GitHub | AI Tools | Online Community** - for being our tool to successfully implement the game and for giving us assistance for us to be guided in the process of doing it.
  
---

## 🔮 Future Enhancements

The following features and improvements are planned for future versions:

- [ ] 🎨 **GUI Implementation**: Create a visual version instead of pure console text. Through integration of tools like HTML, CSS and Javascript.
- [ ] 💾 **Investigation Tools**: Add features like timeline builder, evidence tracker, and suspect comparison tool.
- [ ] 🌐 **API Integration and Online Features**: Add leaderboards / case sharing and connect to external APIs for real-time data.
- [ ] 🔐 **User Authentication**: Add login system with password encryption to handle personal achievements and statistics privately.
- [ ] 🐛 **Enhanced Error Handling**: Add clearer messages and prevent unexpected crashes.
- [ ] 📱 **Smarter Dialogue System**: Use dynamic responses for suspects instead of static text.
- [ ] 🌍 **Cases Bank**: Generates bulk of cases that is access randomly to make the game more diversed and exciting to play

---

## 📚 References

### Documentation & Official Resources
1. **Final Project Guidelines** -  A Guideline issued by the Professor for a comprehensive Project Details Guidelines 
   🔗 [Final Project Requirements](https://docs.google.com/document/d/1VvIyPrOSisnaOd72AehSDdRtcXq27g3oUMBw55ggGpQ/edit?tab=t.0)

2. **Github Repositories**  - This repositories serves as the backbone of our project as we first use it as a basis to utilize encapsulation and polymorphism in our game, the second repository serves as our basis in creating our README.md file to properly document "The Syntax of Crimes" progress.
   🔗 [CS211-LAB-Activity-3](https://github.com/marieemoiselle/CS211LabActivity3)
   🔗 [Java-Notes-Diary](https://github.com/marieemoiselle/java-notes-diary)

2. **Online Resources**  - This resources guided us to properly implement exception hadling situations
   🔗 [Geek for Geeks (Java Exception Handling)](https://www.geeksforgeeks.org/java/exceptions-in-java/)
   🔗 [Geek for Geeks (Try Catch Block)](https://www.geeksforgeeks.org/java/java-try-catch-block/)
   🔗 [Stack Overflow (ArrayList)]( https://stackoverflow.com/questions/1921181/arraylist-of-string-arrays)

### Books and Online Resources
1. **Sherlock Holmes** - Various cases of his were utilized and modified to show our users the art of deduction and critical thinking skills.
2. **Project LOKI** - Serves as the inspiration in creating The Chemistry Lab Murder, one of the case in the game.
---







