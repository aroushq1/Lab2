


public class Pet {
	private String name;
    private static int petID = 0;
    private String breedType;
    private Client owner;
    private PetCareProfile careProfile;

    //constructors
    public Pet(String name, String breedType, Client owner, PetCareProfile careprofile){
        this.name = name;
        this.petID = petID++;
        this.breedType = breedType;
        this.owner = owner;
        this.careProfile = careProfile;
    }

    public Pet(String name, String breedType, PetCareProfile careprofile){
        this.name = name;
        this.petID = petID++;
        this.breedType = breedType;
        this.careProfile = careProfile;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setBreedType(String breedType){
        this.breedType = breedType;
    }

    public void setOwner(String name, String phoneNumber, String address){
        this.owner = new Client(name, phoneNumber, address);
    }

    //getters
    public String getName(){
        return name;
    }

    public int getPetID(){
        return petID;
    }

    public String getBreedType(){
        return breedType;
    }

    public Client getOwner(){
        return owner;
    }

    public PetCareProfile getCareProfile(){
        return careProfile;
    }

	public PetCareProfile getPetCareProfile() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPetCareProfile'");
	}

	public void setPetCareProfile(PetCareProfile petCareProfile) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPetCareProfile'");
	}
}
