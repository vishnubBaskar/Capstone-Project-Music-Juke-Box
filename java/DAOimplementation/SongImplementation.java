package DAOimplementation;

import DAOinterface.SongInterface;
import Model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongImplementation implements SongInterface {
    @Override
    public List<Song> displayAllsongs() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Song> allSongs=new ArrayList<>();
        Song song=null;
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from song");
            while (rs.next()){
                song=new Song();
                song.setSong_name(rs.getString(1));
                song.setSong_id(rs.getInt(2));
                song.setSong_duration(rs.getString(3));
                song.setArtist(rs.getString(4));
                song.setGenre(rs.getString(5));
                song.setSong_file_path(rs.getString(6));
                song.setPlaylist_id(rs.getInt(7));
                allSongs.add(song);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return allSongs;

    }

    @Override
    public List<Song> sortSngs() throws SQLException {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Song> sortsong=new ArrayList<>();
        Song sortingsong=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from song order by songname");
            while (rs.next()) {
                sortingsong = new Song();
                sortingsong.setSong_name(rs.getString(1));
                sortingsong.setSong_id(rs.getInt(2));
                sortingsong.setSong_duration(rs.getString(3));
                sortingsong.setArtist(rs.getString(4));
                sortingsong.setGenre(rs.getString(5));
                sortingsong.setSong_file_path(rs.getString(6));
                sortingsong.setPlaylist_id(rs.getInt(7));
                sortsong.add(sortingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return sortsong;
    }


    @Override
    public Song searchSong(int songid) {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        Song searchingsong=null;
        try {
            PreparedStatement st = conn.prepareStatement("select * from song where songid=?");
            st.setString(1, String.valueOf(songid));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searchingsong = new Song();
                searchingsong.setSong_name(rs.getString(1));
                searchingsong.setSong_id(rs.getInt(2));
                searchingsong.setSong_duration(rs.getString(3));
                searchingsong.setArtist(rs.getString(4));
                searchingsong.setGenre(rs.getString(5));
                searchingsong.setSong_file_path(rs.getString(6));
                searchingsong.setPlaylist_id(rs.getInt(7));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchingsong;
    }

    @Override
    public void playsong() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        PlaySong playSongs=new PlaySong();
        System.out.println("ENTER YOUR PLAYLIST ID");
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

    @Override
    public List<Song> searchsongbygenere(String genere) {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Song> searchsong=new ArrayList<>();
        Song searchingsong=null;
        try {
            PreparedStatement st = conn.prepareStatement("select * from song where genere=?");
            st.setString(1, String.valueOf(genere));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searchingsong = new Song();
                searchingsong.setSong_name(rs.getString(1));
                searchingsong.setSong_id(rs.getInt(2));
                searchingsong.setSong_duration(rs.getString(3));
                searchingsong.setArtist(rs.getString(4));
                searchingsong.setGenre(rs.getString(5));
                searchingsong.setSong_file_path(rs.getString(6));
                searchingsong.setPlaylist_id(rs.getInt(7));
                searchsong.add(searchingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchsong;

    }

    @Override
    public List<Song> searchsongbyfirstname( String songname) {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        List<Song> searchsong=new ArrayList<>();
        Song searchingsong=null;
        try {
            PreparedStatement st = conn.prepareStatement("select * from  song where  songname like ? ");
            st.setString(1, songname);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searchingsong = new Song();
                searchingsong.setSong_name(rs.getString(1));
                searchingsong.setSong_id(rs.getInt(2));
                searchingsong.setSong_duration(rs.getString(3));
                searchingsong.setArtist(rs.getString(4));
                searchingsong.setGenre(rs.getString(5));
                searchingsong.setSong_file_path(rs.getString(6));
                searchingsong.setPlaylist_id(rs.getInt(7));
                searchsong.add(searchingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchsong;
    }

    public boolean addsonginplaylist() {
        DBconnection con=new DBconnection();
        Connection conn=con.getconnection();
        Scanner s1=new Scanner(System.in);
        System.out.println("ENTER YOUR   SONG ID");
        int songid=s1.nextInt();
        System.out.println("ENTER YOUR PLAYLIST ID ");
        int playlistid=s1.nextInt();

        try{
            PreparedStatement st=conn.prepareStatement("update song set playlistid=? where songid=?");
            st.setInt(1, playlistid);
            st.setInt(2,songid);
            int rows= st.executeUpdate();
            return true;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;

    }
}
