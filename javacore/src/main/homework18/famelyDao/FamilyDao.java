package main.homework18.famelyDao;

import main.homework18.family.Family;

import java.util.List;

public interface FamilyDao {
    List<Family>getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);

}
