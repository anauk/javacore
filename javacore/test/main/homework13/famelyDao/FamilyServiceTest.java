package main.homework13.famelyDao;

import main.homework13.family.Family;
import main.homework13.family.Man;
import main.homework13.family.Woman;
import main.homework13.family.Human;
import main.homework13.pet.Fish;
import main.homework13.pet.Pet;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class FamilyServiceTest {
    FamilyDao familyDao = new CollectionFamilyDao();
    FamilyService familyService = new FamilyService(familyDao);


    @Test
    public void check_getAllFamilies() {
        Human mother = new Woman("Pita", "Cluda");
        Human father = new Man("Mila", "Cluda");
        Family family = new Family(mother,father);
        familyService.createNewFamily(mother, father);

        Human mother1 = new Woman("Olga", "Petrova");
        Human father1 = new Man("Peta", "Petrova");
        Family family1 = new Family(mother1,father1);
        familyService.createNewFamily(mother1, father1);
        System.out.println(familyService.getAllFamilies());

        assertEquals(family,familyService.getFamilyById(0));
        assertEquals(family1,familyService.getFamilyById(1));
        assertSame(familyService.getAllFamilies(), familyDao.getAllFamilies());
    }

    @Test
    public void check_getFamiliesBiggerThan() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        Human child = new Woman("Rita", "Petrova");
        familyService.adoptChild(familyService.getAllFamilies().get(0),child);
        ArrayList<Family> list = new ArrayList<>();
        for(Family family:familyService.getAllFamilies()){
                    if(family.countFamily()>3){
                        list.add(family);
            }
        }
        assertEquals(list, familyService.getFamiliesBiggerThan(3));
    }

    @Test
    public void check_getFamiliesLessThan() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        ArrayList<Family> list = new ArrayList<>();
        for(Family family:familyService.getAllFamilies()){
            if(family.countFamily()<3){
                list.add(family);
            }
        }
        assertEquals(list, familyService.getFamiliesLessThan(3));
    }

    @Test
    public void check_countFamiliesWithMemberNumber() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        ArrayList<Family> list = new ArrayList<>();
        for(Family family:familyService.getAllFamilies()){
            if(family.countFamily()==2){
                list.add(family);
            }
        }
        assertEquals(list.size(), familyService.countFamiliesWithMemberNumber(2));
    }

    @Test
    public void check_createNewFamily() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        Human mother1 = new Woman("Lera", "Vanuchina");
        Human father2 = new Man("Sergej", "Vanuchin");
        familyService.createNewFamily(mother1, father2);
        assertEquals(familyService.getAllFamilies().size(), 2);
    }

    @Test
    public void check_deleteFamilyByIndex() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        Human mother1 = new Woman("Lera", "Vanuchina");
        Human father2 = new Man("Sergej", "Vanuchin");
        familyService.createNewFamily(mother1, father2);
        System.out.println(familyService.getAllFamilies().size());
        familyService.deleteFamilyByIndex(0);
        assertEquals(familyService.getAllFamilies().size(), 1);
    }

    @Test
    public void check_bornChild() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        System.out.println(familyService.getAllFamilies());
        familyService.bornChild(familyService.getFamilyById(0), "Wetal", "Lida");
        System.out.println(familyService.getFamilyById(0).countFamily());
        assertEquals(familyService.getFamilyById(0).countFamily(), 3);
        System.out.println(familyService.getFamilyById(0).getChildren());
    }

    @Test
    public void check_adoptChild() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        System.out.println(familyService.getAllFamilies());
        Human child = new Man("Igor", "Radonov");
        familyService.adoptChild(familyService.getFamilyById(0), child);
        assertEquals(familyService.getFamilyById(0).countFamily(), 3);
        System.out.println(familyService.getFamilyById(0).getChildren());
    }

    @Test
    public void deleteAllChildrenOlderThen() {
        Human child = new Man("Igor", "Radonov", 1983,55,new HashMap<>());
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);

        familyService.adoptChild(familyService.getFamilyById(0), child);
        System.out.println(familyService.getFamilyById(0));

        int nowYear = LocalDate.now().getYear();
        assertTrue((nowYear-child.getYear())>20);//проверка действительно ли возраст ребенка больше 20

        familyService.deleteAllChildrenOlderThen(20);
        assertNotEquals(familyService.getFamilyById(0).getChildren().size(),1);//проверка действительно ли ребенок удалился, если его возраст больше 20

    }

    @Test
    public void check_count() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        assertEquals(familyService.getAllFamilies().size(), 1);
    }

    @Test
    public void check_getFamilyById() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        Family family = new Family(mother, father);
        familyService.createNewFamily(mother, father);

        Human mother1 = new Woman("Olga", "Dovbush");
        Human father1 = new Man("Misha", "Dovbush");
        Family family1 = new Family(mother1, father1);
        familyService.createNewFamily(mother1, father1);

        assertEquals(family,familyService.getFamilyById(0));
        assertEquals(family1,familyService.getFamilyById(1));
        assertNotEquals(family1,familyService.getFamilyById(0));
    }

    @Test
    public void check_getPets() {
        Human mother1 = new Woman("Olga", "Dovbush");
        Human father1 = new Man("Misha", "Dovbush");

        Set<Pet> pet = new HashSet<>();
        Pet fish = new Fish("Molly", 1,20, new HashSet<>());
        pet.add(fish);

        familyService.createNewFamily(mother1, father1);
        familyService.getFamilyById(0).addPet(fish);

        assertEquals(pet,familyService.getFamilyById(0).getPet());
    }

    @Test
    public void check_addPet() {
        Human mother1 = new Woman("Olga", "Dovbush");
        Human father1 = new Man("Misha", "Dovbush");

        Set<Pet> pet = new HashSet<>();
        Pet fish = new Fish("Molly", 1,20, new HashSet<>());
        pet.add(fish);

        familyService.createNewFamily(mother1, father1);
        assertEquals(familyService.getFamilyById(0).getPet().size(), 0);

        familyService.getFamilyById(0).addPet(fish);
        assertEquals(familyService.getFamilyById(0).getPet().size(), 1);
    }
}