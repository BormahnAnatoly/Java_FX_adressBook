package objects;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty FIO = new SimpleStringProperty("");
    private SimpleStringProperty Phone = new SimpleStringProperty("");

    public Person() {
    }

    public Person(String FIO, String phone) {
        this.FIO = new SimpleStringProperty(FIO);
        this.Phone = new SimpleStringProperty(phone);
    }
//    public Person(String FIO, String phone) {
//        this.FIO = FIO;
//        Phone = phone;
//    }

    public String getFIO() {
        return FIO.get();
    }

    public void setFIO(String FIO) {
        this.FIO.set(FIO);
    }

    public String getPhone() {
        return Phone.get();
    }

    public void setPhone(String Phone) {
        this.Phone.set(Phone);
    }

    public SimpleStringProperty FIOProperty() {
        return FIO;
    }

    public SimpleStringProperty phoneProperty() {
        return Phone;
    }

    @Override
    public String toString() {
        return "Person{" +
            "FIO=" + FIO +
            ", Phone=" + Phone +
            '}';
    }
}
