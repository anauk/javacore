package main.homework7;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;

public class Family {
    private Human mother;//мама член семьи
    private Human father;//папа член семьи
    private Human[] children;//дети
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new Human[0];

    }

    //какой человек созает семью
    public Human getMother() {
        return mother;
    }

    //какой человек созает семью
    public Human getFather() {
        return father;
    }

    public void addChild(Human child) {
        int len = children.length;
        Human[] result = Arrays.copyOf(children, len + 1);
        result[len] = child;
        children = result;
        child.setFamily(this);
    }

    public boolean deletChild(int index) {
        if (index >= children.length || index < 0) {
            return false;
        }
        if (children[index] != null) {
            children[index].setFamily(null);
            Human[] temp = Arrays.copyOf(children, children.length - 1);
            System.arraycopy(children, 0, temp, 0, index);
            System.arraycopy(children, index + 1, temp, index, children.length - index - 1);
            children = temp;
            return true;
        } else {
            return false;
        }
    }

    public boolean deletMethodChild(Human child) {
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                deletChild(i);
                child.setFamily(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "mother = " + this.mother + ", " +
                "father = " + this.father + ", " +
                "children = " + Arrays.toString(this.children);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return this.mother.equals(family.mother) &&
                this.father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    static {
        System.out.println("It is class: Family");
    }

    {
        System.out.println("Object init from class Family");
    }
    public int countFamily(){
        int count = 2;
        if(children == null) {
            return count;
        } else if(children.length>0){
            count += children.length;
        }
        return count;
    }

    public Pet getPet() {
        return this.pet;
    }
}
