package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database.RecordDAO;
import cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell.database.RecordDatabase;

public class RecordLab {

    private static RecordLab recordLab;

    private RecordDAO recordDAO;

    public RecordLab(Context context) {
        Context appContext = context.getApplicationContext();
        RecordDatabase database =
                Room.databaseBuilder(appContext, RecordDatabase.class, "record").allowMainThreadQueries().build();
        this.recordDAO = database.getGameDAO();
    }

    public static RecordLab get(Context context) {
        if(recordLab == null) recordLab = new RecordLab(context);
        return recordLab;
    }

    public ArrayList<Record> getGames() {
        List<Record> aux = this.recordDAO.getGames();
        ArrayList<Record> recordList = new ArrayList<>(aux);
        return recordList;
    }

    public void addGame(Record record) {

        List<Record> playerList = this.recordDAO.getGamesFromPlayer(record.getId());

        if(playerList == null) {
            this.recordDAO.addGame(record);
        }
        this.recordDAO.addPlayedGame(record.getId());
        this.recordDAO.updateTotalScore(record.getScore(), record.getId());
    }
}
