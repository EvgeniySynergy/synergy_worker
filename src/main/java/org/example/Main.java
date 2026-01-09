package org.example;

import org.example.Service.WorkerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.WorkerUtils.printExperienceFilterMenu;
import static org.example.WorkerUtils.printMainMenu;

public class Main {

    public static void main(String[] args) {
        final WorkerService workerService = new WorkerService();

        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 1995, 200000));
        workers.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 1995, 180000));
        workers.add(new Worker("Васильев", "Артем", "Игоревич", JobTitle.REKTOR, 2010, 170000));
        workers.add(new Worker("Упоров", "Сергей", "Александрович", JobTitle.PROREKTOR, 2000, 160000));
        workers.add(new Worker("Бельченко", "Нина", "Владимировна", JobTitle.PROREKTOR, 1997, 160000));
        workers.add(new Worker("Захаров", "Александр", "Викторович", JobTitle.FACULTET, 2015, 150000));
        workers.add(new Worker("Дмитриев", "Антон", "Геннадиевич", JobTitle.KAFEDRA, 2010, 150000));
        workers.add(new Worker("Носова", "Виктория", "Ильинична", JobTitle.PROFESSOR, 1997, 170000));
        workers.add(new Worker("Горячева", "Елизавета", "Алексеевна", JobTitle.PREPODAVATEL, 2000, 170000));
        workers.add(new Worker("Мухин", "Владимир", "Романович", JobTitle.PREPODAVATEL, 2011, 150000));
        workers.add(new Worker("Романов", "Иван", "Даниилович", JobTitle.ASSISTENT, 2023, 100000));
        workers.add(new Worker("Кузьмин", "Василий", "Давидович", JobTitle.ASSISTENT, 2020, 100000));

        runWorker(workers, workerService);
    }

    private static void runWorker(final List<Worker> workers, final WorkerService workerService) {
        System.out.println("Добро пожаловать!");
        final Scanner scanner = new Scanner(System.in);
        int r = -1;

        printMainMenu();
        while (r != 0) {
            r = scanner.nextInt();
            switch (r) {
                case 1 -> {
                    System.out.print("Введите Фамилию (Обязательно): ");
                    final String surname = scanner.next();
                    System.out.print("Введите Имя (Обязательно): ");
                    final String name = scanner.next();
                    System.out.print("Введите Отчество (Обязательно): ");
                    final String patronymic = scanner.next();
                    System.out.print("Укажите должность (Обязательно): ");
                    for (final JobTitle value : JobTitle.values()) {
                        System.out.println(String.format("%d. %s", value.ordinal() + 1, value.getStructuralUnitPosition()));
                    }
                    final int jobTitle = scanner.nextInt();
                    System.out.print("Укажите год начала работы в учреждении (Обязательно): ");
                    final int yearWorkStart = scanner.nextInt();
                    System.out.print("Укажите зарплату: ");
                    final String salary = scanner.next();

                    final Worker newWorker = workerService.createWorker(surname, name, patronymic,jobTitle - 1, yearWorkStart, salary);
                    workers.add(newWorker);
                    printMainMenu();
                }
                case 2 -> {
                    workerService.printWorkers(workers);
                    printMainMenu();
                }
                case 3 -> {
                    printExperienceFilterMenu();
                    int exp = -1;
                    while (exp != 0) {
                        exp = scanner.nextInt();
                        switch (exp) {
                            case 1 -> {
                                System.out.print("Введите значение: ");
                                int value = scanner.nextInt();
                                workerService.printExperienceWorkers(workerService.findWorkersExperienceMore(value, workers));
                            }
                            case 2 -> {
                                System.out.print("Введите значение: ");
                                int value = scanner.nextInt();
                                workerService.printExperienceWorkers(workerService.findWorkersExperienceLess(value, workers));
                            }
                            case 3 -> {
                                System.out.print("Введите значение: ");
                                int value = scanner.nextInt();
                                workerService.printExperienceWorkers(workerService.findWorkersExperienceEquals(value, workers));
                            }
                            case 0 -> {

                            }
                            default -> {
                                System.out.println("Выберите пункт меню заново.");
                                printExperienceFilterMenu();
                            }
                        }
                        printExperienceFilterMenu();
                    }
                    printMainMenu();
                }
                case 0 -> {
                }
                default -> {
                    System.out.println("Выберите пункт меню заново.");
                    printMainMenu();
                }
            }
        }
        System.out.println("Программа завершена");
    }
}