package task.cloud.transports.service;

import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;

@Component
public interface TransportService {
    TransportSummary processFile(File files) throws IOException;
}
