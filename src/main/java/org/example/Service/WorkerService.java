package org.example.Service;

import org.example.JobTitle;
import org.example.Worker;
import org.example.WorkerUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Сервис Работника
 */
public class WorkerService {
    private static int year = LocalDateTime.now().getYear();

    /**
     * Печать полной информации по работнику
     *
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

    public void printWorker(final Worker worker) {
        System.out.println(String.format("%s, должность: %s, год начала работы: %d, зарплата: %d",
                WorkerUtils.getFullName(worker),
                worker.getJobTitle().getStructuralUnitPosition(),
                worker.getYearWorkStart(),
                worker.getSalary())
        );
    }

    /**
     * Печать сокращенной формы
     *
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
     *
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

    public Worker editWorker(
            final Scanner scanner,
            final List<Worker> workers,
            int indexWorker,
            int indexWorkerСharacteristic
    ) {
        final Worker worker = workers.get(indexWorker);
        switch (indexWorkerСharacteristic) {
            case 1 -> {
                final String oldSurname = worker.getSurname();
                System.out.println("Старое значение: " + oldSurname);
                System.out.print("Введите новое значение: ");
                worker.setSurname(scanner.next());
            }
            case 2 -> {
                final String oldName = worker.getName();
                System.out.println("Старое значение: " + oldName);
                System.out.print("Введите новое значение: ");
                worker.setName(scanner.next());
            }
            case 3 -> {
                final String oldPatronymic = worker.getPatronymic();
                System.out.println("Старое значение: " + oldPatronymic);
                System.out.print("Введите новое значение: ");
                worker.setPatronymic(scanner.next());
            }
            case 4 -> {
                final JobTitle oldJobTitle = worker.getJobTitle();
                System.out.println("Старое значение: " + oldJobTitle.getStructuralUnitPosition());
                System.out.println("Введите новое значение: ");
                JobTitle.print();
                worker.setJobTitle(JobTitle.getJobTitleByOrdinal(scanner.nextInt() - 1));
            }
            case 5 -> {
                final int oldYearWorkStart = worker.getYearWorkStart();
                System.out.println("Старое значение: " + oldYearWorkStart);
                System.out.print("Введите новое значение: ");
                worker.setYearWorkStart(scanner.nextInt());
            }
            case 6 -> {
                final int oldSalary = worker.getSalary();
                System.out.println("Старое значение: " + oldSalary);
                System.out.print("Введите новое значение: ");
                worker.setSalary(scanner.nextInt());
            }
            default -> {
            }
        }
        printWorker(worker);
        return worker;
    }

    /**
     * Поиск работников по стажу больше значения
     *
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
     *
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
     *
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