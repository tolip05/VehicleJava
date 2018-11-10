package vehicles;

import vehicles.cars.Bus;
import vehicles.cars.Car;
import vehicles.cars.Truck;
import vehicles.interfaces.Ivehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Engine {
    BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {

        String[]carInfo = br.readLine().split("\\s+");
        String[]truckInfo = br.readLine().split("\\s+");
        String[]busInfo = br.readLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);
        double carTankQuantity = Double.parseDouble(carInfo[3]);

        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);
        double truckTankQuantity = Double.parseDouble(truckInfo[3]);

        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busFuelConsumption = Double.parseDouble(busInfo[2]);
        double busTankQuantity = Double.parseDouble(busInfo[3]);

        Ivehicle car = new Car(carFuelQuantity,carFuelConsumption,carTankQuantity);
        Ivehicle truck = new Truck(truckFuelQuantity,truckFuelConsumption,truckTankQuantity);
        Ivehicle bus = new Bus(busFuelQuantity,busFuelConsumption,busTankQuantity);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String[] inputArgs = br.readLine().split("\\s+");

            try{
                String action = inputArgs[0];
                String vehicleType = inputArgs[1];
                double value = Double.parseDouble(inputArgs[2]);

                if (action.equals("Refuel")){
                    if(vehicleType.equals("Car")){
                        car.refuel(value);
                    }
                    else if (vehicleType.equals("Truck")){
                        truck.refuel(value);
                    }
                    else if (vehicleType.equals("Bus")){
                        bus.refuel(value);
                    }
                }
                else if(action.equals("Drive")){
                    if (vehicleType.equals("Car")){
                        car.drive(value);
                    }
                    else if(vehicleType.equals("Truck")){
                        truck.drive(value);
                    }
                    else if (vehicleType.equals("Bus")){
                        ((Bus) bus).setVehicleEmpty(true);
                        bus.drive(value);
                    }
                }else if (action.equals("DriveEmpty")){
                    ((Bus) bus).setVehicleEmpty(false);
                    bus.drive(value);
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());


            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
