package fizz_buzz_whizz.refactor;



import fizz_buzz_whizz.RuleResult;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Rule extends IntFunction<String>{

    static Rule action(IntPredicate predicate, Rule rule) {
        return x -> {
            return predicate.test(x) ? rule.apply(x) : "";
        };
    }


    static Rule allOf(Rule... rules){
        return x -> Stream.of(rules)
                .map(r -> r.apply(x))
                .collect(Collectors.joining()) ;
    }


    static Rule anyOf(Rule... rules){
        return x ->Stream.of(rules)
                .map(r -> r.apply(x))
                .filter(s -> !s.isEmpty())
                .findFirst()
                .orElse("");
    }

}
