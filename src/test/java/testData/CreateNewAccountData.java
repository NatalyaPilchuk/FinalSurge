package testData;

import models.CreateNewAccountModel;
import utils.FakeMessageGenerator;

public class CreateNewAccountData {
    public static CreateNewAccountModel getValidData(){
        return CreateNewAccountModel
                .builder()
                .firstName(FakeMessageGenerator.generateFirstName())
                .lastName(FakeMessageGenerator.generateLastName())
                .emailAddress("natalya_pilchuk@yopmail.com")
                .password(FakeMessageGenerator.generatePassword())
                .confirmPassword(FakeMessageGenerator.generatePassword())
                .build();
    }
}
