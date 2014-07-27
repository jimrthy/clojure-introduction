# Clojure Motivations

Basically, this guy named Rich Hickey got sick of trying to write
complex software (his career spanned things like scheduling systems, database
design, exit poll trackers, and lots of audio things) with languages that
encourage adding more complexity.

The community is very big on the distinction between inherent complexity (which
comes from the problem you're trying to solve) and incidental complexity (which
comes from things like poor language design, poor app design, cutting corners,
needless optimizations, choosing the wrong tools for a job (because they happen
to be the ones we're most familiar with), etc. "Into the Tarpit" is a paper
about this that had a lot of influence on the core language design.

## Core Values

A year or so back, I had lunch with one of the core contributors. He mentioned
that all programming languages (like any other tool) are optimized for some use
case. PHP was optimized to be dead simple for non-programmers to slap together
interactive web sites. Perl is optimized for string processing. Python has been
optimized to be dead simple to read and easy to understand.

Clojure was carefully designed to optimize its stability in production.

It's also super-productive and has an incredibly quick developer feedbak loop.
Once you get it, it basically just stays out of your way and lets you focus on
getting work done.


TODO: write [great documentation](http://jacobian.org/writing/great-documentation/what-to-write/)
