package com.training.notepad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class AddNote extends AppCompatActivity {

    EditText editText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editText = findViewById(R.id.new_note);
        Intent intent = getIntent();
        position = intent.getIntExtra("position",-1);
        if(position != -1) {
            editText.setText(MainActivity.notes.get(position));
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    @Override
    public void onBackPressed() {
        String note = editText.getText().toString().trim();
        if(!note.equals("")) {
            if(position != -1) {
                Toast.makeText(this,"Note updated",Toast.LENGTH_SHORT).show();
                MainActivity.notes.set(position,note);
            } else {
                Toast.makeText(this,"Note saved",Toast.LENGTH_SHORT).show();
                MainActivity.notes.add(note);
            }

        }
        finish();
    }
}
