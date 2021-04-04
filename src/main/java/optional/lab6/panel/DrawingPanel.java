package optional.lab6.panel;

import optional.lab6.figure.RegularPolygon;
import optional.lab6.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) frame.getConfigPanel().sizeField.getValue();
        int sides = (int) frame.getConfigPanel().sidesField.getValue();
        String selectedColour = (String) frame.getConfigPanel().colorCombo.getSelectedItem();

        if ("Black".equals(selectedColour)) {
            graphics.setColor(Color.BLACK);
        } else {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color color = new Color(r, g, b);
            graphics.setColor(color);
        }
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
