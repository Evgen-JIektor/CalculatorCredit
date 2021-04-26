package ru.calculator.creditCalc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calculator {

    private float x; // месячный плетеж

    @NotEmpty(message = "not be empty")
    @Min(value = 100000, message="Minimum value should be 100000" )
    @Max(value = 5000000, message="Maximum value should be 5000000")
    private float s = 500000; // стартовая сумма кредита

    private float sl; // часть выплаты, идущая на погашение долга
    private float p;  // процентная ставка в абсолютной велечине

    @NotEmpty(message = "not be empty")
    @Min(value=12, message="Minimum value should be 12" )
    @Max(value=60, message="Maximum value should be 60")
    private int n = 19;  // кредит на n месяцев

    private float st = 15; // процентная ставка, допустимые значения 12,9 - 23,9
    private float pn;  // начисленные проценты
    private float sn; // остаток задолженности на период
    private int i; // номер платежа
    private String data; //  месяц и год платежа


    public Calculator(float x, float s, float sl, float p, int n, float st, float pn, float sn, int i, String data) {
        this.x = x;
        this.s = s;
        this.sl = sl;
        this.p = p;
        this.n = n;
        this.st = st;
        this.pn = pn;
        this.sn = sn;
        this.i = i;
        this.data = data;
    }

    public Calculator() { }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getS() {
        return s;
    }

    public void setS(float s) {
        this.s = s;
    }

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float getSt() {
        return st;
    }

/*    public void setSt(float st) {this.st = st;}*/

    public float getPn() {
        return pn;
    }

    public void setPn(float pn) {
        this.pn = pn;
    }

    public float getSn() {
        return sn;
    }

    public void setSn(float sn) {
        this.sn = sn;
    }

    public float getSl() {
        return sl;
    }

    public void setSl(float sl) {
        this.sl = sl;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Calculator> foo() {

        List<Calculator> credit = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        Calendar cal = Calendar.getInstance();
        /*System.out.println(dateFormat.format(cal.getTime()));*/

        p = (st / 100) / 12;  // процентная ставка
        x = (float) (s * (p + p / (Math.pow((1 + p), n) - 1)));
        //  x = (float) (S * (p / (1 - Math.pow((1 + p),-n)))); // вторая формула для расчета

        sn = s; // остаток задолженности изначально составляет размер кредита

        if (s >= 100000 && s <= 5000000 && n >= 12 && n <= 60 ) {

            for (int i = 1; i <= n + 1; i++) {

                if (i == n + 1) { //  n+1 месяц  делаем платеж равным остатку и не снимаем проценты т.к. процент расчитан на n месяцев
                    x = sn;
                    sn = 0;
                }

                pn = sn * p; // начисленные проценты
                s = x - pn; //часть выплаты, идущая на погашение долга
                sn = sn - s; // остаток задолженности на период

                if (i == n + 1) {  // n+1 месяц выводим остаток в 0
                    sn = 0;
                }

                x = (float) (Math.round(x * 100.0) / 100.0);   // оставляем 2 знака после запятой со стандартным округлением
                pn = (float) (Math.round(pn * 100.0) / 100.0);
                s = (float) (Math.round(s * 100.0) / 100.0);
                sn = (float) (Math.round(sn * 100.0) / 100.0);

                cal.add(Calendar.MONTH, 1);  // расчет первой выплаты кредита начинается со следующего месяца
                String data = dateFormat.format(cal.getTime());

                credit.add(new Calculator(x, s, sl, p, n, st, pn, sn, i, data));

            }
        }
        /*credit.stream().forEach(h -> System.out.println(h));*/
        return credit;
    }

    /*@Override
    public String toString() {
        return "Calculator [месячный платеж=" + x
                + ", часть выплаты, идущая на погашение долга=" + s
                + ", test=" + sl
                + ", tes=" + p
                + ", tes=" + n
                + ", tes=" + st
                + ", начисленные проценты=" + pn
                + ", остаток задолженности на период=" + sn + "]" + "\n";
    }*/

}