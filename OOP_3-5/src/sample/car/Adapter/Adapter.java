package sample.car.Adapter;

import sample.car.CarTypes.Sedan;
import sample.car.CarTypes.GrandTurismo;


    public class Adapter extends Sedan {
        GrandTurismo grandTurismo;

        public Adapter(GrandTurismo grandTurismo){
            this.grandTurismo = grandTurismo;
        }
    }