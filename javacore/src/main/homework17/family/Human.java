package main.homework17.family;

import main.homework17.pet.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private long birthday;
    private int IQ;
    private Family family;
    private Map<String, String> scedule;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public Human() {
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, String birthday) {
        this(name, surname);
        try{
            this.birthday = SDF.parse(birthday).getTime();
        }catch (ParseException e){
            System.out.println(e);
        }

    }

    public Human(String name, String surname, String birthday, int IQ) {
        this(name, surname, birthday);
        this.IQ = IQ;
    }

    public Human(String name, Map<String, String> scedule) {
        this.name = name;
        this.scedule = scedule;
    }

    public Human(String name, String surname, String birthday, int IQ, Map<String, String> scedule) {
        this(name, surname, birthday, IQ);
        this.scedule = scedule;
    }

    public Human(String name, String surname, String birthday, Family family) {
        this(name, surname, birthday);
        this.family = family;
    }

    public Human(String name, String surname, String birthday, int IQ, Family family) {
        this(name, surname, birthday, IQ);
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public void setBirthday(int birthday){
        this.birthday = birthday;
    }

    public long getYear() {
        return birthday;
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

    static {
        System.out.println("It is class: Human");
    }

    {
        System.out.println("Object from class Human");
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

    public boolean feedPet(boolean fraza) {
        if (fraza) {
            System.out.println("Покормил!");
            return true;
        } else {
            for (Pet pet : getFamily().getPet()) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.birthday == human.birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }
    public String describeAge(){
            Date day = new Date( birthday);
            Period periodYearsMonthsDays = Period.between(invertToLocalDate(day), invertToLocalDate(new Date()));
            return new StringBuilder().append(periodYearsMonthsDays.getYears())
                    .append(" years, ").append(periodYearsMonthsDays.getMonths())
                    .append(" months, ").append(periodYearsMonthsDays.getDays())
                    .append(" days.").toString();
    }
    //преобразование long даты в LocalDate
    public LocalDate invertToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //2-й вариант: устаревший return new java.sql.Date(date.getTime()).toLocalDate();
        //3-й вариант: return LocalDate.parse(Date.toString();
    }
    public String birthdateToStr(){
        return SDF.format(new Date(birthday));
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name= " + getName() + ", " +
                "surname= " + getSurname() + ", " + "yearOfBirth= " + birthdateToStr() + ", " +
                "iq= " + getIQ() + ", " + "scedule= " + scedule + '}';
    }




}
