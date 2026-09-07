import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> displayPatients();
                case 5 -> addEmergencyPatient();
                case 6 -> treatNextPatient();
                case 7 -> emergencyQueue.displayQueue();
                case 8 -> completeTreatment();
                case 9 -> removeLastTreatment();
                case 10 -> treatmentStack.displayStack();
                case 11 -> addVisit();
                case 12 -> searchVisit();
                case 13 -> removeVisit();
                case 14 -> displayVisitHistory();
                case 0 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }

    static void displayMenu() {
        System.out.println("\n==========================================");
        System.out.println("     MINI HOSPITAL EMERGENCY SYSTEM");
        System.out.println("==========================================");
        System.out.println("\n--- Patient Records (BST) ---");
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display Patients (In-order)");

        System.out.println("\n--- Emergency Queue ---");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");

        System.out.println("\n--- Treatment Stack ---");
        System.out.println("8. Complete Treatment");
        System.out.println("9. Remove Last Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("\n--- Patient Visit History ---");
        System.out.println("11. Add Visit");
        System.out.println("12. Search Visit");
        System.out.println("13. Remove Visit");
        System.out.println("14. Display Visit History");
        System.out.println("\n0. Exit");
        System.out.println("==========================================");
    }

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void registerPatient() {
        System.out.println("\n===== Register Patient =====");

        int id = readInt("Patient ID: ");

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Age: ");

        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    static void searchPatient() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("\nPatient found:");
            patient.displayPatient();
        }
    }

    static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");

        if (patientBST.delete(id)) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void displayPatients() {
        System.out.println("\n===== All Patients =====");
        patientBST.inOrderTraversal();
    }

    static void addEmergencyPatient() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        emergencyQueue.enqueue(patient);
        System.out.println(patient.getPatientName() +
                " added to emergency queue.");
    }

    static void treatNextPatient() {
        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {
            System.out.println("Now treating: " +
                    patient.getPatientName());
        }
    }

    static void completeTreatment() {
        System.out.println("\n===== Complete Treatment =====");

        int id = readInt("Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Treatment Date: ");
        String date = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getPatientName(),
                doctor,
                treatment,
                date);

        treatmentStack.push(record);
        System.out.println("Treatment completed and recorded.");
    }

    static void removeLastTreatment() {
        TreatmentRecord record = treatmentStack.pop();

        if (record != null) {
            System.out.println("Most recent treatment removed.");
        }
    }

    static void addVisit() {
        System.out.println("\n===== Add Patient Visit =====");

        int patientId = readInt("Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");

        if (patient.getVisitHistory().searchVisit(visitId) != null) {
            System.out.println("Visit ID already exists for this patient.");
            return;
        }

        System.out.print("Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId, date, doctor, diagnosis, treatment);

        patient.getVisitHistory().addVisit(visit);
        System.out.println("Visit added successfully.");
    }

    static void searchVisit() {
        int patientId = readInt("Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("\nVisit found:");
            visit.displayVisit();
        }
    }

    static void removeVisit() {
        int patientId = readInt("Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID to remove: ");

        if (patient.getVisitHistory().removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    static void displayVisitHistory() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("\n===== Visit History of " +
                patient.getPatientName() + " =====");
        patient.getVisitHistory().displayVisits();
    }
}
