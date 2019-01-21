package main.homework12;

import main.homework9.Pet;
import main.homework9.Species;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PetTest {
    String[] habits = {"eat, drink, sleep"};

    Pet dog = new Pet(Species.DOG,"Radik",7,51, habits);
    Pet cat = new Pet(Species.DOG,"Murka",5,21, habits);

    Pet dog2 = dog;

    @Test
    public void testToString() {
        assertEquals(getExpextedToString(dog),dog.toString());
        assertEquals(getExpextedToString(cat),cat.toString());
    }

    @Test
    public void testEquals(){
        assertTrue(dog.equals(dog2));

        dog2 = null;
        assertFalse(dog.equals(dog2));

        assertFalse(dog.equals(cat));

        dog2 = new Pet(Species.DOG,"Radik",7,51, habits);
        assertTrue(dog.equals(dog2));
    }

    @Test
    public void testHashCode(){
        if(dog.equals(dog2)){
            assertTrue(dog.hashCode() == dog2.hashCode());
        }
    }


    public String getExpextedToString(Pet pet){
        String canFly = (pet.getSpecies().CanFly()) ? "может летать" : "не может летать";
        String hasFur = (pet.getSpecies().HasFur()) ? "есть шерсть" : "нет шерсти";
        return pet.getSpecies().getName() + ", " + canFly + ", " + pet.getSpecies().getNumberOfLegs() + " лап, " + hasFur + "{nickname= " +
                pet.getNickname() + " , age= " + pet.getAge() + " , trickLevel= " +
                pet.getTrickLevel() + " , habits= " + Arrays.toString(pet.getHabits()) + "}";
    }


}