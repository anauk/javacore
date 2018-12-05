package homework10;

public interface HumanCreator {
    static Human bornChild(Woman woman, Man man){
        return new Human();
    }
}
