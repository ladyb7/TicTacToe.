package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.button3);
        Button homeBTN = findViewById(R.id.button4);
        TextView playerTurn = findViewById(R.id.textView2);

        //When activity is first loaded up, these vars will be invisible
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        //grab string arr that was passed to GAct and store in this var
        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        //kalau name dah isi, dia akan letak nama first player first
        if(playerNames != null) {
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard2);

        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);
    }

    public void playAgainButtonClick(View view){
        //do fancy stuff
       ticTacToeBoard.resetGame();
       ticTacToeBoard.invalidate();

    }
    public void homeButtonClick(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}