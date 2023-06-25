package mgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ProductManager extends JFrame {
    private final List<Product> products = new ArrayList<>();
    private final JList<Product> productList = new JList<>();
    private final JTextField idField = new JTextField(10);
    private final JTextField nameField = new JTextField(10);
    private final JTextField priceField = new JTextField(10);
    private final JTextField quantityField = new JTextField(10);

    public ProductManager() {
        super("商品库存管理系统");

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 创建商品列表面板
        JPanel productListPanel = new JPanel(new BorderLayout());
        productListPanel.setBorder(BorderFactory.createTitledBorder("商品列表"));
        productListPanel.add(new JScrollPane(productList), BorderLayout.CENTER);
        mainPanel.add(productListPanel, BorderLayout.CENTER);

        // 创建商品信息面板
        JPanel productFormPanel = new JPanel(new GridLayout(4, 2));
        productFormPanel.setBorder(BorderFactory.createTitledBorder("商品信息"));

        productFormPanel.add(new JLabel("编号:"));
        productFormPanel.add(idField);

        productFormPanel.add(new JLabel("名称:"));
        productFormPanel.add(nameField);

        productFormPanel.add(new JLabel("价格:"));
        productFormPanel.add(priceField);

        productFormPanel.add(new JLabel("数量:"));
        productFormPanel.add(quantityField);

        mainPanel.add(productFormPanel, BorderLayout.SOUTH);

        // 创建按钮面板
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4));

        // 添加按钮
        JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        buttonsPanel.add(addButton);

        // 更新按钮
        JButton updateButton = new JButton("更新");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });
        buttonsPanel.add(updateButton);

        // 删除按钮
        JButton deleteButton = new JButton("删除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });
        buttonsPanel.add(deleteButton);

        // 清空按钮
        JButton clearButton = new JButton("清空");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAllProducts();
            }
        });
        buttonsPanel.add(clearButton);

        // 保存按钮
        JButton saveButton = new JButton("保存");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });
        buttonsPanel.add(saveButton);

        mainPanel.add(buttonsPanel, BorderLayout.NORTH);

        // 将主面板设置为内容面板
        setContentPane(mainPanel);

        // 为商品列表添加双击事件监听器
        productList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 双击事件
                    int index = productList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Product product = productList.getModel().getElementAt(index);
                        idField.setText(Integer.toString(product.getId()));
                        nameField.setText(product.getName());
                        priceField.setText(Double.toString(product.getPrice()));
                        quantityField.setText(Integer.toString(product.getQuantity()));
                    }
                }
            }
        });

        // 设置窗口
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 添加商品
    private void addProduct() {
        if (isInputEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入商品信息。");
            return;
        }
        int id = Integer.parseInt(idField.getText());
        if (isIdExist(id)) { // 判断编号是否已存在
            JOptionPane.showMessageDialog(this, "商品编号已存在，请重新输入。");
            return;
        }
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        Product product = new Product(id, name, price, quantity);
        products.add(product);
        productList.setListData(products.toArray(new Product[0]));
        clearInputFields();
    }

    // 更新商品
    private void updateProduct() {
        if (isInputEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入商品信息。");
            return;
        }
        int index = productList.getSelectedIndex();
        if (index == -1) { // 判断是否选择了商品
            JOptionPane.showMessageDialog(this, "请选择要更新的商品。");
            return;
        }
        int id = Integer.parseInt(idField.getText());
        if (isIdExist(id, index)) { // 判断编号是否已存在
            JOptionPane.showMessageDialog(this, "商品编号已存在，请重新输入。");
            return;
        }
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        // 获取要更新的商品并更新
        Product product = products.get(index);
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        productList.setListData(products.toArray(new Product[0]));
        clearInputFields();
    }

    // 删除商品
    private void deleteProduct() {
        int index = productList.getSelectedIndex();
        if (index == -1) { // 判断是否选择了商品
            JOptionPane.showMessageDialog(this, "请选择要删除的商品。");
            return;
        }
        products.remove(index);
        productList.setListData(products.toArray(new Product[0]));
        clearInputFields();
    }

    // 删除所有商品
    private void deleteAllProducts() {
        int result = JOptionPane.showConfirmDialog(this, "您确定要删除所有商品吗？", "删除所有商品", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            products.clear();
            productList.setListData(products.toArray(new Product[0]));
            clearInputFields();
        }
    }

    // 保存数据至文件
    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("ID,Name,Price,Quantity"); // 写入CSV文件头
                for (Product product : products) {
                    writer.printf("%d,%s,%.2f,%d%n", product.getId(), product.getName(), product.getPrice(), product.getQuantity()); // 写入商品数据
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "保存文件失败。");
            }
        }
    }

    // 判断编号是否已存在
    private boolean isIdExist(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // 判断编号是否已存在，排除当前商品
    private boolean isIdExist(int id, int current) {
        for (int i = 0; i < products.size(); i++) {
            if (i != current && products.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    // 判断输入框是否为空
    private boolean isInputEmpty() {
        return idField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() || priceField.getText().trim().isEmpty() || quantityField.getText().trim().isEmpty();
    }

    // 清空输入框
    private void clearInputFields() {
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        new ProductManager();
    }
}