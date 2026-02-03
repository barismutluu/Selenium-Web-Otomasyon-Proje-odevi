# Selenium Web Test Automation Framework

This project is a **web test automation framework** developed using **Java and Selenium WebDriver**.  
It automates a complete **end-to-end user flow on the Kitapyurdu website** and is designed to practice:

- Test automation fundamentals
- Page Object Model (POM) design pattern
- Clean and maintainable framework structure

---

## 🔧 Technologies Used

- **Java 18**
- **Selenium WebDriver**
- **JUnit 5 (Jupiter)**
- **Maven**
- **Page Object Model (POM)**
- **Explicit Wait (WebDriverWait)**
- **Cookie consent handling**
- **CSV-based test data (optional / extendable)**

---

## 📁 Project Structure

```
src
├── main
│   └── java
│       └── Pages
│           ├── BasePage.java
│           ├── HomePage.java
│           ├── RomanPage.java
│           └── CartPage.java
└── test
    └── java
        ├── BaseTest.java
        └── KitapyurduTest.java
```

---

## 🧪 Automated Test Scenarios

The following **end-to-end test flow** is automated:

1. Open **https://www.kitapyurdu.com**
2. Accept cookie consent automatically
3. Verify home page is displayed
4. Search for a product (e.g. *roman*)
5. Select a product from search results
6. Add product to cart
7. Verify cart count is updated
8. Navigate to cart page
9. Increase product quantity
10. Verify cart update message
11. Remove product from cart
12. Verify product is removed from cart

---

## 🧱 Framework Design

- **Page Object Model (POM)** is used to separate test logic from page interactions
- All reusable Selenium methods are centralized in `BasePage`
- Cookie consent popup is handled automatically in `BasePage`
- Tests are ordered using `@TestMethodOrder`
- Assertions are handled using **JUnit 5 Assertions**

---

## ▶️ How to Run Tests

1. Make sure **Java 18** and **Maven** are installed
2. Open the project in IntelliJ IDEA
3. Run the test class:

```
KitapyurduTest.java
```

or via Maven:

```
mvn test
```

---

## ✅ Key Features

- Clean and readable test code
- Stable element handling with Explicit Waits
- Centralized cookie consent handling
- Easy to extend with new test scenarios
- Beginner-friendly Selenium + POM framework

---

## 🚀 Future Improvements (Optional)

- Screenshot on test failure
- Test reports (Allure / Extent)
- Headless browser support
- Retry mechanism for flaky tests
- Data-driven testing with CSV / Excel
