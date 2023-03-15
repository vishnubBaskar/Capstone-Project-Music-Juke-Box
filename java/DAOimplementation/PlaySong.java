package DAOimplementation;
//package org.example;

import javax.sound.midi.MidiFileFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;


public class PlaySong{

//    private MidiFileFormat clip;

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new PlaySong().readAudio("C:\\NIIT PGP in SE\\Jukebox_Final_Project_Java\\src\\main\\resources\\a_song.wav",1);
    }

    public  void readAudio(String audioSrcFile, int count) {
        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count-1;
        try {

            playAudio.playAudio1(audioSrcFile,count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("------------------------\"  PLAYING SONG INTERFACE \"--------------------------------------------------------------------------------------------------------");

                System.out.println("1. PAUSE SONG");
                System.out.println("2. RESUME SONG");
                System.out.println("3. RESTART SONG");
                System.out.println("4. STOP SONG");
//                System.out.println("5.  JUMP TO TIMING");

                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("YOU PAUSED YOUR SONG SELECT 2 FOR RESUME 3 FOR RESTART AND 4 FOR STOP ");
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("YOU RESUMED YOUR SONG LISTEN AND ENJOY");
                        break;
                    case 3:
                        playAudio.restart();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("YOU RESTARTED YOUR SONG SELECT 1 FOR PAUSE 2 FOR RESUME AND 4 FOR STOP ");
                        break;
                    case 4:
                        playAudio.stop();
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("YOU STOPPED LISTENING SONG THANKS FOR LISTENING SONG ");
                        break;
                    /*case 5:
                        System.out.println("Enter time (" + 0 +
                                ", " + playAudio.clip.getFrameLength() +")");
                        System.out.println(playAudio.clip.getFramePosition());
                        System.out.println();
                        Scanner sc = new Scanner(System.in);
                        long c1 = sc.nextLong();
                        playAudio.jump(c1);
                        break;*/
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
}
