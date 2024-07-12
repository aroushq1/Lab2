import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class PetResortApplication implements Application {

	ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Pet> pets = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    ArrayList<Staff> staffList = new ArrayList<>();
    ArrayList<Medication> medList = new ArrayList<>(); 

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;


        while (true) {
            System.out.println("\nWelcome to YYC Pet Resort management system!\n");
            System.out.println("======= Menu ======= \n");
            System.out.println("1. Manage Client");
            System.out.println("2. Manage Pet");
            System.out.println("3. Bookings & Reservations");
            System.out.println("4. Pet Care Profile");
            System.out.println("5. Billings & Payments");
            System.out.println("6. Manage Staff");
            System.out.println("7. Exit\n");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageClient(clients);
                    break;
                case 2:
                    managePet(pets);
                    break;
                case 3:
                    manageBookings(bookings);
                    break;
                case 4:
                    managePetCareProfile();
                    break;
                
                case 5:
                    System.out.println("Please Select an option: ");
                    System.out.println("1. Open Customer Transaction ");
                    System.out.println("2. Invoices ");

                    int choice2 = scanner.nextInt();

                    switch(choice2) {
                        case 1:
                            System.out.println("Please Enter the Payment ID for which you would like to make the Transaction");
                            int paymentNum = scanner.nextInt(); // This is read but not used

                            System.out.println("Please Enter the Transaction Amount in Dollars and then 'Enter' to confirm");
                            double amount = scanner.nextDouble();

                            Payment newPayment = new Payment(amount);
                            newPayment.setStatus("paid");

                            System.out.println("Your Payment has been Processed");

                            break;

                        case 2:
                            System.out.println("Please Enter the Number of services you used today: ");
                            int services = scanner.nextInt();

                            int invoiceAmount = 20 * services;

                            Payment invoicePayment = new Payment(invoiceAmount); // Change amount to invoiceAmount

                            System.out.println("Invoice Printing...");
                            System.out.println("Your total amount is: " + invoiceAmount + "\nServices used: " + services + "\nPaymentID: " + invoicePayment.getPaymentID());
                            System.out.println("A record has been made, Please Pay the amount next");

                            break;

                        default:
                            System.out.println("Invalid Option. Try Again.");
                            break;
                    } break;
                
                case 6:
                    manageStaff();
                    break;

                case 7:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    @Override
    public void manageClient(ArrayList<Client> clients) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\nManage Clients");
        System.out.println("1. Add New Client");
        System.out.println("2. Update Client");
        System.out.println("3. Remove Client");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addClient(clients);
                break;
            case 2:
                updateClient(clients);
                break;
            case 3:
                removeClient(clients);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void addClient(ArrayList<Client> clients) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd New Client");

        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client address: ");
        String address = scanner.nextLine();
        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.nextLine();

        if (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Please enter a valid phone number (10 digits).");
            return;
        }

        Client newClient = new Client(name, phoneNumber, address);
        clients.add(newClient);
        System.out.println("\nClient added successfully!");
    }

    private void updateClient(ArrayList<Client> clients) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUpdate Client");

        System.out.println("List of Clients:");
        for (Client client : clients) {
            System.out.println(client.getName());
        }

        System.out.print("Enter client name to update: ");
        String clientName = scanner.nextLine();

        boolean found = false;
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                System.out.print("Enter updated address: ");
                String address = scanner.nextLine();
                System.out.print("Enter updated phone number: ");
                String phoneNumber = scanner.nextLine();

                if (!phoneNumber.matches("\\d{10}")) {
                    System.out.println("Please enter a valid phone number (10 digits).");
                    return;
                }

                client.setAddress(address);
                client.setPhoneNumber(phoneNumber);
                System.out.println("Client details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Client not found. Please check the name and try again.");
        }
    }

    private void removeClient(ArrayList<Client> clients) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRemove Client");

        System.out.println("List of Clients:");
        for (Client client : clients) {
            System.out.println(client.getName());
        }

        System.out.print("Enter client name to remove: ");
        String clientName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getName().equalsIgnoreCase(clientName)) {
                clients.remove(i);
                System.out.println("Client removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Client not found. Please check the name and try again.");
        }
    }

    @Override
    public void managePet(ArrayList<Pet> pets) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\nManage Pets");
        System.out.println("1. Add New Pet");
        System.out.println("2. Update Pet");
        System.out.println("3. Remove Pet");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addPet(pets);
                break;
            case 2:
                updatePet(pets);
                break;
            case 3:
                removePet(pets);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void addPet(ArrayList<Pet> pets) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd New Pet");

        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet ID: ");
        int petID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter breed type: ");
        String breedType = scanner.nextLine();
        System.out.print("Enter care profile name: ");
        String careProfileName = scanner.nextLine();

        // Create a new PetCareProfile object
        PetCareProfile careProfile = new PetCareProfile(careProfileName);

        // Create a new pet object
        Pet newPet = new Pet(name, breedType, careProfile);

        // Add the new pet to the pets list
        pets.add(newPet);
        System.out.println("\nPet added successfully!");
    }

    private void updatePet(ArrayList<Pet> pets) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUpdate Pet");

        // Display list of pets (names or IDs)
        System.out.println("List of Pets:");
        for (Pet pet : pets) {
            System.out.println(pet.getName()); // or pet.getID() or any other identifier
        }

        // Prompt user to select a pet to update
        System.out.print("Enter pet name to update: ");
        String petName = scanner.nextLine();

        // Search for the pet in the list
        boolean found = false;
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                // Pet found, prompt user for updated details
                System.out.print("Enter updated breed type: ");
                String breedType = scanner.nextLine();

                System.out.print("Enter updated care profile name: ");
                String careProfileName = scanner.nextLine();

                // Update pet details
                pet.setBreedType(breedType);
                pet.getCareProfile().setMedInstructions(careProfileName);

                System.out.println("Pet details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pet not found. Please check the name and try again.");
        }
    }

    private void removePet(ArrayList<Pet> pets) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRemove Pet");

        // Display list of pets (names or IDs)
        System.out.println("List of Pets:");
        for (Pet pet : pets) {
            System.out.println(pet.getName()); // or pet.getID() or any other identifier
        }

        // Prompt user to select a pet to remove
        System.out.print("Enter pet name to remove: ");
        String petName = scanner.nextLine();

        // Search for the pet in the list
        boolean found = false;
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                // Pet found, remove it from the list
                pets.remove(pet);
                System.out.println("Pet removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pet not found. Please check the name and try again.");
        }
    }

  
    public void manageBookings(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        System.out.println("\nManage Bookings & Reservations");
        System.out.println("1. Add New Booking");
        System.out.println("2. Update Booking");
        System.out.println("3. Remove Booking");
        System.out.println("4. Display Booking History");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
    
        switch (choice) {
            case 1:
                addBooking(bookings);
                break;
            case 2:
                updateBooking(bookings);
                break;
            case 3:
                removeBooking(bookings);
                break;
            case 4:
                displayBookingHistory(bookings);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                break;
        }
    }

    private void addBooking(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd New Booking");

        // Assuming we have lists of pets, clients, and staff to select from
        // Let's prompt for necessary information
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter pet name: ");
        String petName = scanner.nextLine();

        Pet pet = findPetByName(petName);

        if (pet == null) {
            System.out.println("Pet not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter caretaker name: ");
        String caretakerName = scanner.nextLine();

        Staff caretaker = findStaffByName(caretakerName);

        if (caretaker == null) {
            System.out.println("Caretaker not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter booking date (YYYY-MM-DD): ");
        String bookingDateString = scanner.nextLine();

        Date bookingDate = parseDate(bookingDateString);

        if (bookingDate == null) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return;
        }

        // Assuming bookingHistory and payment details need to be initialized separately
        // For simplicity, let's initialize an empty array for booking history
        Payment[] bookingHistory = new Payment[0];

        // Create a new Booking object and add it to the list
        Booking newBooking = new Booking(pet, caretaker, bookingHistory, bookingDate, client);
        bookings.add(newBooking);

        System.out.println("Booking added successfully!");
    }

    private void updateBooking(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUpdate Booking");

        System.out.print("Enter client name for booking to update: ");
        String clientName = scanner.nextLine();

        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter pet name for booking to update: ");
        String petName = scanner.nextLine();

        Pet pet = findPetByName(petName);

        if (pet == null) {
            System.out.println("Pet not found. Please check the name and try again.");
            return;
        }

        // Find the booking to update
        Booking bookingToUpdate = findBookingByClientAndPet(bookings, client, pet);

        if (bookingToUpdate == null) {
            System.out.println("Booking not found. Please check client and pet names and try again.");
            return;
        }

        System.out.print("Enter updated caretaker name: ");
        String caretakerName = scanner.nextLine();

        Staff caretaker = findStaffByName(caretakerName);

        if (caretaker == null) {
            System.out.println("Caretaker not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter updated booking date (YYYY-MM-DD): ");
        String bookingDateString = scanner.nextLine();

        Date bookingDate = parseDate(bookingDateString);

        if (bookingDate == null) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return;
        }

        // Update booking details
        bookingToUpdate.setCaretaker(caretaker.getName(), caretaker.getStaffID());
        bookingToUpdate.setBookingDate(bookingDate);

        System.out.println("Booking details updated successfully!");
    }

    private void removeBooking(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRemove Booking");

        System.out.print("Enter client name for booking to remove: ");
        String clientName = scanner.nextLine();

        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please check the name and try again.");
            return;
        }

        System.out.print("Enter pet name for booking to remove: ");
        String petName = scanner.nextLine();

        Pet pet = findPetByName(petName);

        if (pet == null) {
            System.out.println("Pet not found. Please check the name and try again.");
            return;
        }

        // Find the booking to remove
        Booking bookingToRemove = findBookingByClientAndPet(bookings, client, pet);

        if (bookingToRemove == null) {
            System.out.println("Booking not found. Please check client and pet names and try again.");
            return;
        }

        // Remove the booking from the list
        bookings.remove(bookingToRemove);

        System.out.println("Booking removed successfully!");
    }

    private void displayBookingHistory(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDisplay Booking History");

        System.out.print("Enter client name to display booking history: ");
        String clientName = scanner.nextLine();

        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please check the name and try again.");
            return;
        }

        // Display booking history for the client
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getClient().getName().equalsIgnoreCase(clientName)) {
                System.out.println("Booking Date: " + booking.getBookingDate());
                booking.displayBookingHistory(); // Assuming displayBookingHistory is a method in Booking class
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No bookings found for client: " + clientName);
        }
    }

    // Helper methods to find objects in lists
    private Client findClientByName(String clientName) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                return client;
            }
        }
        return null;
    }

    private Pet findPetByName(String petName) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                return pet;
            }
        }
        return null;
    }

    private Staff findStaffByName(String staffName) {
        for (Staff staff : staffList) {
            if (staff.getName().equalsIgnoreCase(staffName)) {
                return staff;
            }
        }
        return null;
    }

    private Booking findBookingByClientAndPet(ArrayList<Booking> bookings, Client client, Pet pet) {
        for (Booking booking : bookings) {
            if (booking.getClient().equals(client) && booking.getPetInfo().equals(pet)) {
                return booking;
            }
        }
        return null;
    }

    private Date parseDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return null;
        }
    }

    public void managePetCareProfile() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\nManage Pet Care Profile");
        System.out.println("1. Create Pet Care Profile");
        System.out.println("2. Update Pet Care Profile");
        System.out.println("3. View Pet Care Profile");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createPetCareProfile();
                break;
            case 2:
                updatePetCareProfile();
                break;
            case 3:
                viewPetCareProfile();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                break;
        }
    }

    private void createPetCareProfile() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCreate Pet Care Profile");

        // Ask for client name
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        // Check if client exists
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please add the client first.");
            // Add logic to handle adding a new client here if needed
            return;
        }

        // Ask for pet name
        System.out.print("Enter pet name: ");
        String petName = scanner.nextLine();

        // Check if pet exists
        Pet pet = findPetByName(petName);

        if (pet == null) {
            System.out.println("Pet not found. Please add the pet first.");
            // Add logic to handle adding a new pet here if needed
            return;
        }

        // Gather necessary information for PetCareProfile
        System.out.print("Enter medication instructions: ");
        String medInstructions = scanner.nextLine();

        System.out.print("Enter feeding instructions (food type, amount, frequency): ");
        String foodType = scanner.nextLine();
        String amount = scanner.nextLine();
        String frequency = scanner.nextLine();
        FeedingInstruction feedingInstruction = new FeedingInstruction(foodType, amount, frequency);

        // Gather medications
        System.out.print("Enter number of medications: ");
        int numMedications = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Medication[] medications = new Medication[numMedications];
        for (int i = 0; i < numMedications; i++) {
            System.out.print("Enter medication start date (YYYY-MM-DD): ");
            String startDateStr = scanner.nextLine();
            System.out.print("Enter medication end date (YYYY-MM-DD): ");
            String endDateStr = scanner.nextLine();
            System.out.print("Enter medication name: ");
            String medName = scanner.nextLine();

            // Parse dates
            Date startDate = parseDate(startDateStr);
            Date endDate = parseDate(endDateStr);

            medications[i] = new Medication(startDate, endDate, medName);
        }

        // Create PetCareProfile object and associate with the pet or store as needed
        PetCareProfile petCareProfile = new PetCareProfile(medInstructions, feedingInstruction, medications);
        pet.setPetCareProfile(petCareProfile);  // Associate profile with the pet

        System.out.println("Pet Care Profile created successfully!");
    }
    private void updatePetCareProfile() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nUpdate Pet Care Profile");

    // Implement logic to select a pet or retrieve pet care profile to update
    // Example: Prompt user to select a pet or search by client, etc.
    System.out.print("Enter pet name or client name to update profile: ");
    String searchQuery = scanner.nextLine();

    // Implement logic to find the pet or client associated with the pet care profile
    // For example:
    Pet petToUpdate = findPetByName(searchQuery);

    if (petToUpdate == null) {
        System.out.println("Pet not found. Returning to main menu.");
        return;
    }

    // Assuming you have a way to associate pet care profiles with pets
    PetCareProfile petCareProfileToUpdate = petToUpdate.getPetCareProfile();

    // Proceed with updating specific fields of the pet care profile
    System.out.print("Update medication instructions (leave blank to keep current): ");
    String updatedMedInstructions = scanner.nextLine();
    if (!updatedMedInstructions.isEmpty()) {
        petCareProfileToUpdate.setMedInstructions(updatedMedInstructions);
    }

    System.out.print("Update feeding instructions (food type, amount, frequency) (leave blank to keep current): ");
    String updatedFoodType = scanner.nextLine();
    String updatedAmount = scanner.nextLine();
    String updatedFrequency = scanner.nextLine();
    if (!updatedFoodType.isEmpty() || !updatedAmount.isEmpty() || !updatedFrequency.isEmpty()) {
        petCareProfileToUpdate.setFeedInstruction(updatedFoodType, updatedAmount, updatedFrequency);
    }

    // Implement logic to update medications, if needed
    System.out.print("Update medications (Y/N)? ");
    String updateMedicationsChoice = scanner.nextLine();
    if (updateMedicationsChoice.equalsIgnoreCase("Y")) {
        // Assuming you want to completely replace medications
        System.out.print("Enter number of medications: ");
        int numMedications = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Medication[] updatedMedications = new Medication[numMedications];
        for (int i = 0; i < numMedications; i++) {
            System.out.print("Enter medication start date (YYYY-MM-DD): ");
            String startDateStr = scanner.nextLine();
            System.out.print("Enter medication end date (YYYY-MM-DD): ");
            String endDateStr = scanner.nextLine();
            System.out.print("Enter medication name: ");
            String medName = scanner.nextLine();

            // Parse dates
            Date startDate = parseDate(startDateStr);
            Date endDate = parseDate(endDateStr);

            updatedMedications[i] = new Medication(startDate, endDate, medName);
        }

        // Update medications in the pet care profile
        petCareProfileToUpdate.setMedicationList(updatedMedications);
    }

    // Optionally, update other fields as needed

    System.out.println("Pet Care Profile updated successfully!");
}

