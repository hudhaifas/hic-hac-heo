/**
 * #author <Hudhaifa Shatnawi>
 */

import java.awt.*;
import java.awt.event.*;

public class HMouseListener extends MouseAdapter {
	public HMouseListener( HGamePanel game ) {
		gp = game;
		one = true;

	} // end constructor

	public void mousePressed( MouseEvent e )
	{
		if ( !gp.stop )

			if ( one ) {
				for ( int a = 0; a < gp.position.length; a++ )
					for ( int b = 0; b < gp.position.length; b++ )
						for ( int c = 0; c < gp.position.length; c++ )

							if ( ( e.getX() > gp.position[ a ][ b ][ c ][ 0 ] && e.getX() < gp.position[ a ][ b ][ c ][ 1 ] )
								&& ( e.getY() > gp.position[ a ][ b ][ c ][ 2 ] && e.getY() < gp.position[ a ][ b ][ c ][ 3 ] ) ) {

									if ( gp.playerX && gp.boards[ a ][ b ][ c ] == 0 ) {
										gp.boards[ a ][ b ][ c ] = X;
										gp.playerX = false;
										HComputer.play();
										gp.playerX = true;
										count += 2;

									} // end if

							} // end if

				} else {

				for ( int a = 0; a < gp.position.length; a++ )
					for ( int b = 0; b < gp.position.length; b++ )
						for ( int c = 0; c < gp.position.length; c++ )

							if ( ( e.getX() > gp.position[ a ][ b ][ c ][ 0 ] && e.getX() < gp.position[ a ][ b ][ c ][ 1 ] )
								&& ( e.getY() > gp.position[ a ][ b ][ c ][ 2 ] && e.getY() < gp.position[ a ][ b ][ c ][ 3 ] ) ) {

									if ( gp.playerX && gp.boards[ a ][ b ][ c ] == 0 ) {
										gp.boards[ a ][ b ][ c ] = X;
										gp.playerX = false;
										++count;

									} else if ( !gp.playerX && gp.boards[ a ][ b ][ c ] == 0 ) {
										gp.boards[ a ][ b ][ c ] = O;
										gp.playerX = true;
										++count;

									} // end if.else

							} // end if

				} // end if..else

		if ( ( gp.result = isWon() ).equals( "Game was END.. " ) ) {
			gp.stop = true;
			gp.oWon = false;

		} else if ( ( gp.result = isWon() ).equals( "Player X was WON!" ) ) {
			gp.stop = true;
			gp.oWon = false;

		} else if ( ( gp.result = isWon() ).equals( "Player O was WON!" ) ) {
			gp.stop = true;
			gp.oWon = true;

		} else if ( ( gp.result = isWon() ).equals( "Game was END.. Player X was WON!" ) ) {
			gp.stop = false;
			gp.oWon = false;

		} else if ( ( gp.result = isWon() ).equals( "Game was END.. Player O was WON!" ) ) {
			gp.stop = false;
			gp.oWon = true;

		} // end if.else

		gp.repaint();

	} // end mousePressed method

	public String isWon()
	{
		String won = "";
		if ( isEnd() )
			won = "Game was END.. ";

		for ( int x= 0; x < gp.boards.length; x++ )
			for ( int y = 0; y < gp.boards[ x ].length; y++ )
				if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
					 & gp.boards[ x ][ y ][ 2 ] & gp.boards[ x ][ y ][ 3 ] ) == X
					 || ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
					 & gp.boards[ x ][ 2 ][ y ] & gp.boards[ x ][ 3 ][ y ] ) == X
					 || ( gp.boards[ x ][ 0 ][ 0 ] & gp.boards[ x ][ 1 ][ 1 ]
					 & gp.boards[ x ][ 2 ][ 2 ] & gp.boards[ x ][ 3 ][ 3 ] ) == X )

					won += "Player X was WON!";

				else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
						  & gp.boards[ x ][ y ][ 2 ] & gp.boards[ x ][ y ][ 3 ] ) == O
						  || ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
						  & gp.boards[ x ][ 2 ][ y ] & gp.boards[ x ][ 3 ][ y ] ) == O )

					won += "Player O was WON!";

		return won;

	} // end isWon method

	public boolean isEnd()
	{
		boolean end = false;

		if ( count == 64 )
			end = true;

		return end;

	} // end isEnd method

	public static void reCount()
	{
		count = 0;

	} // end reCount method

	public static void resetOne( boolean yes )
	{
		one = yes;

	} // end resetOne method

	public static boolean getOne()
	{
		return one;

	} // end getOne method

	private HGamePanel gp;
	private static int count = 0;
	private final int X = 1;
	private final int O = 2;
	private static boolean one;

} // end class HMouseListsner

