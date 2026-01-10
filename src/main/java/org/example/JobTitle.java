package org.example;

import java.util.Optional;

/**
 * Должность
 */
public enum JobTitle {
    PRESIDENT(StructuralUnit.REKTORAT, "Президент"),
    MAIN_DIRECTOR(StructuralUnit.REKTORAT, "Генеральный директор"),
    REKTOR(StructuralUnit.REKTORAT, "Ректор"),
    PROREKTOR(StructuralUnit.REKTORAT, "Проректор"),
    FACULTET(StructuralUnit.FACULTY, "Декан"),
    KAFEDRA(StructuralUnit.DEPARTMENT, "Заведующий кафедрой"),
    PROFESSOR(StructuralUnit.PEDAGOG, "Профессор"),
    PREPODAVATEL(StructuralUnit.PEDAGOG, "Преподаватель"),
    ASSISTENT(StructuralUnit.PEDAGOG, "Ассистент"),
    UNKNOWN(StructuralUnit.UNKNOWN, "Не известно")
;

    /**
     * Наименование структурного подразделения
     */
    private StructuralUnit structuralUnit;

    /**
     * Должность структурного подразделения
     */
    private String structuralUnitPosition;

    JobTitle(final StructuralUnit structuralUnitName, final String structuralUnitPosition) {
        this.structuralUnit = structuralUnitName;
        this.structuralUnitPosition = structuralUnitPosition;
    }

    public StructuralUnit getStructuralUnit() {
        return structuralUnit;
    }

    public String getStructuralUnitPosition() {
        return structuralUnitPosition;
    }

    public static JobTitle getJobTitleByOrdinal(final Integer ordinal) {
        return Optional.ofNullable(ordinal)
                .map(o -> JobTitle.values()[o])
                .orElse(UNKNOWN);
    }

    public static void print() {
        for (final JobTitle value : JobTitle.values()) {
            System.out.println(String.format("%d. %s", value.ordinal() + 1, value.getStructuralUnitPosition()));
        }
    }

    private enum StructuralUnit {
        REKTORAT("Ректорат"),
        FACULTY("Факультет"),
        DEPARTMENT("Кафедра"),
        PEDAGOG("Педагогический состав"),
        UNKNOWN("Не известно");

        private String structuralUnitName;

        StructuralUnit(final String structuralUnitName) {
            this.structuralUnitName = structuralUnitName;
        }
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "structuralUnitPosition='" + structuralUnitPosition + '\'' +
                '}';
    }
}