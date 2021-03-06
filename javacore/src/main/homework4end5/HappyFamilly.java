package main.homework4end5;

/*Мини-проект "Счастливая семья"
        Суть проекта: описание структуры семьи с учетом того, что у каждого человека есть кровные родственники, а состав семьи может со временем меняться.
        До прохождения темы "Коллекции" все домашние задания должны быть выполнены с использованием массивов (НЕ используйте интерфейсы List, Set, Map, пока об этом не будет прямо сказано в задании).

        Объекты

        Задание
        Создайте и опишите классы: Домашний любимец(Pet), Человек(Human). Создайте класс Main и в нем создайте экземпляры описанных классов.

        Технические требования:

        опишите у класса Pet следующие поля:

        вид животного (species), строка (собака, кот и тд)
        кличка (nickname)
        возраст (age)
        уровень хитрости (trickLevel) (целое число от 0 до 100)
        привычки (habits) (массив строк)

        опишите у класса Pet и реализуйте следующие методы:

        покушать (eat) (метод выводит на экран сообщение Я кушаю!)
        отозваться (respond) (метод выводит на экран сообщение Привет, хозяин. Я - [имя животного]. Я соскучился!)
        сделать домашнюю гадость (foul) (метод выводит на экран сообщение Нужно хорошо замести следы...)

        опишите у класса Human следующие поля:

        Имя (name)
        Фамилия (surname)
        Год рождения (year), число
        Уровень IQ (iq) (целое число от 0 до 100)
        Домашний любимец (pet) (объект типа Pet)
        Мама (mother) (объект типа Human)
        Папа (father) (объект типа Human)
        Расписание внерабочих занятий (schedule) (2-мерный массив: [день недели] x [тип секции/отдыха])

        опишите у класса Human и реализуйте следующие методы:

        поприветствовать своего любимца (greetPet)("Привет, [имя животного]")
        описать своего любимца (describePet): (вывести на экран всю информацию о своем питомце: "У меня есть [вид животного], ему [возраст животного] лет, он [очень хитрый]/[почти не хитрый]". Степень описания хитрости должна зависеть от уровня хитрости питомца, если больше 50 - [очень хитрый], если меньше или равно 50 - [почти не хитрый])

        переопределите метод toString() у обоих классов;

        у класса Pet должен выводить сообщение следующего вида: dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}, где dog - вид животного;
        у класса Human должен выводить сообщение следующего вида: Human{name='Michael', surname='Karleone', year=1977, iq=90, mother=Jane Karleone, father=Vito Karleone, pet=dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}}

        в классе Main создайте маму, папу, ребенка и его домашнее животное. Присвойте все необходимые ссылки (у ребенка на родителей и питомца), чтобы получилась полноценная семья. Вызовите все доступные методы у ребенка (включая метод toString()) и у его питомца.


        Не обязательное задание продвинутой сложности:
        Опишите и реализуйте метод накормить питомца (feedPet) у класса Human, который принимает параметром логический тип boolean "наступило ли время кормить". Если время наступило - хозяин кормит питомца, если время не наступило, то уровень хитрости сравнивается с псевдослучайным числом 0-100 java.util.Random, и хозяин кормит, если уровень хитрости больше сгенерированного числа. Метод должен выводить на экран результат (Хм... покормлю ка я Джека[имя животного]/Думаю, Джек не голоден.) и возвращать логический результат (true/false) произошла ли кормежка.

        Литература:

        Классы и объекты
        Object and Classes*/
public class HappyFamilly {
    public static void main(String[] args) {
        //К 4 задаче
        Pet dog = new Pet("Dog", "Bart", 2, 10, new String[]{"play"});
        Pet cat = new Pet("Cat", "Vaca", 1, 70, new String[]{"sleep, play"});
        dog.eat();
        dog.respond();
        dog.foul();
        System.out.println(dog.toString());
        System.out.println(cat.toString());
        Human mother = new Human("Jane", "Karleone");
        System.out.println(mother);
        mother.gridPet(dog);
        Human father = new Human("Vito", "Karleone");
        System.out.println(father);
        father.gridPet(cat);
        Human child = new Human("Michael", "Karleone", 1977, 90, mother, father, dog);

        System.out.println(child.toString());
        child.describePet();
        child.gridPet(cat);
        child.feedPet(true);
//К 5 задаче
        System.out.println("Это первая семья Марковних");
        Human mother1 = new Human("Basilica", "Markovna", 1955);
        Human father1 = new Human("Poman", "Markovich");
        Human child1 = new Human("Eric", "Markovich", 1988, mother1, father1);
        System.out.println(mother1);
        System.out.println(father1);
        System.out.println(child1);
        System.out.println("Это вторая семья Милюшевичей");
        Pet cat2 = new Pet("Cat", "Chernush", 2, 60, new String[]{"sleep, play"});
        Human mother2 = new Human("Vita", "Milushevich", 1955, 90, cat2);
        Human father2 = new Human("Dima", "Milushevich",cat2);
        mother2.setMother("Rodonovna");
        System.out.println(mother2);
        System.out.println(father2);
    }
}
