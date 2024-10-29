public class NetworkMonitor implements Runnable {

    private String initialName;
    private int sleepDuration;

    public NetworkMonitor(String initialName, int sleepDuration) {
        this.initialName = initialName;
        this.sleepDuration = sleepDuration;
    }

    @Override
    public void run() {
        // Set the initial thread name
        Thread.currentThread().setName(initialName);
        System.out.println(Thread.currentThread().getName() + " started.");

        try {
            // Simulate the network check by putting the thread to sleep
            Thread.sleep(sleepDuration);
        } catch (InterruptedException e) {
            System.out.println("Network check interrupted.");
            return;
        }

        // Update the thread name after network check is done
        Thread.currentThread().setName("Network Check Complete");
        System.out.println(Thread.currentThread().getName() + " finished.");
    }

    public static void main(String[] args) {
        // Create and start a thread to simulate network monitoring
        NetworkMonitor networkMonitor = new NetworkMonitor("Checking Network...", 2000);
        Thread monitorThread = new Thread(networkMonitor);
        monitorThread.start();
    }
}

