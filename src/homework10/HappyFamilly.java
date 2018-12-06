package homework10;

public class HappyFamilly {
    public static void main(String[] args) {
        Pet cat = new DomesticCat("Vaca", 1, 70, new String[]{"sleep, play"});
        ((DomesticCat) cat).foul();
        System.out.println("Это кот! " + cat);
        Pet fish = new Fish("Molly", 1, 20, new String[]{"swim, eat"});
        System.out.println(fish.getClass());
        System.out.println("Это рыбка! " + fish);
        fish.respond();
        fish.eat();
        System.out.println(Species.CAT.name());
        Human mother1 = new Woman("Vera", "Petrova", 1966, 79, new String[][]{{DayOfWeek.MONDAY.name()}, {"day_2, task_2"}});
        System.out.println("Это мама Вера! - " + mother1);
        Human father1 = new Man("Artem", "Petrov", 1966, 79, new String[][]{{"day, task"}, {"day_2, task_2"}});
        System.out.println("Это папа Артем! - " + father1);
        mother1.gridPet(cat);
        father1.gridPet(cat);
        Family family1 = new Family(mother1, father1);
        Human boy = new Man("Kola", "Petrov");
        System.out.println("Вот мальчик Коля!");
        family1.addChild(boy);
        System.out.println(family1.countFamily());
        Human girl = new Human("Lera", "Petrova");
        Human girl2 = new Human("Vera", "Petrova");
        System.out.println("Вот девочка Лера! " + girl);
        Human[] children = {boy, girl, girl2};
        System.out.println("Они брат и сестры ");
        family1.addChild(girl);
        family1.addChild(girl2);
        System.out.println(family1.countFamily());
        System.out.println("А вот они вместе с семьей: " + family1);
        System.out.println("Кто-то издетей ушел из семьи?! " + family1.deletChild(0));
        System.out.println(family1);
        System.out.println("Дочь Лера выросла и ушла из семьи?! " + family1.deletMethodChild(girl));
        System.out.println("А куда ушел третий ребенок?! " + family1.deletChild(2) + " Нет столько детей в этой семьи!");
        System.out.println(family1);
        System.out.println("Ушли все дети! " + family1.deletChild(0));
        System.out.println(family1);
        System.out.println(family1.countFamily());
        System.out.println(family1.bornChild());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Вот другая семья!");
        Human mother2 = new Woman("Nina", "Gylash");
        System.out.println("Это мама " + mother2);
        Human father2 = new Man("Devid", "Duchovnuy");
        System.out.println("Это папа " + father2);
        Family family2 = new Family(mother2, father2);
        System.out.println("Это их семья: " + family2);
        family2.deletChild(0);
        ((Woman) mother2).makeUp();
        ((Man) father2).repairCar();
        System.out.println(family2.countFamily());
        System.out.println(family2.bornChild());
    }
}
