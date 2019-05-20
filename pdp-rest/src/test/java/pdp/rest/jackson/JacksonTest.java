package pdp.rest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JacksonTest {

    private ObjectMapper objectMapper = new ObjectMapper();
    private JacksonClass madMax;

    @Before
    public void setup() {
        madMax = new JacksonClass();
        madMax.setId(666L);
        madMax.setFirstName("Max");
        madMax.setLastName("Mad");
        madMax.setHeight(180);
        madMax.setSalary(Double.MAX_VALUE);
    }

    @Test(expected = com.fasterxml.jackson.databind.JsonMappingException.class)
    public void testCycle() throws JsonProcessingException {
        JacksonClass entity = new JacksonClass();
        entity.setId(354L);
        entity.addFriend(entity);

        String s = objectMapper.writeValueAsString(entity);
        System.out.println(s);
    }

    @Test
    public void testDatabind() throws IOException {
        String madMaxJsonStr = objectMapper.writeValueAsString(madMax);

        JacksonClass jacksonClass = objectMapper.readValue(madMaxJsonStr, JacksonClass.class);

        assertEquals(madMax.getFirstName(), jacksonClass.getFirstName());
        assertEquals(madMax.getLastName(), jacksonClass.getLastName());
    }

    @Test
    public void testTreeNodeParser() throws IOException {
        String madMaxJsonStr = objectMapper.writeValueAsString(madMax);

        JsonNode madMaxTree = objectMapper.readTree(madMaxJsonStr);

        assertTrue(madMaxTree.has("firstName"));
        assertEquals(madMax.getFirstName(), madMaxTree.get("firstName").asText());
    }

    @Test
    public void testCustomParser() throws IOException{
        CustomDeserializer customDeserializer = new CustomDeserializer();
        SimpleModule simpleModule = new SimpleModule("CustomSerializerModule", new Version(1, 0, 0, "SNAPSHOT", "pdp", "pdp-rest"));
        simpleModule.addDeserializer(JacksonClass.class, customDeserializer);
        objectMapper.registerModule(simpleModule);

        JacksonClass jacksonClass = objectMapper.readValue(objectMapper.writeValueAsString(madMax), JacksonClass.class);

        assertEquals(madMax.getFirstName(), jacksonClass.getFirstName());
        assertEquals(madMax.getLastName(), jacksonClass.getLastName());
        assertEquals(madMax.getHeight(), jacksonClass.getHeight());
        assertEquals(madMax.getSalary(), jacksonClass.getSalary());
    }

}
