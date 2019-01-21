package main.homework10;

public class Man extends Human {

    public Man(String name, String surname, int year, int IQ, String[][] scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public Man(String name, String surname) {
        super(name, surname);
    }

    public static String getSurname(Human father) {
        return father.surname;
    }
    public int getIq(){
        return IQ;
    }
    void repairCar(){
        System.out.println("Закнчиваю все дела...,и иду смотреть машину!");
    }

    @Override
    void gridPet(Pet animal) {
        System.out.println("Оо.., " + animal.getNickname() + ", ах ты... маленький засранец!");
    }
}
