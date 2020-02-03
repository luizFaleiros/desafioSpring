package com.example.desafioSpring.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * StatusChange
 */
public class StatusChangeTeste {

    public Boolean Validate(Integer value, Date ini, Date fim) {
        if (ini == null) {
            return false;
        }
        if (fim == null) {
            return false;
        }
        if (value == null) {
            return false;
        }
        Boolean results = true;
        switch (value) {
        case 2:
            results = init(ini, fim);
            break;
        case 3:
            results = Concluido(ini, fim);
            break;

        case 4:
            results = Cancel(ini, fim);
            break;

        default:
        results = true;
            break;
        }
        return results;
    }

    private Boolean Cancel(Date ini, Date fima) {

        Calendar daata = Calendar.getInstance();
        daata.setTime(new Date());
        daata.set(Calendar.HOUR, 0);
        daata.set(Calendar.MINUTE, 0);
        daata.set(Calendar.SECOND, 0);
        daata.set(Calendar.MILLISECOND, 1);

        Calendar inicio = Calendar.getInstance();
        inicio.setTime(ini);
        Calendar fim = Calendar.getInstance();
        fim.setTime(fima);
        if (inicio.getTimeInMillis() >= daata.getTimeInMillis()) {

            return false;

        }
        return true;
    }

    private Boolean init(Date ini, Date fim) {
        Calendar c = Calendar.getInstance();
        if ((ini.getTime() > c.getTimeInMillis())) {
            return false;
        }
        if ((c.getTimeInMillis() > fim.getTime())) {
            return false;
        }
        return true;
    }

    private Boolean Concluido(Date ini, Date fim) {
        Calendar c = Calendar.getInstance();
        if (c.getTimeInMillis() < ini.getTime()) {
            return true;
        }
        return false;
    }
}