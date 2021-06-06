package sample.car.decorator;

public class FreightCarTires implements Tires {

    @Override
    public void ChangeTires() {
        System.out.println("Fright cars tires change");
    }
}
