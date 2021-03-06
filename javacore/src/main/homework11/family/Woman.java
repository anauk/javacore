package main.homework11.family;

import main.homework11.pet.Pet;

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

    @Override
    public String gridPet() {
        StringBuilder result = new StringBuilder();
        if (getFamily() == null) {
            return null;
        }
        if (getFamily().getPet() != null){
            for (Pet pet : getFamily().getPet()) {
                result.append("Привет, ").append(pet.getNickname()).append("!").append("\n");
            }
        }
        return result.toString();
    }

    public void makeUp() {
        System.out.println("Как быстро бежит время, а я даже еще не накрасилась!");
    }

}
