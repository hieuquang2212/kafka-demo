package org.baeldung;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

    fun main() {
        while (true) { 
        print("Enter text: ")
        val stringInput = readLine()!!
        val props:  Properties = Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
        val producer: KafkaProducer<String, String> = KafkaProducer(props)
        val data1: ProducerRecord<String, String> = ProducerRecord("demo", 0, "name", String.format(stringInput));
        println("send: key = ${data1.key()}, value = ${data1.value()}");
        producer.send(data1);
        Thread.sleep(1L);
        producer.close();
        }
    }