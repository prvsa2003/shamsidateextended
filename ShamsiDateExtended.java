package tamrin;

import java.time.LocalDate;
import java.time.Period;

public class ShamsiDateExtended {

    public byte day;
    public byte month;
    public short year;
    private static byte[] monthDays = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};

    public ShamsiDateExtended() {
    }

    public ShamsiDateExtended(byte day, byte month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void incDay() {
        day++;
        if (day > monthDays[month - 1]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public int compare(ShamsiDateExtended another) {
        boolean flag = true;
        LocalDate first = LocalDate.of(year, month, day);
        LocalDate second = LocalDate.of(another.year, another.month, another.day);
        Period period = Period.between(first, second);
        flag = period.isNegative();
        if (flag == true) {
            return 1;
        } else {
            if(year==another.year && month == another.month && day == another.day){
            return 0;
        } else {
            return -1;
        }
    }
    }
    public void addDays(int num) {
        int cDay = day + num;
        if (cDay < 1) {
            int difYear = cDay / 365;
            cDay -= difYear * 365;
            int difMonth = -1;
            int mIndex = month - 2;
            if (mIndex == -1) {
                mIndex = 11;
            }
            while (-cDay > monthDays[mIndex]) {
                difMonth--;
                cDay += monthDays[mIndex];
                mIndex--;
                if (mIndex == -1) {
                    mIndex = 11;
                }
            }

            year += difYear;
            month += difMonth;
            if (month <= 0) {
                month += 12;
                year--;
            }
            day = (byte) (monthDays[month - 1] + cDay);

        } else if (cDay > monthDays[month - 1]) {
            int difYear = cDay / 365;
            cDay -= difYear * 365;
            int difMonth = 0;
            int mIndex = month;
            if (mIndex == 12) {
                mIndex = 0;
            }
            while (cDay > monthDays[mIndex]) {
                difMonth++;
                cDay -= monthDays[mIndex];
                mIndex++;
                if (mIndex == 12) {
                    mIndex = 0;
                }
            }

            year += difYear;
            month += difMonth;
            if (month > 12) {
                month -= 12;
                year++;
            }
            day = (byte) (cDay);

        } else {
            day = (byte) cDay;
        }

    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

}
