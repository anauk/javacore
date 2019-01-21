package main.homework14.famelyDao;

import main.homework14.family.Family;

import java.util.List;

public interface FamilyDao {
    List<Family>getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);

}
