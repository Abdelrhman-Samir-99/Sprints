package Controller.ActionListner.Buttons;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceHeader;
import Model.Invoice.globalInvoices;
import View.GUIFactory;
import View.createNewInvoiceInterface;
import View.staticData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class createNewInvoice implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {


        // TODO: How to pause this Frame until the next frame is close?

        int InvoiceNumber = globalInvoices.invoices.size() + 1;
        globalInvoices.currentNewHeader = new InvoiceHeader(InvoiceNumber,
                                                        createNewInvoiceInterface.customerText.getText(),
                                                        createNewInvoiceInterface.dateText.getText());

        Invoice newInvoice = new Invoice(globalInvoices.currentNewHeader, new ArrayList<>());
        globalInvoices.invoices.add(newInvoice);
        staticData.Interface.addLastInvoice(newInvoice);

    }
}
