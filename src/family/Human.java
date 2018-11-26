package family;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int IQ;
    private String pet;
    private String mother;
    private String father;
    private String[][] scedule ={
            {"monday","do samthing"},
            {"sunday","what are doing here"},
            {"friday","what are ..."},
            {"wednesday","... here"}

    };
    public Human(String n,String sn) {
    this.name =n;
    this.surname = sn;
}
    public Human(String n,String[][] sc){
        this.name=n;
        this.scedule=sc;
    }
    public Human(String n, String sN, int y, int iq, String p, String m, String f, String[][] sc) {
        this.name = n;
        this.surname = sN;
        this.year = y;
        this.IQ = iq;
        this.pet = p;
        this.mother = m;
        this.father = f;
        this.scedule = sc;
    }

    public Human(String n, String sN, int y, int iq, String mother, String father, String an) {
    this.name=n;
    this.surname=sN;
    this.year=y;
    this.IQ = iq;
    this.mother = mother;
    this.father = father;
    this.pet = an;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public int getIQ() {
        return IQ;
    }

    public String getPet() {
        return pet;
    }

    public String getMother() {
        return mother;
    }

    public String getFather() {
        return father;
    }

    public void setScedule(int firstParam, int secondParam, String value) {
        scedule[firstParam][secondParam]=value;
    }

    public String getScedule(int firstParam, int secondParam) {
        return scedule[firstParam][secondParam];
    }

    @Override
    public String toString() {
        return String.format("%s{name= %s , surname= %s , year= %d , iq= %d , mother=%s , father= %s , pet= %s}", getClass().getSimpleName(), getName(), getSurname(), getYear(), getIQ(), getMother(), getFather(), getPet());
    }
    void describePet(Pet c) {
    if(c.trickLevel>50){
        System.out.println("У меня есть "+ c.getNickname() +
                ", ему " + c.getAge()+" года, он очень хитрый.");
    }
    if(c.trickLevel <= 50){
        System.out.println("У меня есть "+ c.getNickname() +
                ", ему " + c.getAge()+" года, он почти не хитрый.");
    }
    }

    public void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname()+"!");
    }


}
