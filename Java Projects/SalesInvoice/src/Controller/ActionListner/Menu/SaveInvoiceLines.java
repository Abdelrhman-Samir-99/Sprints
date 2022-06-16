package Controller.ActionListner.Menu;

import Model.FileOperations.CSV;
import Model.Invoice.globalInvoices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveInvoiceLines implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String path = FileActions.read();
        if(path == "") {
            return;
        }

        new CSV().writeInvoiceLines(globalInvoices.invoices, path);
    }
}
