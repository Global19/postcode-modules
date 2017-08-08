package nl.ekholabs.postcode.validator.api;

import nl.ekholabs.postcode.validator.PostcodeValidatorService;

public final class PostcodeValidatorFactory {

  public static PostcodeValidator getInstance() {
    return new PostcodeValidatorService();
  }
}
