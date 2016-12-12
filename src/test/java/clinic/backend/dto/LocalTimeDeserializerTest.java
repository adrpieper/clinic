package clinic.backend.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LocalTimeDeserializerTest {

    @Test
    public void testDeserialization() throws IOException {
        ClassWithLocalTime result = new ObjectMapper().readValue("{\"time\":\"13:21\"}",ClassWithLocalTime.class);
        assertThat(result).isEqualToComparingFieldByField(ClassWithLocalTime.withTime(13,21));
    }

}