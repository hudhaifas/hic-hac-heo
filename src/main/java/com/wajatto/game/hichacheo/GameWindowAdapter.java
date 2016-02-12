package com.wajatto.game.hichacheo;

import javax.swing.JOptionPane;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class GameWindowAdapter
        extends java.awt.event.WindowAdapter {

    public GameWindowAdapter(HicHacHoe hicHac) {
        h = hicHac;
    } // end constructor

    @Override
    public void windowClosing(java.awt.event.WindowEvent event) {
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
        }

    } // end windowClosing method

    private final HicHacHoe h;

} // end class Closer
