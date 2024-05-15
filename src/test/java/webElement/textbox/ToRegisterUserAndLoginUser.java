package webElement.textbox;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import pomRepository.LoginPage;
import pomRepository.RegisterPage;

public class ToRegisterUserAndLoginUser extends BaseClass {

	@Test(priority = 1)
	public void toRegisterUser() throws EncryptedDocumentException, IOException {

		String name = fUtils.fetchDataFromExcelSheet("Sheet1", 1, 0);
		String email = fUtils.fetchDataFromExcelSheet("Sheet1", 1, 1);
		String password = fUtils.fetchDataFromExcelSheet("Sheet1", 1, 2);

		RegisterPage register = new RegisterPage(driver);
		register.registerUser(name, email, password);

		LoginPage login = new LoginPage(driver);

		if (login.verifyRegisterUser()) {
			System.out.println("Pass: the user is registered");
		}

		else
			System.out.println("Fail: the user is not registered");

	}

	@Test(priority = 2, dependsOnMethods = "toRegisterUser")

	public void toLoginUser() throws EncryptedDocumentException, IOException {

		String email = fUtils.fetchDataFromExcelSheet("Sheet1", 1, 1);
		String password = fUtils.fetchDataFromExcelSheet("Sheet1", 1, 2);

		LoginPage login = new LoginPage(driver);
		login.loginAction(email, password);

		if (login.verifyLoginUser()) {
			System.out.println("Pass: the user is logged in");
		}

		else
			System.out.println("Fail: the user is not logged in");

	}

}
