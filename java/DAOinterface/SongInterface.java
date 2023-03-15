package DAOinterface;

import Model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongInterface {

    List<Song> displayAllsongs();
    List<Song> sortSngs() throws SQLException;
    Song searchSong(int songid);
    void playsong();
    List <Song> searchsongbygenere(String genere);
     List<Song> searchsongbyfirstname(String songname);

}
