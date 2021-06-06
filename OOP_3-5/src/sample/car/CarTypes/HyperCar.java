package sample.car.CarTypes;

import sample.car.parametrs.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HyperCar")
public final class HyperCar extends SportCar {
    private final static String TYPE = "HyperCar";

    public HyperCar() {
        super(TYPE, null, null);
    }

    public HyperCar(String model, Engine power) {
        super(TYPE, model, power);
    }

    @Override
    public Cars create(String carModel, Engine power) {
        return new HyperCar(carModel, this.power);
    }



    @Override
    public void drive() {
        System.out.println("HyperCar drive");
    }
}
