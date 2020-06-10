package task.transports.transports.service.filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;
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
                RootDTO root = mapper.readValue(fileEntry, RootDTO.class);
                inputData.put(fileEntry.getName(), root.getTransports());
                log.info(root.getTransports().toString());
            }
        }
        return inputData;
    }
}
