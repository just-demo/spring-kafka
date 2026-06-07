# spring-kafka

## Run Kafka

```
docker compose -f kafka/docker-compose.yml up --force-recreate
```

## Create topic

```
docker exec -it kafka /opt/kafka/bin/kafka-topics.sh \
  --create \
  --topic demo-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1
```

## List topics

```
docker exec -it kafka /opt/kafka/bin/kafka-topics.sh \
  --bootstrap-server kafka:9092 \
  --list
```

## Run producer

```
docker exec -it kafka /opt/kafka/bin/kafka-console-producer.sh \
  --topic demo-topic \
  --bootstrap-server localhost:9092
```

## Run consumer

```
docker exec -it kafka /opt/kafka/bin/kafka-console-consumer.sh \
  --topic demo-topic \
  --from-beginning \
  --bootstrap-server localhost:9092
```