package homework8;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;

public class Family {
    static int count = 2;
    protected static String staticField;
    protected String field;
    private Human mother;//мама член семьи
    private Human father;//папа член семьи
    private Human[] children;//дети
    private Pet pet;
    public void run(){
        System.out.println("run");
        System.out.println(Runtime.getRuntime().freeMemory());
    }
    protected void finalize()throws Throwable{

        System.out.println("This object from class Family will be delete!");
        while(true) break;
    }
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
        children = result;
        child.setFamily(this);
        count++;
        System.out.println("Семья состоит из "+ count+ " человек.");
    }
    public boolean deletChild(int index){
        if(children != null && children.length > 0){
            if(index >= 0 && index<children.length){
                Human[] result = copyOf(children, children.length-1);
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
    public boolean deletMethodChild(Human child){
        for (int i = 0; i < children.length ; i++) {
            if(children[i].equals(child)){
                deletChild(i);
                child.setFamily(null);
                return true;
            }
        }
        return false;
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
