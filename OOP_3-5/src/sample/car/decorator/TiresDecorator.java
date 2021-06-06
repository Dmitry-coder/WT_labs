package sample.car.decorator;

public class TiresDecorator implements Tires {
    Tires wrap;

    public TiresDecorator(Tires changeTires) {
        this.wrap = changeTires;
    }

    @Override
    public void ChangeTires() {
        wrap.ChangeTires();
    }
}
