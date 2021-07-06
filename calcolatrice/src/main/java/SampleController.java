
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController implements Initializable {

    double operand1, operand2, result;
    String op;

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
        if(op.compareTo("") == 0) {
            lbResult.setText("ERROR: select an operation!");
        } else {

            //controllo divisione per 0
            if ((op.compareTo("divisione") == 0) && ((tfOperand2.getText().compareTo("0") == 0) | (tfOperand2.getText().compareTo("") == 0)) ) {
                lbResult.setText("Infinite");
                tfOperand1.setText("");
                tfOperand2.setText("");

            } else {

                //setto operand1
                if(tfOperand1.getText().compareTo("") == 0) {
                    operand1 = 0;
                } else {
                    operand1 = Double.parseDouble(tfOperand1.getText());
                }


                /*
                 * OPERAZIONI:
                 */

                //addizione
                if(op.compareTo("add") == 0) {
                    if(tfOperand2.getText().compareTo("") == 0) {
                        operand2 = 0;
                    } else {
                        operand2 = Double.parseDouble(tfOperand2.getText());
                    }
                    result = operand1 + operand2;
                }

                //log10
                if(op.compareTo("log10") == 0) {
                    result = Math.log10(operand1);
                }

                //divisione
                if(op.compareTo("divisione") == 0) {
                    operand2 = Double.parseDouble(tfOperand2.getText());
                    result = (operand1)/(operand2);
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
