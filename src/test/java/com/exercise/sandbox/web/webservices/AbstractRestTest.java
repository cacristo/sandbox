package com.exercise.sandbox.web.webservices;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Abstract Integration test for Spring MVC Rest Service.
 * <p>
 * It initialize springBoot, the WebApplicationContext and MockMvc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class AbstractRestTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRestTest.class);

    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void initMockMvc() {
        // init web context
        MockitoAnnotations.initMocks(this);
        mockMvc = webAppContextSetup(wac).build();
    }

    /**
     * Utility method to read file from resource.
     * <p>
     * FIXME: add this method to one utility class if necessary to use it in multiple places.
     *
     * @param pathName the path name
     * @return the file as string
     * @throws {@link IOException}
     * @throws {@link URISyntaxException}
     */
    private static String readFile(URL pathName) throws IOException, URISyntaxException {
        Path path = Paths.get(pathName.toURI());
        StringBuilder result = new StringBuilder();

        Stream<String> lines = Files.lines(path);
        lines.forEach(s -> result.append(s.replaceAll("\\s", "")));

        return result.toString();
    }

    /**
     * Utility method to load JSON file from resource.
     * <p>
     * FIXME: add this method to one utility class if necessary to use it in multiple places.
     *
     * @param namePath the path
     * @return the json as string
     */
    protected String loadResourceJson(String namePath) {
        String json;
        try {
            json = readFile(this.getClass().getResource("/" + namePath));
        } catch (IOException | NullPointerException | URISyntaxException e) {
            LOGGER.error("Exception detected: ", e);
            throw new RuntimeException("File Not Found : " + namePath);
        }
        return json;
    }
}
