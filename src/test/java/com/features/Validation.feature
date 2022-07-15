Feature:GET Operation
  Test GET request and Verify response pf API using RestAssured

  Scenario: Perform GET request and Verify response
    Given perform GET operation for "/order"
    And  perform getNACEDetails for the order number "398481"
    Then validate the response as "398481"