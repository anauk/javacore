package main.homework16.famelyDao;

import main.homework16.family.Family;

import java.util.List;

public interface FamilyDao {
    List<Family>getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);

}
