import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ComplexTaskExecutor {
    private final CyclicBarrier barrier;
    private final Logger barierLogger;
    public ComplexTaskExecutor(int n) {
        barierLogger = Logger.getLogger("ComplexTaskExecutorLogger");
        this.barrier = new CyclicBarrier(n, () -> barierLogger.info("Задачи выполнены!"));
    }

    public void executeTasks(int numberOfTasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            executorService.submit(() -> {
                try {
                    new ComplexTask(UUID.randomUUID()).run();
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    barierLogger.warning(e.getMessage());
                }
                finally {
                    executorService.shutdown();
                }
            });
        }
    }

}
