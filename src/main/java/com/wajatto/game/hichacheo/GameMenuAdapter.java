package com.wajatto.game.hichacheo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class GameMenuAdapter
        implements ActionListener {

    public GameMenuAdapter(HicHacHoe hicHac, GamePanel game) {
        h = hicHac;
        gp = game;

    } // end constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        gp.playerX = !gp.oWon;

        if (e.getSource() == h.newGame) {
            if (gp.oWon) {
                GameAI.play();

            } else {
                gp.playerX = true;
            }

            gp.stop = false;
            GameMouseAdapter.reCount();

            if (GameMouseAdapter.getOne()) {
                for (int i = 0; i < gp.boards.length; i++) {
                    for (int j = 0; j < gp.boards[i].length; j++) {
                        for (int l = 0; l < gp.boards[i][j].length; l++) {
                            gp.boards[i][j][l] = 0;
                        }
                    }
                }

            } else {
                for (int i = 0; i < gp.boards.length; i++) {
                    for (int j = 0; j < gp.boards[i].length; j++) {
                        for (int l = 0; l < gp.boards[i][j].length; l++) {
                            gp.boards[i][j][l] = 0;
                        }
                    }
                }

            } // end if..else

            gp.repaint();

        } else if (e.getSource() == h.aboutItem) {
            JOptionPane.showMessageDialog(h,
                    "HicHacHeo miniGame\n by: H.M.Shatnwi\n hudhaifa@aabu.edu.jo",
                    "About HicHacHoe", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == h.exitItem) {

            Object[] options = {"Yes", "No"};
            int c = JOptionPane.showOptionDialog(h, "Are you sure?", "Panit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);

            switch (c) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                default:
                    break;
            } // end switch

        } else if (e.getSource() == h.onePlayer) {
            gp.stop = false;
            GameMouseAdapter.resetOne(true);
            GameMouseAdapter.reCount();

            if (gp.oWon) {
                gp.playerX = false;
                GameAI.play();

            } else {
                gp.playerX = true;
            }

            for (int i = 0; i < gp.boards.length; i++) {
                for (int j = 0; j < gp.boards[i].length; j++) {
                    for (int l = 0; l < gp.boards[i][j].length; l++) {
                        gp.boards[i][j][l] = 0;
                    }
                }
            }

            gp.repaint();

        } else if (e.getSource() == h.twoPlayer) {
            gp.stop = false;
            GameMouseAdapter.resetOne(false);
            GameMouseAdapter.reCount();

            gp.playerX = !gp.oWon;

            for (int i = 0; i < gp.boards.length; i++) {
                for (int j = 0; j < gp.boards[i].length; j++) {
                    for (int l = 0; l < gp.boards[i][j].length; l++) {
                        gp.boards[i][j][l] = 0;
                    }
                }
            }

            gp.repaint();

        } // end if..else

    } // end actionPerformed method

    private final HicHacHoe h;
    private final GamePanel gp;

} // end class GameMenuAdapter
