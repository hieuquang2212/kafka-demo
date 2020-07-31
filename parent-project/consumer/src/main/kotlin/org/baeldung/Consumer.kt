package org.baeldung;

/**
 * Hello world!
 *
 */

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

    fun main(args: Array<String>) {
        val props: Properties = Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        val consumer: KafkaConsumer<String, String> = KafkaConsumer(props);
        consumer.subscribe(Arrays.asList("demo"));
        // System.out.printf("Recieved");
        // val records: ConsumerRecords<String, String> = consumer.poll(1);
        // println(records.count());
        // while (true) {
        // for (record: ConsumerRecord<String, String> in records) {
        //         println("offset = ${record.offset()}, key = ${record.key()}, value = ${record.value()}");
        // }
        //int counter = 0;
        while (true) {
            val recs: ConsumerRecords<String, String> = consumer.poll(10);
            if (recs.count() == 0) {
            } else {
                for (rec: ConsumerRecord<String, String> in recs) {
                    println("Received : ${rec.value()}");
                }
            }
            //counter++;
        }
    }