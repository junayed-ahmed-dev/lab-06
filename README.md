# 🧪 CMPUT 301 – Lab 6: JUnit & Javadoc

## 🎯 Objective
This lab focuses on writing, testing, and documenting Java code.  
You will implement and test methods in the `CityList` class, write **JUnit 5** unit tests, and generate **Javadoc** documentation for your main source files.

---

## 🏙️ Tasks

### 1️⃣ Implement Methods in `CityList.java`
You must implement the following methods:

| Method | Description | Test Requirements |
|:--|:--|:--|
| `boolean hasCity(City city)` | Returns whether a given city exists in the list. | Test for both existing and non-existing cities. |
| `void delete(City city)` | Removes a city if it exists, otherwise throws `IllegalArgumentException`. | Test successful deletion and exception handling. |
| `int countCities()` | Returns how many cities are currently in the list. | Verify count before and after adding cities. |

> 📘 **Helpful References**
> - [Comparing Java Objects with equals and hashCode](https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html)  
> - [JUnit 5 Expected Exception Examples](https://howtodoinjava.com/junit5/expected-exception-example/)

---

### 2️⃣ Add Javadoc Documentation
Add detailed **Javadoc** comments to all methods in:
- `City.java`
- `CityList.java`

Then **generate** the documentation and output it to:
