package homework11;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    public String surname;
    private int year;
    public int IQ;
    private Family family;
    private Map<String, String> scedule;

    public Human() {
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, int year) {
        this(name, surname);
        this.year = year;
    }

    public Human(String name, String surname, int year, int IQ) {
        this(name, surname, year);
        this.IQ = IQ;
    }

    public Human(String name, Map<String, String> scedule) {
        this.name = name;
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year, int IQ, Map<String, String> scedule) {
        this(name, surname, year, IQ);
        this.scedule = scedule;
    }

    public Human(String name, String surname, int year, Family family) {
        this(name, surname, year);
        this.family = family;
    }

    public Human(String name, String surname, int year, int IQ, Family family) {
        this(name, surname, year, IQ);
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

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    public void setScedule(Map<String, String> scedule) {
        this.scedule = scedule;
    }

    public Map<String, String> getScedule() {
        return scedule;
    }

    protected void finalize() {
        System.out.println("This object from class Human will be delete!" + this);
    }

    public void addScdule(String weekDay, String plan) {
        scedule.put(weekDay, plan);
    }

    static {
        System.out.println("It is class: Human");
    }

    {
        System.out.println("Object from class Human");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name= " + getName() + ", " +
                "surname= " + getSurname() + ", " + "year= " + getYear() + ", " +
                "iq= " + getIQ() + ", " + "scedule= " + scedule + '}';
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

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    public void describePet() {
        if (getFamily().getPet() != null) {
            for (Pet pet : family.getPet()) {
                if (pet.getTrickLevel() > 50) {
                    System.out.println("У меня есть " + pet.getNickname() +
                            ", ему " + pet.getAge() + " года, он очень хитрый.");
                } else {
                    System.out.println("У меня есть " + pet.getNickname() +
                            ", ему " + pet.getAge() + " года, он почти не хитрый.");
                }
            }
        }
    }

    public String gridPet() {
        String result = "";
        if (getFamily() == null) {
            return null;
        }
        if (getFamily().getPet() != null){
            for (Pet pet : family.getPet()) {
                result += "Привет, " + pet.getNickname() + "!" + "\n";
            }
        }
        result += " У нас же нет питомца!";
        return result;
    }

    public boolean feedPet(boolean fraza) {
        if (fraza == true) {
            System.out.println("Покормил!");
            return true;
        } else {
            for (Pet pet : family.getPet()) {
                System.out.println("Думаю " + pet.getNickname() + " не голоден");
                int xz = pet.getTrickLevel();
                xz += 50;
                System.out.println(xz);
                int num = new Random().nextInt(100);
                System.out.println(num);
                if (xz > num) {
                    System.out.println("Хм.. покормлю ка я " + pet.getNickname());
                    System.out.println("Покормил!");
                    return true;
                }
            }
            System.out.println("Не дал!");
            return false;
        }
    }

}
