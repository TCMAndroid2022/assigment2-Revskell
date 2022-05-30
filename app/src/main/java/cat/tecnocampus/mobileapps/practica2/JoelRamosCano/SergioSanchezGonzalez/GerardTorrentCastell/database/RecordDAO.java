package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.Record;

@Dao
public interface RecordDAO {

    @Query("SELECT * FROM Record")
    List<Record> getGames();

    @Insert
    void addGame(Record record);

    @Query("UPDATE Record SET record_nOfGames = record_nOfGames + 1 WHERE record_id = id") // no entiendo porque me da este error, hay que mirarlo
    void addPlayedGame(String id);
}
