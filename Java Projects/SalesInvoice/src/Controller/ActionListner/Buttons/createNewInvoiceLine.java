package Controller.ActionListner.Buttons;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceLine;
import Model.Invoice.globalInvoices;
import View.createNewInvoiceLineInterface;
import View.staticData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createNewInvoiceLine implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: How to pause this Frame until the next frame is close?
        if(globalInvoices.currentSelectedInvoiceIndex == -1) {
            System.out.println("Select an Invoice first.");
            return;
        }

        int invoiceNumber = globalInvoices.currentSelectedInvoice.getHeader().getInvoiceNumber();
        InvoiceLine newLine = new InvoiceLine(invoiceNumber,
                createNewInvoiceLineInterface.itemNameText.getText(),
                Double.parseDouble(createNewInvoiceLineInterface.itemPriceText.getText()),
                Integer.parseInt(createNewInvoiceLineInterface.itemCountText.getText()));

        globalInvoices.invoices.get(globalInvoices.currentSelectedInvoiceIndex).getLines().add(newLine);
        globalInvoices.currentSelectedInvoice = globalInvoices.invoices.get(globalInvoices.currentSelectedInvoiceIndex);
        staticData.Interface.addLastInvoiceLine(newLine);
    }
}
