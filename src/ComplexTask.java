import java.util.UUID;
import java.util.logging.Logger;

public class ComplexTask implements Runnable{
    private final UUID uuid;
    private final Logger log;

    public ComplexTask(UUID uuid) {
        this.log = Logger.getLogger("Task Logger");
        this.uuid = uuid;
    }

    public UUID getNumber() {
        return uuid;
    }

    @Override
    public void run() {
        execute();
    }
    private void execute(){
        log.info("Задача " + uuid + " выполняется.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Задача " + uuid + " выполнена!");

    }
}
