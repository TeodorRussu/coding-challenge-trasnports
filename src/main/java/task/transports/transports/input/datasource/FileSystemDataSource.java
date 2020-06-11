package task.transports.transports.input.datasource;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Profile("fs")
public class FileSystemDataSource implements DataSource {

    public static final String DELIMITER = "//";
    @Setter
    @Value("${fs:path}")
    private String path;

    @Setter
    @Value("${filename}")
    private String fileName;

    @Override
    public File getInputFile() {
        File inputFile = new File(path + DELIMITER + fileName);
        if (inputFile.isDirectory()) {
            throw new IllegalArgumentException("Invalid path");
        }
        return inputFile;
    }
}
