package vehicles.abstractClasses;

import vehicles.interfaces.Ivehicle;

public abstract class Vehicle implements Ivehicle {
    private final double CONSUMPTION_AIRCONDITIONER = 1.4;
    protected double fuelQuantity;

    private double fuelConsumption;

    private double tankQuantity;

    private boolean isVehicleEmpty;


    public Vehicle(double fuelQuantity, double fuelConsumption, double tankQuantity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankQuantity(tankQuantity);
        this.isVehicleEmpty = true;

    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < this.getTankQuantity()) {
            fuelQuantity = 0;
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankQuantity() {
        return this.tankQuantity;
    }

    private void setTankQuantity(double tankQuantity) {
        this.tankQuantity = tankQuantity;
    }


    public void setVehicleEmpty(boolean vehicleEmpty) {
        isVehicleEmpty = vehicleEmpty;
    }

    @Override
    public void drive(double distance) {
        if (isVehicleEmpty){
            this.fuelConsumption += this.CONSUMPTION_AIRCONDITIONER;

        }
        double neededFuel = this.fuelConsumption * distance;

        if (this.getFuelQuantity() < neededFuel) {
            throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= neededFuel;
        System.out.printf(String.format("%s travelled %.2f km")
                , this.getClass().getSimpleName(), distance);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.getFuelQuantity() + fuel > this.getTankQuantity()) {
            throw new IllegalArgumentException(String.format("Cannot fit %s fuel in the tank", fuel));
        }
        if (this.getClass().getSimpleName().equals("Truck")) {
            fuel *= 0.95;
        }
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}