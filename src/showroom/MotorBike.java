package showroom;
public abstract class MotorBike extends Vehicle {
   public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public MotorBike(MotorBike motorBike) {
       super(
    		   motorBike.getBrand(),
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
}
