package lecture14;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copyfile {

    private static void showPane(String message) {

        JPanel errorPanel = new JPanel();
        errorPanel.setOpaque(true);
        JOptionPane.showMessageDialog(errorPanel, message, "", JOptionPane.INFORMATION_MESSAGE);
        errorPanel.repaint();
    }

    private static void copyFile(File source, File dest) {

        FileInputStream ins;
        FileOutputStream outs;
        try {

            ins = new FileInputStream(source);
            outs = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = ins.read(buffer)) > 0) {
                outs.write(buffer, 0, length);
            }
            ins.close();
            outs.flush();
            outs.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            showPane(ioe.toString());
        }
    }

    public static void main(String[] args) {
        File file1 = new File("D:\\download\\123.txt");
        File file2 = new File("D:\\download\\новая папка\\123.txt");
        copyFile(file1, file2);
    }
}
