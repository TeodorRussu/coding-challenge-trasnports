package task.cloud.transports.service.filehandler;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import task.cloud.transports.model.dto.RootDTO;
import task.cloud.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class FileHandlerImpl implements FileHandler {

    @Override
    public List<TransportDTO> getInputDataFromFile(File file) throws IOException {

        List<TransportDTO> inputData = null;
        ObjectMapper mapper = new ObjectMapper();

        if (file.isFile()) {
            try {
                RootDTO root = mapper.readValue(file, RootDTO.class);
                inputData = root.getTransports();
                log.info("file parsed successfully");
            } catch (JsonParseException | MismatchedInputException fileParsingException) {
                log.error("File: {}, parsing error. Exception: {}. The file is invalid.", file.getName(),
                          fileParsingException.getMessage());
                throw fileParsingException;
            }
        }
        if (isNull(inputData)) {
            inputData = Collections.emptyList();
        }
        return inputData;
    }
}