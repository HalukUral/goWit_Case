package com.petStore.Tests;

import com.petStore.Base.BaseTest;
import com.petStore.Utilities.ApiTools;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTest extends BaseTest {


    @Test(priority = 1,description = "Scenario 1 : I should be able to Get a pet data by ID successfully(Positive Scenario)")
    public void testGetPetById() {
        String petId = "7";
        Response response = ApiTools.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), petId);
        response.prettyPrint();

    }
    @Test(priority = 2, description = "Scenario 2 : I should not be able to Get a pet data by invalid ID (Negative Scenario)")
    public void testGetPetByInvalidId() {
        String petId = "ass";
        Response response = ApiTools.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 404);


    }
}
