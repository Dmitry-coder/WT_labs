package sample.car.CarTypes;

import sample.car.CarTypes.Composite.Order;
import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hatchback")
public final class Hatchback extends LightCar implements Order {
    private final static String TYPE = "Hatchback";

    public Hatchback(){
        super(TYPE, null, null);
    }

    public Hatchback(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new Hatchback(carModel, power);
    }



    @Override
    public void drive() {
        System.out.println("Hatchback drive");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
