# Magic

One of the really important pieces to clojure is that it is a dialect of lisp.

Which makes it a really hard sell.

One of my co-workers has decided he hates it because it's built on the JVM. I
really hope that's because he (completely justifiably) hate Java, the language.

I hope I can convince him that his hatred is totally misplaced.

Hating lisp because the parantheses are in the wrong place is one thing. That's
as understandable as hating python because whitespace is significant.

There are plenty of reasons to hate any language you happen to run across.
One way or another, they all suck. It's not even the Sturgeon's Law sort of
thing, where 90% of everything is crap.

Or maybe it is. Maybe it's a matter of picking a language where the 10% that
isn't crap doesn't interfere too much in what you're trying to do.

With lisp, the "secret sauce" is that, really, you're writing the
programming language that addresses your particular problems.

# Examples

There's a reason I called this page magic. Some of the stuff you can do
just feels that way. The main point is that these things are mostly
possible because of macros. Which are only possible because of the "OMG!
The parantheses are in the wrong place!" thing that's probably still
spinning through your head if you're the sort of person who's still reading
this.

## core.async

I'm torn between linking to David Nolen's blog posts and the basic examples
that show how it works. I'm told that Tim Baldridge's videos about this
"library" are really inspiring. I won't link to them until I've had some
time to actually watch them myself.

BTW, those two names are very much worth keeping your eye on: if they're
involved, there's probably some magic going on.

The basic idea here is pretty much the same as the entire premise behind
the Go programming language.

Except that this is just an add-on afterthought that anybody could have
written (if they were smart enough...I don't want to begin to imagine
what it took to make javascript look multi-threaded).

## ring

https://github.com/mmcgrana/ring/wiki/Concepts

TODO: Write this

## clojure script

This isn't a library as much as a total game-changer. Well, along
with core.async.

Standard clojure compiles down to java bytecode. Clojure script is along
the same lines as coffeescript, in that it compiles down to javascript and
is designed to run in the browser.

The killer piece of this is that it lets you write javascript programs
as if they were multi-threaded in a language where multi-threading
doesn't make your brain explode.

Why would you want to do such a thing?

I haven't spent much time in javascript. Just enough to feel confident
saying that the language, in general, sucks (there's an important reason
why "Javascript: The Good Parts" has sold so well and is so valuable)
and that writing callback handlers is especially painful.

## ribol

Exception handling that makes sense. TODO: paste in the link for the basic
tutorial.

The basic idea here is earth-shattering. Anything that has an "issue"
notifies its callers that there's been a problem. The idea is very
similar to flagging a defective product that you've spotted on the
assembly line and asking management what you should do about it.

## om

Built on Facebook's react framework. Which is amazing in and of itself.

There are basically two versions of this wrapper. I recently ran
across an exchange between om's author and reagent's. The summary seems
to be "Honestly, I'm just trying to pretend that you haven't made
the past 6 months of my life meaningless. Your approach is one of
those game-changers that shows up *maybe* once a decade."

The "main" clojure company, named Cognitect, released a preliminary
version of a really exciting javascript UI library (pedestal/pedestal
on github). It was a major part of their company roadmap.

Then this one guy (who happens to be the main driver
behind clojurescript) released om, and they decided their approach
was a complete waste of time. So they scrapped it.

AngularJS is all the rage these days. Personally, I think
it's ridiculously over-complicated. But it obviously still has
all the hype that jquery used to get.

React is sort of facebook's non-answer to it. It sort of takes a
"you're totally approaching this wrong" stance. Although that
isn't really true...I'm sure that angular must solve a bunch of
problems that react doesn't address.

TODO: Write up more about this

http://roninhacker.wordpress.com/2014/03/29/how-to-build-stuff-with-om/
http://github.com/sgrove/omchaya

## On Lisp

## datomic

## reduce

