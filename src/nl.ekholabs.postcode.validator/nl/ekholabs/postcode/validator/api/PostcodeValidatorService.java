package nl.ekholabs.postcode.validator.api;

import nl.ekholabs.postcode.validator.api.PostcodeValidator;
import nl.ekholabs.postcode.validator.util.CountryEnum;

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

  public boolean isValid(final String postcode, final CountryEnum countryEnum) {
    final Pattern pattern = Pattern.compile(countryEnum.getRegex());
    if (!pattern.matcher(postcode).matches()) {
      return false;
    }
    return true;
  }
}
