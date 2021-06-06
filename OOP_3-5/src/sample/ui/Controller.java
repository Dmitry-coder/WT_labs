package sample.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Transformation;
import sample.car.parametrs.Combastion;
import sample.car.parametrs.Engine;
import sample.car.parametrs.Electrical;
import sample.car.parametrs.Combastion;
import sample.car.CarTypes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    ListView<Cars> listView;
    ObservableList<Cars> listTransport;

    @FXML
    ComboBox<Cars> cb_transport;
    ObservableList<Cars> transport;

    @FXML
    Button btn_add;

    @FXML
    RadioButton radio_engine1;
    Engine power1 = Electrical.getParametrs();

    @FXML
    RadioButton radio_engine2;
    Engine power2 = Combastion.getParametrs();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        read();
        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        transport = FXCollections.observableArrayList(
                new Truck(), new Bus(), new GrandTurismo(),
                new HyperCar(), new Sedan(), new Hatchback());
        cb_transport.setItems(transport);
        btn_add.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (cb_transport.getValue() != null && model != null) {
                Engine range = power1;
                if (radio_engine2.isSelected())
                    range = power2;
                Cars newTransport = cb_transport.getValue().create(model, range);
                listTransport.add(newTransport);
                try {
                    write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listView.setItems(listTransport);
        listView.setCellFactory(param -> new XCell());
    }

    public void read() throws IOException, ClassNotFoundException {
        try {
            listTransport = FXCollections.observableArrayList();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList list = (ArrayList) objectInputStream.readObject();
            for (int i = 0; i < list.size(); i++) {
                listTransport.add((Cars) list.get(i));
            }
            objectInputStream.close();
        }catch (Exception e){
        }
    }

    private void write() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            List<Cars> list = new ArrayList<>(listTransport);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            int nom = 0;
            for (int i = 0; i < listTransport.size(); i++) {
                File out = new File("XML/" + nom + ".xml");
                out.createNewFile();
                PrintWriter pw = new PrintWriter(out);
                String xml = listTransport.get(i).getXML();
                pw.write(xml);
                pw.close();
                ClassLoader loader = ObjectMapper.class.getClassLoader();
                Class<?> c = Class.forName("com.fasterxml.jackson.databind.ObjectMapper", true, loader);
                Transformation trans = new Transformation();
                String res = trans.transform(xml);
                File in = new File("JSON/" + nom + ".json");
                PrintWriter pw2 = new PrintWriter(in);
                pw2.write(res);
                pw2.close();
            }
            PrintWriter writer1 = new PrintWriter("file.xml");
            String xml = "";
            for (int i = 0; i < list.size(); i++) {
                xml += list.get(i).getXML();
            }
            writer1.write(xml);
            writer1.close();
            FileWriter writer = new FileWriter("text.txt");
            for (Cars car : list) {
                writer.write(car.getCarType());
                writer.write(" ");
                writer.write(car.getCarModel());
                writer.write(" ");
                writer.write(car.getClass().toString());
                writer.write(" ");
                writer.write(car.getPower());
                writer.write("\n");
                writer.flush();
            }

        }catch(Exception e){

        }
    }






}
