import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.FeedRequest;
import model.Zoo;
import services.ZooService;

import java.util.UUID;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("App started");

        ZooService service = new ZooService();
        Gson gson = new GsonBuilder()
                .setDateFormat("MM/dd/yyyy")
                .create();

        get("/zoo/:zooUUID", (req, resp) -> {
            return service.getZoo(UUID.fromString(req.params(":zooUUID")));
        }, gson::toJson);

        put("/zoo/:zooName", (req, resp) -> {
            return service.createZoo(req.params(":zooName"));
        });

        put("/zoo/:zooUUID/:feedName/:amount", (req, resp) -> {
            Zoo zoo = service.getZoo(UUID.fromString(req.params(":zooUUID")));
            if (zoo != null) {
                zoo.addFeed(req.params(":feedName"), Integer.parseInt(req.params(":amount")));
                return zoo;
            }
            return null;
        }, gson::toJson);

        post("/zoo/:zooUUID/feed", (req, resp) -> {
            Zoo zoo = service.getZoo(UUID.fromString(req.params(":zooUUID")));
            FeedRequest feedRequest = gson.fromJson(req.body(), FeedRequest.class);
            if (zoo != null) {

                return zoo;
            }
            return null;
        }, gson::toJson);
    }
}
