package showroom;
public abstract class SUV extends Vehicle {
   public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public SUV(SUV suv) {
       super(
    		   suv.getBrand(),
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
}
