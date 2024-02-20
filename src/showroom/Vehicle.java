package showroom;

public abstract class Vehicle {
	
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected FuelType fueltype;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected StartMechanism startType;
	
	
	public Vehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fueltype,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType)
	{
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fueltype = fueltype;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
	}
	
	
   public Vehicle(Vehicle other) {
       this.brand = other.brand;
       this.make = other.make;
       this.modelYear = other.modelYear;
       this.price = other.price;
       this.color = other.color;
       this.fueltype = other.fueltype;
       this.mileage = other.mileage;
       this.mass = other.mass;
       this.cylinders = other.cylinders;
       this.gasTankCapacity = other.gasTankCapacity;
       this.startType = other.startType;
   }
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public long getModelYear() {
		return modelYear;
	}
	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public VehicleColor getColor() {
		return color;
	}
	public void setColor(VehicleColor color) {
		this.color = color;
	}
	public FuelType getFueltype() {
		return fueltype;
	}
	public void setFueltype(FuelType fueltype) {
		this.fueltype = fueltype;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public double getGasTankCapacity() {
		return gasTankCapacity;
	}
	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}
	public StartMechanism getStartType() {
		return startType;
	}
	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}
	
	@Override
	public String toString() {
		return "Brand = " + brand + ", Make = " + make + ", ModelYear = " + modelYear + ", Price = " + price
				+ ", Color = " + color + ", FuelType = " + fueltype + ", Mileage = " + mileage + ", Mass = " + mass
				+ ", Cylinders = " + cylinders + ", GasTankCapacity = " + gasTankCapacity + ", StartType = " + startType;
	}
	
	
	// Calculates maintenance cost for a specific vehicle
	public abstract double calculateMaintenaceCost(double distance);
	
	
	// Calculates the engine efficiency
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	
	// Prints how the vehicle starts
	public abstract void startEngine();
	
}
