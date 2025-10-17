package com.example.listycity;

import java.util.Objects;

/**
 * Represents a City with a name and a province.
 * This class provides methods for comparison, equality checking,
 * and hash code generation for City objects.
 */
public class City implements Comparable {

    /**
     * The name of the city.
     */
    private String city;

    /**
     * The name of the province the city belongs to.
     */
    private String province;

    /**
     * Constructs a City object with the specified city and province names.
     *
     * @param city
     *      The name of the city.
     * @param province
     *      The name of the province.
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     *
     * @return
     *      The city name.
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Returns the name of the province.
     *
     * @return
     *      The province name.
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this City object with another City based on their city names,
     * using lexicographical (alphabetical) order.
     *
     * @param o
     *      The object to be compared with this City.
     * @return
     *      A negative integer, zero, or a positive integer as this city's name
     *      is lexicographically less than, equal to, or greater than the specified city's name.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Indicates whether some other object is "equal to" this City.
     * Two City objects are considered equal if they have the same city and province names.
     *
     * @param obj
     *      The object to compare this City against.
     * @return
     *      {@code true} if the specified object represents the same city and province;
     *      {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City other = (City) obj;
        return Objects.equals(this.city, other.city) &&
                Objects.equals(this.province, other.province);
    }

    /**
     * Returns a hash code value for this City.
     * This implementation ensures that equal City objects have the same hash code,
     * based on their city and province names.
     *
     * @return
     *      The hash code computed from the city and province names.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.province);
    }
}
