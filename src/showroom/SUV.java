package showroom;

public class SUV extends Vehicle {
   public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public SUV(SUV suv) {
       super(suv.getBrand(),
       	  suv.getMake(),
       	  suv.getModelYear(),
       	  suv.getPrice(),
       	  suv.getColor(),
       	  suv.getFueltype(),
             suv.getMileage(),
             suv.getMass(),
             suv.getCylinders(),
             suv.getGasTankCapacity(),
             suv.getStartType()
             );
   }
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (2024 - modelYear) * cylinders * 0.001;
		return maintenanceCost;
	}
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.05;
		return fuelEfficiency;
	}
	@Override
	public void startEngine() {
	    if (getStartType() == StartMechanism.PUSHSTART) {
	        System.out.println("Starting the engine");
	        System.out.println("Pressing the start button");
	       
	        System.out.println("Your car has started");
	    } else {
	        System.out.println("Engine is already running.");
	       
	    }
	}
}
