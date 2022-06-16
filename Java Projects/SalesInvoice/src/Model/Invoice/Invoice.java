package Model.Invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    InvoiceHeader header;
    ArrayList<InvoiceLine> lines;

    Double totalPrice;


    public Invoice(InvoiceHeader header, ArrayList<InvoiceLine> lines) {
        this.header = header;
        this.lines = lines;
        this.totalPrice = 0.0;
    }

    public Invoice() {

    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
    // TODO: should I change the return type to boolean?
    public void addInvoiceLine(InvoiceLine line) {
        this.lines.add(line);
    }

    public Double addToTotal(Double price) {
        this.totalPrice += price;
        return this.totalPrice;
    }


    public static ArrayList <Invoice> buildInvoices(ArrayList <InvoiceHeader> headers, ArrayList <InvoiceLine> lines) {
        ArrayList <Invoice> invoices = new ArrayList<>();
        // using invoiceNumber to determine the index of its header.
        // MUST be unique.
        Map <Integer, Integer> invoiceHeaderIndex = new HashMap<>();

        for(InvoiceHeader header : headers) {
            invoices.add(new Invoice(header, new ArrayList<>()));
            int invoiceNumber = header.getInvoiceNumber();
            invoiceHeaderIndex.put(invoiceNumber, invoices.size() - 1);
        }

        for(InvoiceLine line : lines) {
            int invoiceNumber = line.getInvoiceNumber();
            int invoiceIndex = invoiceHeaderIndex.get(invoiceNumber);
            invoices.get(invoiceIndex).addInvoiceLine(line);
            invoices.get(invoiceIndex).addToTotal(line.getItemPrice() * line.getCount());
        }

        // testing
        for(Invoice invoice : invoices) {
            System.out.println(invoice);
        }

        return invoices;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "header=" + header +
                ", lines=" + lines +
                '}';
    }
}
