package fizz_buzz_whizz;

import java.util.stream.Stream;

public class AllOf implements Rule {
    private Rule[] rules;

    public AllOf(Rule... rules) {
        this.rules = rules;
    }

    @Override
    public boolean apply(int x, RuleResult rr) {
        RuleResult ruleResult = new RuleResult();
        return rr.append(Stream.of(rules).allMatch(t -> t.apply(x, ruleResult)),
                ruleResult);

    }
}
