package optional.lab6.frame;

import optional.lab6.figure.EllipseTemplate;
import optional.lab6.figure.LineTemplate;
import optional.lab6.figure.RectangleTemplate;
import optional.lab6.figure.ShapeTemplate;
import optional.lab6.panel.ShapePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeTemplateFrame extends JFrame {

    public ShapeTemplateFrame() {
        setTitle("Retained Mode");

        Container contentPane = getContentPane();

        final ShapePanel panel = new ShapePanel();
        contentPane.add(panel, BorderLayout.CENTER);
        final JComboBox comboBox = new JComboBox();
        comboBox.addItem("Line");
        comboBox.addItem("Rectangle");
        comboBox.addItem("Circle");

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String selectedOption = (String) comboBox.getSelectedItem();
                ShapeTemplate shapeTemplate = new LineTemplate();
                switch (selectedOption) {
                    case "Line":
                        shapeTemplate = new LineTemplate();
                        break;
                    case "Rectangle":
                        shapeTemplate = new RectangleTemplate();
                        break;
                    case "Circle":
                        shapeTemplate = new EllipseTemplate();
                        break;
                    default:
                        break;
                }
                panel.setShapeMaker(shapeTemplate);
            }
        });

        contentPane.add(comboBox, BorderLayout.NORTH);
        pack();
    }

}
