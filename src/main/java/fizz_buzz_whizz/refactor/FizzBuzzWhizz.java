package fizz_buzz_whizz.refactor;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

import static fizz_buzz_whizz.refactor.Rule.action;
import static fizz_buzz_whizz.refactor.Rule.allOf;
import static fizz_buzz_whizz.refactor.Rule.anyOf;

public final class FizzBuzzWhizz {

  public static IntFunction spec(int fizz, int buzz, int whizz) {
    Rule r1_3 = action(x -> x % fizz == 0, Results.FIZZ);
    Rule r1_5 = action( x -> x % buzz == 0, Results.BUZZ);
    Rule r1_7 = action( x -> x % whizz == 0, Results.WHIZZ);

    Rule r2 = allOf(r1_3, r1_5, r1_7);

    Rule r3 = action(x -> String.valueOf(x).contains(String.valueOf(fizz)), Results.FIZZ);

    Rule rd = action(x -> true, Results.DEFAULT);

    return anyOf(r3, r2, rd);
  }
} 