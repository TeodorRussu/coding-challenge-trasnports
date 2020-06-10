package task.transports.transports.input.datasource;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public interface DataSource {
    public List<File> getFiles();
}
