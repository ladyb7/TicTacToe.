package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.editTextTextPersonName);
        player2 = findViewById(R.id.editTextTextPersonName2);

    }

    public void submitButtonClick(View view) {
        //when clicked, it will bundle up names from the extracted variables and pass to intent
        String editTextTextPersonName = player2.getText().toString();
        String editTextTextPersonName2 = player1.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("PLAYER_NAMES", new String[] {editTextTextPersonName,editTextTextPersonName2});
        startActivity(intent);
    }
}