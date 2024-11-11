import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @BeforeAll
    public static void displaySource() {
        System.out.println("https://en.wikipedia.org/wiki/Email_address#Invalid_email_addresses");
    }

    @BeforeEach
    public void displaySetupTest() {
        System.out.println("Setting up test");
    }

    @Test
    @DisplayName("Phone no should start with 0")
    public void testIsPhoneNumberValidNoStartingZero() {
        Assertions.assertFalse(Validator.isPhoneNumberValid("123456"));
    }

    @Test
    @DisplayName("Phone no should have at least 6 digits")
    public void testIsPhoneNumberValidLessThanSixDigits() {
        assertFalse(Validator.isPhoneNumberValid("01234"));
    }

    @Test
    @DisplayName("Phone no should have max 10 digits")
    public void testIsPhoneNumberValidMoreThanTenDigits() {
        assertFalse(Validator.isPhoneNumberValid("01234567891"));
    }

    @Test
    @DisplayName("Phone no should only contain digits")
    public void testIsPhoneNumberValidSpecialCharacters() {
        assertFalse(Validator.isPhoneNumberValid("012-345"));
    }

    @Test
    @DisplayName("Phone no contains only digits")
    public void testIsPhoneNumberValidOnlyDigits() {
        assertTrue(Validator.isPhoneNumberValid("012345"));
    }

    @Test
    @DisplayName("no @ character")
    public void testIsEmailValidNoAtSign() {
        assertFalse(Validator.isEmailValid("abc.example.com"));
    }

    @Test
    @DisplayName("only one @ is allowed outside quotation marks")
    public void testIsEmailValidMultipleAtSigns() {
        assertFalse(Validator.isEmailValid("a@b@c@example.com"));
    }

    @Test
    @DisplayName("@ is allowed in local-part inside quotation marks")
    public void testIsEmailValidMultipleAtSignsWithinQuotes() {
        assertTrue(Validator.isEmailValid("\"a@b@c\"@example.com"));
    }

    @Test
    @DisplayName("local-part is longer than 64 characters")
    public void testIsEmailValidOver64Characters() {
        assertFalse(Validator.isEmailValid("1234567890123456789012345678901234567890123456789012345678901234+x@example.com"));
    }

    @Test
    @DisplayName("underscore is not allowed in domain part")
    public void testIsEmailValidUnderscoreInDomainName() {
        assertFalse(Validator.isEmailValid("i.like.underscores@but_they_are_not_allowed_in_this_part.com"));
    }

    @AfterEach
    public void displayEndTest() {
        System.out.println("Test has ended");
    }

    @AfterAll
    public static void displayAllTestsRun() {
        System.out.println("All selected tests have been run");
    }

}