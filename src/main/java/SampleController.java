
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {

    double operand1, operand2, result;
    String op, den, num;

    @FXML
    private Label lbResult;

    @FXML
    private TextField tfOperand1;

    @FXML
    private Button btnLog;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDivisione;

    @FXML
    private TextField tfOperand2;

    @FXML
    private Button btnSend;

    @FXML
    void btnAddPressed(ActionEvent event) {
        op = "add";
    }

    @FXML
    void btnLogPressed(ActionEvent event) {
        op = "log10";
    }

    @FXML
    void btnDivisionePressed(ActionEvent event) {
        op = "divisione";
    }

    @FXML
    void btnSendPressed(ActionEvent event) {

        /*
         * CONTROLLI
         */
        
        //controllo se è stata scelta l'operazione
        if (op.compareTo("") == 0) {
            lbResult.setText("ERROR: select an operation!");
        } else {

            //controllo divisione per 0
            if ((op.compareTo("divisione") == 0) && ((tfOperand2.getText().compareTo("0") == 0) || (tfOperand2.getText().compareTo("") == 0))) {
                lbResult.setText("Infinite");
                tfOperand1.setText("");
                tfOperand2.setText("");

            } else {

                //setto operand1
                if (tfOperand1.getText().compareTo("") == 0) {
                    operand1 = 0;
                } else {
                    den = tfOperand1.getText();
                    if (den.matches("[0-9]*")) {
                        operand1 = Double.parseDouble(den);

                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "It Can not contain letters", ButtonType.OK);
                        alert.showAndWait();
                    }
                }


                /*
                 * OPERAZIONI:
                 */

                //addizione
                if (op.compareTo("add") == 0) {
                    if (tfOperand2.getText().compareTo("") == 0) {
                        operand2 = 0;
                    } else {
                        num = tfOperand2.getText();
                        if (num.matches("[0-9]*")) {
                            operand2 = Double.parseDouble(num);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING, "It Can not contain letters", ButtonType.OK);
                            alert.showAndWait();
                        }
                    }
                    result = operand1 + operand2;
                }

                //log10
                if (op.compareTo("log10") == 0) {
                    result = Math.log10(operand1);
                }

                //divisione
                if (op.compareTo("divisione") == 0) {
                    num = tfOperand2.getText();
                    if (num.matches("[0-9]*")) {
                        operand2 = Double.parseDouble(num);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "It Can not contain letters", ButtonType.OK);
                        alert.showAndWait();
                    }
                    result = (operand1) / (operand2);
                }

                //visualizza risultato operazioni
                lbResult.setText(String.valueOf(result));
                operand1 = 0;
                operand2 = 0;
                result = 0;
                op = "";
                tfOperand1.setText("");
                tfOperand2.setText("");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        operand1 = 0;
        operand2 = 0;
        result = 0;
        op = "";
    }

}
