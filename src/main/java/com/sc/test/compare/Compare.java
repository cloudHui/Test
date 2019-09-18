package com.sc.test.compare;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author: cloud
 * @Date: 2019/2/18 18:03
 * @Version 1.0
 */
public class Compare implements Comparable {

    @NotNull
    @Pattern(regexp = "[1-7]{1}", message = "")
    @NotBlank
    private int type;

    private int value;

    private int color;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Compare(int type, int value, int color) {
        this.type = type;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(type).append(value).append(color).append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Compare compare = (Compare) o;
        if (compare.getType() == this.getType()) {
            if (compare.getValue() == this.getValue()) {
                return compare.getColor() - this.getColor();
            } else {
                return compare.getValue() - this.getValue();
            }
        } else {
            return compare.getType() - this.getType();
        }
    }
}
