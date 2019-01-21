package main.homework12;

import main.homework12.DayOfWeek;
import main.homework12.family.Human;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HumanTest {
    Map<String, String> scedule = new HashMap<String, String>();
    Human mother = new Human("Sara"," ghret", 1983, 91, scedule);
    protected void setUp() throws Exception{
        scedule.put(DayOfWeek.SATURDAY.name(),"relax with family");
        scedule.put(DayOfWeek.FRIDAY.name(),"walk with child");
    }

    @Test
    public void check_toString() {
        String res = mother.getClass().getSimpleName() + "{name= " + mother.getName() + ", " +
                "surname= " + mother.getSurname() + ", " + "year= " + mother.getYear() + ", " +
                "iq= " + mother.getIQ() + ", " + "scedule= " + scedule + '}';
        assertEquals(mother.toString(),res);
    }

    @Test
    public void check_equals() {
        Human mother2 = mother;
        assertTrue(mother.equals(mother2));
        assertTrue(mother2.equals(mother));

        mother2 = null;
        assertFalse(mother.equals(mother2));

        mother2 = new Human("Sara"," ghret", 1981, 91, scedule);
        assertFalse(mother.equals(mother2));

    }

    @Test
    public void check_hashCode() {
        Human mother2 = new Human("Sara"," ghret", 1983, 91, scedule);
        if(mother.equals(mother2)){
            assertTrue(mother.hashCode() == mother2.hashCode());
        }

    }

}