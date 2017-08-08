package nl.ekholabs.address.checker;

import nl.ekholabs.address.checker.api.AddressChecker;
import nl.ekholabs.postcode.validator.api.PostcodeValidatorFactory;

public final class AddressCheckerService implements AddressChecker {

  private static AddressCheckerService instance;

  static {
    instance = new AddressCheckerService();
  }

  private AddressCheckerService() {}

  public static AddressCheckerService getInstance() {
    return instance;
  }

  public boolean isValidPostode(final String postcode) {
    return PostcodeValidatorFactory.getInstance().isValid(postcode);
  }
}
