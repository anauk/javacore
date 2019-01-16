package homework17.famelyDao;

import homework17.family.Family;
import homework17.family.Human;
import homework17.pet.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public FamilyService getFamilyService() {
        return familyService;
    }
    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }
    public void displayAllFamilies(){
        familyService.displayAllFamilies();
    }
    public void getFamiliesBiggerThan(int count){
        familyService.getFamiliesBiggerThan(count);
    }
    public List<Family> getFamiliesBiggerThan1(int count){
        return familyService.getFamiliesBiggerThan1(count);
    }
    public List<Family> getFamiliesLessThan(int count){
        return familyService.getFamiliesLessThan(count);
    }
    public int countFamiliesWithMemberNumber(int number){
        return familyService.countFamiliesWithMemberNumber(number);
    }
    public void createNewFamily(Human woman, Human man){
        familyService.createNewFamily(woman, man);
    }
    public void deleteFamilyByIndex(int index){
        familyService.deleteFamilyByIndex(index);
    }
    public Family bornChild(Family family, String boyName, String girlName){
        return familyService.bornChild(family, boyName, girlName);
    }
    public Family adoptChild(Family family, Human child){
        return familyService.adoptChild(family, child);
    }
    public void deleteAllChildrenOlderThen(int age){
       familyService.deleteAllChildrenOlderThen(age);
    }
    public Set<Family> deleteAllChildrenOlderThen1(int age){
        return familyService.deleteAllChildrenOlderThen1(age);
    }
    public int count() {
        return familyService.count();
    }
    public Family getFamilyById(int index){
        return familyService.getFamilyById(index);
    }
    public Set<Pet> getPets(int index){
        return familyService.getPets(index);
    }
    public Family addPet(int index, Pet pet){
        return familyService.addPet(index, pet);
    }
}
