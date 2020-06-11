package task.transports.transports.input.datasource;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

@Component
@Profile("aws")
@Slf4j
public class AwsDataSource implements DataSource {

    @Setter
    @Value("${aws:bucket}")
    private String bucketName;

    @Setter
    @Value("${filename}")
    String fileName;

    @Override
    public File getInputFile() {

        Regions clientRegion = Regions.EU_CENTRAL_1;
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(clientRegion)
            .build();
        File file = new File(fileName);
        file.deleteOnExit();


        try (S3Object s3Object = s3Client.getObject(bucketName, fileName);
             InputStreamReader streamReader = new InputStreamReader(s3Object.getObjectContent());
             OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
             BufferedReader reader = new BufferedReader(streamReader)) {

            int read;
            while ( ( read = reader.read() ) != -1 ) {
                writer.write(read);
            }
            writer.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return file;
    }

}