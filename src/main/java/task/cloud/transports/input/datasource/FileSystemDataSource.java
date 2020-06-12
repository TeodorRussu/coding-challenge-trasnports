package task.cloud.transports.input.datasource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Profile("fs")
@Slf4j
public class FileSystemDataSource implements DataSource {

    public static final String DELIMITER = "/";
    @Setter
    @Value("${fs.path}")
    private String path;

    @Setter
    @Value("${filename}")
    private String fileName;

    @Override
    public File getInputFile() {
        File directory = new File(path);
        List<String> existingFiles =
            Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .map(File::getName)
                .collect(Collectors.toList());
        if (!existingFiles.contains(fileName)) {
            throw new IllegalArgumentException(
                String.format("The file %s does not exist in the working directory", fileName));
        }

        File inputFile = new File(path + DELIMITER + fileName);
        if (inputFile.isDirectory()) {
            throw new IllegalArgumentException("Invalid path");
        }
        log.info("file {} successfully loaded", fileName);
        return inputFile;
    }
}
