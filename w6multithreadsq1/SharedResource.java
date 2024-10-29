public class SharedResource {
    private int number;
    private boolean isNumberAvailable = false;

    public synchronized int getNumber() {
        while (!isNumberAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isNumberAvailable = false;
        notifyAll();
        return number;
    }

    public synchronized void setNumber(int number) {
        while (isNumberAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.number = number;
        isNumberAvailable = true;
        notifyAll();
    }
}

