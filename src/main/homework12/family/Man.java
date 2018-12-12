package homework12.family;

import homework12.pet.Pet;

import java.util.Map;

final public class Man extends Human {

    public Man(String name, String surname, int year, int IQ, Map<String, String> scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public Man(String name, String surname) {
        super(name, surname);
    }

    public int getIq(){
        return getIQ();
    }
    public void repairCar(){
        System.out.println("Закнчиваю все дела...,и иду смотреть машину!");
    }

    /*@Override
    void gridPet(Pet animal) {
        System.out.println("Оо.., " + f + ", ах ты... маленький засранец!");
    }*/
}
