package com.wajatto.game.hichacheo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class HicHacHoe
        extends JFrame {

    public HicHacHoe() {
        super("HicHacHoe");
        gp = new GamePanel();

        craeteGUI();
        addToContainer();
        registration();

    } // end constructor

    private void addToContainer() {
        c.setLayout(new BorderLayout());
        c.add(gp, BorderLayout.CENTER);

        fileMenu.add(newGame);
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);
        playerMenu.add(onePlayer);
        playerMenu.add(twoPlayer);

        bar.add(fileMenu);
        bar.add(playerMenu);

    } // end addToContainer method

    private void craeteGUI() {
        c = getContentPane();
        c.setBackground(Color.WHITE);

        bar = new JMenuBar();
        setJMenuBar(bar);

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        newGame = new JMenuItem("new game");
        newGame.setMnemonic('N');

        aboutItem = new JMenuItem("About...");
        aboutItem.setMnemonic('A');

        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');

        playerMenu = new JMenu("Players");
        playerMenu.setMnemonic('P');

        onePlayer = new JMenuItem("One Player");
        onePlayer.setMnemonic('1');

        twoPlayer = new JMenuItem("Two Players");
        twoPlayer.setMnemonic('2');

    } // end createGUI method

    private void registration() {
        newGame.addActionListener(new GameMenuAdapter(this, gp));
        aboutItem.addActionListener(new GameMenuAdapter(this, gp));
        exitItem.addActionListener(new GameMenuAdapter(this, gp));
        onePlayer.addActionListener(new GameMenuAdapter(this, gp));
        twoPlayer.addActionListener(new GameMenuAdapter(this, gp));

    } // end registration method

    public static void main(String[] args) {
        HicHacHoe hicHac = new HicHacHoe();

        hicHac.setSize(400, 740);
        hicHac.setVisible(true);
        hicHac.addWindowListener(new GameWindowAdapter(hicHac));

    } // end main
    private JMenuBar bar;
    private Container c;
    private JMenu fileMenu;
    private JTextField playerFeild;
    private JMenu playerMenu;
    protected JMenuItem aboutItem;
    protected JMenuItem exitItem;

    protected GamePanel gp;
    protected JMenuItem newGame;
    protected JMenuItem onePlayer;
    protected JMenuItem twoPlayer;

} // end class HicHacHoe
