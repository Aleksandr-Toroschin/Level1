package ru.toroschin;

public class Lesson5 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван Иванович","Стажер","ivanov@mail.ru", "89998880011",30423,23);
        persArray[1] = new Person("Иванов Петр Иванович","Слесарь","ivanov_petr@mail.ru", "89997770011",50443,26);
        persArray[2] = new Person("Петрова Анастасия Викторовна","Бухгалтер","petrova@mail.ru", "89887770011",90010,45);
        persArray[3] = new Person("Сидоров Петр Николаевич","Программист","sidorov@mail.ru", "89005550055",110015,52);
        persArray[4] = new Person("Федоров Иван Петрович","Директор","fedorov@mail.ru", "89005550505",150500,59);

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].OutputInConsole();
            }
        }

    }
}
