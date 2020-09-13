# Małe zadanie JNP2

Integracja plików z kafką.

## Działanie programu
Folder o nazwie filesForKafka jest obserwowany jedynie na dodawanie nowych plików.
Gdy przeniesiemy plik tekstowy do tego folderu, zostanie on przesłany do kafki jako wiadomość JSON, z takimi informacjami jak nazwa pliku, zawartość oraz moment jego przetworzenia przez program.

## Budowanie
```
docker-compose up

kafka-topics --create --zookeeper localhost:2181 --topic jnp2-fileToKafka --replication-factor 1 --partitions 1

kafka-console-consumer --bootstrap-server localhost:9092 --topic jnp2-fileToKafka --from-beginning
```

## Uruchamianie
```
mvn clean install

mvn spring-boot:run
```

## Na koniec
```
docker-compose down
```