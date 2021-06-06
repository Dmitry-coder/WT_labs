package sample.car.CarTypes;

import sample.car.CarTypes.Composite.Order;
import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sedan")
public class Sedan extends LightCar implements Order {
    private final static String TYPE = "Sedan";

    public Sedan(){
        super(TYPE, null, null);
    }

    public Sedan(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new Sedan(carModel, power);
    }



    @Override
    public void drive() {
        System.out.println("Sedan drive");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
