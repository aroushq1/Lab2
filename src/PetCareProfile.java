import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PetCareProfile {
	//attributes
    private String medInstructions;
    private FeedingInstruction feedInstruction;
    private List<Medication> medicationList;

    //constructors
    public PetCareProfile(String medInstructions, FeedingInstruction feedInstruction, Medication[] medicationList) {
        this.medInstructions = medInstructions;
        this.feedInstruction = feedInstruction;
        this.medicationList = new ArrayList<>();
        if  (medicationList != null) {  //checks if medication parameter is valid before attempting to iterate and add it to the list
            for(Medication medication : medicationList ) {    //AI was used to construct this if branch and for loop
                this.medicationList.add(medication);
            }
        }
    }

    public PetCareProfile(String medInstructions, FeedingInstruction feedInstruction) {
        this(medInstructions, feedInstruction, null); //calling primary constructor
    }

    public PetCareProfile(String medInstructions, Medication[] medicationList) {
        this(medInstructions, null, medicationList);  //calling primary constructor
    }

    public PetCareProfile(String medInstructions) {
        this(medInstructions, null, null); //calling primary constructor
    }

    //setters & getters
    public void setMedicationList(Date medStartDate, Date medEndDate, String medName) {
        if (this.medicationList == null) {     //AI was used to construct the body of this method but was further refined for accuracy
            this.medicationList = new ArrayList<>();
        }
        
        Medication newMedication = new Medication(medStartDate, medEndDate, medName); // Creating a new Medication object
        this.medicationList.add(newMedication); // Adding newMedication to medicationList
    }

    public void setFeedInstruction(String foodType, String amount, String frequency) {
        this.feedInstruction = new FeedingInstruction(foodType, amount, frequency);
    }

    public void setMedInstructions(String medInstructions) {
        this.medInstructions = medInstructions;
    }

    public String getMedInstructions() {
        return medInstructions;
    }

    public FeedingInstruction getFeedInstruction() {
        return feedInstruction;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public String printCareInstructions() {   //prints out the instructions
        StringBuilder sb = new StringBuilder(); //this method was created using AI
        sb.append("Medication Instructions: ").append(medInstructions).append("\n");
        sb.append("Feeding Instructions: ").append(feedInstruction).append("\n");
        sb.append("Medications:\n");
        for (Medication medication : medicationList) {
            sb.append("\t").append(medication).append("\n");
        }
        return sb.toString();
    }

    public void setMedicationList(Medication[] updatedMedications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMedicationList'");
    }
}
