package lesson5;

import java.io.File;

public class ShowFiles {
    public static void main(String[] args) {
        File file = new File("D:\\Java\\Projects\\Algorithm");
        viewFiles(file);
    }

    private static void viewFiles(File file, int level) {
        StringBuilder prefix = new StringBuilder().append(" ".repeat(level));
        if (file.isFile()) {
            System.out.println(prefix + "File: " + file.getName());
        } else {
            System.out.println(prefix + "Dir: " + file.getName());
            level++;
            for (File listFile : file.listFiles()) {
                viewFiles(listFile, level);
            }
        }
    }

    private static void viewFiles(File file) {
        viewFiles(file, 0);
    }
}
