package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.ArrayList;
import java.util.UUID;

@Entity(tableName = "Record")
public class Record implements Parcelable {

    public Record() {
        this.id = UUID.randomUUID().toString();
        this.totalScore = 0;
        this.nOfGames = 0;
        this.scores = new ArrayList<Integer>();
    }

    public Record(String player, int totalScore, int nOfGames) {
        this.player = player;
        this.totalScore = totalScore;
        this.nOfGames = nOfGames;
    }

    public Record(String player, int totalScore, int nOfGames, ArrayList<Integer> scores) {
        this.player = player;
        this.totalScore = totalScore;
        this.nOfGames = nOfGames;
        this.scores = scores;
    }

    protected Record(Parcel in) {
        id = in.readString();
        player = in.readString();
        totalScore = in.readInt();
        nOfGames = in.readInt();
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "record_id")
    public String id;

    @ColumnInfo(name = "record_player")
    public String player;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "record_scores")
    public ArrayList<Integer> scores;

    @ColumnInfo(name = "record_totalScore")
    public int totalScore;

    @ColumnInfo(name = "record_nOfGames")
    public int nOfGames;

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) { return new Record(in); }

        @Override
        public Record[] newArray(int size) { return new Record[size]; }
    };

    public String getId() { return this.id; }

    public int getScore() { return this.scores.get(scores.size()); }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() { return player; }

    public ArrayList<Integer> getScores() { return scores; }

    public int getTotalScore() { return totalScore; }

    public int getnOfGames() { return nOfGames; }

    public void addScore(int score) {
        this.scores.add(score);
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(player);
        parcel.writeInt(totalScore);
        parcel.writeInt(nOfGames);
    }
}
