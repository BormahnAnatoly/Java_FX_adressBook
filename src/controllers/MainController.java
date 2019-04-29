package controllers;


import interfaces.CollectionAdressBook;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.Person;

import java.io.IOException;

public class MainController {

    private CollectionAdressBook adressBookImpl = new CollectionAdressBook();

    private Stage mainStage;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtSearch;

    @FXML
    private Label lableCount;

    @FXML
    private TableView tableAdressBook;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditController editDalogController;
    private Stage editDialogStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    private void initialize() {

        // tableAdressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("FIO"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("Phone"));


        initListeners();

        adressBookImpl.fillTestData();

        tableAdressBook.setItems(adressBookImpl.getPersonList());

        //adressBookImpl.fillTestData();
        initLoader();
    }
//        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
//            @Override
//            public void onChanged(ListChangeListener.Change<? extends Person> c) {
//                updateCountLabel();
//            }
//        });
//        adressBookImpl.fillTestData();
//
//        tableAdressBook.setItems(adressBookImpl.getPersonList());
//        //  updateCountLabel();
//        initListeners();
//        adressBookImpl.fillTestData();
//        tableAdressBook.setItems(adressBookImpl.getPersonList());
//

//    }

    private void initListeners() {
        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        tableAdressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) { // 2 раза по нажатию мышки
                    editDalogController.setPerson((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }

    private void initLoader() {

        try {

            fxmlLoader.setLocation(getClass().getResource("../fxml/secondmodel.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDalogController = fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCountLabel() {
        lableCount.setText("Количество записей: " + adressBookImpl.getPersonList().size());
    }


    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();
        //если нажата не кнопка - выходим из метода
        if (!(source instanceof Button)) {
            return;
        }
        Button clickedButton = (Button) source;
        //       Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();

        //       Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();
        //        editDalogController.setPerson(selectedPerson);

        switch (clickedButton.getId()) {
            case "btnAdd":
                //     System.out.println("add " + selectedPerson);
                editDalogController.setPerson(new Person());
                showDialog();
                adressBookImpl.add(editDalogController.getPerson());
                break;

            case "btnEdit":
                editDalogController.setPerson((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;

            case "btnDelete":
                //   System.out.println("delete " + selectedPerson);
                adressBookImpl.delete((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                break;
        }

//            try {
//                btnAdd.setText("clicked!!!");
//
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("../fxml/secondmodel.fxml"));
//                stage.setTitle("Редактирование записи!");
//                stage.setMinWidth(300);
//                stage.setMinHeight(150);
//                stage.setResizable(false);
//                stage.setScene(new Scene(root));
//                stage.initModality(Modality.WINDOW_MODAL);
//                stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
//                stage.show();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//
//            }
    }

    //private void showDialog(Window parentWindow) {
    @FXML
    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи!");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL); // текущее окно что вызывается на строку выше - объявляется как модальное
            editDialogStage.initOwner(mainStage);
        }
        //editDialogStage.show(); // для закрытия окна
        editDialogStage.showAndWait(); // для ожидания закрытия окна

    }


//        public void actionSearch(ActionEvent actionEvent) {
//            adressBookImpl.getPersonList().clear();
//
//            for (Person person : backupList) {
//                if (person.getFIO().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
//                    person.getPhone().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
//                    adressBookImpl.getPersonList().add(person);
//                }
//            }
//        }
}