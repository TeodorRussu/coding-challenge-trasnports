package task.cloud.transports;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import task.cloud.transports.controller.TransportController;

@SpringBootApplication
@Slf4j
public class TransportsApplication implements CommandLineRunner {

    @Setter(onMethod = @__({@Autowired}))
    TransportController transportController;

    public static void main(String[] args) {
        SpringApplication.run(TransportsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            transportController.processData();
        } catch (Exception exception) {
            log.error("Oops, something went wrong: {}", exception.getLocalizedMessage());
        }
    }
}
