package task.transports.transports.controller;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.transports.transports.input.datasource.DataSource;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.output.OutputService;
import task.transports.transports.service.TransportService;

import java.io.File;

@Component
@Data
public class TransportController {

    @Setter(onMethod = @__({@Autowired}))
    private DataSource dataSource;
    @Setter(onMethod = @__({@Autowired}))
    private TransportService transportService;
    @Setter(onMethod = @__({@Autowired}))
    private OutputService outputService;


    /**
     * The program performs several steps coordinated by this class:
     *
     * 1. Input processing
     * - DataSource Implementation read the input file content
     *
     * 2. Service
     * - FileHandler takes the file content and and maps it to a list raw objects of type TransportDTO class
     * - TransportMapper converts each item from the TransportDTO list and maps it to a Car, Train or Plane object, depending the validations
     * - DataProcessor takes the list of mapped objects, colects all the data into a single  TransportSummary object
     *
     * 3. Output processing
     * - OutputService maps the TransportSummary object and maps it to a Json object and write the content to the output file
     *
     * @throws Exception exception
     */
    public void processData() throws Exception {

        File inputFile = dataSource.getInputFile();
        TransportSummary processed = transportService.processFile(inputFile);

        if (processed.isEmpty()) {
            throw new Exception(String.format("The file %s, doesn't contain any valid entry", inputFile));
        }

        outputService.processOutput(inputFile.getName(), processed);
    }
}
