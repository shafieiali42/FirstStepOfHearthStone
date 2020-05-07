package Utility;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sounds {


    private final static Sounds SoundInstance = new Sounds();

    private static float soundVolume = 1;

    private static AudioInputStream audioInputStream;
    private static Clip clipOfMainSound;
    private static Clip clipOfActionSounds;


    private static boolean muteSound = false;

    public static Sounds getInstance() {
        return SoundInstance;
    }


    public static void playMainSound(String path) {
        if (clipOfActionSounds != null) {

            clipOfActionSounds.stop();
        }
        if (clipOfMainSound!=null){
            clipOfMainSound.stop();
        }

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            clipOfMainSound = AudioSystem.getClip();
            clipOfMainSound.open(audioInputStream);

            FloatControl floatControl = (FloatControl) clipOfMainSound.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));

            if (muteSound) {
                BooleanControl booleanControl = (BooleanControl) clipOfMainSound.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(true);
            } else {
                BooleanControl booleanControl = (BooleanControl) clipOfMainSound.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(false);
            }

            clipOfMainSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public static void playActionSounds(String path) {
        if (clipOfMainSound != null) {
            clipOfMainSound.stop();
        }
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            clipOfActionSounds = AudioSystem.getClip();
            clipOfActionSounds.open(audioInputStream);

            FloatControl floatControl = (FloatControl) clipOfActionSounds.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));

            if (muteSound) {
                BooleanControl booleanControl = (BooleanControl) clipOfActionSounds.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(true);
            } else {
                BooleanControl booleanControl = (BooleanControl) clipOfActionSounds.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(false);
            }

            clipOfActionSounds.start();
            Thread.sleep(1000);
            if (!muteSound) {
                clipOfMainSound.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void changeStatus(int numberOfPushMuteBtn) {
        muteSound = !muteSound;
        if (numberOfPushMuteBtn % 2 == 0) {
            clipOfMainSound.stop();
        } else {
            clipOfMainSound.start();
        }
    }

    public static void decreaseSound() {
        if (soundVolume > 0.06) {

            soundVolume -= 0.06;

            FloatControl floatControl = (FloatControl) clipOfMainSound.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));
        }
    }

    public static void increaseSound() {
        if (soundVolume < 1) {
            soundVolume += 0.06;

            FloatControl floatControl = (FloatControl) clipOfMainSound.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));
        }
    }


}
