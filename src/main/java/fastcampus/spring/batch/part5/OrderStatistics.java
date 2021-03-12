package fastcampus.spring.batch.part5;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderStatistics {

    private String amount;

    private LocalDate date;

    @Builder
    private OrderStatistics(String amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }
}
