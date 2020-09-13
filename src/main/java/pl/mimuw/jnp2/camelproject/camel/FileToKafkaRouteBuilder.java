package pl.mimuw.jnp2.camelproject.camel;

import org.apache.camel.builder.RouteBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import pl.mimuw.jnp2.camelproject.utils.FileToJsonConverter;

import java.io.File;

@Component
public class FileToKafkaRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("file:filesForKafka?noop=true")
                .process(exchange -> {
                    File file = exchange.getIn().getBody(File.class);
                    exchange.getIn().setBody(FileToJsonConverter.convertFileToJson(file), JSONObject.class);
                })
                .to("kafka:jnp2-fileToKafka?brokers=localhost:9092");
    }
}
