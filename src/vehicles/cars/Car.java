package vehicles.cars;

import vehicles.abstractClasses.Vehicle;

public class Car extends Vehicle {
    private final double CONSUMPTION_AIRCONDITIONER = 0.9;
    public Car(double fuelQuantity, double fuelConsumption, double tankQuantity) {
        super(fuelQuantity, fuelConsumption, tankQuantity);
        super.setFuelConsumption(super.getFuelConsumption() + CONSUMPTION_AIRCONDITIONER);
    }

}
