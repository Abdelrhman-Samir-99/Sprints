package Model.Invoice;

public class InvoiceLine {
    String itemName;
    Double itemPrice;
    int invoiceNumber;
    int count;

    Double totalPrice;

    public InvoiceLine() {
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public int getCount() {
        return count;
    }

    public InvoiceLine(int invoiceNumber, String itemName, Double itemPrice, int count) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.invoiceNumber = invoiceNumber;
        this.count = count;
        this.totalPrice = count * itemPrice;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public static InvoiceLine newLine(String[] values) {
        return new InvoiceLine(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]), Integer.parseInt(values[3]));
    }

    public String[] parse() {
        return new String[] {Integer.toString(invoiceNumber), itemName, Double.toString(itemPrice), Integer.toString(count),
                                Double.toString(totalPrice)};
    }

    public String returnAsString() {return String.valueOf(invoiceNumber) + ',' + itemName + ',' + String.valueOf(itemPrice) + ',' +
                                    String.valueOf(count) + ',' + String.valueOf(totalPrice); }


    @Override
    public String toString() {
        return "InvoiceLine{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", count=" + count +
                ", invoiceNumber=" + invoiceNumber +
                '}';
    }
}