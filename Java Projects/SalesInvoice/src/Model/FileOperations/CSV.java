package Model.FileOperations;

import Model.Invoice.Invoice;
import Model.Invoice.InvoiceHeader;
import Model.Invoice.InvoiceLine;
import Model.Invoice.globalInvoices;

import java.io.*;
import java.util.ArrayList;

public class CSV implements FileOperations {

    // Why can't I make it private method?
    @Override
    public ArrayList<InvoiceLine> readInvoiceLines(String path) {
        ArrayList <InvoiceLine> lines = new ArrayList<>();
        String line = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                lines.add(InvoiceLine.newLine(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    @Override
    public ArrayList<InvoiceHeader> readInvoiceHeaders(String path) {
        ArrayList <InvoiceHeader> headers = new ArrayList<>();
        String line = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                headers.add(InvoiceHeader.newHeader(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return headers;
    }

    // TODO: Move to controller? probably yes.
    @Override
    public ArrayList<Invoice> read(String headersPath, String linesPath) {
        ArrayList <InvoiceHeader> headers = readInvoiceHeaders(headersPath);
        ArrayList <InvoiceLine> lines = readInvoiceLines(linesPath);

        return Invoice.buildInvoices(headers, lines);
    }


    public void writeInvoiceLines(ArrayList<Invoice> invoices, String linesPath) {
        File linesCSV = new File(linesPath);
        PrintWriter linesWriter = null;

        try {
            linesWriter = new PrintWriter(linesCSV);
            for(Invoice invoice : invoices) {
                for(InvoiceLine line : invoice.getLines()) {
                    linesWriter.println(line.returnAsString());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        linesWriter.close();
    }


    public void writeInvoiceHeaders(ArrayList <Invoice> invoices, String headersPath) {
        PrintWriter headersWriter;
        File linesCSV = new File(headersPath);

        try {
            headersWriter = new PrintWriter(linesCSV);
            for(Invoice invoice : invoices) {
                headersWriter.println(invoice.getHeader().returnAsString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        headersWriter.close();
    }
}