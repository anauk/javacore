package homework12.family;

import homework12.DayOfWeek;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class FamilyTest {
    Set<String> habits = new HashSet<>();

    Map<String,String> motherSce = new HashMap<>();

    Map<String,String> fatherSce = new HashMap<>();

    Map<String,String> childSce = new HashMap<>();

    Human mother = new Human("Olga", "Rondebush",1977,90,motherSce);

    Human father = new Human("John", "Rondebush",1974,95,fatherSce);

    Family family = new Family(mother,father);

    Human child1 = new Human("Samy", "Rondebush",2007,85 ,childSce);
    Human child2 = new Human("Dred", "Rondebush",2000,80 ,childSce);
    Human child3 = new Human("Trec", "Rondebush",1998,75 ,childSce);
    Human child4 = new Human("Bob", "Rondebush",1956,45 ,childSce);
    Human child5 = new Human("eric", "Rondebushr",1748,10 ,childSce);
    Human mother2 = new Human("froca", "Davinchy",2000,90,motherSce);
    Human father2 = new Human("Bill", "Davinchy",2005,95,fatherSce);

    Family family2 = new Family(mother2,father2);


    protected void setUp() throws Exception{
        habits.add("eat");
        habits.add("sleep");
        habits.add("drink");
        motherSce.put(DayOfWeek.THURSDAY.name(),"relax with family");
        motherSce.put(DayOfWeek.SANDAY.name(),"walk with child");

        fatherSce.put(DayOfWeek.WEDNESDAY.name(),"relax with family");
        fatherSce.put(DayOfWeek.SATURDAY.name(),"visit parents");

        childSce.put(DayOfWeek.SATURDAY.name(),"relax with family");
        childSce.put(DayOfWeek.MONDAY.name(),"walk with mother");
    }
    @Test
    public void checkbornChild() {
        Human child6 = family.bornChild();
        assertTrue(child6 instanceof Man || child6 instanceof Woman);
        assertTrue(child6.getFamily() == father.getFamily() && child6.getFamily() == mother.getFamily());
        assertTrue(child6.getSurname() == father.getSurname());
        assertNotNull(child6.getSurname());
    }
    @Test
    public void checkHashCode(){
        Human father3 = new Human("John", "Rondebush",1974,95,fatherSce);
        assertTrue(father3.equals(father));
        assertTrue(father3.hashCode() == father.hashCode());

    }
    @Test
    public void checkMethodEquals(){
        Human mother4 = new Human("froca", "Davinchy",2000,90,motherSce);
        assertTrue(mother4.equals(mother2));
        assertTrue(mother2.equals(mother4));

        Human mother3= new Human("froca", "Davinchy",2000,90,motherSce);

        assertTrue(mother3.equals(mother4));
        assertTrue(mother4.equals(mother2));

        mother3 = null;
        assertFalse(mother2.equals(mother3));
    }
    @Test
    public void checkCountFamily(){
        int len = family2.countFamily();
        family2.addChild(child2);
        family2.addChild(child3);
        int res = family2.countFamily();
        assertEquals(len+2,res);
    }
    @Test
    public void checkAddChild(){
        int len = family.getChildren().size();
        family.addChild(child1);
        int result = family.getChildren().size();
        assertEquals(result,len+1);
        assertTrue(child1.equals(child1));
    }
    @Test
    public void checkDeleteChild() {
        Human child6 = new Human("Bob", "Rondebush",1956,45 ,childSce);
        Human child7 = new Human("eric", "Rondebushr",1748,10 ,childSce);
        Family family1 = new Family(mother,father);
        family1.addChild(child6);
        family1.addChild(child7);
        int len = family1.getChildren().size();
        System.out.println(len);
        family1.deletChild(1);

        int res = family1.getChildren().size();
        System.out.println(res);
        assertEquals(res, len-1);

        family1.addChild(child5);
        assertSame(child5,family1.getChildren().remove(1));

        for (Human child:family1.getChildren()) {
            assertSame(child, child6);
        }
    }

    @Test
    public void checkToString(){
        String res = "mother = " + this.mother + ", " +
                "father = " + this.father + ", " +
                "children = " + family.getChildren();
        assertEquals(res, family.toString());
    }

}