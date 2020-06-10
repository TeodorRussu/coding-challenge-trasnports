package task.transports.transports.input.datasource;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class AwsDataSource implements DataSource {
    @Override
    public List<File> getFiles() {
        return null;
    }
}
