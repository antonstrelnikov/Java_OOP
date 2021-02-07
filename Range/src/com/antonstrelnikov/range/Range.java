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

    public Range getIntersection(Range range1, Range range2) {
        double from = Math.max(range1.from, range2.from);
        double to = Math.min(range1.to, range2.to);

        if (from < to) {
            return new Range(from, to);
        }

        return null;
    }

    public Range[] getUnion(Range range1, Range range2) {
        if (!range1.isInside(range2.from) && !range2.isInside(range1.from)) {
            return new Range[]{range1, range2};
        }

        double from = Math.min(range1.from, range2.from);
        double to = Math.max(range1.to, range2.to);

        return new Range[]{
                new Range(from, to)
        };
    }

    public Range[] getDifference(Range decreasingRange, Range subtractedRange) {
        if (!decreasingRange.isInside(subtractedRange.from) && !subtractedRange.isInside(decreasingRange.from)) {
            return new Range[]{decreasingRange};
        } else if (subtractedRange.isInside(decreasingRange.from) && subtractedRange.isInside(decreasingRange.to)) {
            return null;
        } else if (decreasingRange.isInside(subtractedRange.from) && decreasingRange.isInside(subtractedRange.to)) {
            return new Range[]{
                    new Range(decreasingRange.from, subtractedRange.from),
                    new Range(subtractedRange.to, decreasingRange.to)
            };

        } else if (decreasingRange.isInside(subtractedRange.from)) {
            return new Range[]{
                    new Range(decreasingRange.from, subtractedRange.from)
            };
        }

        return new Range[]{
                new Range(subtractedRange.to, decreasingRange.to)
        };
    }
}
