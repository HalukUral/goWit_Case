package com.petStore.Utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petStore.Pojos.CreatePetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.petStore.Utilities.JsonUtil.convertJsonData;
import static com.petStore.Utilities.JsonUtil.readJsonFromFile;
import static io.restassured.RestAssured.given;

public class ApiTools {




    public static Response createPet(String data)  {

        return given()
                .contentType(ContentType.JSON)
                .body(data)
                .post("/pet");}

    public static Response createPetWithPojo(CreatePetPojo data) throws JsonProcessingException {
       String payload= convertJsonData(data);
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/pet");
    }
    public static Response createPetWithJson(String path) {
       String data= readJsonFromFile(path);
        System.out.println(data);
        return given()
                .contentType(ContentType.JSON)
                .body(data)
                .post("/pet");
    }

    public static Response getPetById(String id) {

        return given()
                .contentType(ContentType.JSON)
                .get("/pet/" + id);
    }

    public static Response updatePet(String data) {
        return given()
                .contentType(ContentType.JSON)
                .header("api_key", "special-key")
                .body(data)
                .put("/pet");
    }


    public static Response deletePet(String id) {
        return given()
                .contentType(ContentType.JSON)
                .delete("/pet/" + id);
    }


    public static Response createPetFromJsonFile(String jsonFilePath) {
        String payload = readJsonFromFile(jsonFilePath);
        return createPet(payload);
    }

       public static Response updatePetFromJsonFile(String jsonFilePath) {
        String payload = readJsonFromFile(jsonFilePath);
        return updatePet(payload);
    }

}
