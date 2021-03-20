package com.antonstrelnikov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);

        if (from < to) {
            return new Range(from, to);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || range.to < from) {
            return new Range[]{
                    new Range(from, to),
                    new Range(range.from, range.to)
            };
        }

        return new Range[]{
                new Range(Math.min(from, range.from), Math.max(to, range.to))
        };
    }

    public Range[] getDifference(Range range) {
        if (to <= range.from || range.to <= from) {
            return new Range[]{new Range(to, from)};
        }

        if (range.from <= from && range.to >= to) {
            return new Range[]{};
        }

        if (from < range.from && to > range.to) {
            return new Range[]{
                    new Range(from, range.from),
                    new Range(range.to, to)
            };
        }

        return new Range[]{new Range(from, range.from)};
    }

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }
}
