import java.util.ArrayList;

public class Main {

    public static void produceWaste(int n) {

        for (int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeObject someObj = new SomeObject(strID);
        }
    }

    public static ArrayList<SomeObject> produceSomeWaste(int n, int reuseFrom, int reuseTo) {

        ArrayList<SomeObject> reusableWaste = new ArrayList<>();

        for (int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeObject someObj = new SomeObject(strID);
            if (id > reuseFrom && id < reuseTo) {
                reusableWaste.add(someObj);
            }
        }
        return reusableWaste;
    }

    public static void produceWasteWithReuse(int n) {

        for(int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeOtherObject someOtherObj = new SomeOtherObject(strID);
        }
    }


    public static void producePairsOfWaste(int n) {

        for(int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeOtherObject someObj = new SomeOtherObject(strID + "_1");
            SomeOtherObject someOtherObj = new SomeOtherObject(strID + "_2");
            someObj.other = someOtherObj;
            someOtherObj.other = someObj;
        }
    }

    public static void main(String[] args) {

        int n = 500000;
        produceWaste(n);

        int from = 300000;
        int to = 400000;
        produceSomeWaste(n, from, to);

        produceWasteWithReuse(n);

        producePairsOfWaste(n);

    }
}
