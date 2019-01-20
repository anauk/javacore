package homework17.famelyDao;


import homework17.exception.FamilyOverflowException;
import homework17.family.Family;
import homework17.family.Human;
import homework17.family.Woman;
import homework17.pet.Pet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyService {
    private FamilyDao familyDao;
    private final static int MAX_SIZE_OF_FAMILY = 5;

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
        try {
            if(familyDao.getAllFamilies().size() == 0) throw new Exception("This DB is empty!");
            IntStream.range(0, familyDao.getAllFamilies().size())
                    .mapToObj(i -> i + 1 + "-" + familyDao.getFamilyByIndex(i).prettyFormat())
                    .forEach(System.out::println);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getFamiliesBiggerThan(int count) {
        if (familyDao.getAllFamilies().size() == 0) {
            System.out.println("This DB is empty!");
        }
        List<Family> result = new ArrayList<>();

        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() > count) {
                result.add(family);
                System.out.println(result);
            }
        }
        if (result.size() == 0) System.out.println("I didn't find such family!");
    }

    public List<Family> getFamiliesBiggerThan1(int count) {
        List<Family> result = new ArrayList<>();
        familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
        //.collect(Collectors.toCollection(ArrayList::new)); -2-й способ
        if (result.size() == 0) {
            System.out.println("List is empty!");
            return null;
        }
        return result;
    }

    public List<Family> getFamiliesLessThan(int count) {
        List<Family> result = new ArrayList<>();
        try {
            familyDao.getAllFamilies().stream()
                    .filter(family -> family.countFamily() < count)
                    .forEach(family -> {
                        System.out.println(family);
                        result.add(family);
                    });//3-й способ
            if (result.size() == 0) throw new Exception("List is empty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

    public int countFamiliesWithMemberNumber(int number) {
        long count = familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == number)
                .count();
        return (int) count;
    }

    public void createNewFamily(Human woman, Human man) {
        Family family = new Family(woman, man);
        familyDao.saveFamily(family);
    }

    public void deleteFamilyByIndex(int index) {
        try {
            if (checkIndexOfFamily(index)) throw new IOException("Size is wrong!");
            familyDao.deleteFamily(index);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        Family result = null;
        try {
            if(family == null) throw new NullPointerException("List is empty");
            if (family.countFamily() == 5) throw new FamilyOverflowException("Error: family is full - "+ MAX_SIZE_OF_FAMILY + " members");
            Human child = family.bornChild();
            if (child instanceof Woman) {
                child.setName(girlName);
            } else {
                child.setName(boyName);
            }
            result = family;
        } catch (FamilyOverflowException|NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Family adoptChild(Family family, Human child) {
        Family result = null;
        try {
            if (family.countFamily() == 5) throw new FamilyOverflowException("Error: family is full - ");
            family.addChild(child);
            result = family;
        } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage() + MAX_SIZE_OF_FAMILY + " members");
        }
        return result;
    }

    public void deleteAllChildrenOlderThen(int age) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int nowYear = cal.get(Calendar.YEAR);
        for (Family family : familyDao.getAllFamilies()) {
            Iterator<Human> it = family.getChildren().iterator();
            while (it.hasNext()) {
                Human child = it.next();
                cal.setTime(new Date(child.getYear()));
                int year = nowYear - cal.get(Calendar.YEAR);
                if (year > age) {
                    it.remove();
                }
            }
        }
    }

    public Set<Family> deleteAllChildrenOlderThen1(int age) {
        Set<Family> result = new HashSet<>();
        for (Family family : familyDao.getAllFamilies()) {
            for (Iterator<Human> iter = family.getChildren().iterator(); iter.hasNext(); ) {
                Human child = iter.next();
                LocalDate toDate = new Date(child.getYear()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate now = LocalDate.now();
                int childYear = now.minusYears(toDate.getYear()).getYear();
                if (childYear > age) {
                    iter.remove();
                    result.add(family);
                }
                /*-2-й способ используя период:
                Period periodYearsMonthsDays = Period.between(child.invertToLocalDate(new Date(child.getYear())), child.invertToLocalDate(new Date()));
                if( periodYearsMonthsDays.getYears() > age){
                    iter.remove();
                    result.add(family);
                }*/
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
        if (checkIndexOfFamily(index)) return null;
        return familyDao.getAllFamilies().get(index).getPet();
    }

    public Family addPet(int index, Pet pet) {
        if (checkIndexOfFamily(index)) return null;
        Family family = getFamilyById(index);
        family.addPet(pet);
        return family;
    }


}
