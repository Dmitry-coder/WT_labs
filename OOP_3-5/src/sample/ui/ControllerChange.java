package sample.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.car.parametrs.Engine;
import sample.car.parametrs.Electrical;
import sample.car.CarTypes.*;

public class ControllerChange {
    @FXML
    Text t_info;

    @FXML
    Button btn_change;

    @FXML
    RadioButton radio_engine1;
    Engine power1 = Electrical.getParametrs();

    @FXML
    RadioButton radio_engine2;
    Engine power2 = Electrical.getParametrs();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() {
        Cars current = XCell.changeCars;

        t_info.setText(current.getCarType() + "   " + current.getCarModel()
                + "   " + "power = " + current.getPower());

        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        if (current.getPower().equals("1"))
            radio_engine1.setSelected(true);
        else
            radio_engine2.setSelected(true);

        tf_model.setText(current.getCarModel());

        btn_change.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (model != null) {
                Engine power = power1;
                if (radio_engine2.isSelected())
                    power = power2;
                current.setCarModel(model);
                current.setPower(power);
                XCell.changeCars = null;

                Stage stage = (Stage) btn_change.getScene().getWindow();
                stage.close();

            }
        });
    }
}
