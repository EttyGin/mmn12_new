package q1;

public class PolElem {
    private double _coef;
    private int _exp;

    public PolElem(double coef, int exp) {
        _coef = coef;
        _exp = exp;
    }

    public double getCoef() {
        return _coef;
    }

    public void setCoef(double coef) {
        _coef = coef;
    }

    public int getExp() {
        return _exp;
    }

    public void setExp(int exp) {
        _exp = exp;
    }

    public boolean derivElem() {
        if (_exp == 0)
            return false;
        else {
            setCoef(_coef * _exp);
            setExp(_exp - 1);
            return true;
        }
    }

    public boolean equals(PolElem other) {
        return _coef == other.getCoef() && _exp == other.getExp();
    }
}