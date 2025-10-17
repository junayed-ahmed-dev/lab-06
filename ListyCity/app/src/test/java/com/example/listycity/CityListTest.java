package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CityList} class.
 * <p>
 * This test suite verifies that all core functionalities of {@link CityList}
 * — including adding, sorting, checking, deleting, and counting {@link City} objects —
 * behave correctly and handle exceptions as expected.
 * </p>
 */
class CityListTest {

    /**
     * Creates a mock {@link CityList} containing one city (Edmonton, Alberta).
     *
     * @return
     *      A {@link CityList} instance pre-populated with one mock city.
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock {@link City} object representing Edmonton, Alberta.
     *
     * @return
     *      A mock {@link City} instance.
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests the {@link CityList#add(City)} method.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A new city can be added successfully to the list.</li>
     *     <li>The total size of the list increases after the addition.</li>
     *     <li>The newly added city is contained within the list.</li>
     * </ul>
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests that {@link CityList#add(City)} throws an {@link IllegalArgumentException}
     * when trying to add a city that already exists in the list.
     * <p>
     * This ensures that duplicate city entries are not allowed.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Tests the {@link CityList#getCities()} method.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>The list of cities is returned in ascending alphabetical order by city name.</li>
     *     <li>Adding a new city affects the correct order of the sorted list.</li>
     * </ul>
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // The first city should match the mock city (Edmonton)
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // Add a new city that comes alphabetically before Edmonton
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // The new city should now be first in sorted order
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests the {@link CityList#hasCity(City)} method.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>{@code hasCity()} correctly identifies an existing city in the list.</li>
     *     <li>{@code hasCity()} correctly returns {@code false} for a city not in the list.</li>
     * </ul>
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City existingCity = mockCity();
        assertTrue(cityList.hasCity(existingCity));

        City nonExistentCity = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(nonExistentCity));
    }

    /**
     * Tests the {@link CityList#delete(City)} method.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An existing city can be successfully deleted from the list.</li>
     *     <li>The deleted city no longer exists in the list afterward.</li>
     * </ul>
     */
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        cityList.delete(city);

        assertFalse(cityList.hasCity(city));
    }

    /**
     * Tests that {@link CityList#delete(City)} throws an {@link IllegalArgumentException}
     * when attempting to delete a city that does not exist in the list.
     * <p>
     * This ensures that invalid deletion attempts are handled correctly.
     */
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City nonExistentCity = new City("Toronto", "Ontario");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nonExistentCity);
        });
    }

    /**
     * Tests the {@link CityList#countCities()} method.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>The count initially matches the number of cities in the list.</li>
     *     <li>The count updates correctly after adding new cities.</li>
     * </ul>
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));

        assertEquals(2, cityList.countCities());
    }
}
