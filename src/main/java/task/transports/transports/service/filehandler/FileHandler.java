package task.transports.transports.service.filehandler;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public interface FileHandler {
    public List<TransportDTO> getInputDataFromFile(File files) throws IOException;
}
