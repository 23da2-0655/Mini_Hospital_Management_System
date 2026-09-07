public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatment;
    private String treatmentDate;

    public TreatmentRecord(int patientId, String patientName,
                           String doctorName, String treatment,
                           String treatmentDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatment = treatment;
        this.treatmentDate = treatmentDate;
    }

    public void displayRecord() {
        System.out.println("----------------------------------");
        System.out.println("Patient ID      : " + patientId);
        System.out.println("Patient Name    : " + patientName);
        System.out.println("Doctor          : " + doctorName);
        System.out.println("Treatment       : " + treatment);
        System.out.println("Treatment Date  : " + treatmentDate);
        System.out.println("----------------------------------");
    }
}
