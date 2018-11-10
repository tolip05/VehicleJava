package vehicles.cars;

import vehicles.abstractClasses.Vehicle;

public class Truck extends Vehicle {
    private final double CONSUMPTION_AIRCONDITIONER = 1.6;
    public Truck(double fuelQuantity, double fuelConsumption, double tankQuantity) {
        super(fuelQuantity, fuelConsumption, tankQuantity);
        super.setFuelConsumption(super.getFuelConsumption() + CONSUMPTION_AIRCONDITIONER);
    }
}
