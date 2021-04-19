package com.thuso.shoppe;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;

@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Thuso's Momentum Active Shoppe",
        description = "Basic shop service where customers can purchase products with their points.",
        version = "1.0.0", contact = @Contact(name = "Thuso Kgori", email = "thusow875@gmail.com")),
        servers = {
        @Server(description = "LOCAL Environment", url = "http://localhost:8080/") })
public class ApplicationDefinition extends Application {

}
