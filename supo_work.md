---
header-includes:
- |
    \usepackage{tikz,cancel}
    \usepackage{tikz-uml}
    \usetikzlibrary{shapes.geometric,positioning}
---

# OOP supervision 2
See the Github repo at https://github.com/MarcellPerger1/CST-1A-OOP-Supervision2 for the full code.

## Section 4: Inheritance
### 4.1
Inheritance should only be used when the subclass has the same methods and attributes as the base class with some extra (i.e. the subclass extends the functionality). The classes should also follow the Liskov substitution principle: anywhere where the superclass can be used, the subclass should also be allowed.
However, a `Vector3` cannot be used everywhere where a `Vector2` can be used (e.g. you can add a `Vector2` to a given `Vector2` but you can add a `Vector3` to that `Vector2`). The misunderstanding is that it's not enough for the data to be the same with some stuff added, the methods/behaviour also has to be the same but with some stuff added.

### 4.2
If you don't specify and access modifier, the default is package-private - it can be accessed by anything in its class and anything in the same package as it. See `Q4P2/**` for demo (commented-out code will make the compilation fail if it is uncommented)

### 4.3
See `Q4P3/NoConstructor/*.java` for classes without any constructor was added.  
See `Q4P3/UnaryConstructor/*.java` for how it had to be modified when `A`'s constructor now has to take one argument (I had to add a constructor in all the subclasses to correctly call `A`'s constructor with the passed argument).

### 4.4
#### a
\
\nopagebreak
\begin{tikzpicture} 
\umlemptyclass[x=-3.5,y=-5]{Shop}
\umlemptyclass[x=2]{Employee}
\umlemptyclass[y=-8,x=-3.5]{Department}
\umlemptyclass[y=-3,x=4]{Manager}
\umlemptyclass[y=-3,x=0]{ShopAssistant}
\umlemptyclass[y=-5,x=1]{StoreManager}
\umlemptyclass[y=-8,x=1]{DeptManager}
\umlclass[y=-5,x=-7.5]{Item}{
    - price: float\\
    - taxRate: float
}{}

\umlinherit[geometry=|-|]{Manager}{Employee}
\umlinherit[geometry=-|]{StoreManager}{Manager}
\umlinherit[geometry=-|]{DeptManager}{Manager}
\umlinherit[geometry=|-|]{ShopAssistant}{Employee}
\umlcompo[mult=1..*,pos=0.5]{Shop}{Department}
\umlcompo[mult=1..*,pos=0.5,geometry=|-]{Shop}{ShopAssistant}
\umlcompo[mult=1]{Department}{DeptManager}
\umlcompo[mult=1,geometry=-|-,pos=1.0]{Shop}{StoreManager}
\umlcompo[mult=1..*,pos=0.5]{Shop}{Item}
\end{tikzpicture}

Getters, setters and any attributes for the relationships have been omitted for conciseness.  
Though this architecture means that an employee cannot be promoted without having to delete and recreate the object.

#### b
\
\nopagebreak
\begin{tikzpicture} 
\umlemptyclass[x=5,y=0.6]{Person}
\umlclass[y=0.6]{Vehicle}{
    - wheels: int\\
    - hasRoadTax: boolean\\
    - owner: Person
}{
    + Vehicle(wheels: int)
}
\umlclass[x=3.5,y=-3.5]{MotorVehicle}{}{
    + MotorVehicle(wheels: int)
}
\umlclass[x=-3.5,y=-3.5]{UnpoweredVehicle}{}{
    + UnpoweredVehicle(wheels: int)
}
\umlclass[x=-3.5,y=-6]{Bike}{
    - wheels: int = 2
}{
    + Bike()
}
\umlclass[x=3.5,y=-6]{Car}{}{
    + Car(wheels: int)
}
\umlinherit[geometry=|-|]{UnpoweredVehicle}{Vehicle}
\umlinherit[geometry=|-|]{MotorVehicle}{Vehicle}
\umlinherit{Bike}{UnpoweredVehicle}
\umlinherit{Car}{MotorVehicle}
\umlaggreg[mult2=1,mult1=0..*]{Vehicle}{Person}
\umlnote[y=-5.5,x=8.5,width=4cm]{Car}{In constructor, check that `wheels` is 3 or 4}

\end{tikzpicture}


### 4.5
There will never be any runtime errors, only compile-time errors (as Java is smart enough to figure out at compile-time if you're not allowed to be accessing something)

| | `public` | `protected` | unspecified | `private`
|-|-|-|-|-|
|a| OK | OK | OK | Error |
|b| OK | OK | Error | Error |
|c| OK | OK | OK | Error |
|d| OK | Error | Error | Error |


