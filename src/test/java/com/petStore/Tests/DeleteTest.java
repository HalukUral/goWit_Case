package com.petStore.Tests;

import com.petStore.Base.BaseTest;
import com.petStore.Utilities.ApiTools;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.petStore.Utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class DeleteTest extends BaseTest {


    @Test(priority = 1, description = "Scenario 1 : I should be able to delete a pet with valid id number(Positive Scenario)")
    public void testDeletePet() {


        String petId = "1";

        Response response = ApiTools.deletePet(petId);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Verifying pet is deleted");
        Response getResponse = ApiTools.getPetById(petId);
        Assert.assertEquals(getResponse.getStatusCode(), 404);
    }

    @Test(priority = 2, description = "Scenario 2 : I should not be able to delete a pet that is nonexistent(Negative Scenario)")
    public void delete_Non_ExistingID() {
        String petId = "1d";
        Response response = ApiTools.deletePet(petId);
        Assert.assertEquals(response.getStatusCode(), 404);

    }

    @Test(priority = 3, description = "Scenario 3 : I should not be able to delete a pet with invalid id numbers(Negative Scenario)")
    public void delete_Non_InvalidID() {

        ExcelUtil idsfile = new ExcelUtil("src/test/resources/IdsTable.xlsx", "ids");
        List<Map<String, String>> dataList = idsfile.getDataList();
        for (Map<String, String> rowmap : dataList) {
            for (String petId : rowmap.values()) {
                System.out.println(petId);
                Response response = ApiTools.deletePet(petId);
                Assert.assertEquals(response.getStatusCode(), 404);

            }

        }


    }
}

