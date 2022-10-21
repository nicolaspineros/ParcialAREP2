package co.edu.escuelaing;
import static spark.Spark.*;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class Main {
    public static Collatz collatz = new Collatz();

    public static void main(String... args){
        port(getPort());
        //get("/hello", (req, res) -> "Hello ");
        staticFiles.location("/public");
        get("/collatzsequence",(req,res) ->{
            res.type("application/json");
            return calinput(req,res,req.queryParams("value"));
        });

    }

    public static JSONObject calinput(Request req, Response res, String input){
        JSONObject jsonObject = new JSONObject();
        String output = collatz.calculate(Integer.parseInt(input));
        //String output = "prueba";
        jsonObject.put("operation",req.uri());
        jsonObject.put("input",input);
        jsonObject.put("output",output);
        return jsonObject;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}