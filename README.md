# AGoncal Fascicle: Understanding Quarkus

Code of my [Understanding Quarkus Fascicle](https://agoncal.teachable.com/p/ebook-understanding-quarkus)

![Travis](https://travis-ci.org/agoncal/agoncal-fascicle-quarkus.svg?branch=1.x)

Microservices is an architectural style that structures an application as a collection of distributed services.
Microservices are certainly appealing but there are many questions that should be asked prior to diving into this architectural style:
How do I deal with an unreliable network in a distributed architecture?
How do I test my services?
How do I monitor them?
How do I package and execute them?

That's when [Quarkus](https://quarkus.io) comes into play.

In this [fascicle](https://agoncal.teachable.com), you will learn Quarkus but also its ecosystem.
You will discover Quarkus internals and how you can use it to build REST and reactive microservices, bind and process JSON or access datastores in a transactional way.
With Cloud Native and GraalVM in mind, Quarkus makes packaging and orchestrating your microservices with Docker and Kubernetes easy.

This fascicle has a good mix of theory and practical examples.
It is the companion book of [Practising Quarkus](https://agoncal.teachable.com/p/ebook-practising-quarkus) where you learn how to develop an entire microservice architecture.

[![Understanding Quarkus](https://raw.githubusercontent.com/agoncal/agoncal-fascicle-quarkus/master/cover.jpg)](https://agoncal.teachable.com/p/ebook-understanding-quarkus)

Foreword by [Emmanuel Bernard](https://twitter.com/emmanuelbernard)

> Hi there, I'm Emmanuel Bernard, co-founder of Quarkus.
I am Chief Architect at Red Hat overseeing part of the Middleware portfolio.
But, at heart, I'm an Open Source developer (of projects and communities).
I contributed to, and led, the Hibernate projects as well as many others.
Recently, I was lucky enough to be in the right place at the right time with the right people in order to co-found Quarkus.
Since then, I have been leading it since then on its mission to deliver Java for the cloud era.
<br/><br/>
I've known Antonio for a long time now.
We have watched the various evolutions of the Java ecosystem together over the years.
I trust his expertise in figuring out where technology is going and avoiding the latest shiny object distraction.
So when a seasoned developer like him jumps on Quarkus, loves it and wants to invest his time in it, that, to me is a ringing endorsement that the project is doing something right and addressing key problems.
<br/><br/>
I'm really pleased Antonio embarked on this Quarkus book adventure.
He has a deep understanding of the developer community:
from customers to community members, from freelancers to big enterprise development teams.
I trust his ability to explain technology in a practical way and he offers readers the knowledge and building blocks to solve their problems.
<br/><br/>
Fun fact about Quarkus:
we knew we needed to strike a balance between "_new + revolutionary_" and "_familiar + boring_".
One key aspect of Quarkus is how it offers very familiar APIs and programming concepts but it's packaged with boosted usefulness.
Antonio is one of the most expert people I know on the APIs and technologies Quarkus exposes:
CDI, RESTEasy, Hibernate, Eclipse MicroProfile and many more.
<br/><br/>
One of Quarkus' philosophies is "_Developer Joy_".
This is realised, in part, by making developers deliver their applications faster, by being more practical.
But it is also built on a very solid technological foundation.
This book is written with the same philosophy, it gets you to solve the concrete problems you have while distilling the fundamental knowledge you need to go to the next level.
<br/><br/>
When we released Quarkus to the community, we thought we were onto something.
But what you think and what the world thinks are often distinctly different.
It's amazing how Quarkus caught fire.
More importantly, I am really happy when I hear users telling me how Quarkus has addressed their key Cloud Native needs and concerns:
short development cycles, the need for high density deployments (less RAM per instance), and the need for fast startup times - for microservices or functions.
Even better, they love the experience of using it.
<br/><br/>
The future of Java as a solution for writing Cloud Native applications deployed in Kubernetes had been questioned.
This is no longer the case and I think Quarkus is the answer.
I hope this book will spread the word far and wide and help more developers and more teams be productive with Java and our new way of writing modern applications.
<br/><br/>
**Emmanuel Bernard** <br/>
_Co-founder of Quarkus at Red Hat_ <br/>
[@emmanuelbernard](https://twitter.com/emmanuelbernard)

And thanks to my proof-reader team:

* [Georgios Andrianakis](https://twitter.com/geoand86)
* [Roberto Cortez](https://twitter.com/radcortez)
* [Stéphane Épardaud](https://twitter.com/unfromage)
* [George Gastaldi](https://twitter.com/gegastaldi)
* [Youness Teimouri](https://twitter.com/clementplop)
* [Nicolas Martignole](https://twitter.com/nmartignole)

## Testing

`mvn clean test`

Running tests in paralell

`mvn -T 1C clean test`

## References

* [agoncal fascicles](https://www.amazon.com/author/agoncal)
