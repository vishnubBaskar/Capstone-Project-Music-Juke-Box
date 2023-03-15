package DAOinterface;

import Model.Playlist;

import java.util.List;

public interface PlaylistInterface {
    List<Playlist> display_asPlaylist();
    boolean addplaylist();
    List<Playlist>sort_Playlist();
    void Play_song_in_Playlist();
}
