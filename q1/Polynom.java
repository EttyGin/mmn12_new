package q1;

import java.util.Collections;
import java.util.Comparator;
import static java.lang.Math.*;
import java.util.ArrayList;

public class Polynom {
    private ArrayList<PolElem> _poly = new ArrayList<>();

    public Polynom(double[] ceofs, int[] exps) throws Exception {
        if (exps.length != ceofs.length)
            throw new Exception("Error!! the arrays are not in the same length");
        else {
            for (int i = 0; i < exps.length; i++) {
                if (ceofs[i] != 0)
                    _poly.add(new PolElem(ceofs[i], exps[i]));
            }
            /* sort(_poly); */
            Collections.sort(_poly, Comparator.comparing(PolElem::getExp));
        }
    }

    public Polynom(ArrayList<PolElem> pol) {
        _poly = new ArrayList<>();
        for (int i = 0; i < pol.size(); i++) {
            _poly.add(new PolElem(pol.get(i).getCoef(), pol.get(i).getExp()));
        }
    }

    public ArrayList<PolElem> getPoly() {
        return _poly;
    }

    public Polynom plus(Polynom p) throws Exception {
        int lenP = p._poly.size(), lenThis = _poly.size();
        int[] newExps = new int[lenP + lenThis];
        double[] newCeofs = new double[lenP + lenThis];
        int indP = 0, indThis = 0, expP = 0, expThis = 0;

        for (int i = 0; (indP < lenP || indThis < lenThis) && i < newExps.length; i++) {
            if (indP < lenP)
                expP = p._poly.get(indP).getExp();
            if (indThis < lenThis)
                expThis = _poly.get(indThis).getExp();

            if (indP < lenP && (expP < expThis || indThis == lenThis)) {// להכניס את ערכי הפרמטר
                newExps[i] = expP;
                newCeofs[i] = p._poly.get(indP).getCoef();
                indP++;
            } else {
                if (indP < lenP && indThis < lenThis) {// להכניס את הצירוף של הערכים
                    newExps[i] = expThis;
                    newCeofs[i] = _poly.get(indThis).getCoef() + p._poly.get(indP).getCoef();
                    indThis++;
                    indP++;
                }

                else if (indThis < lenThis && (expP > expThis || expP == lenP)) {// להכניס את ערכי הפולינום הנוכחי
                    newExps[i] = expThis;
                    newCeofs[i] = _poly.get(indThis).getCoef();
                    indThis++;
                }
            }
        }
        return new Polynom(newCeofs, newExps);
    }

    public Polynom minus(Polynom p) throws Exception {
        int lenP = p._poly.size(), lenThis = _poly.size();
        int[] newExps = new int[lenP + lenThis];
        double[] newCeofs = new double[lenP + lenThis];
        int indP = 0, indThis = 0, expP = 0, expThis = 0;

        for (int i = 0; (indP < lenP || indThis < lenThis) && i < newExps.length; i++) {
            if (indP < lenP)
                expP = p._poly.get(indP).getExp();
            if (indThis < lenThis)
                expThis = _poly.get(indThis).getExp();

            if (indP < lenP && (expP < expThis || indThis == lenThis)) {// להכניס את ערכי הפרמטר
                newExps[i] = expP;
                newCeofs[i] = -1 * p._poly.get(indP).getCoef();
                indP++;
            } else {
                if (indP < lenP && indThis < lenThis) {// להכניס את הצירוף של הערכים
                    newExps[i] = expThis;
                    newCeofs[i] = _poly.get(indThis).getCoef() - p._poly.get(indP).getCoef();
                    indThis++;
                    indP++;
                }

                else if (indThis < lenThis && (expP > expThis || expP == lenP)) {// להכניס את ערכי הפולינום הנוכחי
                    newExps[i] = expThis;
                    newCeofs[i] = _poly.get(indThis).getCoef();
                    indThis++;
                }
            }
        }
        return new Polynom(newCeofs, newExps);
    }

    public Polynom derivative() {
        Polynom newPol = new Polynom(_poly);
        int i = 0;
        while (i < newPol._poly.size()) {
            if (!newPol._poly.get(i).derivElem())
                newPol._poly.remove(i);
            else
                i++;
        }
        return newPol;
    }

    public String toString() {
        String res = "";
        int i = 0, crtEx = 0;
        double crtCo = 0;
        String sign = "", coefToPrint, expToPrint;
        while (i < _poly.size()) {
            crtCo = _poly.get(i).getCoef();
            crtEx = _poly.get(i).getExp();
            sign = (crtCo > 0) ? "+" : (crtCo == -1) ? "-" : "";
            coefToPrint = (abs(crtCo) != 1) ? "" + crtCo : "";
            expToPrint = (abs(crtEx) > 1) ? "x^" + crtEx : ((crtEx == 0) ? (coefToPrint.equals("") ? "1" : "") : "x");
            res = sign + coefToPrint + expToPrint + res;
            i++;
        }
        if (res.length() == 0)
            return "";
        return (res.charAt(0) == '+') ? res.substring(1) : res;// להוריד את הפלוס הראשון.
    }

    public boolean equals(Polynom other) {
        if (_poly.size() != other.getPoly().size())
            return false;
        int length = _poly.size();
        for (int i = 0; i < length; i++)
            if (!_poly.get(i).equals(other._poly.get(i)))
                return false;
        return true;
    }
}
