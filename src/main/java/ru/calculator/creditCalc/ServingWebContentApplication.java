package ru.calculator.creditCalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);

/*
        Calculator calculator = new Calculator();
        calculator.foo();*/

       /* CalcService.class(foo());*/





/*        float x; // месячный плетеж
        float x1; // месячный плетеж, вторая формула
        float S = 2000000; // стартовая сумма кредита
        float s; // часть выплаты, идущая на погашение долга
        float p;  // процентная ставка в абсолютной велечине
        float n = 18;  // кредит на n месяцев
        float st = 15; // процентная ставка

        float pn;  // начисленные проценты
        float sn = 2000000; // остаток задолженности на период



        p = (st / 100) / 12;

        x1 = (float) (S * (p / (1 - Math.pow((1 + p),-n))));



        p = (st / 100) / 12;

        x = (float) (S * (p + p / (Math.pow((1 + p), n) - 1)));


        for(int i = 1 ; i <= n+1 ; i++) {

            if (i == n+1){ //  n+1 месяц  делаем платеж равным остатку и не снимаем проценты т.к. процент расчитан на n месяцев
                x = sn;
                sn = 0;
            }

            pn = sn * p; // начисленные проценты

            s = x - pn; //часть выплаты, идущая на погашение долга

            sn = sn - s; // остаток задолженности на период

            if (i == n+1){  // n+1 месяц выводим остаток в 0
                sn = 0;
            }

            System.out.println();

            System.out.println(x + " " + "месячный платеж");
            System.out.println(pn + " " + "начисленные проценты");
            System.out.println(s + " " + "часть выплаты, идущая на погашение долга");
            System.out.println(sn + " " + "остаток задолженности на период");
            System.out.println(i + " " + "месяц");

            System.out.println();


        }*/
    }

}
