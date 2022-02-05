package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    public Button topButton;
    public AnchorPane globalBack;
    public GridPane buttonBack;
    Double temp = 0.0, sum = 0.0;
    boolean isOperatorPressed;
    String operatorPressed = "";



    @FXML
    TextField outputTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outputTF.textProperty().addListener((observable, oldValue, newValue) -> {
            //if (!newValue.matches("\\d*([\\.]\\d*)?")) {
              //  outputTF.setText(oldValue);
        });
    }

    @FXML
    private void onNumberClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button button = (Button)event.getSource();
            if(isOperatorPressed) {
                outputTF.setText(button.getText());
            }
            else {
                outputTF.setText(outputTF.getText() + button.getText());
            }
            isOperatorPressed = false;
        }
    }

    @FXML

    private void onPiClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            outputTF.setText(String.valueOf(Math.PI));
        }
    }

    @FXML
    private void onOperatorClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button button = (Button)event.getSource();
            if (!outputTF.getText().isEmpty()) {
                temp = Double.valueOf(outputTF.getText());
                switch (operatorPressed) {

                    case "%":
                    sum = (sum / temp)* 100;
                    break;

                    case "/":
                        sum /= temp;
                        break;
                    case "X":
                        sum *= temp;
                        break;
                    case "+":
                        sum += temp;
                        break;
                    case "-":
                        sum -= temp;
                            //System.out.println(sum + " positive");
                            //System.out.println(sum + " negative");
                        break;
                    //case "兀":
                      //  sum = Math.PI;
                        //break;

                    case "log":
                        double log = Double.parseDouble(String.valueOf(outputTF.getText()));
                        log = Math.log10(log);
                        //System.out.println(log);
                        sum = log;
                        //outputTF.setText(String.valueOf(log));
                        break;

                    case "x^2":
                        double ten = Double.parseDouble(String.valueOf(outputTF.getText()));
                        //System.out.println(ten + "");
                        sum = Math.pow(ten, 2);
                        //sum = ten;
                        break;

                    case "√":
                        double square = Double.parseDouble(String.valueOf(outputTF.getText()));
                        square = Math.sqrt(square);
                        //System.out.println(square);
                        sum = square;
                        break;

                    case "+/-":
                        double negate = Double.parseDouble(String.valueOf(outputTF.getText()));
                        negate = negate*(-1);
                        //System.out.println(negate);
                        outputTF.setText(String.valueOf(negate));
                        sum = negate;
                        break;


                    default:
                        sum = temp;
                }
            }

            if (button.getText().equals("=") || button.getText().equals("%abc")) {
                double result = (Math.round(sum*10000));
                result /= 10000;
                //System.out.println(result);
                outputTF.setText(String.valueOf(result));
                operatorPressed = "";
            } else {
                outputTF.setText("");
                operatorPressed = button.getText().trim();
            }
            isOperatorPressed = true;
        }
    }

    @FXML
    private void onCEClick() {
        outputTF.setText("");
        temp = 0.0;
        sum = 0.0;
        isOperatorPressed = false;
        operatorPressed = "";
    }


}