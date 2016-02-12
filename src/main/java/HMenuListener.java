/**
 * #author <Hudhaifa Shatnawi>
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HMenuListener implements ActionListener {
	public HMenuListener( HicHacHoe hicHac, HGamePanel game ) {
		h = hicHac;
		gp = game;

	} // end constructor

	public void actionPerformed( ActionEvent e )
	{
		if ( gp.oWon ) {
			gp.playerX = false;

		} else
			gp.playerX = true;

		if ( e.getSource() == h.newGame ) {
			if ( gp.oWon ) {
				HComputer.play();


			} else
				gp.playerX = true;

			gp.stop = false;
			HMouseListener.reCount();

			if ( HMouseListener.getOne() ) {
				for ( int i = 0; i < gp.boards.length; i++ )
					for ( int j = 0; j < gp.boards[ i ].length; j++ )
						for ( int l = 0; l < gp.boards[ i ][ j ].length; l++ )
							gp.boards[ i ][ j ][ l ] = 0;

			} else {
				for ( int i = 0; i < gp.boards.length; i++ )
					for ( int j = 0; j < gp.boards[ i ].length; j++ )
						for ( int l = 0; l < gp.boards[ i ][ j ].length; l++ )
							gp.boards[ i ][ j ][ l ] = 0;

			} // end if..else

			gp.repaint();

		} else if ( e.getSource() == h.aboutItem ) {
			JOptionPane.showMessageDialog( h,
				"HicHacHeo miniGame\n by: H.M.Shatnwi\n hudhaifa@aabu.edu.jo" ,
				"About HicHacHoe", JOptionPane.PLAIN_MESSAGE );

		} else if ( e.getSource() == h.exitItem ) {

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
			} // end switch

		} else if ( e.getSource() == h.onePlayer ) {
			gp.stop = false;
			HMouseListener.resetOne( true );
			HMouseListener.reCount();

			if ( gp.oWon ) {
				gp.playerX = false;
				HComputer.play();

			} else
				gp.playerX = true;

			for ( int i = 0; i < gp.boards.length; i++ )
				for ( int j = 0; j < gp.boards[ i ].length; j++ )
					for ( int l = 0; l < gp.boards[ i ][ j ].length; l++ )
						gp.boards[ i ][ j ][ l ] = 0;

			gp.repaint();

		} else if ( e.getSource() == h.twoPlayer ) {
			gp.stop = false;
			HMouseListener.resetOne( false );
			HMouseListener.reCount();

			if ( gp.oWon )
				gp.playerX = false;

			else
				gp.playerX = true;


			for ( int i = 0; i < gp.boards.length; i++ )
				for ( int j = 0; j < gp.boards[ i ].length; j++ )
					for ( int l = 0; l < gp.boards[ i ][ j ].length; l++ )
						gp.boards[ i ][ j ][ l ] = 0;

			gp.repaint();

		} // end if..else

	} // end actionPerformed method

	private HicHacHoe h;
	private HGamePanel gp;

} // end class HMenuListener