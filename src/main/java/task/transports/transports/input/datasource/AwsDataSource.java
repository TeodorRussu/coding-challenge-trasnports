package task.transports.transports.input.datasource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
@Profile("aws")
public class AwsDataSource implements DataSource {
    @Override
    public List<File> getFiles() {
        return Collections.emptyList();

    }
}
