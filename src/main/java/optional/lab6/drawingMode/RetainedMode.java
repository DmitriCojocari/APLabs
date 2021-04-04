package optional.lab6.drawingMode;

import optional.lab6.frame.ShapeTemplateFrame;

import javax.swing.*;
import java.awt.*;

public class RetainedMode {

    public RetainedMode() {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ShapeTemplateFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}



