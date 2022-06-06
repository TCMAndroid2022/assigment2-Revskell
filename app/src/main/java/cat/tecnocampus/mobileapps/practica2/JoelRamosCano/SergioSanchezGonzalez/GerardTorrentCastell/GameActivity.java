package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class GameActivity extends AppCompatActivity
{
    EditText editText;
    TextView tvWord;
    String finalWord;
    String playerWord;
    RequestQueue queue;
    int score=0;
    int lettersGuessed=0;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = getIntent().getParcelableExtra("game");
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Guess the word");

        editText = findViewById(R.id.solveWord);
        tvWord = findViewById(R.id.word);

        queue = Volley.newRequestQueue(this);

        getFinalWord();

        finalWord = tvWord.getText().toString();

        playerWord = "";
        for(int i=0; i < finalWord.length(); i++){
            playerWord+="_";
        }
        tvWord.setText(playerWord);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score", score);
        outState.putInt("lettersGuessed", lettersGuessed);
        outState.putString("finalWord", finalWord);
        outState.putString("playerWord", playerWord);
        outState.putParcelable("game", game);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
        lettersGuessed = savedInstanceState.getInt("lettersGuessed");
        finalWord = savedInstanceState.getString("finalWord");
        playerWord = savedInstanceState.getString("playerWord");
        game = savedInstanceState.getParcelable("game");

        tvWord.setText(playerWord);
    }


    private void winGame() {

        Record record = new Record();
        RecordLab recordLab = new RecordLab(this);

        record.setPlayer(game.getPlayerNickname());
        record.addScore(score);

        recordLab.addGame(record);

        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }


    public void getFinalWord(){

        String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject body = response.getJSONObject("body");
                            String word = body.getString("Word");
                            tvWord.setText(word);
                        } catch (Exception ex) {
                            Log.d("SwA", "Error parsing json array");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        queue.add(jsonArrayRequest);
    }

    public void submitWord(View view) {
        String submittedWord = editText.getText().toString();
        if(submittedWord.length()==1){ //introduce una letra
            char[] playerWordChar= playerWord.toCharArray();
            if(finalWord.indexOf(submittedWord)!=-1){
                for(int i=0;i<playerWordChar.length;i++){
                    if(Character.compare(finalWord.charAt(i),submittedWord.charAt(0))==0){
                        playerWordChar[i]=submittedWord.charAt(0);
                        lettersGuessed++;
                    }
                }
                playerWord=playerWord.valueOf(playerWordChar);
                tvWord.setText(playerWord);
            }
        }
        else { //intenta resolver
            if(submittedWord.equals(finalWord)){
                score= ((submittedWord.length()-lettersGuessed)/submittedWord.length()*10);
                winGame();
            }else{
                score=0;
            }
        }
    }
}
