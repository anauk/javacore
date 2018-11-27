package homework4;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    Pet pet;
    Human mother;
    Human father;
    private String[][] scedule;

    public Human(String name,String[][] scedule){
        this.name = name;
        this.scedule = scedule;
    }
    public Human(String n, String sN, int y, int iq, Pet p, Human m, Human f, String[][] sc) {
        this.name = n;
        this.surname = sN;
        this.year = y;
        this.IQ = iq;
        this.pet = p;
        this.mother = m;
        this.father = f;
        this.scedule = sc;
    }
    public Human(String n, String sN, int year, int iq, Pet pet) {
        this.name = n;
        this.surname = sN;
        this.year = year;
        this.IQ = iq;
        this.pet = pet;
    }

    public Human(String n, String sN, int year, int iq, Human mother, Human father, Pet pet) {
    this.name = n;
    this.surname = sN;
    this.year = year;
    this.IQ = iq;
    this.mother = mother;
    this.father = father;
    this.pet = pet;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String getName() {
        return name;
    }

    private String getSurname() {
        return surname;
    }

    private int getYear() {
        return year;
    }

    private int getIQ() {
        return IQ;
    }

    private Pet getPet() {
        return pet;
    }

    private Human getMother() {
        return mother;
    }

    private Human getFather() {
        return father;
    }

    public void setScedule(String[][] scedule){
        this.scedule = scedule;
    }

    public String[][] getScedule() {
        return scedule;
    }

    @Override
    public String toString() {
        return String.format("%s{name= %s , surname= %s , year= %d , iq= %d , mother=%s , father= %s , pet= %s}", getClass().getSimpleName(), getName(), getSurname(), getYear(), getIQ(), getMother(), getFather(), getPet());
    }

    private void describePet() {
    if(this.pet.trickLevel > 50){
        System.out.println("У меня есть "+ this.pet.getNickname() +
                ", ему " + this.pet.getAge()+" года, он очень хитрый.");
    }
    if(this.pet.trickLevel <= 50){
        System.out.println("У меня есть "+ this.pet.getNickname() +
                ", ему " + this.pet.getAge()+" года, он почти не хитрый.");
    }
    }

    private void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname()+"!");
    }

private boolean feedPet(boolean frasa){
               if(true){
                   System.out.println("Думаю " + this.pet.nickname + " не голоден");
                   return false;
        } else {
                   if(this.pet.trickLevel > new Random().nextInt(100)) {
                       System.out.println("Хм.. покормлю ка я " + this.pet);
                       return true;
                   }
               }
    return false;
}
}
