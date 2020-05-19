package com.company.chessboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class PicJpanel extends JPanel {
    MyJpanel mj;

    public PicJpanel(MyJpanel mj) {
        // 设定面板在窗体中的位置以及高度和宽度
        this.setBounds(0, 0, mj.getWidth(), mj.getHeight());
        this.mj = mj;
    }

    /**
     * 画组件
     */
    @Override
    protected void paintComponent(Graphics g) {

        try {
            BufferedImage bi = ImageIO.read(new File("img/bj.jpg"));
            g.drawImage(bi, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int map[][] = mj.map;

        g.setColor(Color.BLACK);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                g.drawRect(50 * i, 50 * j, 50, 50);
                // 1为白
                if (map[i][j] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(50 * j, 50 * i, 50, 50);
                }
                g.setColor(Color.black);
                // 2为黑
                if (map[i][j] == 2) {
                    g.setColor(Color.black);
                    g.fillOval(50 * j, 50 * i, 50, 50);
                }
            }
        }

    }

}
