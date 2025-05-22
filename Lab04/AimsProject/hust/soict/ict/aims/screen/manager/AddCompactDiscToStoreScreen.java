package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.Track;

import javax.swing.*;
import java.awt.*;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen storeManagerScreen) {
        super(store, storeManagerScreen);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel[] labels = {
                new JLabel("ID: "),
                new JLabel("Title: "),
                new JLabel("Category: "),
                new JLabel("Cost: "),
                new JLabel("Length: "),
                new JLabel("Director: "),
                new JLabel("Artist: "),
                new JLabel("Tracks (title:length,...): ")
        };

        JTextField tfID = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfTracks = new JTextField();

        JTextField[] textFields = {
                tfID, tfTitle, tfCategory, tfCost,
                tfLength, tfDirector, tfArtist, tfTracks
        };

        for (int i = 0; i < labels.length; i++) {
            center.add(labels[i]);
            center.add(textFields[i]);
        }

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                CompactDisc cd = new CompactDisc(
                        tfTitle.getText(),
                        tfCategory.getText(),
                        Float.parseFloat(tfCost.getText())
                );

                String[] tracks = tfTracks.getText().split(",");
                for (String trackStr : tracks) {
                    String[] parts = trackStr.split(":");
                    if (parts.length == 2) {
                        String trackTitle = parts[0].trim();
                        int trackLength = Integer.parseInt(parts[1].trim());
                        cd.addTrack(new Track(trackTitle, trackLength));
                    }
                }

                store.addMedia(cd);
                JOptionPane.showMessageDialog(null, "CD added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage());
            }
        });

        center.add(btnAdd);

        return center;
    }

}
