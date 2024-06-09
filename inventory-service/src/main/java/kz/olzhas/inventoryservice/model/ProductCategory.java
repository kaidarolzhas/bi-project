package kz.olzhas.inventoryservice.model;

public enum ProductCategory {
    BEVERAGES("Beverages"),
    DAIRY("Dairy"),
    BAKERY("Bakery"),
    MEAT("Meat"),
    SEAFOOD("Seafood"),
    VEGETABLES("Vegetables"),
    FRUITS("Fruits"),
    GRAINS("Grains"),
    SNACKS("Snacks"),
    CONDIMENTS("Condiments");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
