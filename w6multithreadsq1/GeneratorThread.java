import java.util.Random;

public class GeneratorThread extends Thread {
    private final SharedResource sharedResource;

    public GeneratorThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(100); // Generate a random integer between 0 and 99
            sharedResource.setNumber(number);
            System.out.println("Generated: " + number);
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
