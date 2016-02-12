import javax.swing.*;

public class HCloser extends java.awt.event.WindowAdapter {
	public HCloser( HicHacHoe hicHac ) {
		h = hicHac;
	} // end constructor

	public void windowClosing( java.awt.event.WindowEvent event )
	{
		Object[] options = { "Yes", "No" };
		int c = JOptionPane.showOptionDialog( h, "Are you sure?", "Panit",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0] );

		switch ( c ) {
			case 0:
			System.exit( 0 );
			break;

			case 1:
			default:
			break;
		}


	} // end windowClosing method

	private HicHacHoe h;

} // end class Closer