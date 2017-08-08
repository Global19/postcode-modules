package nl.ekholabs.address.checker.api;

import nl.ekholabs.postcode.validator.api.CountryEnum;

public interface AddressChecker {
  boolean isValidPostode(final String postcode, final CountryEnum countryCode);
}
