package optional.lab6.panel;

import optional.lab6.drawingMode.FreeDrawingMaker;
import optional.lab6.drawingMode.RetainedMode;
import optional.lab6.frame.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {

    final MainFrame frame;

    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton freeModeBtn = new JButton("Free Mode");
    JButton retainedBtn = new JButton("Retained Mode");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 6));
        add(freeModeBtn);
        add(retainedBtn);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        freeModeBtn.addActionListener(this::freeMode);
        retainedBtn.addActionListener(this::retainedMode);
    }

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("src/main/java/compulsory/lab6/resources"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ImageIO.write(frame.getCanvas().image, "PNG", selectedFile);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        if (e.getSource() == loadBtn) {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("src/main/java/compulsory/lab6/resources"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    this.frame.getCanvas().getGraphics().drawImage(ImageIO.read(selectedFile), 0, 0, this);
                }

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void reset(ActionEvent e) {
        if (e.getSource() == resetBtn) {
            frame.getCanvas().graphics.setColor(Color.WHITE);
            frame.getCanvas().graphics.fillRect(0, 0, 800, 600);
            frame.getCanvas().repaint();
        }
    }

    private void exit(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    private void freeMode(ActionEvent e) {
      if (e.getSource() == freeModeBtn)  {
          new FreeDrawingMaker();
      }
    }

    private void retainedMode(ActionEvent e) {
        if (e.getSource() == retainedBtn) {
            new RetainedMode();
        }
    }

}

