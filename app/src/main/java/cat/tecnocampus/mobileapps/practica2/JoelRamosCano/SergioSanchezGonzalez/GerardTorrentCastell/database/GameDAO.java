package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.Game;

@Dao
public interface GameDAO {

    @Query("SELECT * FROM Game")
    List<Game> getGames();

    @Insert
    void addGame(Game game);
}
