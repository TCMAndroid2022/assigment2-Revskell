package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

    public Game() {

    }

    @PrimaryKey
    @NonNull
    public String id;
}
