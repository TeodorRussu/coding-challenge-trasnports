package task.transports.transports.controller;

import org.springframework.stereotype.Component;
import task.transports.transports.input.datasource.DataSource;
import task.transports.transports.output.OutputService;
import task.transports.transports.service.TransportService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class TransportController {

    private DataSource dataSource;
    private TransportService transportService;
    private OutputService outputService;

    public void processData() throws IOException {
        List<File> files = dataSource.getFiles();
        List<File> processed = transportService.processFiles(files);
        outputService.processOutput(files);
    }

}
