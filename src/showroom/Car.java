package showroom;

public abstract class Car extends Vehicle {
   public Car(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
              double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
       super(brand, make, modelYear, price, color, fueltype, mileage, mass, cylinders, gasTankCapacity, startType);
   }
   public Car(Car car) {
       super(
    		   car.getBrand(),
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
}
