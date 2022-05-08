public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String city;

    public PersonBuilder setName(String name) {
        if (stringIncorrect(name)) {
            throw new IllegalArgumentException("Имя не заполнено");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (stringIncorrect(surname)) {
            throw new IllegalArgumentException("Фамилия не заполнена");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (stringIncorrect(name)) {
            throw new IllegalStateException("Имя не заполнено");
        }
        if (stringIncorrect(surname)) {
            throw new IllegalStateException("Фамилия не заполнена");
        }
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным");
        }

        Person person = new Person(name, surname, age);
        if (!stringIncorrect(city)) person.setAddress(city);

        return person;
    }

    private boolean stringIncorrect(String string) {
        return string == null || string.isEmpty();
    }
}
