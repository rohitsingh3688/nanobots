import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class Application {

  public static void main(String[] args) {

      JsonObject jsonObject = new JsonObject();
      jsonObject.put("k1","v1");
      jsonObject.put("k2","v2");
      jsonObject.put("k3","v3");
      jsonObject.put("k4","v4");


    Vertx vertx = Vertx.vertx();

    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());

    router.route(HttpMethod.POST,"/v1/nanobots/rest/api/add/projection")
            .handler(routingContext -> {

                HttpServerResponse response = routingContext.response();
                response.putHeader("Content-Type","application/Json");
                response.end(routingContext.getBody());
            });
    router.route(HttpMethod.GET,"/v1/nanobots/rest/api/retrieve/projection")
            .handler(routingContext -> {

                HttpServerResponse response = routingContext.response();
                response.putHeader("Content-Type","application/Json");
                response.end(jsonObject.toBuffer());
            });
    router.route(HttpMethod.GET,"/v1/nanobots/rest/api/retrieve/employees")
            .handler(routingContext -> {

                HttpServerResponse response = routingContext.response();
                response.putHeader("Content-Type","application/Json");
                response.end(jsonObject.toBuffer());
            });


    vertx.createHttpServer()
            .requestHandler(router)
            .listen(8443,r->{
              if (r.succeeded())
                System.out.println("SERVER STARTED ON 8443");
              else
                System.out.println("SERVER NOT STARTED: {}"+r.cause());
            });


  }

}
