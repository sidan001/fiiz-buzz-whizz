package fizz_buzz_whizz;


import java.util.stream.Stream;

public class AnyOf implements Rule{
    private Rule[] rules;

    public AnyOf(Rule... rules) {
        this.rules = rules;
    }
    @Override
    public boolean apply(int x, RuleResult rr) {
        return  Stream.of(rules)
                           .anyMatch(t-> t.apply(x,rr));

    }
}
