package task.transports.transports.input.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
public class FileSystemDataSource implements DataSource {

    @Value("/Users/rusiashka/Desktop/folder")
    private String path;

    @Override
    public List<File> getFiles() {
        return Arrays.asList(new File(path).listFiles());
    }
}
