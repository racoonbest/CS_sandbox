# CS_sandbox

Small Java practice exercises:

- `Exercise06_06`: print a right-aligned descending-number pattern.
- `Exercise06_10`: count primes below 10,000 and twin-prime pairs through a limit.

Compile and run the regression checks with a JDK:

```sh
mkdir -p build
javac -d build Exercise06_06.java Exercise06_10.java ExerciseTests.java
java -cp build ExerciseTests
```

Checks cover integer boundaries, prime squares, known prime counts, inclusive
twin-prime limits, and printed pattern spacing. The primality check stops at
the square root using division to avoid integer multiplication overflow.
