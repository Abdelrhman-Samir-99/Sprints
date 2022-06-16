package Model.Invoice;

import View.GUIFactory;

import javax.swing.*;
import java.util.ArrayList;

public class globalInvoices {
    public static ArrayList <InvoiceHeader> headers = new ArrayList<>();
    public static ArrayList <InvoiceLine> lines = new ArrayList<>();

    public static ArrayList <Invoice> invoices = new ArrayList<>();
    public static Invoice currentSelectedInvoice = new Invoice();
    public static int currentSelectedInvoiceIndex = -1;
    public static InvoiceHeader currentNewHeader;
}
