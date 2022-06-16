package Model.Invoice;

public class InvoiceHeader {
    String customerName;
    String invoiceDate;
    int invoiceNumber;

    public InvoiceHeader() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public InvoiceHeader(int invoiceNumber, String customerName, String invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public static InvoiceHeader newHeader(String[] values) {
        return new InvoiceHeader(Integer.parseInt(values[0]), values[1], values[2]);
    }

    public String[] parse() {
        return new String[] {Integer.toString(invoiceNumber), customerName, invoiceDate };
    }

    public String returnAsString() {return String.valueOf(invoiceNumber) + ',' + customerName + ',' + invoiceDate; }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                ", invoiceNumber=" + invoiceNumber + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                "customerName='" + customerName +
                '}';
    }
}