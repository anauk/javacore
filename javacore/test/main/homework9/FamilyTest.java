package main.homework9;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FamilyTest {
    //given
    String[] habits = {"play","eat","sleep"};
    String[][] scedule = {{DayOfWeek.MONDAY.name(),"go to work"},{DayOfWeek.THURSDAY.name(),"do some project"}};
    Human mother = new Human("Vera","Petrova",1955, 56, scedule);
    Human father = new Human("Denis", "Petrov",1950,91,scedule);
    Family family= new Family(mother, father);

    Human child1 = new Human("Kiril","Petrov");
    Human child2 = new Human("Olga", "Petrova");
    Human[] children = {};



    @Test
    public void checkAddChild() {
        //when
        int init = family.getChildren().length;
        System.out.println(init);
        family.addChild(child1);
        //then
        assertEquals(init+1, family.getChildren().length);
        assertEquals(family.getChildren()[family.getChildren().length-1],child1);

    }

    @Test
    public void checkDeletChild() {
        family.addChild(child2);
        int init = family.getChildren().length;
        family.deletChild(0);
        //int result = children.length;
        for (int i = 0; i < family.getChildren().length; i++) {
            assertNotSame(child2,family.getChildren()[i]);
        }
    }

    @Test
    public void testToString() {
        String result = "mother = " + this.mother +", " +
                "father = " + this.father+", " +
                "children = " + Arrays.toString(this.children);
        assertEquals(result, family.toString());
    }

    @Test
    public void checkEquals() {
        Human mother1 = new Human("Lida", "Rehxfnjdf");
        Human father1 = new Human("Eric", "Rehxfnjdf");
        Family family2 = new Family(mother1,father1);
        family2 = family;
        assertTrue(family.equals(family));
        if(family2.equals(family)){
            assertTrue(family.equals(family2));
        }

        Human mother2 = new Human("Qwen", "Rehxfnjdf");
        Human father2 = new Human("Mosa", "Rehxfnjdf");
        Family family3 = new Family(mother2,father2);
        family = family3;
        if(family2.equals(family)){
            assertTrue(family2.equals(family3));
        }
        assertTrue(family2.equals(family2));
    }

    @Test
    public void checkHashCode() {
        Human mother2 = new Human("Qwen", "Rehxfnjdf");
        Human father2 = new Human("Mosa", "Rehxfnjdf");
        Family family3 = new Family(mother2,father2);
        if(family.equals(family3)){
            assertTrue(family.hashCode()==family3.hashCode());
        }

    }

    @Test
    public void checkCountFamily() {
        assertEquals(children.length+2,family.countFamily());
    }

}