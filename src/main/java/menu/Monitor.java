package menu;

public class Monitor<C> {
    private C value;

    synchronized public C getValue() {
        return value;
    }

    synchronized public void setValue(C value) {
        this.value = value;
    }
}