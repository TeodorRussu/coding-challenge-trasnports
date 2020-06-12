package task.transports.transports.input.datasource;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface DataSource {
    File getInputFile();
}
