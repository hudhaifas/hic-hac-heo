/**
 * #author <Hudhaifa Shatnawi>
 */

import java.awt.*;

import javax.swing.*;

public class HicHacHoe extends JFrame {

	public static void main( String[] args )
	{
		HicHacHoe hicHac = new HicHacHoe();

		hicHac.setSize( 400, 740 );
		hicHac.setVisible( true );
		hicHac.addWindowListener( new HCloser( hicHac ) );

	} // end main

	public HicHacHoe() {
		super( "HicHacHoe" );
		gp = new HGamePanel();

		craeteGUI();
		addToContainer();
		registration();

	} // end constructor


	public void craeteGUI()
	{
		c = getContentPane();
		c.setBackground( Color.WHITE );

		bar = new JMenuBar();
		setJMenuBar( bar );

		fileMenu = new JMenu( "File" );
		fileMenu.setMnemonic( 'F' );

		newGame = new JMenuItem( "new game" );
		newGame.setMnemonic( 'N' );

		aboutItem = new JMenuItem( "About..." );
		aboutItem.setMnemonic( 'A' );

		exitItem = new JMenuItem( "Exit" );
		exitItem.setMnemonic( 'X' );

		playerMenu = new JMenu( "Players" );
		playerMenu.setMnemonic( 'P' );

		onePlayer = new JMenuItem( "One Player" );
		onePlayer.setMnemonic( '1' );

		twoPlayer = new JMenuItem( "Two Players" );
		twoPlayer.setMnemonic( '2' );

	} // end createGUI method

	public void addToContainer()
	{
		c.setLayout( new BorderLayout() );
		c.add( gp, BorderLayout.CENTER );

		fileMenu.add( newGame );
		fileMenu.add( aboutItem );
		fileMenu.add( exitItem );
		playerMenu.add( onePlayer );
		playerMenu.add( twoPlayer );

		bar.add( fileMenu );
		bar.add( playerMenu );

	} // end addToContainer method

	public void registration()
	{
		newGame.addActionListener( new HMenuListener( this, gp ) );
		aboutItem.addActionListener( new HMenuListener( this, gp ) );
		exitItem.addActionListener( new HMenuListener( this, gp ) );
		onePlayer.addActionListener( new HMenuListener( this, gp ) );
		twoPlayer.addActionListener( new HMenuListener( this, gp ) );

	} // end registration method

	private Container c;
	private JMenuBar bar;
	private JTextField playerFeild;
	private JMenu fileMenu, playerMenu;
	protected JMenuItem newGame, aboutItem, exitItem, onePlayer, twoPlayer;
	protected HGamePanel gp;


} // end class HicHacHoe