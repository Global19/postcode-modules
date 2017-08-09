module nl.ekholabs.address.checker {
    exports nl.ekholabs.address.checker.api;
    requires nl.ekholabs.postcode.validator;
    // Used when running with GSON fat JAR.
    // requires java.sql;
    // requires gson;
    // Used when running with GSON source.
    requires com.google.gson;
}
