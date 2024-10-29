class CoffeeShop {
    private boolean coffeeReady = false;

    // Barista makes coffee (Producer)
    public synchronized void makeCoffee() throws InterruptedException {
        // Wait until the previous coffee is consumed
        while (coffeeReady) {
            wait();
        }
        // Simulate coffee preparation
        System.out.println("Barista: Making coffee...");
        Thread.sleep(1000); // Simulate the time to make coffee
        coffeeReady = true;
        System.out.println("Barista: Coffee is ready.");
        notify(); // Notify the customer that coffee is ready
    }

    // Customer drinks coffee (Consumer)
    public synchronized void drinkCoffee() throws InterruptedException {
        // Wait until the coffee is ready
        while (!coffeeReady) {
            wait();
        }
        // Simulate drinking coffee
        System.out.println("Customer: Drinking coffee...");
        Thread.sleep(500); // Simulate the time to drink coffee
        coffeeReady = false;
        System.out.println("Customer: Finished drinking coffee.");
        notify(); // Notify the barista to make another coffee
    }
}

class Barista implements Runnable {
    private CoffeeShop shop;

    public Barista(CoffeeShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                shop.makeCoffee();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer implements Runnable {
    private CoffeeShop shop;

    public Customer(CoffeeShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                shop.drinkCoffee();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();
        Thread baristaThread = new Thread(new Barista(shop));
        Thread customerThread = new Thread(new Customer(shop));

        // Start both the barista and the customer threads
        baristaThread.start();
        customerThread.start();
    }
}
