import Controller.ActionListner.Buttons.*;
import Controller.ActionListner.Menu.LoadInvoiceHeaders;
import Controller.ActionListner.Menu.LoadInvoiceLines;
import Controller.ActionListner.Menu.SaveInvoiceHeaders;
import Controller.ActionListner.Menu.SaveInvoiceLines;
import View.GUIFactory;
import View.SalesInvoiceInterface;
import View.staticData;

import javax.swing.*;
import java.util.ArrayList;




public class Main {

    public static void main(String[] args) {
        // All buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(GUIFactory.createJButton("Create New InvoiceHeader", 50, 50));
        buttons.get(0).addActionListener(new showNewInvoiceInterface());
        buttons.add(GUIFactory.createJButton("Delete InvoiceHeader", 100, 100));
        buttons.get(1).addActionListener(new deleteInvoice());
        buttons.add(GUIFactory.createJButton("Create New InvoiceLine", 100, 100));
        buttons.get(2).addActionListener(new showNewInvoiceLineInterface());
        buttons.add(GUIFactory.createJButton("Delete InvoiceLine", 100, 100));
        buttons.get(3).addActionListener(new deleteInvoiceLine());

        // All menu items
        ArrayList <JMenuItem> menuItems = new ArrayList<>();
        menuItems.add(GUIFactory.createJMenuItem("Load InvoiceHeaders"));
        menuItems.get(0).addActionListener(new LoadInvoiceHeaders());
        menuItems.add(GUIFactory.createJMenuItem("Load InvoiceLines"));
        menuItems.get(1).addActionListener(new LoadInvoiceLines());
        menuItems.add(GUIFactory.createJMenuItem("Save InvoiceHeaders"));
        menuItems.get(2).addActionListener(new SaveInvoiceHeaders());
        menuItems.add(GUIFactory.createJMenuItem("Save InvoiceLines"));
        menuItems.get(3).addActionListener(new SaveInvoiceLines());


        // making a menu
        ArrayList <JMenu> menu = new ArrayList<>();
        menu.add(GUIFactory.createJMenu("File", menuItems));

        // making a menu bar
        JMenuBar menuBar = GUIFactory.createMenuBar(menu);


        String[] InvoiceHeaderTitles = {"Invoice Number", "Customer Name", "Date", "Total"};
        String[] InvoiceLineTitles = {"Invoice Number", "Item Name", "Item Price", "Count", "Total"};

        String[][] empty1 = {{"", "", ""}};
        String[][] empty2 = {{"", "", "", "", ""}};

        JTable invoiceLines = GUIFactory.createTableFrame(InvoiceLineTitles, empty2);

        JTable invoiceHeaders = GUIFactory.createTableFrame(InvoiceHeaderTitles, empty1);


        staticData.Interface = new SalesInvoiceInterface(
                                        GUIFactory.createJFrame("Sales Invoices", true,
                                                                1000, 700, 150, 50)
                                        , menuBar, buttons, invoiceHeaders, invoiceLines);

    }
}