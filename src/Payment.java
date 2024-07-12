import java.util.Date;
import java.text.SimpleDateFormat;



public class Payment {
	private double amount;
    private Date transactionDate;
    private static int idCounter = 0;
    private final int paymentID; //used AI to make this final
    private String status;


    public Payment(double amount){
        this.amount = amount;
        this.transactionDate = new Date(); //ChatGPT to generate current date and time
        this.paymentID = ++idCounter;
        this.status = "unpaid";
    }

    //setters
    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setStatus(String status){
        this.status = status;
    }

    //getters
    public double getAmount(){
        return amount;
    }

    public Date getTransactionDate(){
        return transactionDate;
    }

    public int getPaymentID(){
        return paymentID;
    }

    public String getStatus(){
        return status;
    }
}
