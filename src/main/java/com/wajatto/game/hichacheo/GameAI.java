package com.wajatto.game.hichacheo;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class GameAI {

    public GameAI(GamePanel game) {
        panel = game;

    } // end constructor

    public static void play() {
        for (int x = 0; x < panel.boards.length; x++) {
            for (int y = 0; y < panel.boards[x].length; y++) // Horizantaly /O\
            {
                if ((panel.boards[x][y][0] & panel.boards[x][y][1]
                        & panel.boards[x][y][2]) == COMPUTER
                        && panel.boards[x][y][3] == 0) {

                    panel.boards[x][y][3] = COMPUTER;

                } else if ((panel.boards[x][y][0] & panel.boards[x][y][1]
                        & panel.boards[x][y][3]) == COMPUTER
                        && panel.boards[x][y][2] == 0) {

                    panel.boards[x][y][2] = COMPUTER;

                } else if ((panel.boards[x][y][0] & panel.boards[x][y][2]
                        & panel.boards[x][y][3]) == COMPUTER
                        && panel.boards[x][y][1] == 0) {

                    panel.boards[x][y][1] = COMPUTER;

                } else if ((panel.boards[x][y][1] & panel.boards[x][y][2]
                        & panel.boards[x][y][3]) == COMPUTER
                        && panel.boards[x][y][0] == 0) {

                    panel.boards[x][y][0] = COMPUTER;

                } // Virticaly /O\
                else if ((panel.boards[x][0][y] & panel.boards[x][1][y]
                        & panel.boards[x][2][y]) == COMPUTER
                        && panel.boards[x][3][y] == 0) {

                    panel.boards[x][3][y] = COMPUTER;

                } else if ((panel.boards[x][0][y] & panel.boards[x][1][y]
                        & panel.boards[x][3][y]) == COMPUTER
                        && panel.boards[x][2][y] == 0) {

                    panel.boards[x][2][y] = COMPUTER;

                } else if ((panel.boards[x][0][y] & panel.boards[x][2][y]
                        & panel.boards[x][3][y]) == COMPUTER
                        && panel.boards[x][1][y] == 0) {

                    panel.boards[x][1][y] = COMPUTER;

                } else if ((panel.boards[x][1][y] & panel.boards[x][2][y]
                        & panel.boards[x][3][y]) == COMPUTER
                        && panel.boards[x][0][y] == 0) {

                    panel.boards[x][0][y] = COMPUTER;

                } // Horizantaly /X\
                else if ((panel.boards[x][y][0] & panel.boards[x][y][1]
                        & panel.boards[x][y][2]) == X
                        && panel.boards[x][y][3] == 0) {

                    panel.boards[x][y][3] = COMPUTER;

                } else if ((panel.boards[x][y][0] & panel.boards[x][y][1]
                        & panel.boards[x][y][3]) == X
                        && panel.boards[x][y][2] == 0) {

                    panel.boards[x][y][2] = COMPUTER;

                } else if ((panel.boards[x][y][0] & panel.boards[x][y][2]
                        & panel.boards[x][y][3]) == X
                        && panel.boards[x][y][1] == 0) {

                    panel.boards[x][y][1] = COMPUTER;

                } else if ((panel.boards[x][y][1] & panel.boards[x][y][2]
                        & panel.boards[x][y][3]) == X
                        && panel.boards[x][y][0] == 0) {

                    panel.boards[x][y][0] = COMPUTER;

                } // Virticaly /X\
                else if ((panel.boards[x][0][y] & panel.boards[x][1][y]
                        & panel.boards[x][2][y]) == X
                        && panel.boards[x][3][y] == 0) {

                    panel.boards[x][3][y] = COMPUTER;

                } else if ((panel.boards[x][0][y] & panel.boards[x][1][y]
                        & panel.boards[x][3][y]) == X
                        && panel.boards[x][2][y] == 0) {

                    panel.boards[x][2][y] = COMPUTER;

                } else if ((panel.boards[x][0][y] & panel.boards[x][2][y]
                        & panel.boards[x][3][y]) == X
                        && panel.boards[x][1][y] == 0) {

                    panel.boards[x][1][y] = COMPUTER;

                } else if ((panel.boards[x][1][y] & panel.boards[x][2][y]
                        & panel.boards[x][3][y]) == X
                        && panel.boards[x][0][y] == 0) {

                    panel.boards[x][0][y] = COMPUTER;

                } else {
                    while (!panel.playerX) {

                        int row = (int) (Math.random() * 3);
                        int col = (int) (Math.random() * 3);
                        int dig = (int) (Math.random() * 3);

                        if (panel.boards[row][col][dig] == 0) {
                            panel.boards[row][col][dig] = COMPUTER;
                            panel.playerX = true;

                        } // end if

                    } // end while
                }
            }
        }
    } // end play method

    private static GamePanel panel;
    private static final int X = 1;
    private static final int COMPUTER = 2;

} // end class GameAI
