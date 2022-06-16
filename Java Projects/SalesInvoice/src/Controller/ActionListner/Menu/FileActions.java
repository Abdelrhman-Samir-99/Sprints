package Controller.ActionListner.Menu;

import javax.swing.*;

public class FileActions {
    public static String read() {
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showSaveDialog(null);
        String path = response == 0 ? fileChooser.getSelectedFile().getAbsolutePath() : "";

        return path;
    }
}
