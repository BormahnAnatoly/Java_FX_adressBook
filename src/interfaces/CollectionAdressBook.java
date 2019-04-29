package interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Person;

public class CollectionAdressBook implements AdressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    @Override
    // для колекции не используется, но пригодится для случая, когда данные хранятся в БД
    public void edit(Person person) {
    // тк коллекции являются хранилищами, обновлять ничего не нужо
    // если бы данные хранились в БД или в файле - то нужно было бы обновить соотв. запись
    }

    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for (Person person:personList){
        number++;
        System.out.println(number + ") FIO  =" + person.getFIO() + "; phone = " + person.getPhone());
        }
    }

    public void fillTestData (){
        personList.add(new Person("Phill", "38546786"));
        personList.add(new Person("Mike", "11111111"));
        personList.add(new Person("Joe", "4555678"));
        personList.add(new Person("Augustin", "85666786"));
        personList.add(new Person("Mark", "78889456"));
        personList.add(new Person("John", "23335468"));
        personList.add(new Person("Franck", "35654589"));
        personList.add(new Person("Vanessa", "78698452"));
        personList.add(new Person("Jessy", "444444444"));
        personList.add(new Person("Nick", "555555555"));
        personList.add(new Person("Ann", "78453201"));
    }
}
