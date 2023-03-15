package DAOimplementation;

import DAOinterface.PlaylistInterface;
import Model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistImplementation implements PlaylistInterface {
    @Override
    public List<Playlist> display_asPlaylist() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Playlist>display=new ArrayList<>();
        Playlist playlist=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            while(rs.next())
            {
                playlist=new Playlist();
                playlist.setPlaylist_id(rs.getInt(1));
                playlist.setPlaylist_name(rs.getString(2));
                playlist.setUserid(rs.getString(3));
                display.add(playlist);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return display;
    }

    @Override
    public boolean addplaylist() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        Scanner s1=new Scanner(System.in);
        System.out.println("ENTER YOUR  NEW PLAYLIST ID");
        int playlistid=s1.nextInt();
        System.out.println("ENTER YOUR NEW PLAYLISTNAME");
        String playlistname=s1.next();
        System.out.println("ENTER YOUR EXTINGUISH USER ID");
        String userid=s1.next();
        try{
            PreparedStatement st=conn.prepareStatement("insert into playlist(playlistid,playlistname,userid)values(?,?,?)");
            st.setInt(1,playlistid);
            st.setString(2,playlistname);
            st.setString(3,userid);
            int rows= st.executeUpdate();
            System.out.println("YOUR PLAY LIST HAS BEEN ADDED SUCCESSFULLY");
            return true;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;

    }

    @Override
    public List<Playlist> sort_Playlist() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Playlist>sort=new ArrayList<>();
        Playlist playlist=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist order by playlistname");
            while(rs.next())
            {
                playlist=new Playlist();
                playlist.setPlaylist_id(rs.getInt(1));
                playlist.setPlaylist_name(rs.getString(2));
                playlist.setUserid(rs.getString(3));
                sort.add(playlist);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
return sort;
    }

    @Override
    public void Play_song_in_Playlist() {
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
