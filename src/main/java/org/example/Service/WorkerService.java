package org.example.Service;

import org.example.JobTitle;
import org.example.Worker;
import org.example.WorkerUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис Работника
 */
public class WorkerService {
    private static int year = LocalDateTime.now().getYear();

    /**
     * Печать полной информации по работнику
     * @param workers
     */
    public void printWorkers(final List<Worker> workers) {
        if (!workers.isEmpty()) {
            for (int i = 0; i < workers.size(); i++) {
                final Worker worker = workers.get(i);
                System.out.println(String.format("%d. %s, должность: %s, год начала работы: %d, зарплата: %d",
                        i + 1,
                        WorkerUtils.getFullName(worker),
                        worker.getJobTitle().getStructuralUnitPosition(),
                        worker.getYearWorkStart(),
                        worker.getSalary())
                );
            }
        } else {
            System.out.println("* * * Список пуст * * *");
        }
    }

    /**
     * Печать сокращенной формы
     * @param workers
     */
    public void printExperienceWorkers(final List<Worker> workers) {
        if (!workers.isEmpty()) {
            for (int i = 0; i < workers.size(); i++) {
                final Worker worker = workers.get(i);
                System.out.println(String.format("%d. %s - стаж с %d года (%d)",
                        i + 1,
                        WorkerUtils.getShortName(worker),
                        worker.getYearWorkStart(),
                        year - worker.getYearWorkStart()
                ));
            }
        } else {
            System.out.println("* * * Список пуст * * *");
        }
    }


    /**
     * Создание работника
     * @param surname
     * @param name
     * @param patronymic
     * @param jobTitle
     * @param yearWorkStart
     * @param salary
     * @return
     */
    public Worker createWorker(final String surname,
                            final String name,
                            final String patronymic,
                            final Integer jobTitle,
                            final Integer yearWorkStart,
                            final String salary) {
        int i = 0;
        try {
            i = Integer.parseInt(salary);
        } catch (final NumberFormatException ignored) {
        }

        return new Worker(surname, name, patronymic, JobTitle.getJobTitleByOrdinal(jobTitle), yearWorkStart, i);
    }

    /**
     * Поиск работников по стажу больше значения
     * @param value
     * @param workers
     * @return
     */
    public List<Worker> findWorkersExperienceMore(final Integer value, final List<Worker> workers) {
        return workers.stream()
                .filter(work -> year - work.getYearWorkStart() > value)
                .collect(Collectors.toList());
    }

    /**
     * Поиск работников по стажу меньше значения
     * @param value
     * @param workers
     * @return
     */
    public List<Worker> findWorkersExperienceLess(final Integer value, final List<Worker> workers) {
        return workers.stream()
                .filter(work -> year - work.getYearWorkStart() < value)
                .collect(Collectors.toList());
    }

    /**
     * Поиск работников по стажу равному значению
     * @param value
     * @param workers
     * @return
     */
    public List<Worker> findWorkersExperienceEquals(final Integer value, final List<Worker> workers) {
        return workers.stream()
                .filter(work -> year - work.getYearWorkStart() == value)
                .collect(Collectors.toList());
    }
}