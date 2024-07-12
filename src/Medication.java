import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Medication {
	//private attributes
    private Date medStartDate;
    private Date medEndDate;
    private String medName;

    //constructor
    public Medication(Date medStartDate, Date medEndDate, String medName) {
        this.medStartDate = medStartDate;
        this.medEndDate = medEndDate;
        this.medName = medName;
    }

    //setters & getters
    public void setMedStartDate(Date medStartDate) {
        this.medStartDate = medEndDate;
    }

    public void setMedEndDate(Date medEndDate) {
        this.medEndDate = medEndDate;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public Date getMedStartDate() {
        return medStartDate;
    }

    public Date getMedEndDate() {
        return medEndDate;
    }

    public String getMedName() {
        return medName;
    }
}
