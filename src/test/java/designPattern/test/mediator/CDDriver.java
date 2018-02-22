package designPattern.test.mediator;

/**
 * CDDriver
 */
public class CDDriver extends Device {

    private String data;

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void readCD() {
        data = "设计模式,值得好好研究";
        getMediator().changed(this);
    }
}
