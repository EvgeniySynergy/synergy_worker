package org.example;

import java.util.Objects;

/**
 * Работник учреждения
 */
public class Worker {

    /**
     * Фамилия
     */
    private String surname;

    /**
     * Имя
     */
    private String name;

    /**
     * Отчество
     */
    private String patronymic;

    /**
     * Должность
     */
    private JobTitle jobTitle;

    /**
     * Год начала работы в учреждении
     */
    private Integer yearWorkStart;

    /**
     * Зарплата
     */
    private Integer salary;

    public Worker(
            final String surname,
            final String name,
            final String patronymic
    ) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Worker(
            final String surname,
            final String name,
            final String patronymic,
            final JobTitle jobTitle,
            final Integer yearWorkStart
    ) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        this.yearWorkStart = yearWorkStart;
    }

    public Worker(
            final String surname,
            final String name,
            final String patronymic,
            final JobTitle jobTitle,
            final Integer yearWorkStart,
            final Integer salary
    ) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        this.yearWorkStart = yearWorkStart;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(final JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getYearWorkStart() {
        return yearWorkStart;
    }

    public void setYearWorkStart(final Integer yearWorkStart) {
        this.yearWorkStart = yearWorkStart;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Worker worker = (Worker) o;
        return Objects.equals(surname, worker.surname) && Objects.equals(name, worker.name) && Objects.equals(patronymic, worker.patronymic) && jobTitle == worker.jobTitle && Objects.equals(yearWorkStart, worker.yearWorkStart) && Objects.equals(salary, worker.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, jobTitle, yearWorkStart, salary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", jobTitle=" + jobTitle +
                ", yearWorkStart=" + yearWorkStart +
                ", salary=" + salary +
                '}';
    }
}
