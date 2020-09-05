import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class Application {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    Router router = Router.router(vertx);


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
