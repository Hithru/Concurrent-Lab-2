public class Main {
    public static void main(String[] args) {
        final int numberOfRiders = 100;
        SenateBus bus = new SenateBus();

        for (int i = 1; i <= numberOfRiders; i++) {
            int riderId = i;
            new Thread(() -> {
                System.out.println("Rider " + riderId + " is waiting at the bus stop.");
                bus.boardBus();
                System.out.println("Rider " + riderId + " boarded the bus.");
            }).start();
        }

        // First Bus Arrived
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                bus.depart();
                Thread.sleep(1000);
                System.out.println("Bus departed from the bus stop.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //Second Bus Arrived
        new Thread(() -> {
            try {
                Thread.sleep(15000);
                bus.depart();
                Thread.sleep(20000);
                System.out.println("Bus departed from the bus stop.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
