package com.petStore.Tests;

import com.petStore.Base.BaseTest;
import com.petStore.Utilities.ApiTools;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateTest extends BaseTest {

    @Test(priority = 1,description = "Scenario 1 : I should be able to Update a pet data by ID successfully(Positive Scenario)")
    public void testUpdatePet() {

        String data = "{ \"id\": 7, \"name\": \"UpdatedName\", \"status\": \"sold\" }";

        Response response = ApiTools.updatePet(data);


        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "UpdatedName");
        Assert.assertEquals(response.jsonPath().getString("status"), "sold");
    }

    @Test(priority = 2,description = "Scenario 1 : I should be not able to Update a pet data without existing ID (Negative Scenario)")
    public void testUpdatePetNotFound() {
        String nonExistingPet = "{ \"id\": 2, \"name\": \"Unknown\", \"category\": { \"id\": 1, \"name\": \"Cats\" }, \"photoUrls\": [], \"tags\": [], \"status\": \"available\" }";

        Response response = ApiTools.updatePet(nonExistingPet);
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertTrue(response.asString().contains("Pet not found"));
    }
}
