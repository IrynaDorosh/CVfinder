package ua.rabota.model;

import java.util.Objects;

public class Vacancy {
    public String companyName;
    public String vacancyName;
    public String urlVacancy;
    public String vacancyDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        return companyName.equals(vacancy.companyName) &&
                vacancyName.equals(vacancy.vacancyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, vacancyName);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "companyName='" + companyName + '\'' +
                ", vacancyName='" + vacancyName + '\'' +
                '}';
    }
}
