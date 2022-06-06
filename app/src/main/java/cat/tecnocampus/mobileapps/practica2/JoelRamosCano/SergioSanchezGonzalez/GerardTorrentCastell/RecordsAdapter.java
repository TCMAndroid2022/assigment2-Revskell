package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordsAdapter extends RecyclerView.Adapter<RecordsAdapter.RecordsHolder> {

    private Record record;
    private Context context;

    public RecordsAdapter(Record record, Context context) {
        this.record = record;
        this.context = context;
    }

    @NonNull
    @Override
    public RecordsAdapter.RecordsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_collection, parent, false);
        RecordsAdapter.RecordsHolder holder = new RecordsAdapter.RecordsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordsAdapter.RecordsHolder holder, int position) {
        holder.bindData(record, position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecordsHolder extends RecyclerView.ViewHolder {

        TextView tv_gameNumber;
        TextView tv_score;
        private final Context context;

        public RecordsHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_gameNumber = itemView.findViewById(R.id.tv_gameNumber);
            tv_score = itemView.findViewById(R.id.tv_score);
        }

        void bindData(final Record record, int position) {
            tv_gameNumber.setText(String.valueOf(position));
            tv_gameNumber.setText(String.valueOf(record.getScores().get(position)));
        }
    }
}
