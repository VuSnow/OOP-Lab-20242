package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel centerPanel;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(centerPanel = createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowskis", 136, 19.99f);
        CompactDisc cd1 = new CompactDisc("Abbey Road", "The Beatles", 20.00f);
        cd1.addTrack(new Track("Come Together", 4));
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 29.99f);
        book1.addAuthor("J.K. Rowling");

        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book1);


        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                refreshCenterPanel();
            }
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddBookToStoreScreen(store, StoreManagerScreen.this);
            }
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddCompactDiscToStoreScreen(store, StoreManagerScreen.this);
            }
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddDigitalVideoDiscToStoreScreen(store, StoreManagerScreen.this);
            }
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(450, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            if (i < mediaInStore.size()) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else {
                center.add(new JPanel());
            }
        }

        return center;
    }

    private void refreshCenterPanel() {
        getContentPane().remove(centerPanel);
        centerPanel = createCenter();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}