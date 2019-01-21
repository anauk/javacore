package main.homework13.family;

import main.homework13.pet.Pet;

import java.util.Map;

final public class Woman extends Human {
    public Woman(String name, String surname, int year, int IQ, Map<String, String> scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public int getIq() {
        return getIQ();
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public void makeUp() {
        System.out.println("Как быстро бежит время, а я даже еще не накрасилась!");
    }

    @Override
    public String gridPet() {
        StringBuilder result = new StringBuilder();
        if(getFamily() == null){
            return null;
        } else{
            for (Pet pet:getFamily().getPet()) {
                result.append("Привет, ").append(pet.getNickname()).append("! Я рада тебя видеть!");

            }
        }
        return result.toString();
    }
}
