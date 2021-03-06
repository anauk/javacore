package main.homework6;

import java.util.Arrays;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private Family family;//человек создает семью
    private String[][] scedule;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, int year, int iq, String[][] scedule) {
        this(name, surname, year);
        this.IQ = iq;
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Family family) {
        this(name, surname, year);
        this.family = family;
    }

    public Human(String name, String[][] scedule) {
        this.name = name;
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year, int IQ) {
        this(name, surname, year);
        this.IQ = IQ;
    }

    public Human(String name, String surname, int year, int IQ, Family family) {
        this(name, surname, year);
        this.IQ = IQ;
        this.family = family;
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
        if (getFamily().getPet().getTrickLevel() > 50) {
            System.out.println("У меня есть " + getFamily().getPet().getNickname() +
                    ", ему " + getFamily().getPet().getAge() + " года, он очень хитрый.");
        }
        if (getFamily().getPet().getTrickLevel() <= 50) {
            System.out.println("У меня есть " + getFamily().getPet().getNickname() +
                    ", ему " + getFamily().getPet().getAge() + " года, он почти не хитрый.");
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
            System.out.println("Думаю " + getFamily().getPet().getNickname() + " не голоден");
            int xz = getFamily().getPet().getTrickLevel();
            xz += 50;
            System.out.println(xz);
            int num = new Random().nextInt(100);
            System.out.println(num);
            if (xz > num) {
                System.out.println("Хм.. покормлю ка я " + getFamily().getPet().getNickname());
                System.out.println("Покормил!");
                return true;
            }
        }
        System.out.println("Не дал!");
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human person = (Human) o;
        return person.name.equals(this.name) &&
                person.year == this.year;
    }
}
