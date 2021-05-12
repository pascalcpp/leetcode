package com.xpcf.algorithm;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/11/2021 6:46 PM
 */
public class MyFrame extends Frame {
    private int x = 100;
    private int y = 100;
    private static final int SPEED = 10;

    public MyFrame() {
        super("hello");
        this.setVisible(true);
        this.setLocation(200, 200);
        this.setSize(800, 600);
        this.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_LEFT:
                                x -= SPEED;
                                break;
                            case KeyEvent.VK_RIGHT:
                                x += SPEED;
                                break;
                            case KeyEvent.VK_UP:
                                y -= SPEED;
                                break;
                            case KeyEvent.VK_DOWN:
                                y += SPEED;
                                break;
                        }
                    }
                }
        );
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public void update(Graphics g) {

        paint(g);
    }
}
