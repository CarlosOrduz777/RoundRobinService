package com.eci.round;

import com.eci.round.connection.HttpConnection;

import static spark.Spark.*;

public class SparkWeb {

    public static void main(String[] args) {
        port(getPort());
        HttpConnection connection = new HttpConnection();
        staticFiles.location("/public");
        get("/round", (req, res) -> {
            res.type("application/json");
            String cadena = req.queryParams("cadena");
            return connection.getLogServiceData(cadena);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
