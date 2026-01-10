package org.example.Service;

import org.example.JobTitle;
import org.example.Worker;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class WorkerServiceTest {

    private WorkerService workerService;

    @Before
    public void setUp() {
        workerService = new WorkerService();
    }

    @Test
    public void createWorker() {
        final Worker workerActual = workerService.createWorker("Лобов", "Вадим", "Георгиевич", 0, 2000, "200");
        final Worker workerExpected = new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 200);

        assertEquals(workerExpected, workerActual);
    }

    @Test
    public void findWorkersExperienceMore() {
        final int yearCreatedTest = 2026;
        final int yearNow = LocalDateTime.now().getYear();
        final int correctIndex = yearNow - yearCreatedTest;

        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));
        workers.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 2010, 2));
        workers.add(new Worker("Васильев", "Артем", "Игоревич", JobTitle.REKTOR, 2020, 3));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));
        workersExpected.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 2010, 2));

        final List<Worker> workersActual = workerService.findWorkersExperienceMore(10 + correctIndex, workers);

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void findWorkersExperienceLess() {
        final int yearCreatedTest = 2026;
        final int yearNow = LocalDateTime.now().getYear();
        final int correctIndex = yearNow - yearCreatedTest;

        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));
        workers.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 2010, 2));
        workers.add(new Worker("Васильев", "Артем", "Игоревич", JobTitle.REKTOR, 2020, 3));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Васильев", "Артем", "Игоревич", JobTitle.REKTOR, 2020, 3));

        final List<Worker> workersActual = workerService.findWorkersExperienceLess(10 + correctIndex, workers);

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void findWorkersExperienceEquals() {
        final int yearCreatedTest = 2026;
        final int yearNow = LocalDateTime.now().getYear();
        final int correctIndex = yearNow - yearCreatedTest;

        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));
        workers.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 2010, 2));
        workers.add(new Worker("Васильев", "Артем", "Игоревич", JobTitle.REKTOR, 2020, 3));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Нестеров", "Максим", "Сергеевич", JobTitle.MAIN_DIRECTOR, 2010, 2));

        final List<Worker> workersActual = workerService.findWorkersExperienceEquals(16 + correctIndex, workers);

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerSurname() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Нестеров", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersActual = new ArrayList<>();

        final String surname = "Нестеров";
        final Scanner scanner = new Scanner(new ByteArrayInputStream(surname.getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 1));

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerName() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Максим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersActual = new ArrayList<>();

        final String name = "Максим";
        final Scanner scanner = new Scanner(new ByteArrayInputStream(name.getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 2));

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerPatronymic() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Вадим","Сергеевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersActual = new ArrayList<>();

        final String patronymic = "Сергеевич";
        final Scanner scanner = new Scanner(new ByteArrayInputStream(patronymic.getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 3));

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerJobTitle() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.MAIN_DIRECTOR, 2000, 1));

        final List<Worker> workersActual = new ArrayList<>();

        final int indexJobTitle = 2;
        final Scanner scanner = new Scanner(new ByteArrayInputStream(Integer.toString(indexJobTitle).getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 4));

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerYearWorkStart() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT,  2010, 1));

        final List<Worker> workersActual = new ArrayList<>();

        final int yearWorkStart = 2010;
        final Scanner scanner = new Scanner(new ByteArrayInputStream(Integer.toString(yearWorkStart).getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 5));

        assertEquals(workersExpected, workersActual);
    }

    @Test
    public void editWorkerSalary() {
        final List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 1));

        final List<Worker> workersExpected = new ArrayList<>();
        workersExpected.add(new Worker("Лобов", "Вадим", "Георгиевич", JobTitle.PRESIDENT, 2000, 2));

        final List<Worker> workersActual = new ArrayList<>();

        final int salary = 2;
        final Scanner scanner = new Scanner(new ByteArrayInputStream(Integer.toString(salary).getBytes()));
        workersActual.add(workerService.editWorker(scanner, workers, 0 , 6));

        assertEquals(workersExpected, workersActual);
    }
}