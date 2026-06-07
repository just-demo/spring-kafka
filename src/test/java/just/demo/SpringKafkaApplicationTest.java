package just.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.EmbeddedKafkaKraftBroker;

@SpringBootTest
class SpringKafkaApplicationTest {

  @BeforeAll
  static void beforeAll() {
    EmbeddedKafkaBroker broker = new EmbeddedKafkaKraftBroker(1, 1, "demo-topic");
    broker.afterPropertiesSet();
    System.out.println("Running embedded Kafka on: " + broker.getBrokersAsString());
  }

  @Test
  void contextLoads() throws Exception {
    while (true) {
      Thread.sleep(1000);
    }
  }
}