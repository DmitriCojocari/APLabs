package optional.lab6.frame;

import optional.lab6.panel.ConfigPanel;
import optional.lab6.panel.ControlPanel;
import optional.lab6.panel.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_END);

        //invoke the layout manager
        pack();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public void setCanvas(DrawingPanel canvas) {
        this.canvas = canvas;
    }
}