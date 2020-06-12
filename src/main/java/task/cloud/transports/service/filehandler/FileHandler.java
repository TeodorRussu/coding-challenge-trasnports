package task.cloud.transports.service.filehandler;

import org.springframework.stereotype.Component;
import task.cloud.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public interface FileHandler {

    List<TransportDTO> getInputDataFromFile(File files) throws IOException;
}
