package pdp.rest.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;

public class RestConfig extends ResourceConfig {
    public RestConfig() {
        packages("pdp.rest.jersey.resources", "pdp.rest.jersey.mentortask");
    }
}
