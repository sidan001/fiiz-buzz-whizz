package fizz_buzz_whizz

import spock.lang.Specification


class RuleSpec extends Specification {
    def "times(3) -> Fizz"() {
        when:
        Rule rule = new Times(3, "Fizz")
        RuleResult rr = new RuleResult()
        then:
        rule.apply(3 * 2, rr) == true
        rr.toString() == "Fizz"
    }

    def "contains(3) -> Fizz"() {
        when:
        Rule rule = new Contains(3, "Fizz")
        RuleResult rr = new RuleResult()
        then:
        rule.apply(13, rr) == true
        rr.toString() == "Fizz"
    }

    def "default rule "() {
        when:
        Rule rule = new Default()
        RuleResult rr = new RuleResult()
        then:
        rule.apply(2, rr) == true
        rr.toString() == "2"
    }

    def "times(3) -> Fizz } || tiems(5) -> Buzz || tiems(7) -> Whizz"() {
        when:
        Rule rule = new AnyOf(
                new Times(3, "Fizz"),
                new Times(5, "Buzz"),
                new Times(7, "Whizz")
        )
        RuleResult rr = new RuleResult()
        then:
        rule.apply(7 * 2, rr) == true
        rr.toString() == "Whizz"
    }

    def "times(3) -> Fizz && tiems(5) -> Buzz && tiems(7) -> Whizz"() {
        when:
        Rule rule = new AllOf(
                new Times(3, "Fizz"),
                new Times(5, "Buzz"),
                new Times(7, "Whizz")
        )
        RuleResult rr = new RuleResult()
        then:
        rule.apply(3 * 5 * 7, rr) == true
        rr.toString() == "FizzBuzzWhizz"
    }


    def "fizz buzz whizz"() {
        when:
        Rule r1_3 = new Times(3, "Fizz")
        Rule r1_5 = new Times(5, "Buzz")
        Rule r1_7 = new Times(7, "Whizz")

        Rule r1 = new AnyOf(r1_3, r1_5, r1_7);

        Rule r2 = new AnyOf(
                new AllOf(r1_3, r1_5, r1_7),
                new AllOf(r1_3, r1_5),
                new AllOf(r1_3, r1_7),
                new AllOf(r1_5, r1_7)
        );

        Rule r3 = new Contains(3, "Fizz")

        Rule rd = new Default()

        Rule rule = new AnyOf(r3, r2, r1, rd)


        then:
        RuleResult rr = new RuleResult()
        rule.apply(n, rr) == true
        rr.toString() == expect

        where:
        n               |    expect
        3               |   "Fizz"
        5               |   "Buzz"
        7               |   "Whizz"
        3*5             |   "FizzBuzz"
        3*7             |   "FizzWhizz"
        5*7   /*35*/    |   "Fizz"
        5*7*2           |   "BuzzWhizz"
        3*5*7           |   "FizzBuzzWhizz"
        2               |   "2"
    }

}
