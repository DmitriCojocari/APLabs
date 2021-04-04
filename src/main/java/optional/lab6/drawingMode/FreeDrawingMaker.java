package optional.lab6.drawingMode;

import optional.lab6.canvas.DrawingCanvas;

import javax.swing.*;
import java.awt.*;

public class FreeDrawingMaker extends JFrame {

    public FreeDrawingMaker() {
        Canvas drawingCanvas = new DrawingCanvas();
        drawingCanvas.setBackground(Color.LIGHT_GRAY);
        add("Center", drawingCanvas);

        setTitle("Free Drawing Mode");
        setSize(400, 450);
        setVisible(true);
    }

}

