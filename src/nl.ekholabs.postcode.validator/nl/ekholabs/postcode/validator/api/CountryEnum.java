package nl.ekholabs.postcode.validator.api;

import java.util.stream.Stream;

import java.util.stream.Stream;

public enum CountryEnum {

  NL("nl", "(NL-)?(\\d{4})\\s*([A-Z]{2})"),
  UK("uk", "(?i)([A-Z]{1,2}[0-9]{1,2}[A-Z]?)\\s*([0-9][A-Z]{2})");

  private final String countryCode;
  private final String regex;

  CountryEnum(final String countryCode, final String regex) {
    this.countryCode = countryCode;
    this.regex = regex;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getRegex() {
    return regex;
  }

  public static CountryEnum findByCode(final String countryCode) {
    return Stream.of(CountryEnum.values())
        .filter(countryEnum -> countryEnum.countryCode == countryCode)
        .findFirst()
        .orElse(CountryEnum.NL);
  }
}
