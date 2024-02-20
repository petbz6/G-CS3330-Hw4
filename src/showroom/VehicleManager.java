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
               carCount++;
               Car car = (Car) vehicle;
               System.out.println("Car " + carCount);
               System.out.println(car.toString()); 
               System.out.println("Start Type: " + car.getStartType());
               System.out.println("Maintenance Cost: " + car.calculateMaintenaceCost(20000));
               System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency(1000, 100));
               car.startEngine(); 
               System.out.println();
           }
       }
       
   }

  
   
  
}
