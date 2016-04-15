package ua.goit.group09.coreProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that creates menu for user's choice of math operation with matrices
 */
public class MatrixCalculatorMenu {
    public static final String HEAD_MENU = "Two-dimensional Matrix Calculator. Input your choice:";
    public static final String LINE_1 = "1: (+) Find the sum of two matrices";
    public static final String LINE_2 = "2: (-) Find the difference of two matrices";
    public static final String LINE_3 = "3: (*) Find the multiplication of two matrices";
    public static final String LINE_4 = "4: ( ) Find the multiplication of number and matrix";
    public static final String LINE_5 = "5: Exit";

    private List<String> menuLines = new ArrayList<>();

    public MatrixCalculatorMenu() {
        menuLines.add(HEAD_MENU);
        menuLines.add(LINE_1);
        menuLines.add(LINE_2);
        menuLines.add(LINE_3);
        menuLines.add(LINE_4);
        menuLines.add(LINE_5);
    }

    public List<String> getMenuLines() {
        return menuLines;
    }
}
