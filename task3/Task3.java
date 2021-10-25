package Task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task3 {

    public static void main(String[] args) throws IOException, ParseException {
        create(compare(tests("tests.json"), values("values.json")));

   }

    public static void create(JSONArray jarr) {
        try {
            try (FileWriter file = new FileWriter("report.json")) {
                file.write(jarr.toJSONString());
                file.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray compare(JSONArray tests, JSONArray value) {
        int x = -1;
        int y;
        while (++x < tests.size()) {
            if (((JSONObject) tests.get(x)).get("values") != null) // JSONObject tx = ((JSONObject)tests.get(x));
                compare((JSONArray) ((JSONObject) tests.get(x)).get("values"), value);
            y = -1;
            while (++y < value.size()) {
                // JSONObject vy = ((JSONObject) value.get(y));
                if (((JSONObject) tests.get(x)).get("id").equals(((JSONObject) value.get(y)).get("id"))) {
                    ((JSONObject) tests.get(x)).put("value", ((JSONObject) value.get(y)).get("value"));
                }
                // System.out.print(((JSONObject) tests.get(x)).get("id") + " ");
                // System.out.print(((JSONObject) tests.get(x)).get("value") + "\n");
                // System.out.print(x + " $$$$$ " + ((JSONObject) tests.get(x)).get("id") + "
                // ");
                // System.out.println(((JSONObject) value.get(y)).get("id") + " " + y);
                // System.out.println(((JSONObject) tests.get(x)).get("id").equals(((JSONObject)
                // value.get(y)).get("id")));
            }
        }
        return tests;
    }

    public static void print(JSONArray jarr) {
        int i = -1;
        while (++i < jarr.size()) {
            if (((JSONObject) jarr.get(i)).get("values") != null)
                print((JSONArray) ((JSONObject) jarr.get(i)).get("values"));
            System.out.print(((JSONObject) jarr.get(i)).get("id") + "  ");
            System.out.println(((JSONObject) jarr.get(i)).get("value"));
        }
    }

    public static JSONArray tests(String name) throws IOException, ParseException {
        JSONObject jsonObject = ((JSONObject) new JSONParser().parse(new FileReader(name)));
        JSONArray jsonarr = ((JSONArray) jsonObject.get("tests"));
        // print(jsonarr);
        return jsonarr;
    }

    public static JSONArray values(String name) throws IOException, ParseException {
        FileReader reader = new FileReader(name);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray jsonarr = ((JSONArray) jsonObject.get("values"));
        // print(jsonarr);
        return jsonarr;
    }

}
