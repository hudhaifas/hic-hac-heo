package com.wajatto.game.hichacheo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class GamePanel
        extends JPanel {

    public GamePanel() {

        boards = new int[4][4][4];
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                for (int l = 0; l < boards[i][j].length; l++) {
                    boards[i][j][l] = 0;
                }
            }
        }

        playerX = true;
        stop = false;
        oWon = false;
        result = "";

        setGeneralPath();
        addMouseListener(new GameMouseAdapter(this));
        addHComputer();
        setBackground(Color.WHITE);

    } // end constructor

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        shape.moveTo(xPoints[0], yPoints[0]);

        for (int j = 0; j < xPoints.length; j++) {
            shape.lineTo(xPoints[j], yPoints[j]);
        }

        shape.closePath();

        g2d.translate(100, 50);
        g2d.setColor(new Color(240, 235, 235));
        g2d.setStroke(new BasicStroke(3f));
        g2d.fill(shape);
        g2d.setColor(new Color(220, 205, 205));
        g2d.draw(shape);
        g2d.drawLine(192, 144, 192, 625);
        g2d.drawLine(0, 144, 0, 625);
        g2d.drawLine(183, 144, 183, 165);
        g2d.drawLine(9, 144, 9, 165);

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5f));
        for (int h = 0; h < lines.length; h++) {
            g2d.draw(lines[h]);
        }

        g2d.translate(0, 165);
        g2d.setColor(new Color(240, 235, 235));
        g2d.setStroke(new BasicStroke(3f));
        g2d.fill(shape);
        g2d.setColor(new Color(220, 205, 205));
        g2d.draw(shape);
        g2d.drawLine(183, 144, 183, 160);
        g2d.drawLine(9, 144, 9, 160);

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5f));
        for (int h = 0; h < lines.length; h++) {
            g2d.draw(lines[h]);
        }

        g2d.translate(0, 160);
        g2d.setColor(new Color(240, 235, 235));
        g2d.setStroke(new BasicStroke(3f));
        g2d.fill(shape);
        g2d.setColor(new Color(220, 205, 205));
        g2d.draw(shape);
        g2d.drawLine(183, 144, 183, 155);
        g2d.drawLine(9, 144, 9, 155);

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5f));
        for (int h = 0; h < lines.length; h++) {
            g2d.draw(lines[h]);
        }

        g2d.translate(0, 155);
        g2d.setColor(new Color(240, 235, 235));
        g2d.setStroke(new BasicStroke(3f));
        g2d.fill(shape);
        g2d.setColor(new Color(220, 205, 205));
        g2d.draw(shape);

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5f));
        for (int h = 0; h < lines.length; h++) {
            g2d.draw(lines[h]);
        }

        g2d.translate(-85, -505);
        g2d.setFont(new Font("Lucida Console", Font.BOLD, 20));
        for (int x = 0; x < boards.length; x++) {
            for (int y = 0; y < boards[x].length; y++) {
                for (int z = 0; z < boards[x][y].length; z++) {
                    if (boards[x][y][z] == X) {
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("X", position[x][y][z][0], position[x][y][z][2]);

                    } else if (boards[x][y][z] == O) {
                        g2d.setColor(Color.BLACK);
                        g2d.drawString("O", position[x][y][z][0], position[x][y][z][2]);

                    } // end if..else
                }
            }
        }
        if (stop) {
            g2d.setFont(new Font("Lucida Console", Font.BOLD + Font.ITALIC, 30));
            g2d.setColor(Color.BLUE);
            g2d.drawString(result, 10, 300);

        } // end if..else

    } // end paint method

    private void setGeneralPath() {
        shape = new GeneralPath();
        lines = new GeneralPath[6];
        lines[0] = new GeneralPath();
        lines[0].moveTo(xTop[0], 0);
        lines[0].lineTo(xBottom[0], 144);

        lines[1] = new GeneralPath();
        lines[1].moveTo(xTop[1], 0);
        lines[1].lineTo(xBottom[1], 144);

        lines[2] = new GeneralPath();
        lines[2].moveTo(xTop[2], 0);
        lines[2].lineTo(xBottom[2], 144);

        lines[3] = new GeneralPath();
        lines[3].moveTo(6.75f, y[0]);
        lines[3].lineTo(185.25f, y[0]);

        lines[4] = new GeneralPath();
        lines[4].moveTo(4.5f, y[1]);
        lines[4].lineTo(187.5f, y[1]);

        lines[5] = new GeneralPath();
        lines[5].moveTo(2.25f, y[2]);
        lines[5].lineTo(189.75f, y[2]);

    } // end setGeneralPath method

    private void addHComputer() {
        GameAI hc = new GameAI(this);

    } // end addHComputer method

    private GeneralPath shape, lines[];
    private final float xPoints[] = {9f, 183f, 193f, 0.0f};
    private final float yPoints[] = {0.0f, 0.0f, 144f, 144f};
    private final float xTop[] = {52.5f, 96f, 139.5f};
    private final float xBottom[] = {48f, 96f, 144};
    private final float y[] = {36f, 73f, 108f};

    protected int[][][] boards;
    protected boolean playerX, stop, oWon;
    protected String result;

    protected final int X = 1;
    protected final int O = 2;
    protected final int[][][][] position = {
        // level D
        {
            {
                {109, 153, 50, 86},
                {153, 196, 50, 86},
                {196, 240, 50, 86},
                {240, 283, 50, 86}
            },
            {
                {107, 151, 86, 122},
                {152, 196, 86, 122},
                {196, 241, 86, 122},
                {241, 285, 86, 122}
            },
            {
                {102, 149, 122, 158},
                {149, 196, 122, 158},
                {196, 243, 122, 158},
                {243, 289, 122, 158}
            },
            {
                {100, 148, 158, 194},
                {148, 196, 158, 194},
                {196, 244, 158, 194},
                {244, 292, 158, 194}
            },},
        // level C
        {
            {
                {109, 153, 215, 251},
                {153, 196, 215, 251},
                {196, 240, 215, 251},
                {240, 283, 215, 251}
            },
            {
                {107, 151, 251, 287},
                {152, 196, 251, 287},
                {196, 241, 251, 287},
                {241, 285, 251, 287}
            },
            {
                {102, 149, 287, 323},
                {149, 196, 287, 323},
                {196, 243, 287, 323},
                {243, 289, 287, 323}
            },
            {
                {100, 148, 323, 359},
                {148, 196, 323, 359},
                {196, 244, 323, 359},
                {244, 292, 323, 359}
            },},
        // level B
        {
            {
                {109, 153, 375, 411},
                {153, 196, 375, 411},
                {196, 240, 375, 411},
                {240, 283, 375, 411}
            },
            {
                {107, 151, 411, 447},
                {152, 196, 411, 447},
                {196, 241, 411, 447},
                {241, 285, 411, 447}
            },
            {
                {102, 149, 447, 483},
                {149, 196, 447, 483},
                {196, 243, 447, 483},
                {243, 289, 447, 483}
            },
            {
                {100, 148, 483, 519},
                {148, 196, 483, 519},
                {196, 244, 483, 519},
                {244, 292, 483, 519}
            },},
        // level A
        {
            {
                {109, 153, 530, 566},
                {153, 196, 530, 566},
                {196, 240, 530, 566},
                {240, 283, 530, 566}
            },
            {
                {107, 151, 566, 602},
                {152, 196, 566, 602},
                {196, 241, 566, 602},
                {241, 285, 566, 602}
            },
            {
                {102, 149, 602, 638},
                {149, 196, 602, 638},
                {196, 243, 602, 638},
                {243, 289, 602, 638}
            },
            {
                {100, 148, 638, 674},
                {148, 196, 638, 674},
                {196, 244, 638, 674},
                {244, 292, 638, 674}
            },},};

} // end class GamePanel
