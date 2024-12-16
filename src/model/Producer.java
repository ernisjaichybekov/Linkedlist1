package model;

public class Producer {
    private String firstName;
    private String lastName;

    public Producer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "\nProducer{" +
                "\nfirstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                '}';
    }

}
