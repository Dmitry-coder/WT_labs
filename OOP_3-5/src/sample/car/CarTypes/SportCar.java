package sample.car.CarTypes;

import sample.car.parametrs.Engine;

public abstract class SportCar extends Cars {
    protected int powerOfTheCar;

    protected SportCar(String weaponType, String weaponModel, Engine range) {
        super(weaponType, weaponModel, range);
    }

    public int getPowerOfTheCar() {
        return powerOfTheCar;
    }

    public void setPowerOfTheCar(int powerOfTheCar) {
        this.powerOfTheCar = powerOfTheCar;
    }

    public abstract void drive();
}
