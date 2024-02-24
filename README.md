# G-CS3330-Hw4

## Team:
- Kyle Young
- Pierce Terry
- Isaac Rider
- Andrew Hamilton

## Project Description
        This project involves a vehicle showroom management system that utilizes Java Object-Oriented Programming. There is an abstract base class named Vehicle with four subclasses including Car, Truck, MotorBike and SUV. There are also three enums named FuelType, StartMechanism and VehicleColor. The VehicleManager class manages the inventory and performs various tasks such as reading the CSV file that contains the vehicle information, displaying the information of the vehicles/vehicle types, altering the information in the CSV, determining the number of vehicles by type, and calculating the fuel efficiency and maintenance cost for each vehicle and identifying which vehicle has the highest and lowest respectively.
        

## How to Run/Compile Program
1. Open Eclipse
2. Click File - Import - Projects from Git - Clone URL - Paste the Github Repository URL - Finish
3. Open the Main File of the project
4. Click the green arrow button to run the program

## Dependencies
- java.util.ArrayList;
- java.util.List;
- java.util.Random;
- java.util.Scanner;
- java.io.FileInputStream;
- java.io.FileNotFoundException;
- java.io.FileWriter;
- java.io.IOException;

## Team Member Contributions
Kyle Young: 
- getVehicleWithLowestMaintenaceCost method
- getVehicleWithHighestMaintenaceCost method

Pierce Terry:
 - Project File/Class Structure
 - InitializeStock method
 - isVehicleType Method
 - getNumberOfVehiclesByType method

Isaac Rider: 
- removeVehicle method
- addVehicle method
- saveVehicleList method

Andrew Hamilton: 
- displayAllCarInformation method
- displayAllTruckInformation method
- displayAllMotorBikeInformation method
- displayAllVehicleInformation method
- getVehicleWithHighestEfficiency method
- getVehicleWithLowestEfficiency method
- getAverageFuelEfficiency method
