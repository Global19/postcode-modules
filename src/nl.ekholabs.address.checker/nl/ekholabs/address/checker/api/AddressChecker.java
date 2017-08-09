package nl.ekholabs.address.checker.api;

import nl.ekholabs.postcode.validator.util.CountryEnum;
import nl.ekholabs.postcode.validator.model.Postcode;

public interface AddressChecker {
  Postcode validatePostcode(final String postcode, final CountryEnum countryCode);
}
