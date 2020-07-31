
chạy server zookeeper: zookeeper: zookeeper-server-start.bat C:\app\kafka_2.12-2.5.0\config\zookeeper.properties
chay server kafka: kafka-server-start.bat C:\app\kafka_2.12-2.5.0\config\server.properties

1. git clone  https://github.com/hieuquang2212/kafka-demo.git
2. cd kafka-demo
3. cd parent-project
4. mvn clean package 

5. chay stream:
java -jar ./streams/target/streams-1.0-SNAPSHOT-jar-with-dependencies.jar 
6. chay producer:
java -jar ./producer/target/producer-1.0-SNAPSHOT-jar-with-dependencies.jar
7. chay consumer:
java -jar ./consumer/target/consumer-1.0-SNAPSHOT-jar-with-dependencies.jar




 