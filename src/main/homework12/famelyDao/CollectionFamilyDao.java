package homework12.famelyDao;

import homework12.family.Family;
import homework12.family.Human;
import homework12.family.Man;
import homework12.family.Woman;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            if (index > families.size() || index < 0) return false;
            families.remove(index);
            return true;
        } catch (IndexOutOfBoundsException e){
            System.out.println("В листе нет столько семей");
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }


    @Override
    public void saveFamily(Family family) {
        boolean is = false;
        for (int i = 0; i < families.size(); i++) {
            if (families.get(i).equals(family)) {
                families.set(i, family);
                is = true;
                System.out.println(getAllFamilies());
                break;
            }
        }
        if (!is) {
            families.add(family);
        }
    }
}
