package DAOimplementation;
//package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayAudio {
    Clip clip;
    AudioInputStream audioInputStream;
    String filePath;
    Long currentFrame;
    String status;
    static int count1 = 0;

    public PlayAudio() {

    }

    public void playAudio1(String filePath, int count) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        count1 = count;
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        clip = AudioSystem.getClip();

        clip.open(audioInputStream);
        clip.loop(count1);

    }

    public void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        clip.start();

        status = "play";
    }

    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        play();
    }

    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        play();
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

   /* public void jump(long c1) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        if (c1 > 0 && c1 < clip.getFrameLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c1;
            clip.setFramePosition(Math.toIntExact(c1));;
            play();
        }
    }*/
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
    }
}
