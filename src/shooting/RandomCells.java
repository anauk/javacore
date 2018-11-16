package shooting;

public class RandomCells {
    int[] locCells;
    int numOfHit;
    public void setLocCells(int[] locCells){
        this.locCells=locCells;
    }
    public String getHit(String s) {
        int num = Integer.parseInt(s);
        String result = "*";
        for(int cell:locCells){
            if(num == cell){
                result = "x";
                numOfHit++;
                break;
            }
        }
        if(numOfHit == locCells.length) {
            result = "x";
        }
        System.out.println(result);
        return result;
    }
}
