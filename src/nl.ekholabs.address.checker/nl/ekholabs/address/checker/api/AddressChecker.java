package nl.ekholabs.address.checker.api;

import nl.ekholabs.postcode.validator.util.CountryEnum;

public interface AddressChecker {
  boolean isValidPostode(final String postcode, final CountryEnum countryCode);
}
