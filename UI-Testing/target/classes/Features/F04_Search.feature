@smoke
Feature: F04_Search | user should be able to search product by different parameters
  Scenario: user search product by name
    Given user could search using product name "Apple"

  Scenario: user search product by SKU (Serial Key Unit)
    Given user search using sku "AP_MBP_13"