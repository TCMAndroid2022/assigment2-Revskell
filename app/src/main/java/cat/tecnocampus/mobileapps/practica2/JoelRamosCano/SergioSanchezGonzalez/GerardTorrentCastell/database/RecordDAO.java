package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.Record;

@Dao
public interface RecordDAO {

    @Query("SELECT * FROM Record ORDER BY record_totalScore") // mirar si es ascendiente
    List<Record> getGames();

    @Query("SELECT * FROM Record WHERE record_id = :id")
    List<Record> getGamesFromPlayer(String id);

    @Insert
    void addGame(Record record);

    @Query("UPDATE Record SET record_nOfGames = record_nOfGames + 1 WHERE record_id = :id")
    void addPlayedGame(String id);

    @Query("UPDATE Record SET record_totalScore = record_totalScore + :newScore WHERE record_id = :id")
    void updateTotalScore(int newScore, String id);
}
