package showroom;

public class Truck extends Vehicle {
   public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public Truck(Truck truck) {
       super(truck.getBrand(),
       	  truck.getMake(),
       	  truck.getModelYear(),
       	  truck.getPrice(),
       	  truck.getColor(),
       	  truck.getFueltype(),
             truck.getMileage(),
             truck.getMass(),
             truck.getCylinders(),
             truck.getGasTankCapacity(),
             truck.getStartType()
             );
   }
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenaceCost = distance * mass * (2024 - modelYear) * cylinders * 0.002;
		return maintenaceCost;
	}
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders  * gasTankCapacity * (fuelPrice / distance) * 0.1;
		return fuelEfficiency;
		
	}
	@Override
	public void startEngine() {
	    if (getStartType() == StartMechanism.KEYSTART) {
	        System.out.println("Starting the engine");
	        System.out.println("Pressing the start button");
	       
	        System.out.println("Your car has started");
	    } else {
	        System.out.println("Engine is already running.");
	       
	    }
	}
}
