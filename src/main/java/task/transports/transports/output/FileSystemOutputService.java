package task.transports.transports.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Slf4j
@Data
public class FileSystemOutputService implements OutputService {

    public static final String DELIMITER = "//";
    private final String OUTPUT_JSON_FILENAME_PREFIX = "output_";

    @Value("${output.directory}")
    private String path;

    @Override
    public void processOutput(String fileName, TransportSummary filesSummary) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Files.createDirectories(Paths.get(path));
            mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(path + DELIMITER + OUTPUT_JSON_FILENAME_PREFIX + fileName), filesSummary);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }

}
