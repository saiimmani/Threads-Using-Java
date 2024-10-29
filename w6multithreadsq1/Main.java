public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        GeneratorThread generator = new GeneratorThread(sharedResource);
        EvenNumberThread evenThread = new EvenNumberThread(sharedResource);
        OddNumberThread oddThread = new OddNumberThread(sharedResource);

        generator.start();
        evenThread.start();
        oddThread.start();
    }
}

