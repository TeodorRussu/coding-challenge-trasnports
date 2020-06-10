package task.transports.transports.service.filehandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dto.RootDTO;
import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class FileHandlerImpl implements FileHandler {

    @Override
    public Map<String, List<TransportDTO>> getInputDataFromFiles(List<File> files) throws IOException {

        Map<String, List<TransportDTO>> inputData = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        for (final File fileEntry : files) {
            if (fileEntry.isFile()) {
                try {
                    RootDTO root = mapper.readValue(fileEntry, RootDTO.class);
                    inputData.put(fileEntry.getName(), root.getTransports());
                    log.info(root.getTransports().toString());
                } catch (JsonParseException | MismatchedInputException fileParsingException) {
                    log.error("File: {}, parsing error. Exception: {}. The file will be skipped.", fileEntry.getName(), fileParsingException.getMessage());
                }
            }
        }
        return inputData;
    }
}