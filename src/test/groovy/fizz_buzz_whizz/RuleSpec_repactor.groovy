package fizz_buzz_whizz

import fizz_buzz_whizz.refactor.FizzBuzzWhizz
import spock.lang.Specification

class RuleSpec_repactor extends Specification {


    def "fizz buzz whizz"() {
        expect:
        FizzBuzzWhizz.spec(3,5,7).apply(n) == expect

        where:
        n               |    expect
        3               |   "Fizz"
        5               |   "Buzz"
        7               |   "Whizz"
        3*5             |   "FizzBuzz"
        3*7             |   "FizzWhizz"
        5*7*2           |   "BuzzWhizz"
        3*5*7           |   "FizzBuzzWhizz"
        5*7     /*35*/  |   "Fizz"
        2               |   "2"
    }

}
