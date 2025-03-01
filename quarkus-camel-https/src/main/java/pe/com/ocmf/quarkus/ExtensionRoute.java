package pe.com.ocmf.quarkus;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public class ExtensionRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest("/api")
                .get("/extensions")
                .param().name("id").type(RestParamType.query).description("Id artifact")
                .endParam()
                .to("direct:callExtensions");

        from("direct:callExtensions")
                .setHeader("Content-Type", constant("application/json"))
                .setHeader("Accept", constant("application/json"))
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .removeHeader(Exchange.HTTP_PATH)
                .toD("{{quarkus.rest-client.extensions-api.url}}?bridgeEndpoint=true&id=${header.id}")
                .log("response received: ${body}");
    }
}
