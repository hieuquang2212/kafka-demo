package org.baeldung;

/**
 * Hello world!
 *
 */
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

fun main(args: Array<String>) {
        val config: Properties = Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass);
        config.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass);
        val builder: KStreamBuilder = KStreamBuilder();
        val stream: KStream<String, String> = builder.stream("odd", "even", "demo");

        val kafkaStreams: KafkaStreams =  KafkaStreams(builder, config);
        println("Open streams...")
        kafkaStreams.start();
}