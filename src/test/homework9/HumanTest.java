package homework9;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HumanTest {
    String[] arr = {"play, drink, sleep"};
    String[][] mScedule = {
            {DayOfWeek.SATURDAY.name(),"bla-bla with family"},
            {DayOfWeek.THURSDAY.name(),"play with child"},
    };
    Human mother = new Human("Wera", "Qwerty",1977,90,mScedule);


    @Test
    public void testToString() {
        /*System.out.println(mother.toString());

        assertEquals(getExpextedToString(),mother.toString());*/

        /*Human human = new Human("Alex", "Winch",2000,80,mScedule);
        assertEquals(getExpextedToString(),human.toString());*/

    }


    @Test
    public void testEquals() {
        Human mother2 = mother;
        assertTrue(mother.equals(mother2));
        assertTrue(mother2.equals(mother));

        mother2 = null;
        assertFalse(mother.equals(mother2));

        Pet dog = new Pet(Species.DOG,"Bobik",7,51,arr);
        assertFalse(mother.equals(dog));

        mother2 = new Human("Mary", "NotWinchester",1977,90,mScedule);
        assertFalse(mother.equals(mother2));

        mother2 = new Human("Mary", "Winchester",1977,100,mScedule);
        assertTrue(mother.equals(mother2));
    }

    @Test
    public void testHashCode(){
        Human mother2 = new Human("Mary", "Winchester",1977,100,mScedule);
        if(mother.equals(mother2)){
            assertTrue(mother.hashCode() == mother2.hashCode());
        }

    }

    public String getExpextedToString(){
        String res = getClass().getSimpleName() + "{name= " + mother.getName() + ", " +
                "surname= " + mother.getSurname() + ", " + "year= " + mother.getYear() + ", " +
                "iq= " + mother.getIQ() + ", " + "scedule= " + Arrays.deepToString(mother.getScedule()) + '}';
        return res;
    }


}