package nl.ekholabs.postcode.validator.model;

import nl.ekholabs.postcode.validator.util.CountryEnum;

public class Postcode {

  private String code;
  private CountryEnum countryCode;
  private String validationMessage;

  public Postcode(final String code, final CountryEnum countryCode, final String validationMessage) {
    this.code = code;
    this.countryCode = countryCode;
    this.validationMessage = validationMessage;
  }
  
  public String getCode() {
    return code;
  }

  public CountryEnum getCountryCode() {
    return countryCode;
  }

  public String getValidationMessage() {
    return validationMessage;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Postcode postcode = (Postcode) o;

    if (code != null ? !code.equals(postcode.code) : postcode.code != null) {
      return false;
    }
    if (countryCode != postcode.countryCode) {
      return false;
    }
    return validationMessage != null ? validationMessage.equals(postcode.validationMessage) : postcode.validationMessage == null;
  }

  @Override
  public int hashCode() {
    int result = code != null ? code.hashCode() : 0;
    result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
    result = 31 * result + (validationMessage != null ? validationMessage.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Postcode{" +
        "code='" + code + '\'' +
        ", countryCode=" + countryCode +
        ", validationMessage='" + validationMessage + '\'' +
        '}';
  }
}
