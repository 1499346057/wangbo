package lab6.wangbo.rest;

import java.io.IOException;
import java.net.URI;

import com.sun.jersey.api.core.PackagesResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class App {
    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) {
        System.out.println("Start");
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new PackagesResourceConfig(BeautyProductResource.class.getPackage().getName());
            resourceConfig.getProperties().put("com.sun.jersey.spi.container.ContainerRequestFilters", "lab6.wangbo.rest.AuthenticationFilter");
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }
    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}