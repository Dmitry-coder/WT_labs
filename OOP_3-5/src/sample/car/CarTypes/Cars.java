package sample.car.CarTypes;

import sample.car.parametrs.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.*;

@XmlSeeAlso({Truck.class, Bus.class, GrandTurismo.class, HyperCar.class, Sedan.class, Hatchback.class})
public abstract class Cars implements Serializable {
    protected String carType;
    protected String carModel;
    protected Engine power;

    protected Cars(String carType, String carModel, Engine power) {
        this.carType = carType;
        this.carModel = carModel;
        this.power = power;
    }

    public String getXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Cars.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }


    public abstract Cars create(String weaponModel, Engine range);

    public String getCarType() {
        return carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarType(String vehicleType) {
        this.carType = vehicleType;
    }

    public void setCarModel(String vehicleModel) {
        this.carModel = vehicleModel;
    }

    public void setPower(Engine power) {
        this.power = power;
    }

    public String getPower() {
        if (power != null)
            return power.getPower();
        return "100";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
