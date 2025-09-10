import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class Treadhs {
    public static void main(String[] args) {
        final int NTASKS = 100;
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < NTASKS; i++) {
            service.submit(() -> {
                long id = Thread.currentThread().threadId();
                LockSupport.parkNanos(1_000_000_000);
                System.out.println(id);
                Treadhs t = new Treadhs();
                int resultado = t.forparalelo((int) id);
                System.out.println("Resultado: " + resultado);

                for (int j = 0; j < 10; j++) {
                    System.out.println("Thread ID: " + id + " - Count: " + j);
                }
            });
        }


        service.close();
    }
    public int forparalelo (int id){
        for(int i=0;i<1000;i++){
            id+=i;
        }
        return id;

    }

}