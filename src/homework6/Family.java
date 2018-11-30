package homework6;

import java.util.Arrays;

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


}
