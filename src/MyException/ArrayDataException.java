package MyException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDataException extends Exception {
    public ArrayDataException(int column, int row, String[][] arr) {
        super("Некорректные данные в " + column + " строке, " + row + " столбце: "
        + arr[column][row]);
    }
}
