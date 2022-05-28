package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.Game;

@Database(entities = {Game.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    public abstract GameDAO getGameDAO();
}
