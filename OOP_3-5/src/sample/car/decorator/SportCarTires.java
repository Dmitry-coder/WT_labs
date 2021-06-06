package sample.car.decorator;

public class SportCarTires implements Tires {

    @Override
    public void ChangeTires() {
        System.out.println("Sport cars tires change");
    }
}
