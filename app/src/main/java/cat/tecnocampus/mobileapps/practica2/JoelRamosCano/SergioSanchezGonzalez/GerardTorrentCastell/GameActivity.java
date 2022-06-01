package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class GameActivity extends AppCompatActivity
{
    EditText editText;
    TextView tvWord;
    String username;
    String usedWord;
    String finalWord;
    String playerWord;
    String url= "https://palabras-aleatorias-public-api.herokuapp.com/random";
    // RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
    int score=0;
    int letterCount=0;

    private Game game;
    private RecordLab recordLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = getIntent().getParcelableExtra("game");
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = findViewById(R.id.solveWord);
        tvWord = findViewById(R.id.word);
        /*
        finalWord = getFinalWord();
        playerWord = "";
        for(int i=0; i<finalWord.length(); i++){
            playerWord+="_";
        }
        */
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // desarrollar
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // desarrollar
    }

    private void solve(){

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

    /*
    String getFinalWord(){
        JSONArray jsonArray_result = new JSONArray(queue);//Posiblemente mal, comprobar luego
        jsonArray_result.length(); //Nº de registres
        //Bucle per a agafar cada objecte JSON:
        for (int i = 0; i<jsonArray_result.length(); i++)
        {
            JSONObject json_word =jsonArray_result.getJSONObject(i);
            String name = json_word.getString("Word:");
        }
    }
     */


    public void stringClicked(View view) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("Test", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("SwA", "Error in request ");
                    }
                }
        );
        // queue.add(stringRequest);
    }

    public void submitWord(View view) {
        String submittedWord=editText.getText().toString();
        if(submittedWord.length()==1){ //introduce una letra
            if(finalWord.indexOf(submittedWord)!=-1){
                int position= finalWord.indexOf(submittedWord);
                playerWord = playerWord.substring(0,position-1)+submittedWord+playerWord.substring(position+1);
                //Si la palabra solo tiene 1 vez esta letra
                letterCount++;
            }
        }else{ //intenta resolver
            if(submittedWord== usedWord){
                score= ((submittedWord.length()-letterCount)/submittedWord.length()*10);
            }else{
                score=0;
            }
        }
    }
}
