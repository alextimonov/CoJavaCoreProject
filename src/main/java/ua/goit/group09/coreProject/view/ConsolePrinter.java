package ua.goit.group09.coreProject.view;

import java.util.List;

/**
 * Provides printing messages to console
 */
public class ConsolePrinter {
    /**
     * prints string message to console
     * @param message       string to print
     */
    public static void printLine(String message) {
        System.out.println(message);
    }

    /**
     * prints given list of strings to console
     * @param lines         List of strings to print
     */
    public static void printLineList(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
