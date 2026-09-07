# Mini Hospital Management System

A Java console application for managing patient records, emergency patients, treatment history, and patient visit history.

## Features

- Register, search, delete, and display patient records
- Add registered patients to an emergency queue
- Treat the next patient in the emergency queue
- Record and remove completed treatments
- Add, search, remove, and display patient visits
- Validate numeric menu input and prevent duplicate patient and visit IDs

## Data Structures

| Component | Data structure | Purpose |
| --- | --- | --- |
| Patient records | Binary Search Tree (BST) | Stores and searches patients by patient ID |
| Emergency patients | Queue | Processes patients in first-in, first-out order |
| Treatment history | Stack | Stores the most recent treatment first |
| Visit history | Linked list | Stores visits for each patient |

## Project Files

- `Main.java` - Application entry point and console menu
- `Patient.java` - Patient details and visit history
- `PatientBST.java` - Binary search tree for patient records
- `EmergencyQueue.java` - Emergency patient queue
- `TreatmentRecord.java` - Treatment information
- `TreatmentStack.java` - Treatment history stack
- `Visit.java` - Patient visit information
- `VisitLinkedList.java` - Linked list for patient visits

## Requirements

- Java Development Kit (JDK) 14 or newer, because the project uses modern switch-case syntax
- A command-line terminal or Java-compatible IDE

## Compile and Run

Open a terminal in the project folder and run:

```bash
javac *.java
java Main
```

To remove compiled class files on Windows PowerShell:

```powershell
Remove-Item *.class
```

To remove compiled class files on macOS or Linux:

```bash
rm *.class
```

## Main Menu

1. Register a new patient
2. Search for a patient
3. Delete a patient
4. Display all patients
5. Add a patient to the emergency queue
6. Treat the next emergency patient
7. Display the emergency queue
8. Complete and record a treatment
9. Remove the last treatment
10. Display treatment history
11. Add a patient visit
12. Search for a visit
13. Remove a visit
14. Display visit history
0. Exit

## Usage Notes

- A patient must be registered before being added to the emergency queue or receiving a treatment record.
- A patient must exist before adding or searching visit history.
- Patient IDs must be unique.
- Visit IDs must be unique for each patient.
- Data is stored in memory and is lost when the program exits.

## Author

Manfahath
