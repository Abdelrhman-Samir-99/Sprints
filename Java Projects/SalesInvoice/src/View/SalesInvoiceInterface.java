package View;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceHeader;
import Model.Invoice.InvoiceLine;
import Model.Invoice.globalInvoices;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class SalesInvoiceInterface {
    JFrame mainScreen;
    JMenuBar menuBar;
    ArrayList <JButton> buttons;

    public JTable invoiceHeaders, invoiceLines;
    String[] InvoiceHeaderTitles = {"Invoice Number", "Customer Name", "Date", "Total"};
    String[] InvoiceLineTitles = {"Invoice Number", "Item Name", "Item Price", "Count", "Total"};


    public SalesInvoiceInterface(JFrame mainScreen, JMenuBar menuBar, ArrayList<JButton> buttons, JTable invoiceHeaders, JTable invoiceLines) {
        this.mainScreen = mainScreen;
        this.menuBar = menuBar;
        this.buttons = buttons;
        this.invoiceHeaders = invoiceHeaders;
        this.invoiceLines = invoiceLines;
        this.build();
        this.mainScreen.setVisible(true);
    }

    public SalesInvoiceInterface() {
    }

    private void build() {
        this.addButtons();
        this.addMenus();
        this.addTable();
    }

    public void addLastInvoice(Invoice invoice) {
        DefaultTableModel model = (DefaultTableModel) invoiceHeaders.getModel();
        String[] currentRow = invoice.getHeader().parse();
        String[] row = {currentRow[0], currentRow[1], currentRow[2], "0"};
        model.addRow(row);
    }


    public void addLastInvoiceLine(InvoiceLine invoiceLine) {
        DefaultTableModel model = (DefaultTableModel) invoiceLines.getModel();
        model.addRow(invoiceLine.parse());
    }
    private void addTable() {
        mainScreen.add(new JScrollPane(invoiceHeaders));
        mainScreen.add(new JScrollPane(invoiceLines));
        clearTableData((DefaultTableModel)invoiceHeaders.getModel());

        invoiceHeaders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int currentRow = invoiceHeaders.getSelectedRow();
                String invoiceNumber = (String) invoiceHeaders.getValueAt(currentRow, 0);
                globalInvoices.currentSelectedInvoiceIndex = currentRow;

                if(globalInvoices.invoices == null) {
                    return;
                }

                // TODO: optimize it later.
                int cnt = 0;
                for(Invoice invoice : globalInvoices.invoices) {
                    if(invoice.getHeader().getInvoiceNumber() == Integer.parseInt(invoiceNumber)) {
                        staticData.Interface.fillLinesTable(invoice.getLines());
                        globalInvoices.lines = invoice.getLines();
                        globalInvoices.currentSelectedInvoice = invoice;
                        globalInvoices.currentSelectedInvoiceIndex = cnt;
                        break;
                    }
                    ++cnt;
                }
            }
        });
    }
    private void addButtons() {
        for(JButton button : buttons) {
            mainScreen.add(button);
        }
    }

    private void addMenus() {
        mainScreen.setJMenuBar(menuBar);
    }

    private void clearTableData(DefaultTableModel model) {
        // clear the rows and columns
        for(int i = model.getRowCount() - 1; i > -1; --i) {
            model.removeRow(i);
        }
    }


    public void fillHeaderTable(ArrayList <Invoice> invoices) {
        DefaultTableModel model = (DefaultTableModel) invoiceHeaders.getModel();
        clearTableData(model);
        clearTableData((DefaultTableModel) invoiceLines.getModel());

        for(Invoice invoice: invoices) {
            // TODO: find a better way to add the total.
            String[] headerInfo = invoice.getHeader().parse();
            ArrayList<String> currentRow = new ArrayList<>();
            for(String c : headerInfo) {
                currentRow.add(c);
            }
            Double heyyy = invoice.getTotalPrice();
            String total = Double.toString(heyyy);
            currentRow.add(total);
            String[] row = new String[currentRow.size()];
            for(int i = 0; i < currentRow.size(); ++i) {
                row[i] = currentRow.get(i);
            }
            model.addRow(row);
        }
    }

    public void fillLinesTable(ArrayList <InvoiceLine> lines) {
        DefaultTableModel model = (DefaultTableModel) invoiceLines.getModel();
        clearTableData(model);

        for(InvoiceLine line: lines) {
            model.addRow(line.parse());
        }
    }
}