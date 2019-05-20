package pdp.rest.jackson;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomDeserializer extends StdDeserializer<JacksonClass> {

    public CustomDeserializer() {
        super(JacksonClass.class);
    }

    @Override
    public JacksonClass deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("invoked customSerializer");
        JacksonClass jacksonClass = new JacksonClass();
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if(JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                switch (fieldName) {
                    case "firstName" :
                        jacksonClass.setFirstName(parser.getValueAsString());
                        break;
                    case "lastName" :
                        jacksonClass.setLastName(parser.getValueAsString());
                        break;
                    case "height" :
                        jacksonClass.setHeight(parser.getValueAsInt());
                        break;
                    case "salaryUSD" :
                        jacksonClass.setSalary(parser.getValueAsDouble());
                        break;
                }
            }
        }
        return jacksonClass;
    }
}
