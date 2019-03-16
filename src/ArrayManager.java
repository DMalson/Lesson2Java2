import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class ArrayManager  {

    public ArrayManager() {
    }

    public static int getSum(String[][] stringArray) throws Exception {
        int arrSum = 0;
        int i;
        int j=0;
        if (stringArray.length != 4) throw new MyArraySizeException();
        for (i = 0; i < 4; i++) {
            if (stringArray[i].length != 4) throw new  MyArraySizeException();
        }
        try {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    arrSum += Integer.parseInt(stringArray[i][j]);
                }
            }
        } catch (Exception e) {
            throw new MyArrayDataException(i,j);
        }

        return arrSum;
    }


}
