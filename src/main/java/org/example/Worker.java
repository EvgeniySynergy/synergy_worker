package org.example;

import java.util.Objects;

/**
 * Работник учреждения
 */
public class Worker {

    /**
     * Фамилия
     */
    final private String surname;

    /**
     * Имя
     */
    final private String name;

    /**
     * Отчество
     */
    final private String patronymic;

    /**
     * Должность
     */
    final private JobTitle jobTitle;

    /**
     * Год начала работы в учреждении
     */
    final private Integer yearWorkStart;

    /**
     * Зарплата
     */
    private Integer salary;

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

    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public Integer getYearWorkStart() {
        return yearWorkStart;
    }

    public Integer getSalary() {
        return salary;
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
