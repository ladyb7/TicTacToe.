package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class GameLogic {
    private int[][] gameBoard;

    private String[] playerNames = {"Player 1", "Player 2"};

    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    private int player = 1;

    GameLogic() {
        //once class is created, it will populate GB w a bunch of 0s
        //tell game logic that spots are available for users to place a marker
        gameBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col) {
        //check to make sure row n cols passed is available
        //once user clicks on a cell. these lines will check
        //if the boxes are empty, it will assign the spot to the player
        if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row - 1][col - 1] = player;

            if (player == 1) {
                playerTurn.setText((playerNames[1] + "'s Turn"));
            } else {
                playerTurn.setText((playerNames[0] + "'s Turn"));
            }
            return true;
        } else {
            return false;
        }
    }

    //check if we have a winner
    public boolean winnerCheck() {
        boolean isWinner = false;

        //1. This is to scan through each row, iterated three times, starting from the first row to see if there's a set of matching values
        for (int r = 0; r < 3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0) {
                isWinner = true;

            }
        }

        //2. This is to scan through each column, iterated three times, starting from the first column to see if there's a set of matching va
        for (int c = 0; c < 3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] && gameBoard[0][c] != 0) {
                isWinner = true;
            }
        }

        //3. This is to check for the negative sloping diagonal

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0) {
            isWinner = true;
        }

        //4. This is to check for the positive sloping diagonal
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[2][0] != 0) {
            isWinner = true;
        }


        //This is the board counter, when a spot on the board is filled up, it will increment the counter to 1
        //When it reaches until the 9th move, and no winner is made, the program will display tie as the result.
        int boardFilled = 0;


        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled += 1;
                }
            }
        }

        if (isWinner) {
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(playerNames[player - 1] + "MAN, You're on a Roll ;)");
            return true;
        } else if (boardFilled == 9) {
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(" Too bad innit. Its A TIE :C");
            return true;
        } else {
            return false;
        }
    }

    //reset the game by emulating 0s into the board
    public void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
        //reset the player
        player = 1;
        //reset buttons and textView
        playAgainBTN.setVisibility((View.GONE));
        homeBTN.setVisibility((View.GONE));

        playerTurn.setText((playerNames[0] + "'s turn"));
    }

        public void setPlayAgainBTN (Button playAgainBTN){
            this.playAgainBTN = playAgainBTN;
        }

        public void setHomeBTN (Button homeBTN){
            this.homeBTN = homeBTN;
        }

        public void setPlayerTurn (TextView playerTurn){
            this.playerTurn = playerTurn;
        }

        public void setPlayerNames (String[] playerNames){
            this.playerNames = playerNames;
        }

        public int[][] getGameBoard(){
            return gameBoard;
        }

        public void setPlayer(int player){
            this.player = player;
        }

        public int getPlayer() {
            return player;
        }
    }



