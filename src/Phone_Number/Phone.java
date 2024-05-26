package Phone_Number;

import java.util.Objects;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
        this.sendMessage();
    }
    // Конструктор с двумя параметрами (вызывает конструктор с тремя параметрами)
    public Phone(String number, String model) {
        this(number, model, 0.0); // Вес по умолчанию
    }

    public Phone() {
        this("", ""); // Номер и модель по умолчанию
    }

    public String getNumber() {
        return number;
    }
    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);

    }
    // Перегруженный метод receiveCall
    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + " (номер: " + callerNumber + ")");
    }
    // Метод sendMessage с аргументами переменной длины
    public void sendMessage(String... phoneNumbers) {
        System.out.println("Отправляем сообщение следующим номерам: " + getNumber());
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }

        }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Double.compare(weight, phone.weight) == 0 && Objects.equals(number, phone.number) && Objects.equals(model, phone.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, weight);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public static void main(String[] args) {
        // Создаем три экземпляра класса Phone
        Phone phone1 = new Phone("+375296542315", "iPhone 13", 0.2);
        Phone phone2 = new Phone("+375336548753", "Honor 90", 0.3);
        Phone phone3 = new Phone("+375447548563", "Huawei 70", 0.25);
        // Вызываем методы для каждого телефона
        phone1.receiveCall("Анна");
        phone1.receiveCall("Петр", "+375336548753");

        phone2.receiveCall("Мария");
        phone2.receiveCall("Иван", "+375447548563");


        // Выводим значения переменных для каждого телефона
        System.out.println("Телефон 1:");
        phone1.receiveCall("Анна");
        System.out.println("Номер телефона: " + phone1.getNumber());
        System.out.println("Модель: " + phone1.getModel());
        System.out.println("Вес: " + phone1.getWeight() + " кг");

        System.out.println("\nТелефон 2:");
        phone2.receiveCall("Петр");
        System.out.println("Номер телефона: " + phone2.getNumber());
        System.out.println("Модель: " + phone2.getModel());
        System.out.println("Вес: " + phone2.getWeight() + " кг");

        System.out.println("\nТелефон 3:");
        phone3.receiveCall("Мария");
        System.out.println("Номер телефона: " + phone3.getNumber());
        System.out.println("Модель: " + phone3.getModel());
        System.out.println("Вес: " + phone3.getWeight() + " кг");
    }


}


