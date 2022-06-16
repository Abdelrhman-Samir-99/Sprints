package Controller.ActionListner.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Invoice.Invoice;
import Model.Invoice.globalInvoices;
import View.staticData;

public class deleteInvoice implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(globalInvoices.currentSelectedInvoice == null) {
            System.out.println("Select an Invoice first.");
            return;
        }

        Invoice invoice = globalInvoices.currentSelectedInvoice;
        globalInvoices.invoices.remove(invoice);
        globalInvoices.currentSelectedInvoice = null;

        if(globalInvoices.invoices != null) {
            staticData.Interface.fillHeaderTable(globalInvoices.invoices);
        }
    }
}