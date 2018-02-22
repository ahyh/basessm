package designPattern.test.mediator;

/**
 * 设备
 */
public abstract class Device {

    private Mediator mediator;

    public Device(Mediator mediator){
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
