# Yes, this is a religious debate

And I apologize for that.

I try to be agnostic about how people edit their code. It's all just ASCII, right?

Lisp really isn't.

Lisp code is almost an abstract syntax tree. Or maybe an orchard. I'm a firm
believer in keeping all the pieces short enough that it's more like a shrubbery.

I guess there's an argument to be made that this leads to labyrinths, but
Real Programmers can write FORTRAN in any language.

## Density

Lisp code is, by its very nature, extremely dense. That's what makes it so powerful.

Most programming languages (by comparison) have lots and lots of boiler
plate. I know that I've gotten used to skimming through a dozen or so functions
that basically look identical, picking out the pieces that make them different,
and then figuring out why one isn't working from there.

That's the wrong way to do things, in general. Most of the point is abstracting
away all the parts that are the same so we can get down to the kernel that actually
matters.

That sort of thing is tough to do in, say, C or C# or Java.

It gets easier in a language like python. I've spent a lot of time over the past
few years stripping boiler plate away from python code.

I've made a lot of people really mad by doing so. I'm not going to speculate
why.

The problem is that really dense code is hard to read.

## Readability

Python is near and dear to my heart. It could have been designed from the ground
up to be a beginner-friendly language that has a lot of features that are specifically
designed to force programmers to write code that future programmers will be able
to comprehend.

Lisp, in general, has lots of really good features. I think clojure adds a lot of
others. Readable code wasn't particularly on the agenda.

It's not like the code always looks like line noise, like you get when you're
dealing with, say, perl or scala, or APL. But you *can* name your variables
pretty much anything you like. [%->? would probably be legal.

More importantly, let's just deal with it: OMG! The parantheses are in the
wrong place!!!

To me, this complaint is almost like the one I've heard over the years about
python's significant white space. Almost.

Regular syntax is a *feature*.

## History

The guy who invented/discovered lisp planned on giving it a syntax that was
more in line with "standard" programming languages of the time.

Like, say, FORTRAN.

No one who was actually *using* the language thought this was a good idea.

All I can really say is "Give it a chance."

It's different.

Larry Wall's the only person I've run across who tried lisp and hated
it.

And, well...perl.

## Do I Have a Point?

Use an editor that understands lisp.

The computer doesn't care about white space, but people do.

If you try to use something like notepad or nano, you *will* be
absolutely miserable. So will the rest of us.

There are rules and standards that have been in place for 40 or 50
years now. I don't know what they are, but I recognize when
they're being violated.

Pretty much always because I've screwed up and put a paranthesis
in the wrong spot.

## That Never Happens!

Unless I've screwed things up by copy/pasting some block of code
that has mis-matched brackets.

At least 99% of the time, I use this thing called paredit that keeps
me from screwing things up.

It does weird things that you probably don't expect at first. You type
the character \( and it automatically adds the closing \). If you
type the closing \), it doesn't insert one: it just forwards you past
the next one.

It's horribly frustrating until you get used to it. And then you wonder
how you ever managed without it.

I've seen some pretty vicious flame wars (well, as vicious as clojure
flame wars ever get...it's a pretty accepting community) about this
topic. The people who actually develop software love paredit passionately.

The people who don't like it are almost always the ones who have to teach
newbies why their text editor doesn't act the same as their word processor.

## Clojure is Not a Newbie Language

For decades, MIT taught Scheme in their introductory programming
courses. I've read that they've switched to python now.

There are 2 or 3 members of the clojure community who are
professors trying to teach clojure in freshman programming classes.

I think they're out of their minds.

I had to spend years programming in C++ to realize that I can get
more done in python. It took me years more to realize that I can
get more done in lisp. And then it took me several years of dabbling
in common lisp to realize that clojure hits a really sweet spot
between common lisp's "all things for everyone" and scheme's
"beautiful diamond that only works for teaching" approaches.

You almost have to spend years learning why all programming languages
suck to appreciate something like clojure.

## Anyway...

Use an editor that understands the syntax. Trying to edit clojure
code in Visual Studio is just an exercise in futility.

Somewhere in the past year or so, I so a troll on the mailing list
that proclaimed Sublime 2 as The One True Way to editing
clojure code.

Most places, that have provoked a flame war.

The clojure community's different.

The guy who maintains the Eclipse plugin humbly asked if the
troll had any suggestions about what his plugin is missing.
(Apparently, it's pretty darn good).

Everyone else just laughed. They've found editors that work well
for them, and they don't care what anyone else uses.

### So What Am I Saying?

Right now (and probably for the foreseeable future), the
state-of-the-art editor is emacs. It has decades of lisp
support. Most of the movers/shakers in the clojure
community use it. Guys around town look at alternatives, but
they just never work as well.

I know: emacs is scary. I fought against it for years.
http://www.braveclojure.com/basic-emacs/ is a pretty
decent intro, though it's more of a "this is how I do
it" than "here's why it's awesome."

And I *totally* understand why you need some convincing
arguments before investing time into learning something
as arcane as emacs. I fought against it passionately.

These days, there *are* viable alternatives. Reportedly.

The eclipse plugin probably gets almost as much love. I've
been told that its latest release has something that resembles
a usable debugger (which is a game-changer).

Intellij from cursiveclojure.com has a lot of adherents.

Lighttable is worth looking at...I think it probably shows
what the IDE will look like in 10 years.

I've been told that vim support is surprisingly good.

And then there's sublime. Which, reportedly, isn't
horrible.

I don't have any experience with any of these except
emacs. I've dabbled with lighttable (mainly for client-side
web browser stuff, which is pretty jaw-dropping), and
I've tried to get eclipse working. But I don't have enough
experience with anything else to have an opinion.

## Why Does It Matter?

Well, in most programming languages, it wouldn't. It's all
just ASCII. Or maybe UTF-8.

But lisp is about tying into the REPL. It's probably a bigger
deal for clojure than other lisps, because a clojure
environment has a long startup time.

Lisp environments are, in general, supposed to start
once, then run for years. You just modify them on the
fly when it comes to bugs/new features.

If you try to do clojure development the same way you
do "standard" programming, you'll wind up spending even more
time twiddling your thumbs waiting for the environment
to run so you can see what happened with your latest
change.

We don't have time for that.

Whichever editor you choose, it needs to have solid integration
with the REPL. This was the entire point behind
lighttable. Emacs probably has the best support. Everything
else falls into the "it's almost as good" category.

With the bonus that it isn't emacs, of course.

# Workflow Reloaded

Stuart Sierra gave a talk a couple of years back that
centered around the idea that it takes *forever* for
a clojure program to start from scratch.

He gave another one at a conference early this year that
clarified a lot of those ideas and talked about how to
make this work well.

The short version of this whole thing is that you really
need to be able to start a REPL that's connected to your
editor, run `(reset)` and start interacting with the
system you just started/changed.

That basic idea's huge. It starts with an editor that
can connect to your programming environment.

(This is sort-of what Visual Studio does, but that's like saying
that a zebra is sort-of like a horse).






