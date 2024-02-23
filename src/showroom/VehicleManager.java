package showroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class VehicleManager {
   ArrayList<Vehicle> vehicleList = new ArrayList<>();
   private static String vehicleFilePath = "src/showroom/vehicleList.csv";
   private final static double distance = 300;
   private final static double fuelPrice = 3.25;
  
   public boolean initializeStock() {
       try {
           Scanner fileIn = new Scanner(new FileInputStream(vehicleFilePath));
          
           fileIn.nextLine(); 
          
           while (fileIn.hasNextLine()) {
               String[] fields = fileIn.nextLine().split(",");
               String vehicleType = fields[0];
               String brand = fields[1];
               String make = fields[2];
               long modelYear = Long.parseLong(fields[3]);
               double price = Double.parseDouble(fields[4]);
               VehicleColor color = VehicleColor.valueOf(fields[5]);
               FuelType fuelType = FuelType.valueOf(fields[6]);
               double mileage = Double.parseDouble(fields[7]);
               double mass = Double.parseDouble(fields[8]);
               int cylinders = Integer.parseInt(fields[9]);
               double gasTankCapacity = Double.parseDouble(fields[10]);
               StartMechanism startType = StartMechanism.valueOf(fields[11]);
               switch (vehicleType) {
                   case "Car":
                       vehicleList.add(new Car(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
                       break;
                   case "Truck":
                       vehicleList.add(new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
                       break;
                   case "MotorBike":
                       vehicleList.add(new MotorBike(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
                       break;
                   case "SUV":
                       vehicleList.add(new SUV(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
                       break;
                   default:
                       System.out.println("Unknown vehicle type: " + vehicleType);
                       break;
               }
           }
           fileIn.close();
           return true;
       } catch (FileNotFoundException e) {
           System.out.println("An error has occurred. File not found.");
           return false;
       }
   }
   
   
   public void displayAllCarInformation() {
       int carCount = 0;
       for (Vehicle vehicle : vehicleList) {
           if (vehicle instanceof Car) {
        	   try {
        		   carCount++;
        		   Car car = (Car) vehicle;
        		   System.out.println("Car " + carCount);
        		   System.out.println(car.toString()); 
        		   System.out.println("Start Type: " + car.getStartType());
        		   System.out.println("Maintenance Cost: " + car.calculateMaintenaceCost(distance));
        		   System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency(distance, fuelPrice));
        		   car.startEngine(); 
        		   System.out.println();
        	   } catch(Exception e) {
        		   System.out.println("Error: Vehicle not found");
        	   }
           }
       }
       
   }

   public void displayAllTruckInformation() {
       int truckCount = 0;
       for (Vehicle vehicle : vehicleList) {
           if (vehicle instanceof Truck) {
        	   try {
        		   truckCount++;
        		   Truck truck = (Truck) vehicle;
        		   System.out.println("Truck " + truckCount);
        		   System.out.println(truck.toString()); 
        		   System.out.println("Start Type: " + truck.getStartType());
        		   System.out.println("Maintenance Cost: " + truck.calculateMaintenaceCost(distance));
        		   System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency(distance, fuelPrice));
        		   truck.startEngine(); 
        		   System.out.println();
        	   	} catch(Exception e) {
        		   System.out.println("Error: Vehicle not found");
        	   	}
           }
       }
       
   }
   
   public void displayAllSUVInformation() {
       int suvCount = 0;
       for (Vehicle vehicle : vehicleList) {
           if (vehicle instanceof SUV) {
        	   try {
        		   suvCount++;
        		   SUV suv = (SUV) vehicle;
        		   System.out.println("SUV " + suvCount);
        		   System.out.println(suv.toString()); 
        		   System.out.println("Start Type: " + suv.getStartType());
        		   System.out.println("Maintenance Cost: " + suv.calculateMaintenaceCost(distance));
        		   System.out.println("Fuel Efficiency: " + suv.calculateFuelEfficiency(distance, fuelPrice));
        		   suv.startEngine(); 
        		   System.out.println();
        	   	} catch(Exception e) {
        	   		System.out.println("Error: Vehicle not found");
        	   	}
        	   
           }
       }
       
   }
   
   public void displayAllMotorBikeInformation() {
       int bikeCount = 0;
       for (Vehicle vehicle : vehicleList) {
           if (vehicle instanceof MotorBike) {
        	   try {
        		   bikeCount++;
        		   MotorBike bike = (MotorBike) vehicle;
        		   System.out.println("Motorbike " + bikeCount);
        		   System.out.println(bike.toString()); 
        		   System.out.println("Start Type: " + bike.getStartType());
        		   System.out.println("Maintenance Cost: " + bike.calculateMaintenaceCost(distance));
        		   System.out.println("Fuel Efficiency: " + bike.calculateFuelEfficiency(distance, fuelPrice));
        		   bike.startEngine(); 
        		   System.out.println();
        	   } catch(Exception e) {
        		   System.out.println("Error: Vehicle not found");
        	   }
           }
       }
       
   }
   
   public void displayAllVehicleInformation() {
       int vehicleCount = 0;
       for (Vehicle v : vehicleList) {
    	   try {
    		   vehicleCount++;
    		   System.out.println("Vehicle " + vehicleCount);
    		   System.out.println(v.toString()); 
    		   System.out.println("Start Type: " + v.getStartType());
    		   System.out.println("Maintenance Cost: " + v.calculateMaintenaceCost(distance));
    		   System.out.println("Fuel Efficiency: " + v.calculateFuelEfficiency(distance, fuelPrice));
    		   v.startEngine(); 
    		   System.out.println();
    	   } catch(Exception e) {
    		   System.out.println("Error: List is empty");
    	   }
       }
       
   }
   
   public boolean removeVehicle(Vehicle vehicle) {
	   for(Vehicle v : vehicleList) {
		   if(v == vehicle) {
			   vehicleList.remove(v);
            return true;
         }
      }
	   return false;
   }
   
   public boolean addVehicle(Vehicle vehicle) {
      if(vehicle != null) {
		   vehicleList.add(vehicle);
		   return true;
      }
      return false;
   }
   public boolean saveVehicleList() {
       try (FileWriter writer = new FileWriter(vehicleFilePath)) {
           String[] headers = { "Type", "Model", "Make", "ModelYear", "Price", "Color", "FuelType", "Mileage", "Mass", "Cylinders", "GasTankCapacity", "StartType" };
           for (int i = 0; i < headers.length; i++) {
               writer.append(headers[i]);
               if (i < headers.length - 1) {
                   writer.append(", ");
               }
           }
           writer.append(System.getProperty("line.separator"));

           for (Vehicle v : vehicleList) {
               if (v instanceof Car) {
                   writer.write("Car, " + v.getBrand() + "," + v.getMake() + "," + v.getModelYear() + "," + v.getPrice() + "," + v.getColor()
                   + "," + v.getFueltype() + "," + v.getMileage() + "," + v.getMass() + "," + v.getCylinders()
                   + "," + v.getGasTankCapacity() + "," + v.getStartType() + System.getProperty("line.separator"));
               } else if (v instanceof MotorBike) {
                   writer.write("MotorBike, " + v.getBrand() + "," + v.getMake() + "," + v.getModelYear() + "," + v.getPrice() + ","+ v.getColor()
                   + "," + v.getFueltype() + "," + v.getMileage() + "," + v.getMass() + "," + v.getCylinders()
                   + "," + v.getGasTankCapacity() + "," + v.getStartType() + System.getProperty("line.separator"));
               } else if(v instanceof SUV){
                   writer.write("SUV, " + v.getBrand() + "," + v.getMake() + "," + v.getModelYear() + "," + v.getPrice() + "," + v.getColor() + ","
               + v.getFueltype() + "," + v.getMileage() + "," + v.getMass() + "," + v.getCylinders() + ","
                		   + v.getGasTankCapacity() + "," + v.getStartType() + System.getProperty("line.separator"));
               } else if(v instanceof Truck){
                   writer.write("Truck, " + v.getBrand() + "," + v.getMake() + "," + v.getModelYear() + "," + v.getPrice() + "," + v.getColor()
                   + "," + v.getFueltype() + "," + v.getMileage() + "," + v.getMass() + "," + v.getCylinders()
                   + "," + v.getGasTankCapacity() + "," + v.getStartType() + System.getProperty("line.separator"));
               } else {
                   writer.write("Vehicle, " + v.getBrand() + "," + v.getMake() + "," + v.getModelYear() + "," + v.getPrice() + "," + v.getColor()
                   + "," + v.getFueltype() + "," + v.getMileage() + "," + v.getMass() + "," + v.getCylinders()
                   	+ "," + v.getGasTankCapacity() + "," + v.getStartType() + System.getProperty("line.separator"));
               }
           }
           return true;
       } catch (IOException e) {
           System.out.println("An error has occurred");
           e.printStackTrace();
           return false;
       }
   }
   
   private boolean isVehicleType(Vehicle v, Class clazz) {
       return clazz.isInstance(v);
   }
   

   Truck checkTruck = new Truck("Volvo", "VNL300", 2022, 120000.0, VehicleColor.WHITE, FuelType.DIESEL, 18000.0, 5.0, 16, 50.0, StartMechanism.KEYSTART);
   boolean isTruck = isVehicleType(checkTruck, Truck.class);

   
   public int getNumberOfVehiclesByType(Class clazz) {
	    int count = 0;
	    for (Vehicle vehicle : vehicleList) {
	        if (isVehicleType(vehicle, clazz)) {
	            count++;
	        }
	    }
	    return count;
	    
	}
   public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
	   ArrayList<Vehicle> highestCost = new ArrayList<>();
	   double Maximum = -1;
	   
	   for (Vehicle vehicle: vehicleList) {
		   double cost = vehicle.calculateMaintenaceCost(distance);
		   if (cost > Maximum) {
			   highestCost.clear();
			   highestCost.add(vehicle);
			   
		   }
		   else
		   {
			   if (cost == Maximum) {
				   highestCost.add(vehicle);
			   }
		   }
		   
	   }
	   if (highestCost.isEmpty()) {
		   return null;
	   }
	   Random random = new Random();
	   int randomIndex = random.nextInt(highestCost.size());
	   return highestCost.get(randomIndex);
   }
   
   public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
	    if (vehicleList.isEmpty()) {
	        return null;
	    }

	    double minimum = vehicleList.get(0).calculateMaintenaceCost(distance);
	    ArrayList<Vehicle> lowestCostVehicles = new ArrayList<>();
	    lowestCostVehicles.add(vehicleList.get(0)); 


	    for (int i = 1; i < vehicleList.size(); ++i) {
	        double cost = vehicleList.get(i).calculateMaintenaceCost(distance);
	        if (cost < minimum) {

	            lowestCostVehicles.clear();
	            lowestCostVehicles.add(vehicleList.get(i));
	            minimum = cost;
	        } else if (cost == minimum) {

	            lowestCostVehicles.add(vehicleList.get(i));
	        }
	    }


	    Random random = new Random();
	    int randomIndex = random.nextInt(lowestCostVehicles.size());
	    return lowestCostVehicles.get(randomIndex);
	}

   public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
	   ArrayList<Vehicle> highestFuelEfficiency = new ArrayList<>();
	   double Maximum = -1;
	   
	   for (Vehicle vehicle: vehicleList) {
		   double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
		   if (fuelEfficiency > Maximum) {
			   highestFuelEfficiency.clear();
			   highestFuelEfficiency.add(vehicle);
			   
		   }
		   else
		   {
			   if (fuelEfficiency == Maximum) {
				   highestFuelEfficiency.add(vehicle);
			   }
		   }
		   
	   }
	   if (highestFuelEfficiency.isEmpty()) {
		   return null;
	   }
	   return highestFuelEfficiency;
   }

   public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
	   ArrayList<Vehicle> lowestFuelEfficiency = new ArrayList<>();
	   double minimum = vehicleList.get(0).calculateFuelEfficiency(distance, fuelPrice);
	   
	   for (Vehicle vehicle: vehicleList) {
		   double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
		   if (fuelEfficiency < minimum) {
			   lowestFuelEfficiency.clear();
			   lowestFuelEfficiency.add(vehicle);
			   
		   }
		   else
		   {
			   if (fuelEfficiency == minimum) {
				   lowestFuelEfficiency.add(vehicle);
			   }
		   }
		   
	   }
	   if (lowestFuelEfficiency.isEmpty()) {
		   return null;
	   }
	   return lowestFuelEfficiency;
   }
   
   public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
	   double averageFuelEfficiency = 0;
	   int count = 0;
	   double fuelEfficiency = 0;
	   for (Vehicle vehicle : vehicleList) {
		   if (isVehicleType(vehicle, SUV.class)) {
			   	fuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
			   	System.out.println(fuelEfficiency);
	            count++;
	        }
	    }
	   	System.out.println(count);
	    averageFuelEfficiency = (fuelEfficiency/count);
	    return averageFuelEfficiency;
   }
   
}