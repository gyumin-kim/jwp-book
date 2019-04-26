package com.jwpbook.chapter02.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void add_null값_혹은_빈_문자열() {
        assertThat(calculator.add(null)).isEqualTo(0);
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    public void add_숫자_하나() {
        assertThat(calculator.add("3")).isEqualTo(3);
    }

    @Test
    public void add_쉼표로_구분() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_혹은_콜론_구분() {
        assertThat(calculator.add("1,2:4")).isEqualTo(7);
    }

    @Test
    public void add_custom_구분() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
        assertThat(calculator.add("//]\n1]2]3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void add_negetive() {
        calculator.add("-1,2,3");
    }
}