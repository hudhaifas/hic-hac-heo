/**
 * #author <Hudhaifa Shatnawi>
 */

public class HComputer {

	public HComputer( HGamePanel game ) {
		gp = game;

	} // end constructor

	public static void play()
	{
		for ( int x= 0; x < gp.boards.length; x++ )
			for ( int y = 0; y < gp.boards[ x ].length; y++ )

				// Horizantaly /O\
				if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
					& gp.boards[ x ][ y ][ 2 ] ) == COMPUTER
					&& gp.boards[ x ][ y ][ 3 ] == 0 ) {

						gp.boards[ x ][ y ][ 3 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
					& gp.boards[ x ][ y ][ 3 ] ) == COMPUTER
					&& gp.boards[ x ][ y ][ 2 ] == 0 ) {

						gp.boards[ x ][ y ][ 2 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 2 ]
					& gp.boards[ x ][ y ][ 3 ] ) == COMPUTER
					&& gp.boards[ x ][ y ][ 1 ] == 0 ) {

						gp.boards[ x ][ y ][ 1 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 1 ] & gp.boards[ x ][ y ][ 2 ]
					& gp.boards[ x ][ y ][ 3 ] ) == COMPUTER
					&& gp.boards[ x ][ y ][ 0 ] == 0 ) {

						gp.boards[ x ][ y ][ 0 ] = COMPUTER;

				}
				// Virticaly /O\
				else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
					& gp.boards[ x ][ 2 ][ y ] ) == COMPUTER
					&& gp.boards[ x ][ 3 ][ y ] == 0 ) {

						gp.boards[ x ][ 3 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == COMPUTER
					&& gp.boards[ x ][ 2 ][ y ] == 0 ) {

						gp.boards[ x ][ 2 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 2 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == COMPUTER
					&& gp.boards[ x ][ 1 ][ y ] == 0 ) {

						gp.boards[ x ][ 1 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 1 ][ y ] & gp.boards[ x ][ 2 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == COMPUTER
					&& gp.boards[ x ][ 0 ][ y ] == 0 ) {

						gp.boards[ x ][ 0 ][ y ] = COMPUTER;

				}
				// Horizantaly /X\
				else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
					& gp.boards[ x ][ y ][ 2 ] ) == X
					&& gp.boards[ x ][ y ][ 3 ] == 0 ) {

						gp.boards[ x ][ y ][ 3 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 1 ]
					& gp.boards[ x ][ y ][ 3 ] ) == X
					&& gp.boards[ x ][ y ][ 2 ] == 0 ) {

						gp.boards[ x ][ y ][ 2 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 0 ] & gp.boards[ x ][ y ][ 2 ]
					& gp.boards[ x ][ y ][ 3 ] ) == X
					&& gp.boards[ x ][ y ][ 1 ] == 0 ) {

						gp.boards[ x ][ y ][ 1 ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ y ][ 1 ] & gp.boards[ x ][ y ][ 2 ]
					& gp.boards[ x ][ y ][ 3 ] ) == X
					&& gp.boards[ x ][ y ][ 0 ] == 0 ) {

						gp.boards[ x ][ y ][ 0 ] = COMPUTER;

				}
				// Virticaly /X\
				else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
					& gp.boards[ x ][ 2 ][ y ] ) == X
					&& gp.boards[ x ][ 3 ][ y ] == 0 ) {

						gp.boards[ x ][ 3 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 1 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == X
					&& gp.boards[ x ][ 2 ][ y ] == 0 ) {

						gp.boards[ x ][ 2 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 0 ][ y ] & gp.boards[ x ][ 2 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == X
					&& gp.boards[ x ][ 1 ][ y ] == 0 ) {

						gp.boards[ x ][ 1 ][ y ] = COMPUTER;

				} else if ( ( gp.boards[ x ][ 1 ][ y ] & gp.boards[ x ][ 2 ][ y ]
					& gp.boards[ x ][ 3 ][ y ] ) == X
					&& gp.boards[ x ][ 0 ][ y ] == 0 ) {

						gp.boards[ x ][ 0 ][ y ] = COMPUTER;

				} else
					while ( !gp.playerX ) {

						int row = ( int )( Math.random() * 3 );
						int col = ( int )( Math.random() * 3 );
						int dig = ( int )( Math.random() * 3 );

						if ( gp.boards[ row ][ col ][ dig ] == 0 ) {
							gp.boards[ row ][ col ][ dig ] = COMPUTER;
							gp.playerX = true;

						} // end if

					} // end while

	} // end play method

	private static HGamePanel gp;
	private static final int X = 1;
	private static final int COMPUTER = 2;

} // end class HComputer