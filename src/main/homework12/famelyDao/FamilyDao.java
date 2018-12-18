package homework12.famelyDao;

import homework12.family.Family;

import java.util.List;

public interface FamilyDao {
    List<Family>getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
