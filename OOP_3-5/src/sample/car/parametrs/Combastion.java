package sample.car.parametrs;

public class Combastion implements Engine {
    private static Engine power;

    private Combastion() {

    }

    public static Engine getParametrs() {
        if (power != null)
            return power;
        power = new Combastion();
        return power;
    }

    @Override
    public String getPower() {
        return "100";
    }
}
