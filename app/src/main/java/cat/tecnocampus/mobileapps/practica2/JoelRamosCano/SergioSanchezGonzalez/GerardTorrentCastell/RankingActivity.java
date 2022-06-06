package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private RecordLab recordLab;
    private ArrayList<Record> recordList;

    private Button recordButton;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_leaderboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ranking");

        recyclerView = findViewById(R.id.rankingList);

        layoutManager = new GridLayoutManager(RankingActivity.this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recordLab = recordLab.getSingleton(this);
        recordList = recordLab.getGames();

        mAdapter = new RecordAdapter(recordList, RankingActivity.this, new RecordAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Record record) {
                openRecordsActivity(record);
            }
        });
        recyclerView.setAdapter(mAdapter);

        if(recordList.isEmpty()) recyclerView.setVisibility(View.GONE);
        else recyclerView.setVisibility(View.VISIBLE);
    }

    public void openRecordsActivity(Record record) {
        Intent recordsIntent = new Intent(this, RecordsActivity.class);
        recordsIntent.putExtra("record", record);
        startActivity(recordsIntent);
    }
}
