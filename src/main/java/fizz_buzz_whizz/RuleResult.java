package fizz_buzz_whizz;


public class RuleResult {

    private StringBuffer buffer =new StringBuffer();

    @Override
    public String toString() {
        return buffer.toString();
    }

    public boolean append(boolean matched, String s) {
        if (matched) buffer.append(s);
        return matched;
    }

    public boolean append(boolean matched, RuleResult rr) {
        return append(matched, rr.toString());
    }
}
