package org.motechproject.openmrs19.domain;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.Matchers.equalTo;

/**
 * Represents a single person. This class stores personal information about the person. It's used by the
 * {@link OpenMRSPatient}. It's part of the MOTECH model.
 */
public class OpenMRSPerson {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private String address;
    private DateTime dateOfBirth;
    private Boolean birthDateEstimated;
    private Integer age;
    private String gender;
    private boolean isDead;

    private List<OpenMRSAttribute> attributes = new ArrayList<OpenMRSAttribute>();
    private DateTime deathDate;

    /**
     * Default constructor.
     */
    public OpenMRSPerson() {
        this(null);
    }

    /**
     * Creates a person with the given OpenMRS {@code id}.
     *
     * @param id  the OpenMRS ID of the person
     */
    public OpenMRSPerson(String id) {
        this.id = id;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBirthDateEstimated(Boolean birthDateEstimated) {
        this.birthDateEstimated = birthDateEstimated;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIsDead(Boolean isDead) {
        this.isDead = isDead;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public List<OpenMRSAttribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(OpenMRSAttribute attribute) {
        attributes.add(attribute);
    }

    public void setAttributes(List<OpenMRSAttribute> attributes) {
        this.attributes = attributes;
    }

    public void setDeathDate(DateTime deathDate) {
        this.deathDate = deathDate;
    }

    @Deprecated
    public String attrValue(String key) {
        List<OpenMRSAttribute> filteredItems = select(attributes, having(on(OpenMRSAttribute.class).getName(), equalTo(key)));
        return CollectionUtils.isNotEmpty(filteredItems) ? filteredItems.get(0).getValue() : null;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public DateTime getDateOfBirth() {
        return new DateTime(dateOfBirth);
    }

    public String getAddress() {
        return address;
    }

    public Boolean getBirthDateEstimated() {
        return birthDateEstimated;
    }

    public Boolean isDead() {
        return isDead;
    }

    public Integer getAge() {
        return age;
    }

    public DateTime getDeathDate() {
        return deathDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OpenMRSPerson)) {
            return false;
        }

        OpenMRSPerson other = (OpenMRSPerson) o;

        return equalNameData(other) && equalAgeAndBirthDates(other) && Objects.equals(id, other.id)
                && Objects.equals(address, other.address) && Objects.equals(gender, other.gender)
                && Objects.equals(attributes, other.attributes) && Objects.equals(deathDate, other.deathDate)
                && isDead == other.isDead;
    }

    public boolean equalNameData(OpenMRSPerson other) {
        return Objects.equals(firstName, other.firstName) && Objects.equals(middleName, other.middleName)
                && Objects.equals(lastName, other.lastName) && Objects.equals(preferredName, other.preferredName);
    }

    public boolean equalAgeAndBirthDates(OpenMRSPerson other) {
        return Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(birthDateEstimated, other.birthDateEstimated) && Objects.equals(age, other.age);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(id);
        hash = hash * 31 + ObjectUtils.hashCode(firstName);
        hash = hash * 31 + ObjectUtils.hashCode(middleName);
        hash = hash * 31 + ObjectUtils.hashCode(lastName);
        hash = hash * 31 + ObjectUtils.hashCode(preferredName);
        hash = hash * 31 + ObjectUtils.hashCode(address);
        hash = hash * 31 + ObjectUtils.hashCode(dateOfBirth);
        hash = hash * 31 + ObjectUtils.hashCode(birthDateEstimated);
        hash = hash * 31 + ObjectUtils.hashCode(age);
        hash = hash * 31 + ObjectUtils.hashCode(gender);
        hash = hash * 31 + Boolean.valueOf(isDead).hashCode();
        hash = hash * 31 + ObjectUtils.hashCode(attributes);
        hash = hash * 31 + ObjectUtils.hashCode(deathDate);
        return hash;
    }

    public String getPersonId() {
        return id;
    }

    public void setPersonId(String id) {
        this.id = id;
    }

}
