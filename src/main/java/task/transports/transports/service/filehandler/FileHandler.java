package task.transports.transports.service.filehandler;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public interface FileHandler {
    public Map<String, List<TransportDTO>> getInputDataFromFiles(List<File> files) throws IOException;
}
