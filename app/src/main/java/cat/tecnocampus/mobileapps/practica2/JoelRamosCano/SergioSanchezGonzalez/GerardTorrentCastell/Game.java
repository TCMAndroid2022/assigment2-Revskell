package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Game extends AppCompatActivity
{
    EditText editText;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username= getIntent().getStringExtra("username");
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText= findViewById(R.id.et_name);
        getSupportActionBar().setTitle(username);
    }


    public void submitWord(View view) {

    }


}
