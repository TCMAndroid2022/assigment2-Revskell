package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {

    private ArrayList<Record> recordList;
    private Context context;

    public RecordAdapter(ArrayList<Record> recordList, Context context) {
        this.recordList = recordList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_collection, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_nickname.setText(recordList.get(position).getPlayer());
        holder.tv_totalScore.setText(String.valueOf(recordList.get(position).getTotalScore()));
        holder.tv_nOfGames.setText(String.valueOf(recordList.get(position).getnOfGames()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nickname;
        TextView tv_totalScore;
        TextView tv_nOfGames;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nickname = itemView.findViewById(R.id.tv_nickname);
            tv_totalScore = itemView.findViewById(R.id.tv_totalScore);
            tv_nOfGames = itemView.findViewById(R.id.tv_nOfGames);
        }
    }
}
