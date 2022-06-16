package View;

import Controller.ActionListner.Buttons.createNewInvoice;
import Controller.ActionListner.Buttons.createNewInvoiceLine;

import javax.swing.*;
import java.awt.*;

public class createNewInvoiceLineInterface {
    public static JTextField itemNameText, itemPriceText, itemCountText;

    public static JFrame createNewInterface() {
        JFrame frame = new JFrame("New Invoice Line");
        frame.setSize(800, 100);
        frame.setLayout(new FlowLayout());

        JLabel itemNameLabel = new JLabel("Item Name");
        JLabel itemPriceLabel = new JLabel("Item Price");
        JLabel itemCountLabel = new JLabel("Item Price");

        itemNameText = new JTextField(20);
        itemPriceText = new JTextField(10);
        itemCountText = new JTextField(10);


        JButton createButton = new JButton("Create");
        createButton.addActionListener(new createNewInvoiceLine());
        frame.add(itemNameLabel);
        frame.add(itemNameText);
        frame.add(itemPriceLabel);
        frame.add(itemPriceText);
        frame.add(itemCountLabel);
        frame.add(itemCountText);

        frame.add(createButton);
        frame.setVisible(true);
        return frame;
    }
}
