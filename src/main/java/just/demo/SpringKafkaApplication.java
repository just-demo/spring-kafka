package just.demo;

import static java.lang.System.currentTimeMillis;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication {

  // This topic is created manually, see README.md file
  private static final String DEMO_TOPIC = "demo-topic";

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }

  @KafkaListener(groupId = "demo-group-1", id = "demo-consumer-1", topics = DEMO_TOPIC)
  public void listen1(String message) {
    System.out.println("demo-consumer-1: " + message);
  }

  @KafkaListener(groupId = "demo-group-2", id = "demo-consumer-2", topics = DEMO_TOPIC)
  public void listen2(String message) {
    System.out.println("demo-consumer-2: " + message);
  }

  @Bean
  @SuppressWarnings("resource")
  public ApplicationRunner publish(KafkaTemplate<String, String> template) {
    return args -> newSingleThreadScheduledExecutor().scheduleAtFixedRate(() ->
        template.send(DEMO_TOPIC, "test-" + currentTimeMillis()), 0, 1, SECONDS);
  }
}
