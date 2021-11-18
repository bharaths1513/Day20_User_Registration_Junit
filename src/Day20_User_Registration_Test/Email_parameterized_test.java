package Day20_User_Registration_Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Day20_User_Registration_Junit.UserRegistration;

@RunWith(Parameterized.class)
public class Email_parameterized_test {
	String input;
	Boolean expected;

	UserRegistration userregestration;

	@Before
	public void initilize() {
		userregestration = new UserRegistration();
	}

	public Email_parameterized_test(String input, Boolean expected) {
		this.input = input;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection emails() {
		return Arrays.asList(new Object[][] { { "abc@bridgelabz.co.in", true }, { "abc@gmail.com.com", true },
				{ "abc@yahoo.com", true }, { "abc@1.com", true }, { "abc-100@yahoo.com", true },
				{ "abc.100@yahoo.com", true }, { "abc111@abc.com", true }, { "abc-100@abc.net", true },
				{ "abc.100@abc.com.au", true }, { "abc+100@gmail.com", true },

				{ ".abc@abc.com", false }, { "abc", false }, { "abc@.com.my", false }, { "abc@abc@gmail.com", false },
				{ "abc()*@gmail.com", false }, { "abc..2002@gmail.com", false }, { "abc.@gmail.com", false },
				{ "abc123@.com", false }, { "abc123@.com.com", false }, { "abc123@gmail.a", false },
				{ "abc@%*.com", false }, { "abc@gmail.com.1a", false }, { ".abc@gmail.com.aa.au", false } });
	}

	public void TestMails() {
		System.out.println("Parameterized mail is: " + input);
		assertEquals(expected, UserRegistration.emailAddressSample(input));
	}
}
