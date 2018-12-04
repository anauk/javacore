package homework4end5;

public class Mother {
    Human mother;
    String name;
    String surname;
    public Mother(String name,String surname){
        this.name=name;
        this.surname=surname;
    }
    @Override
    public String toString(){
         String motherName = mother != null?mother.name + " " + mother.surname:null;
         return  String.format("%s{mother=%s}",getClass().getSimpleName(),motherName);
}
}
