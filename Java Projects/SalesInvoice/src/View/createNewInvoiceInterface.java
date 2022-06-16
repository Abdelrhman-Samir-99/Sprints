package View;

import Controller.ActionListner.Buttons.createNewInvoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createNewInvoiceInterface {

    public static JTextField customerText, dateText;
    public static JFrame createNewInterface() {
        JFrame frame = new JFrame("New Invoice");
        frame.setSize(600, 100);
        frame.setLayout(new FlowLayout());

        JLabel customerNameLabel = new JLabel("Customer Name");
        JLabel DateLabel = new JLabel("Date");

        customerText = new JTextField(20);
        dateText = new JTextField(10);


        JButton createButton = new JButton("Create");
        createButton.addActionListener(new createNewInvoice());

        frame.add(customerNameLabel);
        frame.add(customerText);
        frame.add(DateLabel);
        frame.add(dateText);
        frame.add(createButton);
        frame.setVisible(true);
        return frame;
    }

}
