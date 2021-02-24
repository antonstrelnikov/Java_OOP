package com.antonstrelnikov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = Math.min(from, to);
        this.to = Math.max(from, to);
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
        if (this.to < range.from || range.to < this.from) {
            return new Range[]{
                    new Range(this.from, this.to),
                    new Range(range.from, range.to)
            };
        }

        double from = Math.min(this.from, range.from);
        double to = Math.max(this.to, range.to);

        return new Range[]{
                new Range(from, to)
        };
    }

    public Range[] getDifference(Range subtractedRange) {
        if (to < subtractedRange.from || subtractedRange.to < from) {
            return new Range[]{
                    new Range(to, from)
            };
        }

        if (subtractedRange.from <= from && subtractedRange.to >= to) {
            return new Range[]{};
        }

        if (from < subtractedRange.from && to > subtractedRange.to) {
            return new Range[]{
                    new Range(from, subtractedRange.from),
                    new Range(subtractedRange.to, to)
            };
        }

        if (subtractedRange.from < to && subtractedRange.from > from) {
            return new Range[]{
                    new Range(from, subtractedRange.from)
            };
        }

        return new Range[]{
                new Range(subtractedRange.to, to)
        };
    }
}
