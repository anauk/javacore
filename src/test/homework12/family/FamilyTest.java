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
        father2 = father;
        if(father2.equals(father)){
            assertTrue(father2.hashCode() == father.hashCode());
        }
    }
    @Test
    public void checkMethodEquals(){
        mother2 = mother;
        if(mother2.equals(mother)&& mother.equals(mother2)){
            assertTrue(true);
        }
        assertTrue(mother2.equals(mother));
        Human mother3= new Woman("Pola", "Ritrova");
        mother = mother3;
        if(mother2.equals(mother)&&mother.equals(mother3)){
            assertTrue(mother2.equals(mother3));
        }
        assertTrue(mother2.equals(mother2));
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
        int len = family.getChildren().size();
        family.deletChild(1);
        int res = family.getChildren().size()-1;
        assertEquals(res, len-1);
        family.addChild(child3);
        family.addChild(child4);
        assertSame(child4,family.getChildren().remove(1));
        family2.addChild(child5);
        family2.deletChild(child5);
        for (Human child:family2.getChildren()) {
            assertSame(child, child5);
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