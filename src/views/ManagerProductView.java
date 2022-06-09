package views;

import controllers.ManagerProduct;
import models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManagerProductView extends JFrame {
    private JTable tableProduct;
    private JPanel mainPanel;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPrice;
    private JButton createButton;

    ManagerProduct managerProduct = new ManagerProduct();

    ManagerProductView() {
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        showTable();

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                int price = Integer.parseInt(txtPrice.getText());
                managerProduct.products.add(new Product(id, name, price));
                showTable();
                txtId.setText("");
                txtName.setText("");
                txtPrice.setText("");
            }
        });
    }

    public void showTable() {
        String[] tieuDe = {"ID", "Name", "Price"};
        String[][] data = new String[managerProduct.products.size()][];
        for (int i = 0; i < managerProduct.products.size(); i++) {
            Product product = managerProduct.products.get(i);
            data[i] = new String[]{product.getId() + "", product.getName(), product.getPrice() + ""};
        }
        DefaultTableModel model = new DefaultTableModel(data, tieuDe);
        tableProduct.setModel(model);

    }

    public static void main(String[] args) {
        new ManagerProductView();
    }
}
