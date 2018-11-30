package homework6;

public class HappyFamilly {
    public static void main(String[] args) {
        Pet cat = new Pet("Cat", "Vaca", 1, 70, new String[]{"sleep, play"});
        System.out.println(cat.toString());
        Human mother1 = new Human("Vera", "Petrova");
        Human father1 = new Human("Artem", "Petrov");
        Human child = new Human("Kola", "Petrov");
        Family family1 = new Family(mother1, father1);
family1.addChild(child);
    }
}
