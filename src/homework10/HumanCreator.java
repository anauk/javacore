package homework10;

public interface HumanCreator {
    void bornChild();

    static int getChildIQ(Human mother,Human father) {
        return (mother.IQ+father.IQ)/2;
    }
    static String getGender(){
        String[] gender = {"mail", "femail"};
        int result = (int)(Math.random()*gender.length);
        return gender[result];
    }
    static String getChildName(){
        String result = " ";
        String[] boyName = {"Roma", "Peta", "Kola","Vasa","Kiril"};
        String[] girlName = {"Lida","Veta", "Olga", "Vlada", "Hasta"};
        int boyNameR = (int)(Math.random()*boyName.length);
        int girlNameR = (int)(Math.random()*girlName.length);
        if (getGender() == "mail"){
            return result + boyName[boyNameR];
        } else if(getGender() == "femail") {
            return result + girlName[girlNameR];
        }
        return result;
    }
}
