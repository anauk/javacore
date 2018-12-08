package homework10;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;

public class Family implements HumanCreator{
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
    public Pet getPet(){
        return pet;
    }

    public void addChild(Human child) {
        int len = children.length;
        Human[] result = Arrays.copyOf(children, len + 1);
        result[len] = child;
        children = result;
        child.setFamily(this);
    }

    public boolean deletChild(int index) {
        if (children != null && children.length > 0) {
            if (index >= 0 && index < children.length) {
                Human[] result = copyOf(children, children.length - 1);
                System.arraycopy(children, 0, result, 0, index);
                System.arraycopy(children, index + 1, result, index, children.length - index - 1);
                children[index].setFamily(null);
                children = result;
                return true;
            } else {
                return false;
            }
        }
        System.out.println("В этой семьи нет детей!");
        return false;
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

    protected void finalize() {
        System.out.println("This object from class Family will be delete!");
    }

    static {
        System.out.println("It is class: Family");
    }

    {
        System.out.println("Object init from class Family");
    }

    public int countFamily() {
        int count = 2;
        if (children == null) return count;
        if (children.length > 0) return count + children.length;
        return count;
    }

    @Override
    public Human bornChild() {
        String[] boyName = {"Roma", "Peta", "Kola","Vasa","Kiril"};
        String[] girlName = {"Lida","Veta", "Olga", "Vlada", "Hasta"};
        int boyNameR = (int)(Math.random()*boyName.length);
        int girlNameR = (int)(Math.random()*girlName.length);

        if((int)(Math.random()*2) == 0) {
            Human child = new Man(boyName[boyNameR], Man.getSurname(father));
            child.setFamily(this);
            this.addChild(child);
            child.setIQ((mother.IQ+father.IQ)/2);
            return child;
        } else if((int)(Math.random()*2) == 1){
            Human child = new Woman(girlName[girlNameR], Man.getSurname(father));
            child.setFamily(this);
            this.addChild(child);
            child.setIQ((mother.IQ+father.IQ)/2);
            return child;
        }
        return null;
    }


}
