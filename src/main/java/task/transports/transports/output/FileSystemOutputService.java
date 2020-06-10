package task.transports.transports.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Component
@Slf4j
public class FileSystemOutputService implements OutputService {

    public static final String OUTPUT_JSON_FILENAME_SUFFIX = "_output.json";

    @Value("${fs.files.path.output}")
    private String path;

    @Override
    public void processOutput(Map<String, TransportSummary> filesSummary) {
        filesSummary.forEach((key, value) -> {
            String outputFileName = key + OUTPUT_JSON_FILENAME_SUFFIX;
            exportOutput(outputFileName, value);
        });
    }

    @Override
    public void exportOutput(String fileName, TransportSummary summary) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Files.createDirectories(Paths.get(path));
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path + "//" + fileName), summary);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }

    }

}
