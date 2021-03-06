package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordHolder> {

    private ArrayList<Record> recordList;
    private Context context;
    final RecordAdapter.OnItemClickListener listener;

    public RecordAdapter(ArrayList<Record> recordList, Context context, RecordAdapter.OnItemClickListener listener) {
        this.recordList = recordList;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClick(Record record);
    }

    @NonNull
    @Override
    public RecordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_collection, parent, false);
        RecordHolder holder = new RecordHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordHolder holder, int position) {
        holder.bindData(recordList.get(position));
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public class RecordHolder extends RecyclerView.ViewHolder {

        TextView tv_nickname;
        TextView tv_totalScore;
        TextView tv_nOfGames;
        private final Context context;

        public RecordHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_nickname = itemView.findViewById(R.id.tv_nickname);
            tv_totalScore = itemView.findViewById(R.id.tv_totalScore);
            tv_nOfGames = itemView.findViewById(R.id.tv_nOfGames);
        }

        void bindData(final Record record) {
            tv_nickname.setText(record.getPlayer());
            tv_totalScore.setText(String.valueOf(record.getTotalScore()));
            tv_nOfGames.setText(String.valueOf(record.getnOfGames()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { listener.OnItemClick(record); }
            });
        }
    }
}
