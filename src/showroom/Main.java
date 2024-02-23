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
        
        Car testVehicle = new Car("brand", "make", 2009, 100.6, VehicleColor.BLACK, FuelType.DIESEL, 100.22, 23932.23, 233, 3923.23, StartMechanism.KEYSTART);
        initialize.addVehicle(testVehicle);
        
        // Remove Vehicle
        Vehicle vehicle = initialize.vehicleList.get(0);
        initialize.removeVehicle(vehicle);
                
        initialize.saveVehicleList();
        
        int numberOfSUVs = initialize.getNumberOfVehiclesByType(SUV.class);
        System.out.println("Number of SUVs: " + numberOfSUVs);
        
        int numberOfTrucks = initialize.getNumberOfVehiclesByType(Truck.class);
        System.out.println("Number of Trucks: " + numberOfTrucks);

        int numberOfCars = initialize.getNumberOfVehiclesByType(Car.class);
        System.out.println("Number of Cars: " + numberOfCars);

        int numberOfMotorBikes = initialize.getNumberOfVehiclesByType(MotorBike.class);
        System.out.println("Number of MotorBikes: " + numberOfMotorBikes);
        
        Vehicle highestMaintenanceVehicle = initialize.getVehicleWithHighestMaintenanceCost(50);
        
        System.out.println("This is the vehicle with the highest maintenance cost: ");
        System.out.println(highestMaintenanceVehicle.brand);

        
        Vehicle lowestMaintenanceVehicle = initialize.getVehicleWithLowestMaintenanceCost(50);
        
        
        System.out.println("This is the vehicle with the lowest maintenace cost: ");
        System.out.println(lowestMaintenanceVehicle.brand);

    }
}