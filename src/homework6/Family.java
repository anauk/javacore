package homework6;

import java.util.Arrays;

import static java.util.Arrays.*;

public class Family {
    static int count = 2;
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

    @Override
    public String toString() {
        return "mother = " + this.mother + ", \n" +
                "father = " + this.father + ", \n" +
                "children = " + Arrays.toString(this.children);
    }

    public void addChild(Human child) {
        int len = children.length;
        Human[] result = copyOf(children, len + 1);
        result[len] = child;
        children = result;
        System.out.println(Arrays.toString(result));
        child.setFamily(this);
        count++;
        System.out.println("Семья состоит из " + count + " человек.");
    }

    public boolean deletChild(int i) {
        if (i >= children.length || i < 0) {
            return false;
        }
        if (children[i] != null) {
            children[i].setFamily(null);
            Human[] temp = Arrays.copyOf(children, children.length - 1);
            System.arraycopy(children, 0, temp, 0, i);
            System.arraycopy(children, i + 1, temp, i, children.length - i - 1);
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
}
