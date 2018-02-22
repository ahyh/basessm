package designPattern.test.mediator;

import org.junit.Test;

/**
 * 测试中介者模式
 */
public class MediatorTest {

    @Test
    public void testMediator(){
        MainBoard mediator = new MainBoard();
        CDDriver cdDriver = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard videoCard = new VideoCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);
        mediator.setCdDriver(cdDriver);
        mediator.setCpu(cpu);
        mediator.setVideoCard(videoCard);
        mediator.setSoundCard(soundCard);
        cdDriver.readCD();
    }
}
