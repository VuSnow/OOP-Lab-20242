package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.Book;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, StoreManagerScreen storeManagerScreen) {
        super(store, storeManagerScreen);
        setTitle("Add Book to Store");
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JTextField titleField = new JTextField(20);
        JTextField categoryField = new JTextField(20);
        JTextField costField = new JTextField(20);
        JTextField authorsField = new JTextField(20);

        center.add(new JLabel("Title:"));
        center.add(titleField);
        center.add(new JLabel("Category:"));
        center.add(categoryField);
        center.add(new JLabel("Cost:"));
        center.add(costField);
        center.add(new JLabel("Authors:"));
        center.add(authorsField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String[] authors = authorsField.getText().split(",");

            Book book = new Book(title, category, cost, new ArrayList<>(Arrays.asList(authors)));
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added!");
        });

        center.add(addButton);
        return center;

    }

}
