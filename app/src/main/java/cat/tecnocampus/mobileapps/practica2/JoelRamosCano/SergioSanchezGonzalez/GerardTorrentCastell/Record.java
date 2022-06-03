package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "Record")
public class Record {

    public Record() {
        this.id = UUID.randomUUID().toString();
        this.totalScore = 0;
        this.scores = new ArrayList<Integer>();
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

    public String getId() { return this.id; }

    public int getScore() { return this.scores.get(scores.size()); } // quizas hay alguna mejor forma de hacerlo

    public void setPlayer(String player) {
        this.player = player;
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public void setnOfGames(int nOfGames) {
        this.nOfGames = nOfGames;
    }

    public void addTotalScore(int newScore) { this.totalScore += newScore; }
}
