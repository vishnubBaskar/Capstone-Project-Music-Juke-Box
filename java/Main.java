import DAOimplementation.*;
import Model.Playlist;
import Model.Podcast;
import Model.Song;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        System.out.println("--------------WELCOME TO JUKEBOX---------------");
        System.out.println("DO YOU HAVE THE ACCOUNT");
        System.out.println("1) YES I HAVE");
        System.out.println("2) NO  I NEED TO CREATE");
        System.out.println("3) NO I NEED NOT TO CREATE");
        int input = scanner.nextInt();
        UserImplementation userimplementation = new UserImplementation();
        if (input == 2)
        {
                 boolean flag=userimplementation.createAccount();
                    System.out.println("SUCCESSFULLY CREATED");
        }
        else if (input==3)
        {
            System.out.println("THANKS FOR VISITING JUKEBOX");
            System.exit(0);
        }
        else if (input == 1)
         {

            boolean flag=userimplementation.login();
             while (true) {
                 System.out.println("---------------------------------------MAIN MENU------------------------------------------------------------------------------------------");
                 System.out.println("1. SONGS");
                 System.out.println("2. PODCAST");
                 System.out.println("3. PLAYLIST");
                 System.out.println("4. PLAY SONG");
                 System.out.println("5. PLAY PODCAST");
                 System.out.println("6. EXIT");
                 System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                 int main = scanner.nextInt();

                System.out.println("WELCOME JUKEBOX USER");
             if (main == 1) {
                 System.out.println("----------------------------------------------SONGS MENU---------------------------------------------------------------------------");
                 System.out.println("1. DISPLAY ALL SONGS");
                 System.out.println("2. SORT ALL SONGS");
                 System.out.println("3. SEARCH SONG");
                 System.out.println("4. SEARCH SONG BY GENRE");
                 System.out.println("5. SEARCH SONG BY FIRST LETTER");
                 System.out.println("6. ADD SONG IN PLAYLIST");
                 System.out.println("7. MAIN MENU");
                 System.out.println("8. EXIT");
                 System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                 int song = scanner.nextInt();
                 SongImplementation obj2 = new SongImplementation();
                 switch (song) {
                     case 1:
                         System.out.println("LIST OF SONGS");
                         List<Song> allSongDetails = obj2.displayAllsongs();
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","SONG NAME","SONG ID","SONG DURATION","SONG ARTIST","SONG GENERE","SONG FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         for (Song s : allSongDetails) {
                             System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n",s.getSong_name(),s.getSong_id(),s.getSong_duration(),s.getArtist(),s.getGenre(),s.getSong_file_path(),s.getPlaylist_id());
                         }
                         break;
                     case 2:
                         System.out.println("SORTED LIST OF SONGS");
                         List<Song> sorted = obj2.sortSngs();
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","SONG NAME","SONG ID","SONG DURATION","SONG ARTIST","SONG GENERE","SONG FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         for (Song s : sorted) {
                             System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n", s.getSong_name(), s.getSong_id(), s.getSong_duration(), s.getArtist(), s.getGenre(), s.getSong_file_path(), s.getPlaylist_id());
                         }
                         break;
                     case 3:
                         System.out.println(" ENTER THE SONG ID ");
                         int id = scanner.nextInt();
                         Song s = obj2.searchSong(id);
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","SONG NAME","SONG ID","SONG DURATION","SONG ARTIST","SONG GENERE","SONG FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n", s.getSong_name(), s.getSong_id(), s.getSong_duration(), s.getArtist(), s.getGenre(), s.getSong_file_path(), s.getPlaylist_id());

                         break;
                     case 4:
                         System.out.println(" ENTER THE SONG GENERE ");
                         String genere = scanner.next();
                         List<Song> s1 = obj2.searchsongbygenere(genere);
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","SONG NAME","SONG ID","SONG DURATION","SONG ARTIST","SONG GENERE","SONG FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         for(Song searchgen:s1)
                         System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n", searchgen.getSong_name(), searchgen.getSong_id(), searchgen.getSong_duration(), searchgen.getArtist(), searchgen.getGenre(), searchgen.getSong_file_path(), searchgen.getPlaylist_id());
                         break;
                     case 5:
                         System.out.println(" ENTER THE SONG FIRST LETTER ");
                         String songname = scanner.next();
                         List<Song> s2 = obj2.searchsongbyfirstname(songname);
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","SONG NAME","SONG ID","SONG DURATION","SONG ARTIST","SONG GENERE","SONG FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         for (Song s4 : s2) {

                             System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n",s4.getSong_name(),s4.getSong_id(),s4.getSong_duration(),s4.getArtist(),s4.getGenre(),s4.getSong_file_path(),s4.getPlaylist_id());
                         }
//                         System.out.format("%-20s %20d %30s %35s %40s %100s %40d \n", s2, s1.getSong_id(), s1.getSong_duration(), s1.getArtist(), s1.getGenre(), s1.getSong_file_path(), s1.getPlaylist_id());

                         break;

                     case 6:
                         boolean addsonginplaylist=obj2.addsonginplaylist();
                         System.out.println("YOUR SONG IS ADDED IN PLAY LIST SUCCESSFULLY");
                         break;
                     case 7:
                         break;

                     case 8:
                         System.exit(0);

                 }
                 }
             if (main == 2) {
                 System.out.println("-----------------------------------------------PODCAST MENU-------------------------------------------------------------------------------------");
                 System.out.println("1. DISPLAY ALL PODCAST");
                 System.out.println("2. SORT ALL PODCAST");
                 System.out.println("3. SEARCH PODCAST");
                 System.out.println("4. MAIN MENU");
                 System.out.println("5. EXIT");
                 System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                 int choice2 = scanner.nextInt();
                  PodcastImplentation obj2 = new PodcastImplentation();
                 switch (choice2) {
                     case 1:
                         System.out.println("LIST OF PODCAST");
                         List<Podcast> allpodcastDetails = obj2.display_allpodcast();
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","PODCAST NAME","PODCAST ID","PODCAST DURATION","PODCAST EPISODE","PODCAST LANGUAGE","PODCAST FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         for (Podcast podcast : allpodcastDetails) {
                             System.out.format("%20s %20d %30s %35s %40s %100s %40d \n",podcast.getPodcast_name(),podcast.getPlaylist_id(),podcast.getPodcast_duration(),podcast.getPodcast_episode(),podcast.getPodcast_lang(),podcast.getPodcast_file_path(),podcast.getPlaylist_id());
                                                   }
                         break;
                     case 2:
                         System.out.println("SORTED LIST OF PODCAST");
                         List<Podcast> sorted = obj2.sort_podcasts() ;
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","PODCAST NAME","PODCAST ID","PODCAST DURATION","PODCAST EPISODE","PODCAST LANGUAGE","PODCAST FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         for (Podcast podcast : sorted) {

                             System.out.format("%20s %20d %30s %35s %40s %100s %40d \n",podcast.getPodcast_name(),podcast.getPlaylist_id(),podcast.getPodcast_duration(),podcast.getPodcast_episode(),podcast.getPodcast_lang(),podcast.getPodcast_file_path(),podcast.getPlaylist_id());
                         }
                         break;
                     case 3:
                         System.out.println("ENTER THE PODCASTID ");
                         int id = scanner.nextInt();
                         Podcast podcast = obj2.search_podcasts(id);
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20s %30s %35s %40s %100s %40s \n","PODCAST NAME","PODCAST ID","PODCAST DURATION","PODCAST EPISODE","PODCAST LANGUAGE","PODCAST FILE PATH","SONG PLAYLISTID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         System.out.format("%20s %20d %30s %35s %40s %100s %40d \n",podcast.getPodcast_name(),podcast.getPlaylist_id(),podcast.getPodcast_duration(),podcast.getPodcast_episode(),podcast.getPodcast_lang(),podcast.getPodcast_file_path(),podcast.getPlaylist_id());
                         break;
                     case 4:
                         break;
                     case 5:
                         System.exit(0);

                 }
             }


             if(main==3)
             {
                 System.out.println("----------------------------------------------------------PLAYLIST MENU-------------------------------------------------------------------------");
                 System.out.println("1. DISPLAY ALL PLAYLIST");
                 System.out.println("2. SORT PLAYLIST");
                 System.out.println("3. ADD PLAYLIST");
                 System.out.println("4. PLAY SONG IN PLAYLIST");
                 System.out.println("5. EXIT");
                 System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                 int choice4=scanner.nextInt();
                 PlaylistImplementation obj2 =new PlaylistImplementation();
                 switch(choice4){
                     case 1:
                         System.out.println("LIST OF PLAYLIST");
                         List<Playlist> allSongDets = obj2.display_asPlaylist();
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20S %30s  \n","PLAYLIST ID","PLAYLIST NAME","PLAYLIST USER ID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         for (Playlist playlist : allSongDets) {
                             System.out.format("%20d %20s %30s\n",playlist.getPlaylist_id(),playlist.getPlaylist_name(),playlist.getUserid());
                         }
                         break;
                     case 2:
                         System.out.println("SORTED LIST OF  PLAYLIST");
                         List<Playlist> sorted = obj2.sort_Playlist();
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.format("%20s %20S %30s  \n","PLAYLIST ID","PLAYLIST NAME","PLAYLIST USER ID");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         for (Playlist playlist : sorted) {
                             System.out.format("%20d %20s %30s\n",playlist.getPlaylist_id(),playlist.getPlaylist_name(),playlist.getUserid());
                         }
                         break;
                     case 3:
                         boolean resul=obj2.addplaylist();
                         break;

                     case 4:
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                         System.out.println("--------------LISTEN AND ENJOY YOUR PLAYLIST SONG--------------------------------------------------------------------------------------------------------");
                         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                         obj2.Play_song_in_Playlist();
                         break;
                     case 5:
                         System.out.println("THANKS FOR USING JUKEBOX WELCOME");
                         System.exit(0);
                 }
             }



                 if(main==4)
                 {
                     System.out.println("------------------------\"PLAY SONG MENU\"--------------------------------------------------------------------------------------------------------");

                     System.out.println("1: PLAY SONG");
                     System.out.println("2. EXIT");
                     System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                     int choice5=scanner.nextInt();
                     SongImplementation obj2=new SongImplementation();
                     switch(choice5)
                     {
                         case 1:

                             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                             System.out.println("--------------LISTEN AND ENJOY YOUR PLAY SONG--------------------------------------------------------------------------------------------------------");
                             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                             obj2.playsong();
                             break;
                         case 2:
                             System.out.println("THANKS FOR USING JUKEBOX WELCOME");
                             System.exit(0);
                     }
                 }


                 if(main==5)
                 {
                     System.out.println("------------------------\"PLAY PODCAST MENU\"--------------------------------------------------------------------------------------------------------");

                     System.out.println("1: PLAY PODCAST");
                     System.out.println("2. EXIT");
                     System.out.println("------------------------\"SELECT ANYONE TO PROCEED\"--------------------------------------------------------------------------------------------------------");

                     int choice5=scanner.nextInt();
                     PodcastImplentation obj2=new PodcastImplentation();
                     switch(choice5)
                     {
                         case 1:

                             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                             System.out.println("--------------LISTEN AND ENJOY YOUR PODCAST SONG--------------------------------------------------------------------------------------------------------");
                             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

                             obj2.Play_podcast();
                             break;
                         case 2:
                             System.out.println("THANKS FOR USING JUKEBOX WELCOME");
                             System.exit(0);
                     }
                 }

                 if(main==6)
                 {
                     System.out.println("THANKS FOR USING JUKEBOX WELCOME");
                     System.exit(0);
                 }
        }
    }
}
}
