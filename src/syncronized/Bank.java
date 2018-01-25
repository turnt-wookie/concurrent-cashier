package syncronized;

import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private AtomicLong amount;

    public Bank(int amount) {
        this.amount = new AtomicLong(amount);
    }

    public double charge(double toPay) {
        double toGiveBack = toPay % 100;
        boolean haveChange = amount.get() - toGiveBack > 0;

        if (haveChange) {
            amount.addAndGet(Double.doubleToLongBits(toPay));
            return toGiveBack;
        } else {
            return -1;
        }
    }
}
