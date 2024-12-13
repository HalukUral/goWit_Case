package com.petStore.Tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petStore.Base.BaseTest;
import com.petStore.Pojos.Category;
import com.petStore.Pojos.CreatePetPojo;
import com.petStore.Pojos.Tag;
import com.petStore.Utilities.ApiTools;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreateTest extends BaseTest {


    @Test(priority = 1, description = "Scenario 1 : I should be able to create a new pet with valid information successfully(Positive Scenario)")

    public void Users_CreatePet_Success() throws JsonProcessingException {

        Category category = new Category(1, "Dog");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("photo1.jpg");
        photoUrls.add("photo2.jpg");
        Tag tag1 = new Tag(101, "friendly");
        Tag tag2 = new Tag(102, "playful");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        CreatePetPojo createdata = new CreatePetPojo(
                12345,
                category,
                "Buddy",
                photoUrls,
                tags,
                "available"
        );


        Response response = ApiTools.createPetWithPojo(createdata);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), createdata.getName());
        Assert.assertEquals(response.jsonPath().getString("status"), createdata.getStatus());
    }

    @Test(priority = 2, description = "Scenario 2 : I should not be able to create a new pet with invalid Id type (Negative Scenario)")
    public void Users_CreatePet_Without_InvalidId() {
        String invalidId = "{ \"id\": \"a\", \"name\": \"Unknown\", \"category\": { \"id\": 1, \"name\": \"Cats\" }, \"photoUrls\": [], \"tags\": [], \"status\": \"available\" }";
        Response response = ApiTools.createPet(invalidId);
        System.out.println(response.getStatusCode());
        Assert.assertFalse(response.getStatusCode() == 200);
        System.out.println(response.body().asString());

    }

    @Test(priority = 3, description = "Scenario 2 : I should not be able to create a new pet without picture(Negative Scenario)")
    public void Users_CreatePet_Without_any_Pic() {
        Response response = ApiTools.createPetWithJson("src/test/resources/Pet.json");
        System.out.println(response.getStatusCode());
        Assert.assertFalse(response.getStatusCode() == 200);


    }
}
