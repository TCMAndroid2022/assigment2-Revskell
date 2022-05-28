package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et_name);
    }

    public void login(View view) {
        String username = editText.getText().toString();
        if(username == null) username = "";
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}