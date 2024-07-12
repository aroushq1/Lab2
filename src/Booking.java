import java.util.Date;
import java.util.Arrays;



public class Booking {
	private Pet petInfo;
    private Staff caretaker;
    private Payment[] bookingHistory;
    private Date bookingDate;
    private Client client;

    //constructors
    public Booking(Pet petInfo, Staff caretaker, Payment[] bookingHistory, Date bookingDate, Client client){
        this.petInfo = petInfo;
        this.caretaker = caretaker;
        this.bookingHistory = bookingHistory;
        this.bookingDate = bookingDate;
        this.client = client;
    }

    //setters
    public void setPetInfo(String name, String breedType, Client owner, PetCareProfile careProfile){
        this.petInfo = new Pet(name, breedType, owner, careProfile);
    }

    public void setCaretaker(String name, String staffID){
        this.caretaker = new Staff(name, staffID);
    }

    public void setBookingHistory(Payment[] bookingHistory){
        this.bookingHistory = bookingHistory; //IS THIS CORRECT??
    }

    public void setBookingDate(Date bookingDate){
        this.bookingDate = bookingDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //getters
    public Pet getPetInfo(){
        return petInfo;
    }

    public Staff getCaretaker(){
        return caretaker;
    }

    public Date getBookingDate(){
        return bookingDate;
    }

    public Payment[] getBookingHistory(){
        return bookingHistory;
    }

    public Client getClient(){
        return client;
    }

    //Choose to show booking History
    public void displayBookingHistory(){
        if(bookingHistory != null && bookingHistory.length > 0){
            for(Payment payment: bookingHistory){
                System.out.println("Date: " + payment.getTransactionDate() + "\nPayment ID: " + payment.getPaymentID());
            }
        }else{
            System.out.println("Your Booking History is Empty");
        }
    }
}
