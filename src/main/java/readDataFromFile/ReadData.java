package readDataFromFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.json.Json;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class ReadData {
    public String  readFile(String attribute) throws Exception {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+("/ReadData/Read.json"));
        Object obj=jsonParser.parse(reader);
        JsonObject jsonObject = (JsonObject) obj;
        String  value = jsonObject.get(attribute).getAsString();
        return value;
        }

}
