package fizz_buzz_whizz;


public class Times implements Rule{
    private final int n;
    private final String result;

    public Times(int n, String result) {
        this.n = n;
        this.result = result;
    }
    @Override
    public boolean apply(int x,RuleResult rr) {
        return rr.append(x % n == 0,result);
    }
}
