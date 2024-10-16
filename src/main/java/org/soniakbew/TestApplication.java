package org.soniakbew;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.soniakbew.controllers.ClientController;
import org.soniakbew.controllers.DeliveryEmployeeController;
import org.soniakbew.daos.ClientDao;
import org.soniakbew.daos.DeliveryEmployeeDao;
import org.soniakbew.services.ClientService;
import org.soniakbew.services.DeliveryEmployeeService;

public class TestApplication extends Application<TestConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(
                new ClientController(
                        new ClientService(
                                new ClientDao()
                        )
                )
        );

        environment.jersey().register(
                new DeliveryEmployeeController(
                        new DeliveryEmployeeService(
                                new DeliveryEmployeeDao()
                        )
                )
        );

    }

}
