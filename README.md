# AGoncal Fascicle: Understanding Quarkus

Code of my future Practising Quarkus Fascicle

![Travis](https://travis-ci.org/agoncal/agoncal-fascicle-quarkus.svg?branch=1.x)

Microservices is an architectural style that structures an application as a collection of distributed services.
Microservices are certainly appealing but there are many questions that should be asked prior to diving into this architectural style:
How do I deal with an unreliable network in a distributed architecture?
How do I test my services?
How do I monitor them?
How do I package and execute them?

That's when [Quarkus](https://quarkus.io/) comes into play.

In this [fascicle](https://www.amazon.com/author/agoncal), you will learn Quarkus but also its ecosystem.
You will discover Quarkus internals and how you can use it to build REST and reactive microservices, bind and process JSON or access datastores in a transactional way.
With Cloud Native and GraalVM in mind, Quarkus makes packaging and orchestrating your microservices with Docker and Kubernetes easy.

This fascicle has a good mix of theory and practical examples.
It is the companion book of [Practising Quarkus](https://github.com/agoncal/agoncal-fascicle-quarkus-pract) where you learn how to develop an entire microservice architecture.

![Quarkus](https://raw.githubusercontent.com/agoncal/agoncal-fascicle-quarkus/master/cover.jpg)

Foreword by [Emmanuel Bernard](https://twitter.com/emmanuelbernard)

> Hi there, I'm Emmanuel Bernard and co-founder of Quarkus.
I am Chief Architect at Red Hat overseeing part of the Middleware portfolio.
But at core, I'm an Open Source developer (of projects and of communities).
I have contributed to and led the Hibernate projects and many more.
Recently I have been lucky enough to be at the right place, the right time, with the right people and co-founded Quarkus.
I have been leading it since then on its mission to deliver Java for the cloud era.
<br/><br/>
I've known Antonio for a long time now.
We have watched together the various evolutions of the Java ecosystem over the years.
I trust his expertise in figuring out where technology is going and avoid the latest shiny object distraction.
So when a seasoned developer like him jumps on Quarkus, loves it and wants to invest his time on it, that is a big confirmation to me that the project is doing some things right and addressing key problems.
<br/><br/>
I'm really pleased Antonio embarked on this Quarkus book adventure.
He has a deep understanding of the developer community:
from customers to community members, from freelancer to big enterprise development teams.
I trust his ability to explain technology in a practical way and offer readers the knowledge and building blocks to solve their concrete problems.
<br/><br/>
Fun fact about Quarkus, we knew we needed to strike the balance between new + revolutionary and familiar + boring.
One key aspect of Quarkus is to offer very familiar APIs and programming concepts but packaged with boosted usefulness.
Antonio is one of the most expert people I know on the APIs and technologies Quarkus exposes:
CDI, RESTEasy, Hibernate, Eclipse MicroProfile and many more.
<br/><br/>
One of Quarkus' philosophies is Developer Joy.
It is impersonated in part by making developers deliver their applications faster, by being more practical.
But it is also built on a very solid technological foundation.
This book is written in the same philosophy, it gets you to solve the concrete problems you have while distilling the fundamental knowledge you need to go to the next level.
<br/><br/>
When we released Quarkus to the community, we thought we were onto something.
But what you think and what the world thinks are often distinct.
It's amazing how Quarkus caught fire.
More critically, I am really happy when I hear users telling me how Quarkus has addressed their key Cloud Native needs and concerns:
short development cycles, need for high density deployments (less RAM per instance), need for fast startup times - for microservices or functions.
Even better, they love the experience of using it.
<br/><br/>
The future of Java as a solution for writing Cloud Native apps deployed in Kubernetes had been questioned.
No more and I think Quarkus is the answer.
I hope this book will spread the word wide and large, help more developers and more teams be productive with Java and our new way of writing modern applications.
<br/><br/>
**Emmanuel Bernard**
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

