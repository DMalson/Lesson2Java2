import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

import java.util.Arrays;
import java.util.Random;

public class ProgramLauncher {

    public static void main(String[] args) {
        String[][] testArray1 = new String[4][4];
        String[][] testArray2 = new String[5][4];
        String[][] testArray3 = new String[4][4];

        fillArray(testArray1, true);
        System.out.println("Массив чисел 4 х 4");
        printArray(testArray1);
        doTask(testArray1);

        fillArray(testArray2, true);
        System.out.println("Массив чисел 5 х 4");
        printArray(testArray2);
        doTask(testArray2);

        fillArray(testArray3, false);
        System.out.println("Массив строк 4 х 4");
        printArray(testArray3);
        doTask(testArray3);
    }


    // Заполнение тестового массива значениями
    public static void fillArray(String testArray[][], boolean intOnly) {
        String[] array1 = {"25", "12", "6", "fdc", "78", "22", "11", "6", "7", "8", "frde", "55", "31", "64", "79", "52", "31", "18", "qwerty", "55", "1", "6", "7", "99", "0", "11", "37"};
        Random random = new Random();
        if (intOnly) {
            for (int i = 0; i < testArray.length; i++) {
                for (int j = 0; j < testArray[i].length; j++) {
                    testArray[i][j] = String.valueOf(random.nextInt(10));
                }
            }
        } else {
            for (int i = 0; i < testArray.length; i++) {
                for (int j = 0; j < testArray[i].length; j++) {
                    testArray[i][j] = array1[random.nextInt(array1.length)];
                }
            }
        }
    }

    // Контрольный вывод значений массива
    public static void printArray(String testArray[][]) {
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(Arrays.toString(testArray[i]));
        }
    }

    // Выполнение задания и перехват exception при необходимости
    public static void doTask(String testArray[][]) {
        ArrayManager arrayManager = new ArrayManager();
        try {
            System.out.println("Сумма элементов равна " + arrayManager.getSum(testArray));
        } catch (MyArraySizeException e) {
            System.out.println("Перехвачен MyArraySizeException. Размер массива не соотвествует требуемому");
        } catch (MyArrayDataException e) {
            System.out.println("Перехвачен MyArraySizeException. Ошибка преобразования." + '\n' +
                    "Строка " + e.getRow() + ", столбец " + e.getColumn() +  '\n' +
                    "Значение \'" + testArray[e.getRow()][e.getColumn()] + "\'");
        } catch (Exception e) {
            System.out.println("Перехвачен Exception. Произошла неизвестная ошибка.");
        }
        System.out.println();
    }
}
