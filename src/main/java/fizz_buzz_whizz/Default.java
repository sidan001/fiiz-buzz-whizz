package fizz_buzz_whizz;

public class Default implements Rule{
    @Override
    public boolean apply(int x, RuleResult rr) {
        return rr.append(true, String.valueOf(x));
    }
}
