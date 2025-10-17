package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The {@code CityList} class maintains and manages a dynamic collection of {@link City} objects.
 * <p>
 * It provides operations to:
 * <ul>
 *     <li>Add new cities (with duplicate checking)</li>
 *     <li>Check for a city's existence</li>
 *     <li>Delete cities safely</li>
 *     <li>Count how many cities are stored</li>
 *     <li>Retrieve an alphabetically sorted list of cities</li>
 * </ul>
 * <p>
 * Internally, the class uses an {@link ArrayList} to store the list of cities and
 * ensures that each {@link City} object is unique by comparing both its name and province
 * using the {@link City#equals(Object)} and {@link City#hashCode()} methods.
 * <p>
 * This class is part of the CMPUT 301 Lab exercise on implementing and testing list operations
 * and generating Javadoc documentation.
 *
 * @author
 *      Junayed Ahmed
 * @version
 *      1.0
 * @since
 *      2024-09
 */
public class CityList {

    /**
     * The underlying list structure used to store {@link City} objects.
     * <p>
     * This list ensures that cities are stored in the order they are added,
     * but can be retrieved in sorted order via {@link #getCities()}.
     */
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a new {@link City} to the list if it does not already exist.
     * <p>
     * This method ensures uniqueness — before adding, it checks if the
     * same city (based on both name and province) is already present using
     * {@link City#equals(Object)}. If it is, an {@link IllegalArgumentException}
     * is thrown.
     *
     * @param city
     *      The {@link City} object to be added to the list.
     * @throws IllegalArgumentException
     *      If the specified city already exists in the list.
     * @see #hasCity(City)
     * @see #delete(City)
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * Returns a new list of {@link City} objects sorted in ascending
     * lexicographical order by their city names.
     * <p>
     * The sorting is performed using {@link Collections#sort(List)} which relies on
     * the natural ordering defined in the {@link City#compareTo(Object)} method.
     * <p>
     * A shallow copy of the internal list is returned to prevent external modification
     * of the original {@code cities} list.
     *
     * @return
     *      A sorted {@link List} containing all {@link City} objects currently stored.
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a specified {@link City} exists in the list.
     * <p>
     * The comparison is based on both the city name and province name,
     * as defined in the {@link City#equals(Object)} method.
     * This method provides a quick membership check without modifying the list.
     *
     * @param city
     *      The {@link City} to be checked for existence.
     * @return
     *      {@code true} if the city exists in the list;
     *      {@code false} otherwise.
     * @see City#equals(Object)
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a specified {@link City} from the list if it exists.
     * <p>
     * If the city is not found, an {@link IllegalArgumentException} is thrown to
     * indicate that the operation could not be completed. This ensures that only
     * valid deletions occur and prevents silent failures.
     *
     * @param city
     *      The {@link City} object to be removed from the list.
     * @throws IllegalArgumentException
     *      If the specified city does not exist in the list.
     * @see #add(City)
     * @see #hasCity(City)
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("Cannot delete a city that does not exist in the list.");
        }
        cities.remove(city);
    }

    /**
     * Returns the total number of {@link City} objects currently stored in the list.
     * <p>
     * This method provides a simple way to measure the size of the collection and
     * is often used in unit tests to validate list modifications after add or delete operations.
     *
     * @return
     *      The number of cities stored in this {@code CityList}.
     * @see #add(City)
     * @see #delete(City)
     */
    public int countCities() {
        return cities.size();
    }
}
