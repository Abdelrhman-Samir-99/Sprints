package View;

import Controller.ActionListner.Buttons.createNewInvoice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GUIFactory {
    public static JFrame createJFrame(String title, boolean visible, int width, int height, int x, int y) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        return frame;
    }

    public static JButton createJButton(String title, int x, int y) {
        JButton button = new JButton(title);
        button.setLocation(x, y);
        button.setLayout(new FlowLayout());
        return button;
    }

    public static JTextField createJTextField(String title) {
        JTextField textField = new JTextField(title);
        textField.setLayout(new FlowLayout());
        return textField;
    }

    public static JLabel createJLabel(String title) {
        JLabel label = new JLabel();
        return label;
    }

    public static JTable createTableFrame(String[] headers, String[][] content) {
        JTable table = new JTable(new DefaultTableModel(content, headers));

        return table;
    }

    public static JMenuItem createJMenuItem(String name) {
        return new JMenuItem(name);
    }

    public static JMenu createJMenu(String name, ArrayList <JMenuItem> menuItems) {
        JMenu menu = new JMenu(name);
        for(JMenuItem item : menuItems) {
            menu.add(item);
        }
        return menu;
    }

    public static JMenuBar createMenuBar(ArrayList <JMenu> menus) {
        JMenuBar menuBar = new JMenuBar();
        for(JMenu menu : menus) {
            menuBar.add(menu);
        }
        return menuBar;
    }

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        return new JPanel();
    }

    public static JPanel createPanelWithButtons(ArrayList <JButton> buttons) {
        JPanel panel = createPanel();
        for(JButton button : buttons) {
            panel.add(button);
        }
        return panel;
    }
}
