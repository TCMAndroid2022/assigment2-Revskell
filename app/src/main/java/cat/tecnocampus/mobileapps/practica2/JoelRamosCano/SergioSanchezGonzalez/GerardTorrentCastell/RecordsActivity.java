package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecordsActivity extends AppCompatActivity {

    private Record record;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        record = getIntent().getParcelableExtra("record");
        getSupportActionBar().setTitle(record.getPlayer());

        recyclerView = findViewById(R.id.scoreList);

        layoutManager = new GridLayoutManager(RecordsActivity.this, 1);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecordsAdapter(record, RecordsActivity.this);

        if(record == null) recyclerView.setVisibility(View.GONE);
        else recyclerView.setVisibility(View.VISIBLE);
    }
}
