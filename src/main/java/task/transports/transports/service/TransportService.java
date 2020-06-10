package task.transports.transports.service;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public interface TransportService {
    Map<String, TransportSummary> processFiles(List<File> files) throws IOException;
}
