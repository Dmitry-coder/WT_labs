package sample.car.CarTypes;

import sample.car.CarTypes.Composite.Order;
import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Truck")
public final class Truck extends FreightCar implements Order {
    private final static String TYPE = "Truck";

    public Truck(){
        super(TYPE, null, null);
    }

    public Truck(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new Truck(carModel, power);
    }

    @Override
    public void drive() {
        System.out.println("Truck drive");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
