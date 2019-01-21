package main.homework11.family;

import java.util.Map;

final public class Man extends Human {

    public Man(String name, String surname, int year, int IQ, Map<String, String> scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public Man(String name, String surname) {
        super(name, surname);
    }

    public void repairCar() {
        System.out.println("Закнчиваю все дела...,и иду смотреть машину!");
    }

}
