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
    public Human getMother(){
        return mother;
    }
    //какой человек созает семью
    public Human getFather() {
        return father;
    }

    @Override
    public String toString() {
        return "mother = " + this.mother +", \n" +
                "father = " + this.father+", \n" +
                "children = " + Arrays.toString(this.children);
    }

    public void addChild(Human child) {
        int len = children.length;
        Human[] result = copyOf(children, len+1);
        result[len] = child;
        children = result;
        System.out.println(Arrays.toString(result));
        child.setFamily(this);
        count++;
        System.out.println("Семья состоит из "+ count+ " человек.");
    }
    public boolean deletChild(int index){
        if(children != null && children.length > 0){
            if(index >= 0 && index<children.length){
                Human[] result = copyOf(children, children.length-1);
                children = result;
                return true;
            } else {
                return false;
            }
        }
        /*int i;
        int len=children.length;
        for(i=0; i<len; i++){
            if(i == index);
            break;
        }
        for(int k=i; k<len-1; k++) {
            children[k]= children[k+1];
            len--;
        }*/
        System.out.println("В этой семьи нет детей!");
        return false;
    }
}
