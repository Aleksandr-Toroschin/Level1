package ru.toroschin;

public class Person {
    public String fio;
    public String position;
    public String email;
    public String phone;
    public double salary;
    public int age;

    public Person(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void OutputInConsole() {
        System.out.print("Сотрудник: "+fio);
        System.out.print(", должность: "+position);
        System.out.print(", e-mail: "+email);
        System.out.print(", тел: "+phone);
        System.out.print(", зарплата: "+salary);
        System.out.println(", возраст: "+age);
    }
}
