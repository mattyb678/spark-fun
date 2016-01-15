import com.google.gson.Gson;
import services.ZooService;

import java.util.UUID;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("App started");

        ZooService service = new ZooService();
        Gson gson = new Gson();

        get("/zoo/:zooUUID", (req, resp) -> {
            return service.getZoo(UUID.fromString(req.params(":zooUUID")));
        }, gson::toJson);

        put("/zoo/:zooName", (req, resp) -> {
            return service.createZoo(req.params(":zooName"));
        });
    }
}
