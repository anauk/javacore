package homework4;
/*В классе Human создайте конструкторы:

        конструктор, описывающий имя, фамилию и год рождения
        конструктор, описывающий имя, фамилию, год рождения, папу и маму
        конструктор, описывающий все поля
        пустой конструктор*/
import java.util.Random;

public class Human {
    public String name;
    public String surname;
    private int year;
    private int IQ;
    Pet pet;
    Human mother;
    Human father;
    private String[][] scedule;
    public Human(String name, String surname, int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
    }
    public Human(String name, String surname, int year, Human mother, Human father){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.mother=mother;
        this.father=father;
    }
    public Human(String name, String[][] scedule){
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

    public Human(String name, String surname, Pet pet) {
        this(name, surname);
        this.pet = pet;
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
        String motherName = mother!=null?mother.name+" "+mother.surname:null;
        String fatherName = father!=null?father.name+" "+father.surname:null;
        return String.format("%s{name= %s , surname= %s , year= %d , iq= %d , mother=%s , father= %s , pet= %s}", getClass().getSimpleName(), getName(), getSurname(), getYear(), getIQ(), motherName, fatherName, pet);
    }

    public void describePet() {
    if(this.pet.trickLevel > 50){
        System.out.println("У меня есть "+ this.pet.getNickname() +
                ", ему " + this.pet.getAge()+" года, он очень хитрый.");
    }
    if(this.pet.trickLevel <= 50){
        System.out.println("У меня есть "+ this.pet.getNickname() +
                ", ему " + this.pet.getAge()+" года, он почти не хитрый.");
    }
    }

    public void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname()+"!");
    }

public boolean feedPet(boolean frasa){
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

    public void setMother(String surname) {
        this.surname=surname;
    }

}
