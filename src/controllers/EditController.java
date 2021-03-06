package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Person;

public class EditController {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtPhone;

    private Person person;

    public void setPerson(Person person) {
        if (person == null) {
            return;
        }
        this.person = person;
        txtFIO.setText(person.getFIO());
        txtPhone.setText(person.getPhone());
    }

    public Person getPerson() {
        return person;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        //stage.close();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent) {

        person.setFIO(txtFIO.getText());
        person.setPhone(txtPhone.getText());
        actionClose(actionEvent);
    }

}
