package designPattern.test.mediator;

/**
 * Created by yanhuan1 on 2018/2/14.
 */
public class MainBoard implements Mediator {

    private CDDriver cdDriver;

    private CPU cpu;

    private VideoCard videoCard;

    private SoundCard soundCard;

    public void opeCDDriverReadData(CDDriver cdDriver) {
        String data = cdDriver.getData();
        cpu.executeData(data);
    }

    public void opeCPU(CPU cpu) {
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();
        videoCard.showData(videoData);
        soundCard.showData(soundData);
    }

    public CDDriver getCdDriver() {
        return cdDriver;
    }

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    @Override
    public void changed(Device device) {
        if (device instanceof CDDriver) {
            opeCDDriverReadData((CDDriver) device);
        } else if (device instanceof CPU) {
            opeCPU((CPU) device);
        }
    }
}
