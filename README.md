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
- **Navigate through Cases**: Investigate crime cases by selecting case numbers in the Cases Vault.
- **Investigate**: Analyze suspects and read their alibis, personal backgrounds, and motives.
- **Deduce Culprit**: Examine evidence presented for each case to deduce the culprit.
- **Feature 4**: Identify the correct suspect by manually typing their name based on clues.
- **Feature 5**: Explore locked files inside Pandora’s Box through a login system (hidden scandals).
- **Feature 6**: Encounter game consequences, such as error messages (CaseNotFoundException) when choosing an invalid case.
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

<table>
  <thead>
    <tr>
      <th align="center">Structure</th>
      <th align="center">Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Main.java</td>
      <td>Entry point of the program, containing the menu and handles user interactions.</td>
    </tr>
    <tr>
      <td>Case.java</td>
      <td >Abstract base class defining the structure and behavior of all cases.</td>
    </tr>
    <tr>
      <td>Suspect.java</td>
      <td>Interface defining the contract for all suspects, requiring methods for full name and category.</td>
    </tr>
    <tr>
      <td>NoSuspect.java</td>
      <td>Enum representing the initial state when no suspect has been chosen.</td>
    </tr>
    <tr>
      <td>PoetsLastDeadline.java</td>
      <td>Concrete case class detailing the Poets Last Deadline, suspect’s alibis evidence, and analysis logic.</td>
    </tr>
    <tr>
      <td>ChemistryLabMurder.java</td>
      <td>Concrete case class detailing the Case of the Chemistry Lab Murder, suspect’s alibis evidence, and analysis logic.</td>
    </tr>
    <tr>
      <td>StolenFormula.java</td>
      <td>Concrete case class detailing the Case of the Stolen Formula, suspect’s alibis evidence, and analysis logic.</td>
    </tr>
    <tr>
      <td>CaseOfBackwardClock.java</td>
      <td>Concrete case class detailing the Case of Backward Clock, suspect’s alibis evidence, and analysis logic.</td>
    </tr>
    <tr>
      <td>ConductorsFinalNote.java</td>
      <td>Concrete case class detailing the Case of Conductors Final Note, suspect’s alibis evidence, and analysis logic.</td>
    </tr>
    <tr>
      <td>PoetsLastDeadlineSuspects.java</td>
      <td>Enum enlisting all suspects in the Poet’s Last Deadline case, with their names, roles, and category.</td>
    </tr>
    <tr>
      <td>ChemistryLabMurderSuspects.java</td>
      <td>Enum enlisting all suspects in the Chemistry Lab Murder case, with their names, roles, and category.</td>
    </tr>
    <tr>
      <td>StolenFormulaSuspects.java</td>
      <td>Enum enlisting all suspects in the Stolen Formula case, with their names, roles, and category.</td>
    </tr>
    <tr>
      <td>CaseOfBackwardClockSuspects.java</td>
      <td>Enum enlisting all suspects in the Backward Clock case, with their names, roles, and category.</td>
    </tr>
    <tr>
      <td>ConductorsFinalNoteSuspects.java</td>
      <td>Enum enlisting all suspects in the Conductor's case, with their names, roles, and category.</td>
    </tr>
    <tr>
      <td>CaseNotFoundException</td>
      <td>Custom exception thrown when an invalid case number is requested.</td>
    </tr>
  </tbody>
</table>


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
// Preview of Code Implementation
public abstract class Case {
    private int caseID;
    private String caseName;
    .....

    public Case(int caseID, String caseName, String caseDescription, String suspectAlibi, String evidences) {
        this.caseID = caseID;
        this.caseName = caseName;
        .....
    }

    public Case() {
        this.caseID = 0;
        this.caseName = "";
        .....
    }

    public int getCaseID() {return caseID;}
    public String getCaseName() {return caseName;}
    .....

    public void setCaseID(int caseID) {this.caseID = caseID;}
    public void setCaseName(String caseName) {this.caseName = caseName;}
    .....

```

**Implementation in Project:**
- Private instance variables in all data classes
- Public getter/setter methods with validation

---

## 2️⃣ Inheritance
> 🌳 **Code Reusability & Hierarchy**

Inheritance promotes code reusability by creating parent-child relationships between classes. Child classes inherit properties and methods from parent classes while adding their own specific functionality.

```java
//Preview of Code Implementation
class PoetsLastDeadline extends Case {
    private Suspect suspect;

