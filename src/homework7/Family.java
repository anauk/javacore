package homework7;

import homework6.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    protected static String staticField;
    protected String field;
    private Human mother;//мама член семьи
    private Human father;//папа член семьи
    private Human[] children;//дети
    private Pet pet;
    static{
        staticField = "Family";
        System.out.println("It is class: " + staticField);
    }
    {
        field = "from class Family";
        System.out.println("Object init " + field);
    }
    public Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new Human[0];

    }
    //какой человек созает семью
    public Human getMother(){
        return mother;
    }
    //какой человек созает семью
    public Human getFather() {
        return father;
    }

    @Override
    public String toString() {
        return "mother = " + this.mother +", " +
                "father = " + this.father+", " +
                "children = " + Arrays.toString(this.children);
    }

    public void addChild(Human child) {
        int len = children.length;
        Human[] result = Arrays.copyOf(children, len+1);
        result[len] = child;
        System.out.println(Arrays.toString(result));
        child.setFamily(new Family(mother,father));
    }
    public boolean deletChild(int index){
        int i;
        int len=children.length;
        for(i=0; i<len; i++){
            if(i == index);
            break;
        }
        for(int k=i; k<len-1; k++) {
            children[k]= children[k+1];
            len--;
        }
        return true;
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
        return Objects.hash(mother,father);
    }
}
