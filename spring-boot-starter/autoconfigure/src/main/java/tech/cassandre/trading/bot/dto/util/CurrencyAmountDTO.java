package tech.cassandre.trading.bot.dto.util;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import tech.cassandre.trading.bot.util.java.EqualsBuilder;
import tech.cassandre.trading.bot.util.test.ExcludeFromCoverageGeneratedReport;

import java.math.BigDecimal;

import static tech.cassandre.trading.bot.dto.util.CurrencyDTO.BTC;

/**
 * Currency amount (amount value and currency).
 */
@Value
@Builder
@SuppressWarnings("checkstyle:VisibilityModifier")
public class CurrencyAmountDTO {

    /** Zero. */
    public static final CurrencyAmountDTO ZERO = CurrencyAmountDTO.builder()
            .value(BigDecimal.ZERO)
            .currency(BTC)
            .build();

    /** Amount value. */
    BigDecimal value;

    /** Currency. */
    CurrencyDTO currency;

    /**
     * Constructor.
     *
     * @param newValue    amount value
     * @param newCurrency amount currency
     */
    public CurrencyAmountDTO(@NonNull final String newValue,
                             @NonNull final CurrencyDTO newCurrency) {
        this.value = new BigDecimal(newValue);
        this.currency = newCurrency;
    }

    /**
     * Constructor.
     *
     * @param newValue    amount value
     * @param newCurrency amount currency
     */
    public CurrencyAmountDTO(@NonNull final BigDecimal newValue,
                             @NonNull final CurrencyDTO newCurrency) {
        this.value = newValue;
        this.currency = newCurrency;
    }

    @Override
    @ExcludeFromCoverageGeneratedReport
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CurrencyAmountDTO that = (CurrencyAmountDTO) o;
        return new EqualsBuilder()
                .append(this.value, that.value)
                .append(this.currency, that.currency)
                .isEquals();
    }

    @Override
    @ExcludeFromCoverageGeneratedReport
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(value)
                .append(currency)
                .toHashCode();
    }

    @Override
    public final String toString() {
        return value.stripTrailingZeros().toPlainString() + " " + currency;
    }

}
