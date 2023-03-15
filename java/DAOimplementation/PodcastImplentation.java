package DAOimplementation;

import DAOinterface.PlaylistInterface;
import DAOinterface.PodcastInterface;
import Model.Playlist;
import Model.Podcast;
import Model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PodcastImplentation implements PodcastInterface {

    @Override
    public List<Podcast> display_allpodcast() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Podcast> allpodcast=new ArrayList<>();
        Podcast podcast=null;
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from podcast");
            while (rs.next()){
                podcast=new Podcast();
                podcast.setPodcast_name(rs.getString(1));
                podcast.setPodcast_id(rs.getInt(2));
                podcast.setPodcast_duration(rs.getString(3));
                podcast.setPodcast_episode(rs.getString(4));
                podcast.setPodcast_lang(rs.getString(5));
                podcast.setPodcast_file_path(rs.getString(6));
                podcast.setPlaylist_id(rs.getInt(7));
                allpodcast.add(podcast);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return allpodcast;
    }

    @Override
    public  List<Podcast>  sort_podcasts()
    {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Podcast> podcast=new ArrayList<>();
        Podcast sortingpodcast=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from podcast order by podcastname");
            while (rs.next()) {
                sortingpodcast = new Podcast();
                sortingpodcast.setPodcast_name(rs.getString(1));
                sortingpodcast.setPodcast_id(rs.getInt(2));
                sortingpodcast.setPodcast_duration(rs.getString(3));
                sortingpodcast.setPodcast_episode(rs.getString(4));
                sortingpodcast.setPodcast_lang(rs.getString(5));
                sortingpodcast.setPodcast_file_path(rs.getString(6));
                sortingpodcast.setPlaylist_id(rs.getInt(7));
                podcast.add(sortingpodcast);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return podcast;
    }




    @Override
    public Podcast search_podcasts(int podcast_id) {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Podcast> searchpodcast=new ArrayList<>();
        Podcast searchingpodcast=null;
        try {
            PreparedStatement st = conn.prepareStatement("select * from podcast where podcastid=?");
            st.setString(1, String.valueOf(podcast_id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searchingpodcast = new Podcast();
                searchingpodcast.setPodcast_name(rs.getString(1));
                searchingpodcast.setPodcast_id(rs.getInt(2));
                searchingpodcast.setPodcast_duration(rs.getString(3));
                searchingpodcast.setPodcast_episode(rs.getString(4));
                searchingpodcast.setPodcast_lang(rs.getString(5));
                searchingpodcast.setPodcast_file_path(rs.getString(6));
                searchingpodcast.setPlaylist_id(rs.getInt(7));
//                searchpodcast.add(searchingpodcast);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchingpodcast;
    }

    @Override
    public void Play_podcast() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        PlaySong playSongs=new PlaySong();
        System.out.println("Enter the playlist id ");
        Scanner sc1 = new Scanner(System.in);
        int id = sc1.nextInt();
        try {

            PreparedStatement pr = conn.prepareStatement("Select songfilepath from song where playlistid=?");
            pr.setInt(1, id);
            ResultSet rs= pr.executeQuery();
            while(rs.next())
            {
                playSongs.readAudio(rs.getString(1),1);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

