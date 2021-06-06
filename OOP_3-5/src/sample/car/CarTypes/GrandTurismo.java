package sample.car.CarTypes;

import sample.car.CarTypes.Composite.Order;
import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GrandTurismo")
public final class GrandTurismo extends SportCar implements Order {
    private final static String TYPE = "GrandTurismo";

    public GrandTurismo(){
        super(TYPE, null, null);
    }

    public GrandTurismo(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new GrandTurismo(carModel, power);
    }



    @Override
    public void drive() {
        System.out.println("Grand Turismo car drive");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
