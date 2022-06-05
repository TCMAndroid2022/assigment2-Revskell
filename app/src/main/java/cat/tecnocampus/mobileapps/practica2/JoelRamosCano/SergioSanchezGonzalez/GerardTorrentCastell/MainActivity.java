package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Log in");
        editText = findViewById(R.id.et_name);
    }

    public void login(View view) {
        String username = editText.getText().toString();
        if(username == null) username = "";
        Intent gameIntent = new Intent(this, GameActivity.class);
        gameIntent.putExtra("game", new Game(username));
        startActivity(gameIntent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.rankingButton) {
            Intent rankingIntent = new Intent(this, RankingActivity.class);
            startActivity(rankingIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}