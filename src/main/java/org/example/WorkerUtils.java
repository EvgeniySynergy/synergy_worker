package org.example;

public final class WorkerUtils {
    private WorkerUtils() {
        throw new UnsupportedOperationException("Это утилитный класс, нельзя создавать экземпляры");
    }

    /**
     * Получение короткого имени работника.
     * @return Фамилия и инициалы
     */
    public static String getShortName(final Worker worker) {
        if (worker.getSurname().length() == 0 || worker.getPatronymic().length() == 0) {
            return worker.getSurname();
        } else {
            final String firstCharName = String.valueOf(worker.getName().charAt(0)).toUpperCase();
            final String firstCharPatronymic = String.valueOf(worker.getPatronymic().charAt(0)).toUpperCase();

            return String.format("%s %s.%s.", worker.getSurname(), firstCharName, firstCharPatronymic);
        }
    }

    /**
     * Получение полного имени работника.
     * @return ФИО полностью
     */
    public static String getFullName(final Worker worker) {
        if (worker.getSurname().length() == 0 || worker.getPatronymic().length() == 0) {
            return worker.getSurname();
        } else {
            return String.format("%s %s %s", worker.getSurname(), worker.getName(), worker.getPatronymic());
        }
    }

    /**
     * Печать Главного меню
     */
    public static void printMainMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Вы находитесь в главном меню:");
        System.out.println(" *   *   *   *   *   *   *   *");
        System.out.println("1. Добавить нового сотрудника");
        System.out.println("2. Вывести полный список сотрудников");
        System.out.println("3. Фильтр сотрудников по стажу работы");
        System.out.println("0. Выход из программы");
        System.out.println("--------------------------------------");
    }

    /**
     * Печать Меню фильтра по стажу
     */
    public static void printExperienceFilterMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Вы находитесь в меню Фильтр сотружников по стажу:");
        System.out.println(" *   *   *   *   *   *   *   *");
        System.out.println("1. Больше чем ***");
        System.out.println("2. Меньше чем ***");
        System.out.println("3. Равно ***");
        System.out.println("0. Выход из меню");
        System.out.println("--------------------------------------");
    }
}