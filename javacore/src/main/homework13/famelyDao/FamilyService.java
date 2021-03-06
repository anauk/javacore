package main.homework13.famelyDao;


import main.homework13.family.Family;
import main.homework13.family.Human;
import main.homework13.family.Woman;
import main.homework13.pet.Pet;

import java.time.LocalDate;
import java.util.*;

public class FamilyService {
    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }
    private boolean checkIndexOfFamily(int i) {
        return i >= familyDao.getAllFamilies().size() || i < 0;
    }
    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        for (int i = 0; i < familyDao.getAllFamilies().size(); i++) {
            System.out.println((i + 1) + " " + familyDao.getFamilyByIndex(i));
        }
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() > count) {
                result.add(family);
            }
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int count) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() < count) {
                result.add(family);
            }
        }
        return result;
    }

    public int countFamiliesWithMemberNumber(int number) {
        int count = 0;
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() == number) {
                count++;
            }
        }
        return count;
    }

    public void createNewFamily(Human woman, Human man) {
        Family family = new Family(woman, man);
        familyDao.saveFamily(family);
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        Human child = family.bornChild();
        if (child instanceof Woman) {
            child.setName(girlName);
        } else {
            child.setName(boyName);
        }
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int nowYear = cal.get(Calendar.YEAR);
        for(Family family : familyDao.getAllFamilies()){
            Iterator<Human> it = family.getChildren().iterator();
            while(it.hasNext()){
                Human child = it.next();
                int year = nowYear - child.getYear();
                if(year > age){
                    it.remove();
                }
            }
        }
    }
    public List<Family> deleteAllChildrenOlderThen1(int age){
        int yearNow = LocalDate.now().getYear();
        List<Family> result = new ArrayList<>();
        for(Family family : familyDao.getAllFamilies()){
            Iterator<Human> it = family.getChildren().iterator();
            while(it.hasNext()){
                Human child = it.next();
                int differenceYear = yearNow - child.getYear();
                if(differenceYear > age){
                    it.remove();
                    result.add(family);
                }
            }
        }
        return result;
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        if (checkIndexOfFamily(index)) return null;
        return familyDao.getAllFamilies().get(index);
    }

    public Set<Pet> getPets(int index) {
        if(checkIndexOfFamily(index)) return null;
        return familyDao.getAllFamilies().get(index).getPet();
    }

    public Family addPet(int index, Pet pet) {
        if(checkIndexOfFamily(index)) return null;
        Family family = getFamilyById(index);
        family.addPet(pet);
        return family;
    }


}
