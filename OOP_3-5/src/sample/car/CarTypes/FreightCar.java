package sample.car.CarTypes;

import sample.car.parametrs.Engine;

public abstract class FreightCar extends Cars {
    protected int displacement;

    protected FreightCar(String carType, String carModel, Engine power) {
        super(carType, carModel, power);
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public abstract void drive();
}