    public PoetsLastDeadline() {
        super(
                6601,
                "\u001B[36m Case of Poet's Last Deadline \u001B[36m",
                "Oliver Grant, a relentless investigative journalist, was found dead inside ...",
                "Rebecca Moore (Assistant):\n-last person to speak to him...",
                "1. Handwritten poem pinned to chest...");
        this.suspect = NoSuspect.NONE;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }
```

**Class Hierarchy**
```
```

**Implementation in Project:**
- Base class contains common attributes and methods
- Derived classes extend functionality for specific use cases
- Reduces code duplication and improves maintainability

---

## 3️⃣ Polymorphism
> 🎭 **Many Forms, One Interface**

Polymorphism allows objects to take multiple forms through method overriding and overloading, enabling flexible and dynamic behavior at runtime.
```java
//Preview of Code Implementation
class Main {
    public static void main(String[] args) {
        .....
        Switch(choice){
          Case.casesVault();
            case 1:
                try {
                    if(caseNo == 6601){
                        Case case1 = new PoetsLastDeadline();
                        case1.displayCaseInfo();
                        .....
                    }else if(caseNo == 6602){
                        Case case2 = new ChemistryLabMurder();
                        case2.displayCaseInfo();
                        .....
                    }else if(caseNo == 6603){
                        Case case3 = new StolenFormula();
                        case3.displayCaseInfo();
                        .....
                    }else
                        .....
                }catch{
                    break;
                }
            case 2:
                ....
                break;
            default:
            break;
        }
    }
}
```
**Implementation in Project:**
- Method overriding for specialized behavior in child classes
- Method overloading for different parameter combinations
- Interface implementation for contract-based programming

---

## 4️⃣ Abstraction
> 🎨 **Hiding Complexity**

Abstraction hides complex implementation details and shows only the essential features of objects. This simplifies the interface and reduces complexity for users of the class.

```java
public interface Suspect {
    String getFullName();
    String getCategory();
}
```
**Implementation in Project:**
- Abstract classes define common structure
- Interfaces specify required methods
- Implementation details hidden from end users
---
## 📦 Main Classes and Their Roles

### **1. MainClass** 
🎯 **Role**: Entry point of the application, handles user interaction and program flow

**Key Methods:**
- `main()` - Program entry point
- `displayMenu()` - Shows user options
- `processInput()` - Handles user commands

---

### **2. DataHandler**
💾 **Role**: Manages data operations, storage, and retrieval

**Key Methods:**
- `loadData()` - Loads data from source
- `saveData()` - Persists data to storage
- `validateData()` - Ensures data integrity

---

### **3. BusinessLogic**
⚙️ **Role**: Contains core business rules and processing logic

**Key Methods:**
- `calculate()` - Performs calculations
- `process()` - Executes business operations
- `validate()` - Validates business rules

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
```
Wtsn_47: Congratulations! Please type your preferred codename: Doe12   

LET THE PROTOCOL BEGIN, Doe12
System loading.....................(Enter to continue)


╔════════════════════════════════════════╗
║            MAIN MENU                   ║
╚════════════════════════════════════════╝

[1] Cases Vault
[2] Pandora's Box
[3] Morse Code Decoder
[4] Leave Game

» Enter your choice:
```

> 💡 **Note**: Actual output may vary based on user input and program state.

## 📸 Sample Screenshots

*(If you have screenshots, add them here)*

```
[Screenshot of main menu]
[Screenshot of processing screen]
[Screenshot of results display]
```

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
    <td>Project Leader/Git Manager & System Architect</td>
</tr>
<tr>
    <td><img src="static/irish.png" width="100" height="100"> </td>
    <td><strong>Irish M. Banaag, BSCS</strong> <br/>
    <a href="https://github.com/ciancrey" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=blue" alt="ciancrey's GitHub">
        </a>
    </td>
    <td>Content Writer / Security & Error-Handling Specialist</td>
</tr>
<tr>
    <td><img src="static/anica.png" width="100" height="100"> </td>
    <td><strong>Baruel, Anica Kim D., BSCS</strong> <br/>
    <a href="https://github.com/Anicakim13" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=pink" alt="Anicakim13's GitHub">
        </a>
    </td>
    <td>Content Writer & Documentation Head</td>
</tr>
</table>

---

## 🙏 Acknowledgements

I would like to express my gratitude to:

- **Professor/Instructor Name** - For guidance and support throughout the project development
- **Classmate/Peer Name** - For collaboration and helpful discussions on implementation
- **Resource/Tutorial Name** - For valuable learning materials and code examples
- **Online Community** - Stack Overflow and GitHub communities for problem-solving assistance

---

## 🔮 Future Enhancements

The following features and improvements are planned for future versions:

- [ ] 🎨 **GUI Implementation**: Create a graphical user interface using JavaFX or Swing
- [ ] 💾 **Database Integration**: Implement MySQL/PostgreSQL for persistent data storage
- [ ] 🌐 **API Integration**: Connect to external APIs for real-time data
- [ ] 🔐 **User Authentication**: Add login system with password encryption
- [ ] 📊 **Data Visualization**: Implement charts and graphs for data analysis
- [ ] 🐛 **Enhanced Error Handling**: Comprehensive exception handling for edge cases
- [ ] ⚡ **Performance Optimization**: Improve algorithm efficiency for large datasets
- [ ] 📱 **Mobile Version**: Develop Android/iOS companion app
- [ ] 🌍 **Internationalization**: Support multiple languages
- [ ] 📝 **Logging System**: Implement detailed logging for debugging

---

## 📚 References

### Documentation & Official Resources
1. **Java Documentation** - Oracle Official Docs  
   🔗 [https://docs.oracle.com/en/java/](https://docs.oracle.com/en/java/)

2. **Java SE API Specification**  
   🔗 [https://docs.oracle.com/en/java/javase/11/docs/api/](https://docs.oracle.com/en/java/javase/11/docs/api/)

### Books & Tutorials
3. **Effective Java** - Joshua Bloch (3rd Edition, 2018)
4. **Head First Java** - Kathy Sierra & Bert Bates (2nd Edition)
5. **Clean Code** - Robert C. Martin (2008)

### Online Resources
6. **Stack Overflow** - Community discussions and problem-solving  
   🔗 [https://stackoverflow.com/](https://stackoverflow.com/)

7. **GeeksforGeeks** - Java programming tutorials and concepts  
   🔗 [https://www.geeksforgeeks.org/java/](https://www.geeksforgeeks.org/java/)

8. **Baeldung** - Java tutorials and guides  
   🔗 [https://www.baeldung.com/](https://www.baeldung.com/)

### Video Tutorials
9. **YouTube Channel Name** - Specific tutorial series on [topic]
10. **Coursera/Udemy Course** - [Course name and instructor]

---

<div align="center">

## ⭐ Support This Project

If you found this project helpful, please consider giving it a ⭐!

**Made with ❤️ and ☕ by [Your Name]**

---

### 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

---

![Thank You](https://img.shields.io/badge/Thank%20You-For%20Visiting-brightgreen?style=for-the-badge)

</div>
