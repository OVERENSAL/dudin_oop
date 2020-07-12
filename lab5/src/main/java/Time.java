public class Time {
    private final int LOWER_HOUR_LIMIT = 0;
    private final int HIGHER_HOUR_LIMIT = 23;
    private final int LOWER_MINUTE_LIMIT = 0;
    private final int HIGHER_MINUTE_LIMIT = 59;
    private final int LOWER_SECOND_LIMIT = 0;
    private final int HIGHER_SECOND_LIMIT = 59;
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isValid(Time time) {
        if (time.getHour() > HIGHER_HOUR_LIMIT || time.getHour() < LOWER_HOUR_LIMIT) {
            return false;
        }
        if (time.getMinute() > HIGHER_MINUTE_LIMIT || time.getMinute() < LOWER_MINUTE_LIMIT) {
            return false;
        }
        return time.getSecond() <= HIGHER_SECOND_LIMIT || time.getSecond() >= LOWER_SECOND_LIMIT;
    }

    public void prefixInc() {
        if (this.getSecond() + 1 > HIGHER_SECOND_LIMIT) {
            if (this.getMinute() + 1 > HIGHER_MINUTE_LIMIT) {
                if (this.getHour() + 1 > HIGHER_HOUR_LIMIT) {
                    this.setSecond(00);
                    this.setMinute(00);
                    this.setHour(00);
                } else {
                    this.setSecond(00);
                    this.setMinute(00);
                    this.setHour(this.getHour() + 1);
                }
            } else {
                this.setSecond(00);
                this.setMinute(this.getMinute() + 1);
            }
        } else {
            this.setSecond(this.getSecond() + 1);
        }
    }

    public Time postfixInc() {
        Time oldTime = new Time(this.getHour(), this.getMinute(), this.getSecond());
        this.prefixInc();
        return oldTime;
    }

    public Time sumTime(Time time1, Time time2) {
        int resultSecond = time1.getSecond() + time2.getSecond();
        int resultMinute = time1.getMinute() + time2. getMinute();
        int resultHour = time1.getHour() + time2.getHour();
        if (resultSecond > HIGHER_SECOND_LIMIT) {
            resultMinute += resultSecond / (HIGHER_SECOND_LIMIT + 1);
            resultSecond -= (HIGHER_SECOND_LIMIT + 1) * (resultSecond / (HIGHER_SECOND_LIMIT + 1));
        }
        if (resultMinute > HIGHER_MINUTE_LIMIT) {
            resultHour += resultMinute / (HIGHER_MINUTE_LIMIT + 1);
            resultMinute -= (HIGHER_MINUTE_LIMIT + 1) * (resultMinute / (HIGHER_MINUTE_LIMIT + 1));
        }
        if (resultHour > HIGHER_HOUR_LIMIT) {
            resultHour -= (HIGHER_HOUR_LIMIT + 1) * (resultHour / (HIGHER_HOUR_LIMIT + 1));
        }

        return new Time(resultHour, resultMinute, resultSecond);
    }

    public Time subtractTime(Time time1, Time time2) {
        if (time1.getSecond() < time2.getSecond()) {
            time1.setMinute(time1.getMinute() - 1);
            time1.setSecond(time1.getSecond() + HIGHER_SECOND_LIMIT + 1);
        }
        int resultSecond = time1.getSecond() - time2.getSecond();
        if (time1.getMinute() < time2.getMinute()) {
            time1.setHour(time1.getHour() - 1);
            time1.setMinute(time1.getMinute() + HIGHER_MINUTE_LIMIT + 1);
        }
        int resultMinute = time1.getMinute() - time2.getMinute();
        if (time1.getHour() < time2.getHour()) {
            time1.setHour(time1.getHour() + HIGHER_HOUR_LIMIT + 1);
        }
        int resultHour = time1.getHour() - time2.getHour();

        return new Time(resultHour, resultMinute, resultSecond);
    }

    public void prefSumTime(Time time) {
        Time tempTime = this.sumTime(this, time);
        this.setHour(tempTime.getHour());
        this.setMinute(tempTime.getMinute());
        this.setSecond(tempTime.getSecond());
    }

    public void prefSubtractTime(Time time) {
        Time tempTime = this.subtractTime(this, time);
        this.setHour(tempTime.getHour());
        this.setMinute(tempTime.getMinute());
        this.setSecond(tempTime.getSecond());
    }

    public Time multiplicationTime(Time time, int multiplier) {
        int tempSecond = time.getSecond() * multiplier;
        int tempMinute = time.getMinute() * multiplier;
        int tempHour = time.getHour() * multiplier;
        while (tempSecond > HIGHER_SECOND_LIMIT) {
            tempMinute += tempSecond / (HIGHER_SECOND_LIMIT + 1);
            tempSecond %= (HIGHER_SECOND_LIMIT + 1);
        }
        while (tempMinute > HIGHER_MINUTE_LIMIT) {
            tempHour += tempMinute / (HIGHER_MINUTE_LIMIT + 1);
            tempMinute %= (HIGHER_MINUTE_LIMIT + 1);
        }
        while (tempHour > HIGHER_HOUR_LIMIT) {
            tempHour %= (HIGHER_HOUR_LIMIT + 1);
        }

        return new Time(tempHour, tempMinute, tempSecond);
    }

    public Time divisionTime(Time time, int divider) {
        return new Time(time.getHour() / divider, time.getMinute() / divider, time.getSecond() / divider);
    }

    public Time divisionTimeOnTime(Time time, Time time2) {
        return new Time(time.getHour() / time2.getHour(), time.getMinute() / time2.getMinute(), time.getSecond() / time2.getSecond());
    }

    public void prefMultiplicationTime(int multiplier) {
        Time tempTime = this.multiplicationTime(this, multiplier);
        this.setHour(tempTime.getHour());
        this.setMinute(tempTime.getMinute());
        this.setSecond(tempTime.getSecond());
    }

    public void prefDivisionTime(int divider) {
        this.setHour(this.getHour() / divider);
        this.setMinute(this.getMinute() / divider);
        this.setSecond(this.getSecond() / divider);
    }

    public boolean timesAreEqual(Time time1, Time time2) {
        if (time1.getHour() == time2.getHour()) {
            if (time1.getMinute() == time2.getMinute()) {
                return time1.getSecond() == time2.getSecond();
            }
            return false;
        }
        return false;
    }

    public boolean firstIsStrictlyGreaterThenSecond(Time time1, Time time2) {
        if (time1.getHour() > time2.getHour()) {
            return true;
        } else if (time1.getHour() < time2.getHour()) {
            return false;
        } else if (time1.getMinute() > time2.getMinute()) {
            return true;
        } else if (time1.getMinute() < time2.getMinute()) {
            return false;
        } else return time1.getSecond() > time2.getSecond();
    }

    public boolean firstIsStrictlyLessThenSecond(Time time1, Time time2) {
        if (time1.getHour() < time2.getHour()) {
            return true;
        } else if (time1.getHour() > time2.getHour()) {
            return false;
        } else if (time1.getMinute() < time2.getMinute()) {
            return true;
        } else if (time1.getMinute() > time2.getMinute()) {
            return false;
        } else return time1.getSecond() < time2.getSecond();
    }

    public boolean firstIsNotStrictlyGreaterThenSecond(Time time1, Time time2) {
        if (time1.getHour() > time2.getHour()) {
            return true;
        } else if (time1.getHour() < time2.getHour()) {
            return false;
        } else if (time1.getMinute() > time2.getMinute()) {
            return true;
        } else if (time1.getMinute() < time2.getMinute()) {
            return false;
        } else return time1.getSecond() >= time2.getSecond();
    }

    public boolean firstIsNotStrictlyLessThenSecond(Time time1, Time time2) {
        if (time1.getHour() < time2.getHour()) {
            return true;
        } else if (time1.getHour() > time2.getHour()) {
            return false;
        } else if (time1.getMinute() < time2.getMinute()) {
            return true;
        } else if (time1.getMinute() > time2.getMinute()) {
            return false;
        } else return time1.getSecond() <= time2.getSecond();
    }
}
