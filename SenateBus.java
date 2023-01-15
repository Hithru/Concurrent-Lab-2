import java.util.concurrent.Semaphore;

public class SenateBus {
    private final int capacity = 50;
    private int waitingRiders = 0;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore busArrived = new Semaphore(0);
    private final Semaphore boarded = new Semaphore(0);

    public void boardBus() {
        try {
            mutex.acquire();
            waitingRiders++;
            mutex.release();
            busArrived.acquire();
            boarded.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void depart() {
        try {
            System.out.println("Bus arrived at the bus stop.");
            mutex.acquire();

            int numberOfRidersGettingBoarded;
            if (waitingRiders > capacity){
                numberOfRidersGettingBoarded = capacity;
            }else{
                numberOfRidersGettingBoarded = waitingRiders;
            }

            busArrived.release(numberOfRidersGettingBoarded);
            for (int i = 0; i < numberOfRidersGettingBoarded; i++) {
                boarded.acquire();
            }

            if (waitingRiders > capacity){
                waitingRiders = waitingRiders-capacity;
            }else{
                waitingRiders = 0;
            }

            mutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
