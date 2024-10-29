public class EvenNumberThread extends Thread {
    private final SharedResource sharedResource;

    public EvenNumberThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            int number = sharedResource.getNumber();
            if (number % 2 == 0) {
                System.out.println("Square of " + number + ": " + (number * number));
            }
        }
    }
}
