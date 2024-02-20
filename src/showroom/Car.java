package showroom;

public class Car extends Vehicle {
   public Car(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public Car(Car car) {
       super(car.getBrand(),
       	  car.getMake(),
       	  car.getModelYear(),
       	  car.getPrice(),
       	  car.getColor(),
       	  car.getFueltype(),
             car.getMileage(),
             car.getMass(),
             car.getCylinders(),
             car.getGasTankCapacity(),
             car.getStartType()
             );
   }
	@Override
	public double calculateMaintenaceCost(double distance) {
		
		double maintenaceCost = distance * mass * (2024 - modelYear) * cylinders* 0.0005;
		return maintenaceCost;
	}
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		
		double fuelEfficiency = cylinders * gasTankCapacity * (fuelPrice / distance) * 0.003;
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
