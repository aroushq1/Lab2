


public class Client {
	private String name;
    private String phoneNumber;
    private String address;

    //constructor
    public Client(String name, String phoneNumber, String address){
        this.name = name;
        this.setPhoneNumber(phoneNumber); //this way we will get an exception if needed
        this.address = address;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")){ //used Chatgpt to help create regex to match the phonenumber to
            throw new IllegalArgumentException("Please Enter a valid number. The number must be digits only and 10 characters long");
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    public void setAddress(String address){
        this.address = address;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return address;
    }
}
