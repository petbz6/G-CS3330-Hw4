package showroom;

public class MotorBike extends Vehicle {
   public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public MotorBike(MotorBike motorBike) {
       super(motorBike.getBrand(),
       	  motorBike.getMake(),
       	  motorBike.getModelYear(),
       	  motorBike.getPrice(),
       	  motorBike.getColor(),
       	  motorBike.getFueltype(),
             motorBike.getMileage(),
             motorBike.getMass(),
             motorBike.getCylinders(),
             motorBike.getGasTankCapacity(),
             motorBike.getStartType()
             );
   }
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (2024 - modelYear) * cylinders * 0.0002;
		return maintenanceCost;
	}
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.001;
		return fuelEfficiency;
	}
	@Override
	public void startEngine() {
	    if (getStartType() == StartMechanism.KICKSTART) {
	        System.out.println("Starting the engine");
	        System.out.println("Pressing the start button");
	       
	        System.out.println("Your car has started");
	    } else {
	        System.out.println("Engine is already running.");
	       
	    }
	}
}
