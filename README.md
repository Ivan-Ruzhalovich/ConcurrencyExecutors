<h1 align="center">Hi there, I'm <a>Ruzhalovich Ivan</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>

<h2 align="center">This is Concurrency - Executors</h2>

## Описание
- Синхронизация потоков с использованием CyclicBarrier и ExecutorService
- В этой задаче мы будем использовать CyclicBarrier и ExecutorService для синхронизации нескольких потоков, выполняющих сложную задачу, 
и затем ожидающих, пока все потоки завершат выполнение, чтобы объединить результаты.
- Класс ComplexTask представляет сложную задачу, которую будут выполнять несколько потоков. В каждой задаче реализован метод execute(), который выполняет часть сложной задачи.
- Класс ComplexTaskExecutor, в котором будет использоваться CyclicBarrier и ExecutorService для синхронизации выполнения задач. В классе реализован метод executeTasks(int numberOfTasks), который создает пул потоков и назначает каждому потоку экземпляр сложной задачи для выполнения. Затем CyclicBarrier ожидает завершения всех потоков и объединяет результаты их работы. 
- В методе main создайте экземпляр ComplexTaskExecutor и вызовите метод executeTasks с несколькими задачами для выполнения.
## Код для тестирования
```java
public class TestComplexTaskExecutor {

    public static void main(String[] args) {
        ComplexTaskExecutor taskExecutor = new ComplexTaskExecutor(5); // Количество задач для выполнения

        Runnable testRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started the test.");

            // Выполнение задач
            taskExecutor.executeTasks(5);

            System.out.println(Thread.currentThread().getName() + " completed the test.");
        };

        Thread thread1 = new Thread(testRunnable, "TestThread-1");
        Thread thread2 = new Thread(testRunnable, "TestThread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

```
## Технологический стек:
- *Java 17*
- *Maven*
