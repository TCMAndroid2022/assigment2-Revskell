package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class Game extends AppCompatActivity
{
    EditText editText;
    TextView tvWord;
    String username;
    String usedWord;
    String finalWord;
    String playerWord;
    String url= "https://palabras-aleatorias-public-api.herokuapp.com/random";
    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
    int score=0;
    int letterCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username= getIntent().getStringExtra("username");
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText= findViewById(R.id.solveWord);
        tvWord= findViewById(R.id.word);
        finalWord=getFinalWord();
        playerWord="";
        for(int i=0;i<finalWord.length();i++){
            playerWord+="_";
        }

    }

    void solve(){


    }

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
        queue.add(stringRequest);
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
