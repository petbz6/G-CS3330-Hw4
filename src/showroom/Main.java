package showroom;

public class Main {

    public static void main(String[] args) {
        VehicleManager initialize = new VehicleManager(); 
        boolean checkFileRead = initialize.initializeStock(); 
        if (checkFileRead == true) {
            System.out.println("Vehicle stock initialized successfully.\n");
        }
        else
        {
        	System.out.println("Error: Vehicle stock could not be initialized.");
        }
        
        initialize.displayAllCarInformation();
        initialize.displayAllTruckInformation();
        initialize.displayAllSUVInformation();
        initialize.displayAllMotorBikeInformation();
        initialize.displayAllVehicleInformation();
    }
}
