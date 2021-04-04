package optional.lab6.panel;

import optional.lab6.frame.MainFrame;

import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JSpinner sidesField;
    JLabel sidesLabel;
    JComboBox colorCombo;
    JSpinner sizeField;
    JLabel sizeLabel;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides

        sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sizeField.setValue(30); //default size

        colorCombo = new JComboBox();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");

        add(sizeLabel);
        add(sizeField);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

}

