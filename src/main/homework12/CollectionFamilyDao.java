package homework12;

import homework12.family.Family;
import homework12.family.Human;
import homework12.family.Man;
import homework12.family.Woman;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> families;

    public CollectionFamilyDao() {
        families = new ArrayList<>();
        Human mother = new Woman("Vera","Petrova");
        Human father = new Man("Peta","Petrov");
        Family family1 = new Family(mother, father);
        Human mother1 = new Woman("Masha","Kochetcova");
        Human father1 = new Man("Roma","Kochetcov");
        Family family2 = new Family(mother1,father1);
        families.add(family1);
        families.add(family2);
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

    @Override
    public void saveFamily(Family family) {
        System.out.println(families);
    }

   /* @Override
    public void saveFamily(Family family) {
        if(families.get(getFamilyByIndex() == -1){
            families.add(family);
        } else {
            families.getAllFamilies();
        }
    }*/
}
