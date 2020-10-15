package com.stream.ts;

import com.stream.ts.model.Stream;
import com.stream.ts.model.Viewer;
import com.stream.ts.repository.StreamRepository;
import com.stream.ts.repository.ViewerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TsApplication.class, args);
        StreamRepository streamRepository =
                configurableApplicationContext.getBean(StreamRepository.class);
        ViewerRepository viewerRepository =
                configurableApplicationContext.getBean(ViewerRepository.class);

        Viewer ericViewer = new Viewer("Eric55");
        Viewer troelsViewer = new Viewer("Troels92");
        List<Viewer> viewers = Arrays.asList(ericViewer,troelsViewer);

        Stream gamingStream = new Stream("Binding of Issac");
        Stream irlStream = new Stream("Walking around cph");
        List<Stream> streams = Arrays.asList(gamingStream,irlStream);
        streamRepository.saveAll(streams);

        ericViewer.followStream(irlStream);
        troelsViewer.followStream(gamingStream);
        troelsViewer.followStream(irlStream);

        viewerRepository.saveAll(viewers);


    }

}
