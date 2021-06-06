package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import sample.car.CarTypes.Cars;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Transformation {
    public  String transform(String xml) throws IOException, JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Cars current = (Cars) un.unmarshal(reader);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(current);
            jsonString = jsonString.substring(0, jsonString.indexOf("\"xml\"") - 1) + "}";

        return jsonString;
    }
}
