package task.transports.transports.service;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.io.File;
import java.io.IOException;

@Component
public interface TransportService {
    TransportSummary processFile(File files) throws IOException;
}
