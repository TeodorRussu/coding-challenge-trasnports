package task.transports.transports;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import task.transports.transports.model.dto.RootDTO;

import java.io.File;

@SpringBootApplication
@Slf4j
public class TransportsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TransportsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();


    }
}

