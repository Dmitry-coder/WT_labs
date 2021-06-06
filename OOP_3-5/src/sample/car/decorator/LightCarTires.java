package sample.car.decorator;

public class LightCarTires implements Tires {

    @Override
    public void ChangeTires() {
        System.out.println("Light cars tires change");
    }
}
