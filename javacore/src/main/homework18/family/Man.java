package main.homework18.family;

import main.homework18.pet.Pet;

import java.util.Map;

final public class Man extends Human {
    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, String birthday, int IQ) {
        super(name, surname, birthday, IQ);
    }

    public Man(String name, String surname, String birthday, int IQ, Map<String, String> scedule) {
        super(name, surname, birthday, IQ, scedule);
    }


    public int getIq() {
        return getIQ();
    }

    public void repairCar() {
        System.out.println("Закнчиваю все дела...,и иду смотреть машину!");
    }

    @Override
    public String gridPet() {
        StringBuilder result = new StringBuilder();
        if (getFamily() == null) {
            return null;
        } else {
            for (Pet pet : getFamily().getPet()) {
                result.append("Привет, ").append(pet.getNickname()).append("!");
            }
        }
        return result.toString();
    }
}
