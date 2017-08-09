package nl.ekholabs.address.checker;

import nl.ekholabs.address.checker.api.AddressChecker;
import nl.ekholabs.postcode.validator.api.PostcodeValidatorService;
import nl.ekholabs.postcode.validator.util.CountryEnum;
import nl.ekholabs.postcode.validator.model.Postcode;

public final class AddressCheckerService implements AddressChecker {

  private static AddressCheckerService instance;

  static {
    instance = new AddressCheckerService();
  }

  private AddressCheckerService() {}

  public static AddressCheckerService getInstance() {
    return instance;
  }

  public Postcode validatePostcode(final String postcode, final CountryEnum countryCode) {
    return PostcodeValidatorService.getInstance().validate(postcode, countryCode);
  }
}
