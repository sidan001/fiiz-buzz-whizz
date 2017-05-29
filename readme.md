#形式化
`FizzBuzzWhizz`详细描述请自行查阅相关资料。此处以`3`, `5`, `7`为例，形式化地描述一下问题。

```
r1
- times(3) -> Fizz
- times(5) -> Buzz
- times(7) -> Whizz
r2
- times(3) && times(5) && times(7) -> FizzBuzzWhizz
- times(3) && times(5) -> FizzBuzz
- times(3) && times(7) -> FizzWhizz
- times(5) && times(7) -> BuzzWhizz
r3
- contains(3) -> Fizz
- the priority of contains(3) is highest
rd
- others -> others
```