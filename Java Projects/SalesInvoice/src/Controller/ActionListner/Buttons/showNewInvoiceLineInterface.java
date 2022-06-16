package Controller.ActionListner.Buttons;

import Model.Invoice.globalInvoices;
import View.createNewInvoiceLineInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showNewInvoiceLineInterface implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(globalInvoices.currentSelectedInvoiceIndex == -1) {
            System.out.println("Please Select an Invoice First.");
            return;
        }
        JFrame frame = createNewInvoiceLineInterface.createNewInterface();
    }
}
