package thread.test.wangwenjun.workerthread;

/**
 *
 */
public abstract class InstructionBook {

    public void create() {
        this.firstProcess();
        this.secondProcess();
    }

    public abstract void firstProcess();

    public abstract void secondProcess();
}
