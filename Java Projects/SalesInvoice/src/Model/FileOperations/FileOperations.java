package Model.FileOperations;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceHeader;
import Model.Invoice.InvoiceLine;

import java.util.ArrayList;


public interface FileOperations {
    ArrayList <Invoice> read(String headerPath, String linePath);
    ArrayList <InvoiceLine> readInvoiceLines(String path);
    ArrayList <InvoiceHeader> readInvoiceHeaders(String path);
}
