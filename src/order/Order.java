package order;

import java.math.BigDecimal;

public record Order(int number, double price, BigDecimal discount, double finalPrice) {

    public Order(int number, double price, BigDecimal discount) {
        this(number, price, discount, BigDecimal.valueOf(price)
                .multiply(BigDecimal.ONE.subtract(discount)).doubleValue());
    }


}

