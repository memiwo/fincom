package edu.mum.fincom.framework;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Issa Fikadu
 */
public interface IEntry {
    double getAmount();
    LocalDate getDate();
    String getDescription();
}
