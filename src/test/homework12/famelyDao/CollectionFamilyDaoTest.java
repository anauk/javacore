package homework12.famelyDao;


import homework12.family.Family;
import homework12.family.Woman;
import homework12.family.Man;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CollectionFamilyDaoTest {
    Woman mother = new Woman("Vera", "Semonova", 1981, 85, new HashMap());
    Man father = new Man("Peta", "Semonova", 1974, 88, new HashMap());
    Family family = new Family(mother, father);
    FamilyDao familyDao = new CollectionFamilyDao();

    @Test
    public void check_getAllFamilies() {
        Woman mother2 = new Woman("Lida", "Semonova", 1981, 85, new HashMap());
        Man father2 = new Man("Samuray", "Semonova", 1974, 88, new HashMap());
        Family family2 = new Family(mother2, father2);

        Woman mother3 = new Woman("Masha", "Симпсоны", 1981, 85, new HashMap());
        Man father3 = new Man("Erik", "Симсоны", 1974, 88, new HashMap());
        Family family3 = new Family(mother3, father3);

        familyDao.saveFamily(family2);
        familyDao.saveFamily(family3);
        assertTrue(familyDao.getAllFamilies().size() == 2);
    }

    @Test
    public void check_getFamilyByIndex() {
        //given
        Woman mother1 = new Woman("Vera", "Semonova", 1981, 85, new HashMap<>());
        Man father1 = new Man("Peta", "Semonova", 1974, 88, new HashMap<>());
        Family family1 = new Family(mother1, father1);
        //when
        familyDao.saveFamily(family1);
        Family familyIndex = familyDao.getFamilyByIndex(0);
        //then
        assertTrue(familyIndex.equals(family1));
    }

    @Test
    public void check_deleteFamilyByIndex() {
        Woman mother2 = new Woman("Vera", "Semonova", 1981, 85, new HashMap<>());
        Man father2 = new Man("Peta", "Semonova", 1974, 88, new HashMap<>());
        Family family2 = new Family(mother2, father2);
        //when
        familyDao.saveFamily(family2);

        //then
        assertTrue(familyDao.deleteFamily(0));
        assertTrue(familyDao.getAllFamilies().size() == 0);
    }

    @Test
    public void check_deleteFamilyByObject() {
        Woman mother2 = new Woman("Кира", "Semonova", 1981, 85, new HashMap<>());
        Man father2 = new Man("Рома", "Semonova", 1974, 88, new HashMap<>());
        Family family2 = new Family(mother2, father2);

        Woman mother3 = new Woman("Соня", "Симпсоны", 1981, 85, new HashMap<>());
        Man father3 = new Man("Федя", "Симсоны", 1974, 88, new HashMap<>());
        Family family3 = new Family(mother3, father3);

        familyDao.saveFamily(family2);
        familyDao.saveFamily(family3);
        //when
        familyDao.deleteFamily(family3);
        assertTrue("Номер удаленной семьи соответствует самой семье!", familyDao.getFamilyByIndex(0).equals(family2));
        assertTrue(familyDao.getAllFamilies().size() == 1);
    }

    @Test
    public void check_saveFamily() {
        Woman mother3 = new Woman("Rita", "Симпсоны", 1981, 85, new HashMap<>());
        Man father3 = new Man("Kirill", "Симсоны", 1974, 88, new HashMap<>());
        Family family3 = new Family(mother3, father3);
        familyDao.saveFamily(family3);

        assertTrue(familyDao.getFamilyByIndex(0).equals(family3));
        assertNotNull(familyDao.getAllFamilies().size());

    }
}