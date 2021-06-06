package sample.car.parametrs;

public class Electrical implements Engine {
    private static Engine power;

    private Electrical() {

    }

    public static Engine getParametrs() {
        if (power != null)
            return power;
        power = new Electrical();
        return power;
    }

    @Override
    public String getPower() {
        return "50";
    }
}
