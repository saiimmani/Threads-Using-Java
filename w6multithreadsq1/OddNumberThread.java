public class OddNumberThread extends Thread {
    private final SharedResource sharedResource;

    public OddNumberThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            int number = sharedResource.getNumber();
            if (number % 2 != 0) {
                System.out.println("Cube of " + number + ": " + (number * number * number));
            }
        }
    }
}
