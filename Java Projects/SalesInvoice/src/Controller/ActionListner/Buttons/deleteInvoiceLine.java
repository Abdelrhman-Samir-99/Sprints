package Controller.ActionListner.Buttons;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceLine;
import Model.Invoice.globalInvoices;
import View.staticData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteInvoiceLine implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(globalInvoices.currentSelectedInvoiceIndex == -1) {
            System.out.println("Please Select an Invoice First.");
            return;
        }

        if(globalInvoices.currentSelectedInvoice.getLines().isEmpty()) {
            return;
        }

        int currentRow = staticData.Interface.invoiceLines.getSelectedRow();
        globalInvoices.lines.remove(currentRow);

        if(globalInvoices.lines != null) {
            staticData.Interface.fillLinesTable(globalInvoices.lines);
        }
    }
}
