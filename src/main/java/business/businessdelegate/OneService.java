package business.businessdelegate;

import java.applet.AudioClip;

public class OneService implements BusinessService{
    public void doProcessing()
    {
        System.out.println("Processed Service One");
        AudioClip audio=java.applet.Applet.newAudioClip(getClass().getResource("/main/java/musics/BellaCiao.mp3"));
        audio.play();
    }
}
