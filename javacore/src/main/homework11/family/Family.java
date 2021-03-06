package main.homework11.family;

import main.homework11.pet.Pet;

import java.util.*;

import static java.util.Arrays.copyOf;

public class Family implements HumanCreator{
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet = new HashSet<>();

    public Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new ArrayList<>(0);
    }
    public Set<Pet> getPet(){
        return pet;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deletChild(int index) {
        if (children != null && children.size() > 0) {
            if (index >= 0 && index < children.size()) {
                children.remove(index).setFamily(null);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean deletChild(Human child) {
        if(!children.isEmpty()) {
            child.setFamily(null);
            return children.remove(child);
        } else {
            return false;
        }
    }

    public void addPet(Pet animal) {
        pet.add(animal);
    }

    @Override
    public String toString() {
        return "mother = " + this.mother + ", " +
                "father = " + this.father + ", " +
                "children = " + children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return this.mother.equals(family.mother) &&
                this.father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    protected void finalize() {
        System.out.println("This object from class Family will be delete!");
    }

    static {
        System.out.println("It is class: Family");
    }

    {
        System.out.println("Object init from class Family");
    }

    public int countFamily() {
        int count = 2;
        if (children == null) return count;
        if (children.size() > 0) return count + children.size();
        return count;
    }

    @Override
    public Human bornChild() {
        Human child;
        if((int)(Math.random()*2) == 0) {
            String[] boyName = {"Roma", "Peta", "Kola","Vasa","Kiril"};
            int boyNameR = (int)(Math.random()*boyName.length);
            child = new Man(boyName[boyNameR], father.getSurname());
        } else {
            String[] girlName = {"Lida","Veta", "Olga", "Vlada", "Hasta"};
            int girlNameR = (int)(Math.random()*girlName.length);
            child = new Woman(girlName[girlNameR], father.getSurname());
        }
        child.setFamily(this);
        this.addChild(child);
        child.setIQ((mother.getIQ()+father.getIQ())/2);
        return child;
    }
}