private void viewPetCareProfile() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nView Pet Care Profile");

    // Implement logic to select a pet or retrieve pet care profile to view
    // Example: Prompt user to select a pet or search by client, etc.
    System.out.print("Enter pet name or client name to view profile: ");
    String searchQuery = scanner.nextLine();

    // Implement logic to find the pet or client associated with the pet care profile
    // For example:
    Pet petToView = findPetByName(searchQuery);

    if (petToView == null) {
        System.out.println("Pet not found. Returning to main menu.");
        return;
    }

    // Assuming you have a way to associate pet care profiles with pets
    PetCareProfile petCareProfileToView = petToView.getPetCareProfile();

    // Display pet care profile information
    System.out.println("Pet Care Profile for " + petToView.getName() + ":");
    System.out.println(petCareProfileToView.printCareInstructions());
}

// Method to manage staff
private void manageStaff() {
    Scanner scanner = new Scanner(System.in);
    int choice;

    while (true) {
        System.out.println("\n======= Manage Staff =======");
        System.out.println("1. Add Staff");
        System.out.println("2. Update Staff");
        System.out.println("3. View Staff");
        System.out.println("4. Delete Staff");
        System.out.println("5. Back to Main Menu\n");
        System.out.print("Enter your choice: ");

        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                addStaff();
                break;
            case 2:
                updateStaff();
                break;
            case 3:
                viewStaff();
                break;
            case 4:
                deleteStaff();
                break;
            case 5:
                return; // Return to main menu
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }
}

    // Method to add a new staff member
    private void addStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n======= Add Staff =======");
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff position: ");
        String position = scanner.nextLine();

        // Create a new Staff object and add it to the staff list
        Staff staff = new Staff(name, position);
        staffList.add(staff);

        System.out.println("Staff added successfully!");
    }

        // Method to update an existing staff member
    private void updateStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n======= Update Staff =======");
        System.out.print("Enter staff name to update: ");
        String name = scanner.nextLine();

        Staff staff = findStaffByName(name);
        if (staff == null) {
            System.out.println("Staff not found.");
            return;
        }

        System.out.print("Enter updated position: ");
        String newPosition = scanner.nextLine();

        // Update staff position (assuming you have a setPosition method in Staff class)
        staff.setName(newPosition);

        System.out.println("Staff updated successfully!");
    }

    // Method to view all staff members
    private void viewStaff() {
        System.out.println("\n======= View Staff =======");
        if (staffList.isEmpty()) {
            System.out.println("No staff members found.");
            return;
        }

        System.out.println("List of Staff Members:");
        for (Staff staff : staffList) {
            System.out.println("Name: " + staff.getName() + ", Staff ID: " + staff.getStaffID()); // Corrected to getStaffID method
        }
    }


    // Method to delete a staff member
    private void deleteStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n======= Delete Staff =======");
        System.out.print("Enter staff name to delete: ");
        String name = scanner.nextLine();

        Staff staff = findStaffByName(name);
        if (staff == null) {
            System.out.println("Staff not found.");
            return;
        }

        staffList.remove(staff);

        System.out.println("Staff deleted successfully!");
    }
        



    public static void main(String[] args) {
        PetResortApplication app = new PetResortApplication();
        app.run();
    }

}
