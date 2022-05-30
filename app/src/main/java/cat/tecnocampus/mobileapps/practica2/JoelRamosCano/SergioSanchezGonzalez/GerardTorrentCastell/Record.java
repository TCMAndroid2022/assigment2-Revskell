package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Record")
public class Record {

    public Record() {
        this.id = UUID.randomUUID().toString();
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "record_id")
    public String id;

    @ColumnInfo(name = "record_player")
    public String player;

    @ColumnInfo(name = "record_score")
    public int score;

    @ColumnInfo(name = "record_nOfGames")
    public int nOfGames;

    public String getId() { return this.id; }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setnOfGames(int nOfGames) {
        this.nOfGames = nOfGames;
    }
}