package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleFilter extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate predicate;
    private double next;

    public DoubleFilter(PrimitiveIterator.OfDouble iterator, DoublePredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            next = iterator.nextDouble();
            if (predicate.test(next)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double nextDouble() {
        return next;
    }
}
