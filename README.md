Welcome to physics-framework!

The main proposes of this framework are:
* Facilitate a bit the use of [Jbox2d](http://code.google.com/p/jbox2d/)(and other physics engines).
* Make the simulations **independent** from the physics engine and the visualization mode (so you can compare several without modifying your simulation at all)

> ###I don't want to read more!!! **Show me pictures**!!

Ok, ok :)
Just execute physics-example/../_ShapeJboxSimulation.java_:

![Shape Execution](https://raw.github.com/adarrivi/jbox2d-adapter/master/wiki/images/shapeExecution.PNG)

Or physics-example/../_ShapeAndCandyJboxSimulation.java_:

![Shape and Candy execution](https://raw.github.com/adarrivi/jbox2d-adapter/master/wiki/images/shapeAndCandyExecution.PNG)


To archive this, and inspired by the way [SLF4J](http://www.slf4j.org/)is designed (one abstract implementation and multiple _real ones_), a layer has been created between the possible simulations (examples) and the view/physics engines:

![General Architecture](https://raw.github.com/adarrivi/jbox2d-adapter/master/wiki/images/generalArchitecture.PNG)

### physics-framework
The main framework. It contains elements like _Circle, Rectangle, Position,_ etc... It also holds the two main adapter interfaces: _PhysicsAdapter.java_ and _ViewAdapter.java_

This module also includes a small utility to execute _Runnable_ commands at a given hertz rate, but not **faster**!. Very useful for execute the simulation steps/ refresh the graphics. See _SteadyExecutor.java_

### physicsf-view-swing
This is a simple adapter for use the framework with _Java Swing_. It draws in the panel the different elements' shapes.
If offers a sample JPanel, _SandboxPanel.java_, where draw the simulation elements.
Also uses the [Decorator Pattern](http://en.wikipedia.org/wiki/Decorator_pattern) to define the way each element is rendered (see _ViewPositionalElementDecorator.java, ViewCircle, etc..._).

### physicsf-physics-jbox2d
The [Jbox2d](http://code.google.com/p/jbox2d/) library adapter. As above, it uses extensively the [Decorator Pattern](http://en.wikipedia.org/wiki/Decorator_pattern) to let the own components create by themselves.

### physicsf-example
Two examples:
* The easy one, with both jbox2d and swing adapters (see screenshot above).
* The complex one, with the same than above, but a the shapes are also drawn with images at the same time.


## TODO
Well, there are a lot of things TODO :(

The intention of the framework was to play with Jbox2d and the Adaptor concepts. But as a framework to be **exposed to 3rd parties**, some other things are necessary:
* Javadoc the exposed functions.
* Failproof the API.
* 100% Test coverage.
* More features like collisions, polygons, etc...

I hope you enjoy it!
