package showroom;
public abstract class Truck extends Vehicle {
   public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public Truck(Truck truck) {
       super(
    		   truck.getBrand(),
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
}
