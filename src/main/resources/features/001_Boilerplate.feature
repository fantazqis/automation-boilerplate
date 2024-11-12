Feature: Test Function
  Scenario: Test001 Opening web
    When Test001 Membuka Halaman Web
    And Test001 Validasi Halaman Utama
    And Test001 Input Username <username>
    And Test001 Input Password <password>
    And Test001 Klik Tombol Login
    Then Test001 Validasi Halaman Login

    Examples:
      | username      | password      |
      | locked_out_user | secret_sauce  |
