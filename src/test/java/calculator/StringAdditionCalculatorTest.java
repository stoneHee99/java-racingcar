package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAdditionCalculatorTest {

    @DisplayName("쉼표를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withComma() {
        assertThat(StringAdditionCalculator.calculate("1,2")).isEqualTo(3);
    }

    @DisplayName("콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withColon() {
        assertThat(StringAdditionCalculator.calculate("2:5")).isEqualTo(7);
    }

    @DisplayName("콜론과 쉼표를 모두 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withCommaAndColon() {
        assertThat(StringAdditionCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @DisplayName("빈 문자열이나 null이 입력된 경우 0을 반환하는지")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateTest_whenNullOrEmptyString(String input) {
       assertThat(StringAdditionCalculator.calculate(input)).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withCustomDelimiter() {
        assertThat(StringAdditionCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException을 반환하는지")
    @ParameterizedTest
    @ValueSource(strings = {"1,-2,3", "안,녕,하,세,요"})
    void calculateTest_withNonNumericValue_OrNegativeValue(String input) {
        assertThatThrownBy(() -> StringAdditionCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }
}
