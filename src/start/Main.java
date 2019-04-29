package start;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/mainsample.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale",new Locale("ru")));

        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle(fxmlLoader.getResources().getString("adress_book"));
        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(480);

        primaryStage.setScene(new Scene(fxmlMain, 450, 475));
        primaryStage.show();

        testData();
    }

    private void testData(){
//       CollectionAdressBook adressBook = new CollectionAdressBook();
//
//        Person person = new Person();
//        person.setFIO("ASD");
//        person.setPhone("123456789");
//
//        adressBook.add(person);
//
//        Person person1 = new Person("Qwerty", "555555555");
//
//        adressBook.add(person1);
//
//        person.setPhone("111111111");
//      //  adressBook.edit(person);
//        adressBook.delete(person);
//
//       adressBook.fillTestData();
//        adressBook.print();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
