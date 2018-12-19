package homework13.famelyDao;

import homework13.family.Family;
import homework13.family.Man;
import homework13.family.Woman;
import homework13.family.Human;
import homework13.pet.Fish;
import homework13.pet.Pet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FamilyServiceTest {
    FamilyDao familyDao = new CollectionFamilyDao();
    FamilyService familyService = new FamilyService(familyDao);

    @Test
    public void check_getAllFamilies() {
        assertTrue(familyService.getAllFamilies()==familyDao.getAllFamilies());
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
        assertTrue(familyService.getAllFamilies().size() == 2);
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
        assertTrue(familyService.getAllFamilies().size() == 1);
    }

    @Test
    public void check_bornChild() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        System.out.println(familyService.getAllFamilies());
        familyService.bornChild(familyService.getFamilyById(0), "Wetal", "Lida");
        System.out.println(familyService.getFamilyById(0).countFamily());
        assertTrue(familyService.getFamilyById(0).countFamily()==3);
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
        assertTrue(familyService.getFamilyById(0).countFamily()==3);
        System.out.println(familyService.getFamilyById(0).getChildren());
    }

    @Test
    public void deleteAllChildrenOlderThen() {
    }

    @Test
    public void check_count() {
        Human mother = new Woman("Olga", "Petrova");
        Human father = new Man("Peta", "Petrova");
        familyService.createNewFamily(mother, father);
        assertTrue(familyService.getAllFamilies().size() == 1);
    }

    @Test
    public void getFamilyById() {
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
        assertTrue(familyService.getFamilyById(0).getPet().size()==0);

        familyService.getFamilyById(0).addPet(fish);
        assertTrue(familyService.getFamilyById(0).getPet().size()==1);
    }
}