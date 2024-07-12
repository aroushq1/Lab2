



public class FeedingInstruction {
	//private attributes
    private String foodType;
    private String amount;
    private String frequency;

    //constructor
    public FeedingInstruction(String foodType, String amount, String frequency) {
        this.foodType = foodType;
        this.amount = amount;
        this.frequency = frequency;
    }

    //setters & getters
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getAmount() {
        return amount;
    }

    public String getFrequency() {
        return frequency;
    }
}
