package homework12.famelyDao;

import homework12.family.Family;
import homework12.family.Human;
import homework12.family.Man;
import homework12.family.Woman;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> families = new ArrayList<>();

    /*public CollectionFamilyDao() {
        families = new ArrayList<>();
        Human mother = new Woman("Vera","Petrova");
        Human father = new Man("Peta","Petrov");
        Family family1 = new Family(mother, father);
        Human mother1 = new Woman("Masha","Kochetcova");
        Human father1 = new Man("Roma","Kochetcov");
        Family family2 = new Family(mother1,father1);
        families.add(family1);
        families.add(family2);
    }*/
    public CollectionFamilyDao() {
        Human mother1 = new Woman("Vera","Petrova");
        Human father1 = new Man("Peta","Petrov");
        addFamily(mother1, father1);
        Human mother2 = new Woman("Vera","Petrova");
        Human father2 = new Man("Peta","Petrov");
        addFamily(mother2, father2);
        Human mother3 = new Woman("Vera","Petrova");
        Human father3 = new Man("Peta","Petrov");
        addFamily(mother3, mother3);
        Human mother4 = new Woman("Vera","Petrova");
        Human father4 = new Man("Peta","Petrov");
        addFamily(mother4, father4);
        Human mother5 = new Woman("Vera","Petrova");
        Human father5 = new Man("Peta","Petrov");
        addFamily(mother5, father5);
    }

    private void addFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        families.add(family);
    }

    @Override
    public List<Family> getAllFamilies() {
        if(families == null){
            return null;
        } else {
            return families;
        }
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if(families.remove(getFamilyByIndex(index))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if(!families.isEmpty()&&families.remove(family)) {
            return true;
        }
        return false;
    }

    /*@Override
    public void saveFamily(Family family) {
        families.get(getFamilyByIndex()).setFamily(family);
        System.out.println(families);
    }*/

    @Override
    public void saveFamily(Family family) {
        for (int i = 0; i < families.size() ; i++) {
            Family family1 = families.get(i);
            if(family1.equals(family)){
                families.set(i, family);
                System.out.println(getAllFamilies());
            } else {
                families.add(family);
            }
        }

    }
}
