
public class Staff {
	//private Attributes
    private String name;
    private String staffID;

    //public methods & constructor
    public Staff(String name, String staffID) {  //constructor
        this.name = name;
        this.staffID = staffID;
    }
 
    //setters & getters
    public void setName(String name) {
        this.name = name;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public String getStaffID() {
        return staffID;
    }
    
    
    

}
