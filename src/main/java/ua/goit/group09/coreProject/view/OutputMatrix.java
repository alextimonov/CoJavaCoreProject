package ua.goit.group09.coreProject.view;

import ua.goit.group09.coreProject.data.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for output data from class Matrix
 */

public class OutputMatrix {
    public static final char SPACE = ' ';
    public static final char COMMA = ',';

    /**
     * configures matrix to List of strings to further printing
     * @param matrix        given Matrix
     * @return              List of strings
     */
    public static List<String> matrixToStringList(Matrix matrix) {
        List<String> result = new ArrayList<>();
        result.add(outputNLinesColumns(matrix.getLines(), matrix.getColumns()));
        for (int i = 0; i < matrix.getLines(); i++) {
            result.add(outputArray(matrix.getArray()[i]));
        }
        return result;
    }

    // returns String with matrix's numbers of lines & columns
    private static String outputNLinesColumns(int lines, int columns) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lines = ").append(lines);
        sb.append(COMMA).append(SPACE);
        sb.append("columns = ").append(columns);
        return sb.toString();
    }

    // returns string with numbers of given one-dimension array
    private static String outputArray(double[] lineOfDoubles) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < lineOfDoubles.length; j++) {
            //TODO align output
            sb.append(lineOfDoubles[j]).append(SPACE);
        }
        return sb.toString();
    }
}
