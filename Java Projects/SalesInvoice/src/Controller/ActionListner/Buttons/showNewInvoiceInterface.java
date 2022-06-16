package Controller.ActionListner.Buttons;

import View.GUIFactory;
import View.createNewInvoiceInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showNewInvoiceInterface implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = createNewInvoiceInterface.createNewInterface();
    }
}
