# Selenium Web Test Automation Framework

This project is a **web test automation framework** developed using **Java and Selenium WebDriver**.  
It automates a complete **end-to-end (E2E) user flow on the Kitapyurdu website** and is designed to practice:

- Test automation fundamentals
- Page Object Model (POM) design pattern
- JUnit 5 test lifecycle and ordering
- Logging test results with Log4j2
- Clean and maintainable framework structure

---

## 🔧 Technologies Used

- **Java 18**
- **Selenium WebDriver**
- **JUnit 5 (Jupiter)**
- **Maven**
- **WebDriverManager**
- **Log4j2**
- **Page Object Model (POM)**
- **Explicit & Implicit Waits**
- **Cookie consent handling**

---

## 📁 Project Structure

```

src/
├── main
│ └── java
│ ├── Logger
│ │ └── Log.java
│ └── Pages
│ ├── BasePage.java
│ ├── HomePage.java
│ ├── RomanPage.java
│ └── CartPage.java
│
├── test
│ └── java
│ ├── testlogger
│ │ └── TestResultLogger.java
│ ├── BaseTest.java
│ └── KitapyurduTest.java
│
└── resources
└── log4j2.xml
```
---

## 🧪 Automated Test Scenario (E2E)

The following end-to-end test flow is automated:

1. Open **https://www.kitapyurdu.com**
2. Accept cookie consent automatically
3. Verify home page is opened
4. Search for a product (e.g. *roman*)
5. Select a product from search results
6. Add product to cart
7. Verify cart count is updated
8. Navigate to cart page
9. Increase product quantity
10. Verify cart update
11. Remove product from cart
12. Verify cart is empty

---

## 🧱 Framework Design

- **Page Object Model (POM)** is used to separate test logic from page interactions
- All reusable Selenium actions are centralized in `BasePage`
- Cookie consent popup is handled automatically
- Explicit waits are used for stable element interactions
- Tests are executed in order using `@TestMethodOrder`

---

## 🧪 Test Layer

### BaseTest
- WebDriver setup using **WebDriverManager**
- Chrome browser configuration
- Site availability verification
- Test lifecycle management (`@BeforeAll`, `@AfterAll`)
- Test result logging via JUnit 5 Extension

### KitapyurduTest
- Ordered E2E test execution
- Assertions using **JUnit 5**
- Real user scenario simulation

---

## 📝 Logging

- **Log4j2** is used for centralized logging
- Test results are captured using a custom **JUnit 5 TestWatcher**
    - PASSED tests → INFO log
    - FAILED tests → ERROR log with failure reason

---

## 🚀 Future Improvements

- Screenshot on test failure
- Test reporting (Allure / Extent)
- Headless browser support
- Retry mechanism for flaky tests
- Data-driven testing

---

## 👤 Author

**Barış Mutlu**  
Junior Software Test Automation Engineer
