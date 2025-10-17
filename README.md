# CMPUT 301 : Lab 6 – JUnit and Javadoc

## Student Details

**Full Name:** Junayed Ahmed  
**CCID:** junayed  

---

## References and Resources

- CMPUT 301 Lab 6 Slides – JUnit and Javadoc Exercise  
- [Infoworld – Comparing Java Objects with equals() and hashCode()](https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html)  
- [HowToDoInJava – JUnit 5 Expected Exception Examples](https://howtodoinjava.com/junit5/expected-exception-example/)  
- [Oracle Java Documentation – Javadoc Tool Reference](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html)  
- CMPUT 301 eClass – Lab 6 Participation Guide  

---

## Verbal Collaboration

N/A (Did not collaborate)

---

## Design and Implementation

### Objective

Implement, test, and document the `CityList` class by writing methods that handle list operations on `City` objects.  
Use **JUnit 5** to validate method functionality and generate **Javadoc** documentation for `City.java` and `CityList.java`.

---

### User Guide

1. Open the project in IntelliJ IDEA or Android Studio.  
2. Review `City.java` and `CityList.java` — all methods include detailed Javadoc comments.  
3. Run all tests in `CityListTest.java` to verify functionality.  
4. Generate Javadoc documentation by:  
   - Using the IDE menu: **Tools → Generate JavaDoc...**  
   - Or running this command in the terminal:  
     ```bash
     javadoc -d javadoc -sourcepath ListyCity/src com.example.listycity
     ```
5. Open `javadoc/index.html` in a browser to view your generated documentation.

---

## Testing Checklist

| Test | Expected Outcome |
|:--|:--|
| **Add City** | City successfully added to the list. |
| **Add Existing City** | Throws `IllegalArgumentException`. |
| **Has City** | Returns `true` for existing city, `false` for non-existing. |
| **Delete City** | Removes city; no longer present in list. |
| **Delete Non-existent City** | Throws `IllegalArgumentException`. |
| **Count Cities** | Returns accurate number of cities in the list. |
| **Get Cities (Sorted)** | Returns list of cities in ascending alphabetical order. |
| **Javadoc Generated** | HTML documentation created in `/javadoc/`. |

---

## Known Issues and Fixes

| Issue | Cause | Fix |
|:--|:--|:--|
| **"Test events were not received"** | Occurs when IntelliJ or Gradle test runner desyncs with JUnit. | Restart IntelliJ or rebuild the project. Then re-run tests using the green “Run All Tests” icon. |
| **"Error creating Javadoc"** | Javadoc generation fails if output directory or source paths are incorrect. | Ensure you have a `javadoc/` folder at project root and correct package paths (e.g., `com.example.listycity`). |
| **Javadoc not updating** | The IDE cached older docs. | Delete the old `javadoc/` folder, then regenerate via *Tools → Generate JavaDoc...*. |
| **JUnit test not detected** | Missing `@Test` import or incorrect classpath. | Ensure `import org.junit.jupiter.api.Test;` is present and your project SDK uses JUnit 5. |

---

## File Structure

