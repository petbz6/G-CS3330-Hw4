package showroom;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VehicleManager {
   ArrayList<Vehicle> vehicleList = new ArrayList<>();
   private static String vehicleFilePath = "src/showroom/vehicleList.csv";
  
  
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
        		   System.out.println("Maintenance Cost: " + car.calculateMaintenaceCost(20000));
        		   System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency(1000, 100));
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
        		   System.out.println("Maintenance Cost: " + truck.calculateMaintenaceCost(20000));
        		   System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency(1000, 100));
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
        		   System.out.println("Maintenance Cost: " + suv.calculateMaintenaceCost(20000));
        		   System.out.println("Fuel Efficiency: " + suv.calculateFuelEfficiency(1000, 100));
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
        		   System.out.println("Maintenance Cost: " + bike.calculateMaintenaceCost(20000));
        		   System.out.println("Fuel Efficiency: " + bike.calculateFuelEfficiency(1000, 100));
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
    		   System.out.println("Maintenance Cost: " + v.calculateMaintenaceCost(20000));
    		   System.out.println("Fuel Efficiency: " + v.calculateFuelEfficiency(1000, 100));
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
//   private boolean isVehicleType(Vehicle v, Class clazz) {
//	   
//   }
//   public int getNumberOfVehichlesByType(Class clazz) {
//	   
//   }

   public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
   	   Vehicle highest = vehicleList.get(0);
   	   for(Vehicle v: vehicleList) {
   		   if(v.calculateMaintenaceCost(distance) > highest.calculateMaintenaceCost(distance)) {
   			   highest = v;
   		   }
   	   }
   	   return highest;
   }
   
   public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
   	   Vehicle lowest = vehicleList.get(0);
   	   for(Vehicle v: vehicleList) {
   		   if(v.calculateMaintenaceCost(distance) < lowest.calculateMaintenaceCost(distance)) {
   			   lowest = v;
   		   }
   	   }
   	   return lowest;
   }
	
   public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
   	   ArrayList<Vehicle> highestFuel = new ArrayList<>();
   	   for(Vehicle v: vehicleList) {
   		   if(highestFuel.isEmpty() == true) {
   			   highestFuel.add(v);
   		   }
   		   if(v.calculateFuelEfficiency(distance, fuelPrice) == highestFuel.get(0).calculateFuelEfficiency(distance, fuelPrice)) {
   			   highestFuel.add(v);
   		   }
   		   else if(v.calculateFuelEfficiency(distance, fuelPrice) > highestFuel.get(0).calculateFuelEfficiency(distance, fuelPrice)) {
   			   highestFuel.clear();
   			   highestFuel.add(v);
   		   }
   	   }
   	   return highestFuel;
   }
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
   	   ArrayList<Vehicle> lowestFuel = new ArrayList<>();
   	   for(Vehicle v: vehicleList) {
   		   if(lowestFuel.isEmpty() == true) {
   			   lowestFuel.add(v);
   		   }
   		   if(v.calculateFuelEfficiency(distance, fuelPrice) == lowestFuel.get(0).calculateFuelEfficiency(distance, fuelPrice)) {
   			   lowestFuel.add(v);
   		   }
   		   else if(v.calculateFuelEfficiency(distance, fuelPrice) < lowestFuel.get(0).calculateFuelEfficiency(distance, fuelPrice)) {
   			   lowestFuel.clear();
   			   lowestFuel.add(v);
   		   }
   	   }
   	   return lowestFuel;
   	}
   	
   	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
   		double average = 0.0;
   		int total = 0;
   		for(Vehicle v: vehicleList) {
   			if(v instanceof SUV)
   			average = average + v.calculateFuelEfficiency(distance, fuelPrice);
   			total = total + 1;
   		}
   		average = average/total;
   		return average;
   	}
}
