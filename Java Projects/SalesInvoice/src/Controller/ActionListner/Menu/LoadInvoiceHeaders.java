package Controller.ActionListner.Menu;


import Model.FileOperations.CSV;
import Model.Invoice.Invoice;
import Model.Invoice.globalInvoices;
import View.SalesInvoiceInterface;
import View.staticData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadInvoiceHeaders implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String path = FileActions.read();
        if(path == "") {
            return;
        }
        globalInvoices.headers = new CSV().readInvoiceHeaders(path);

        if(globalInvoices.lines != null) {
            globalInvoices.invoices = Invoice.buildInvoices(globalInvoices.headers, globalInvoices.lines);
            staticData.Interface.fillHeaderTable(globalInvoices.invoices);
        }
    }
}
