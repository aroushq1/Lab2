import java.util.ArrayList;



public interface Application {
	void run();
    void manageClient(ArrayList<Client> clients);
    void managePet(ArrayList<Pet> pets);
    // Other methods for managing bookings, pet care profiles, etc.
}
