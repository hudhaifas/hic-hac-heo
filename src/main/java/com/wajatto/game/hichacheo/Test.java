package com.wajatto.game.hichacheo;

/**
 * @author Hudhaifa Shatnawi <hudhaifa.shatnawi@gmail.com>
 * @version 1.0
 */
public class Test {

    public static final void main(String[] args) {
        int s = 0;

        int[][][] boards = new int[4][4][4];

        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                for (int l = 0; l < boards[i][j].length; l++) {
                    boards[i][j][l] = s++;
                }
            }
        }

        for (int i = 0; i < boards.length; i++) {

            for (int j = 0; j < boards[i].length; j++) {

                for (int l = 0; l < boards[i][j].length; l++) {

                    System.out.print(boards[i][j][l]);
                    System.out.print("\t");

                } // end inner for
                System.out.println();

            } // end mid for
            System.out.println("\n");

        } // end outer for

    } // end main

} // end class Test
