package JavaDevelopmentKit.Lesson1.Server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JPanel panelTop = new JPanel(new GridLayout(1, 2));
    private final JPanel panelBottom = new JPanel();
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea(20, 15);

    private boolean isServerWorking;

    ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking == false) {
                    System.out.println("Server isn't running " + "\n");
                    log.append("Server isn't running " + "\n");
                } else
                    System.out.println("Server stopped " + "\n");
                    log.append("Server stopped " + "\n");
                isServerWorking = false;
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking == true) {
                    System.out.println("Server is already running " + "\n");
                    log.append("Server is already running " + "\n");
                } else
                    System.out.println("Server started " + "\n");
                    log.append("Server started " + "\n");
                isServerWorking = true;
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        panelTop.add(btnStart);
        panelTop.add(btnStop);
        add(panelTop, BorderLayout.NORTH);
        panelBottom.add(log);
        add(panelBottom, BorderLayout.SOUTH);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        setVisible(true);
    }
}
