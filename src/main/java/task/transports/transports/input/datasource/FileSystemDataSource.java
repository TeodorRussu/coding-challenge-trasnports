package task.transports.transports.input.datasource;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
public class FileSystemDataSource implements DataSource {

    @Setter
    @Value("${fs.files.path.input}")
    private String path;

    @Override
    public List<File> getFiles() {
        File inputDirectory = new File(path);
        if (!inputDirectory.isDirectory()) {
            throw new IllegalArgumentException("Invalid path");
        }
        return Arrays.asList(inputDirectory.listFiles());
    }
}
