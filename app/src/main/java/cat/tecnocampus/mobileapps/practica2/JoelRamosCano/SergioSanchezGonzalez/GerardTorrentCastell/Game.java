package cat.tecnocampus.mobileapps.practica2.JoelRamosCano.SergioSanchezGonzalez.GerardTorrentCastell;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {

    private String playerNickname;
    private int score;

    public Game(String playerNickname) {
        this.playerNickname = playerNickname;
        this.score = 0;
    }

    protected Game(Parcel in) {
        this.playerNickname = in.readString();
        this.score = in.readInt();
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getPlayerNickname() { return playerNickname; }

    public void setPlayerNickname(String playerNickname) { this.playerNickname = playerNickname; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(playerNickname);
        parcel.writeInt(score);
    }
}
