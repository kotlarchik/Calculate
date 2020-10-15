package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    private int num1 = 0;
    private int num2 = 0;

    private boolean start;

    private String operator = "";

    Model model = new Model();

    @FXML
    private Text textWindow;

    @FXML
    public void pressNum(ActionEvent event){
        if (start) {
            textWindow.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        textWindow.setText(textWindow.getText() + value);
    }
    @FXML
    public void pressOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!"=".equals(value)){
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Integer.parseInt(textWindow.getText());
            textWindow.setText("");
        }
        if (operator.isEmpty()) return;
        num2 = Integer.parseInt(textWindow.getText());
        textWindow.setText(String.valueOf(model.calculate(num1, num2, operator)));
        operator = "";
        start = true;
    }
    @FXML
    public void pressClear(ActionEvent event){
        textWindow.setText("");
    }
}