package main.homework11;

import main.homework11.family.*;
import main.homework11.pet.Dog;
import main.homework11.pet.DomesticCat;
import main.homework11.pet.Fish;
import main.homework11.pet.Pet;

import java.util.*;

public class HappyFamilly {
    public static void main(String[] args) {
        Set<String> habits = new HashSet<>();
        habits.add("play");
        habits.add("slep");

        Pet cat = new DomesticCat("Vaca", 1, 70, habits);
        ((DomesticCat) cat).foul();
        cat.eat();

        Map<String, String> sceduleWomen = new HashMap<>();
        sceduleWomen.put(DayOfWeek.MONDAY.name(),"go to work");
        sceduleWomen.put(DayOfWeek.THURSDAY.name(),"prepare progect");

        Woman woman = new Woman("Vera", "Ivanova",55,82,sceduleWomen);
        System.out.println(woman);
        Man man = new Man("Peta", "Ivanov");
        Family family = new Family(woman, man);

        Pet dog = new Dog("Batd", 1, 69, habits);
        Pet fish = new Fish("Molly", 1, 7, habits);
        family.addPet(dog);
        family.addPet(fish);
        woman.describePet();
        woman.feedPet(true);
        man.describePet();

        Human girl = new Woman("Mila", "Ivanova");
        Human boy = new Man("Kola", "Ivanov");
        family.addChild(boy);
        family.addChild(girl);

        System.out.println(family);

        family.deletChild(1);
        System.out.println(family);
        family.deletChild(boy);
        System.out.println(family);

        ArrayList<Object> children = new ArrayList<>();
        children.add(boy);
        children.add(girl);
        System.out.println(children);

        woman.makeUp();
        man.repairCar();

    }
}
