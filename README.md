# SOFA
## Introduction

SOFA (Scripted Offline Fighting Arena) is a simulation and implementation of a programming language name SOFAScript. SOFAScript is a language designed to control the AI of the SOFA simulation. So in a sense it is a game for developers. The simulation is a battle between two teams, each with a warrior, a healer, and a ranger. And each team is controlled by it's own SOFAScript. 

Both the simulation and programming language is implemented in Java, using the libraries and utilities listed below in the building-section.

Challenge your friends to a programming battle in SOFA.

## Building

Requirements:

* Eclipse (http://www.eclipse.org)
* libGDX (http://libgdx.badlogicgames.com)
* ANTLR4 (http://www.antlr.org)
* Mockito (https://code.google.com/p/mockito/)

After downloading the requirements above open all three projects in eclipse.
Update the classpath in each project to point to the correct location of each library.
Export a runnable jar from the sofa-desktop project.

## Running

Run as:

```
java -jar sofa.jar <redTeam.sofa-file> <blueTeam.sofa-file>
```

## Documentation

There is some basic documentation of the scripting language in the documentations folder, aswell as two test scripts.
More documentation will be added soon.
