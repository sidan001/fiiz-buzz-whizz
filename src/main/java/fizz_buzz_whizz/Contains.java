package fizz_buzz_whizz;

public class Contains implements Rule{

    private final int n;
    private final String result;

    public Contains(int n, String result) {
        this.n = n;
        this.result = result;
    }
    @Override
    public boolean apply(int x, RuleResult rr) {
        return rr.append(String.valueOf(x).contains(String.valueOf(n)),result);
    }
}
