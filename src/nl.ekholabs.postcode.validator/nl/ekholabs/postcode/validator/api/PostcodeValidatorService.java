package nl.ekholabs.postcode.validator.api;

import nl.ekholabs.postcode.validator.api.PostcodeValidator;
import nl.ekholabs.postcode.validator.util.CountryEnum;
import nl.ekholabs.postcode.validator.model.Postcode;

import java.util.regex.Pattern;

public final class PostcodeValidatorService implements PostcodeValidator {

  private static PostcodeValidatorService instance;

  static {
    instance = new PostcodeValidatorService();
  }

  private PostcodeValidatorService(){}

  public static PostcodeValidatorService getInstance() {
    return instance;
  }

  public Postcode validate(final String postcode, final CountryEnum countryEnum) {
    final Pattern pattern = Pattern.compile(countryEnum.getRegex());
    String message;
    if (!pattern.matcher(postcode).matches()) {
      message = String.format("Invalid postcode for country with code: '%s'", countryEnum.getCountryCode());
    } else {
      message = String.format("Valid postcode for country with code: '%s'", countryEnum.getCountryCode());
    }

    return new Postcode(postcode, countryEnum, message);
  }
}
