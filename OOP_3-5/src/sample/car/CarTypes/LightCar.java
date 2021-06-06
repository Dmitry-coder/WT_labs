package sample.car.CarTypes;

import sample.car.parametrs.Engine;

public abstract class LightCar extends Cars {
    enum DRIVE_UNIT{FRONT_WHEEL, REAR_WHEEL}
    protected DRIVE_UNIT driveUnit;

    protected LightCar(String carType, String carModel, Engine power) {
        super(carType, carModel, power);
    }

    public DRIVE_UNIT getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(DRIVE_UNIT driveUnit) {
        this.driveUnit = driveUnit;
    }

    public abstract void drive();
}
