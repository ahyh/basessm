package designPattern.test.mediator;

/**
 * Created by yanhuan1 on 2018/2/14.
 */
public class CPU extends Device {

    private String videoData;
    private String soundData;

    public CPU(Mediator mediator) {
        super(mediator);
    }

    public String getVideoData() {
        return videoData;
    }

    public void setVideoData(String videoData) {
        this.videoData = videoData;
    }

    public String getSoundData() {
        return soundData;
    }

    public void setSoundData(String soundData) {
        this.soundData = soundData;
    }

    public void executeData(String data) {
        String[] datas = data.split(",");
        this.videoData = datas[0];
        this.soundData = datas[1];
        getMediator().changed(this);
    }
}
