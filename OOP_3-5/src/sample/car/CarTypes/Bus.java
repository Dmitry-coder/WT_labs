package sample.car.CarTypes;

import sample.car.CarTypes.Composite.Order;
import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bus")
public final class Bus extends FreightCar implements Order {
    private final static String TYPE = "Bus";

    public Bus(){
        super(TYPE, null, null);
    }

    public Bus(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new Bus(carModel, power);
    }



    @Override
    public void drive() {
        System.out.println("Bus drive");

    }

    @Override
    public int getCount() {
        return 1;
    }
}
