package homework7;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private Family family;//человек создает семью
    private String[][] scedule;
    private Pet pet;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, Pet pet) {
        this(name, surname);
        this.pet = pet;
    }

    public Human(String name, String surname, int year) {
        this(name, surname);
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] scedule) {
        this(name, surname, year);
        this.IQ = iq;
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year, Family family) {
        this(name, surname, year);
        this.family = family;
    }

    public Human(String name, String[][] scedule) {
        this.name = name;
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year, int IQ, Pet pet) {
        this(name, surname, year);
        this.IQ = IQ;
        this.pet = pet;
    }

    public Human(String name, String surname, int year, int IQ, Family family, Pet pet) {
        this(name, surname, year);
        this.IQ = IQ;
        this.family = family;
        this.pet = pet;
    }


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

    public void setScedule(String[][] scedule) {
        this.scedule = scedule;
    }

    public String[][] getScedule() {
        return scedule;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name= " + getName() + ", " +
                "surname= " + getSurname() + ", " + "year= " + getYear() + ", " +
                "iq= " + getIQ() + ", " + "scedule= " + Arrays.deepToString(getScedule()) + '}';
    }

    public void describePet() {
        if (this.pet.getTrickLevel() > 50) {
            System.out.println("У меня есть " + this.pet.getNickname() +
                    ", ему " + this.pet.getAge() + " года, он очень хитрый.");
        }
        if (this.pet.getTrickLevel() <= 50) {
            System.out.println("У меня есть " + this.pet.getNickname() +
                    ", ему " + this.pet.getAge() + " года, он почти не хитрый.");
        }
    }

    public void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname() + "!");
    }

    public boolean feedPet(boolean fraza) {
        if (fraza == true) {
            System.out.println("Покормил!");
            return true;
        } else {
            System.out.println("Думаю " + this.pet.getNickname() + " не голоден");
            int xz = this.pet.getTrickLevel();
            xz += 50;
            System.out.println(xz);
            int num = new Random().nextInt(100);
            System.out.println(num);
            if (xz > num) {
                System.out.println("Хм.. покормлю ка я " + this.pet.getNickname());
                System.out.println("Покормил!");
                return true;
            }
        }
        System.out.println("Не дал!");
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.year == human.year;
    }

    static {
        System.out.println("It is class: Human");
    }

    {
        System.out.println("Object from class Human");
    }
}
