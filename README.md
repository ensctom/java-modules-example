
Intro to java modules

Since java 9, introduced one of key feature to the java ecosystem. JPMS (java platform modules system) helps developers maintain 
a grouping of packages into a modules, as well as common resources such as images, xml files, config files, etc. Modules are very explicit in what dependencies are introduced and introduces some strong encapsulation 

To see all base modules in jdk use `java --list-modules` command

The goal of modules 
-  reducing run time size. You only need to import what packages your application needs instead.
Pre java 9 the, the JRE was a monolith and included run time packages that were irrelevant to your actually application
which causes bloat. For example oracle jdk 8 includes javafx which is not required for non gui driven applications
- With modules, you can restrict access to which apis are available vs hidden

# In Java, there are five types of modules:

## Automatic modules:
 These are modules that are created from regular JAR files that do not have a module-info.java file. Automatic modules have a name that is derived from the name of the JAR file and can access all other modules in the application.

An automatic module derives its name using a two-step process:

If the JAR defines the Automatic-Module-Name header in its `MANIFEST.MF, then that property defines the module’s name.
Alternately, the JAR file name is used to determine the name. The second approach is intrinsically unstable, so no modules with a dependency on such an automatic module should be published in public Maven repositories.

## Named modules: 
These are modules that have a module-info.java file and a unique, explicit name. Named modules can specify the packages they expose to other modules, as well as the modules they depend on.

## Unnamed modules: 
These are modules that do not have a module-info.java file and are created by the Java runtime when you launch an application. Unnamed modules have a special name and can access only the classes in the classpath.

## Platform modules: 
These are modules that are included in the Java SE platform and are used to define the core functionality of the Java runtime. Platform modules are named and are not intended to be used by applications.

## Custom modules: 
These are modules that are created by developers to modularize their own applications. Custom modules can be either named or automatic, depending on whether they have a module-info.java file.

# Module Declaration

## requires 
A requires module directive specifies that this module depends on another module—this relationship is called a module dependency. Each module must explicitly state its dependencies.


## requires static
There is also a `requires static` directive to indicate that a module is required at compile time, but is optional at runtime.

<details> 
 <summary>some examples of these types of packages include:</summary> 


> Annotation processors: Annotation processors are Java programs that are used to generate code based on annotations in the source code. These processors are typically invoked by the javac compiler at compile time, but they do not need to be present on the classpath at runtime.

> Compiler plugins are Java programs that can be used to customize the behavior of the javac compiler. These plugins are typically invoked by the compiler at compile time, but they do not need to be present on the classpath at runtime.

> Code generation tools: There are a number of tools that can be used to generate Java code based on input files or other sources. These tools are typically invoked at compile time, but the generated code is usually sufficient for the program to run without the need for the tool itself at runtime.

> Debugging and profiling tools: There are a number of tools that can be used to debug or profile Java programs, such as the Java Debug Interface (JDI) and the Java Virtual Machine Tool Interface (JVMTI). These tools are usually only needed at development time and are not required at runtime.

> Test frameworks: Many Java projects use test frameworks such as JUnit or TestNG to write and run tests. These frameworks are usually only needed at development time and are not required at runtime.

</details> 

## requires transitive
To specify a dependency on another module and to ensure that other modules reading your module also read that dependency—known as implied readability—use requires transitive, as in:

Consider the following directive from the `java.desktop` module declaration:

> requires transitive java.xml; 

In this case, any module that reads `java.desktop` also implicitly reads `java.xml`. If a method from the `java.desktop` module returns a type from the `java.xml module`, code in modules that read `java.desktop` also becomes dependent on `java.xml`. Without the `requires transitive` directive in `java.desktop`’s module declaration, such dependent modules will not compile unless they explicitly read `java.xml`.


## exports, exports...to
This directive specifies a package that should be made available to other modules.

## opens, opens, opens..to: 
This directive specifies a package that should be made available to other modules for reflection, but not for regular code access. However post jdk 9, it will now give you a warning if there is any code that access platform modules

> Platform modules: These are modules that are included in the Java SE platform and are used to define the core functionality of the Java runtime. Platform modules are named and are not intended to be used by applications.

Reflection is a super powerful tool that allows developer access to the internals of a package. Prior to jdk 9, it has super power

The relaxed strong encapsulation provides a launcher option –illegal-access to control the runtime behavior. We should note that the –illegal-access option only works when we use reflection to access platform modules from unnamed modules. Otherwise, this option has no effect.

The –illegal-access option has four concrete values:

permit: opens each package of platform modules to unnamed modules and shows a warning message only once
warn: is identical to “permit“, but shows a warning message per illegal reflective access operation
debug: is identical to “warn“, and also prints the corresponding stack trace
deny: disables all illegal reflective access operations
From Java 9, the –illegal-access=permit is the default mode. To use other modes, we can specify this option on the command line:

## uses: 
This directive specifies a service that the module uses.

## provides...with: 
This directive specifies a service that the module provides and the implementation class that should be used to provide the service.



## Migrating application to use java 9 modules





# References

- https://developer.okta.com/blog/2020/07/27/spring-boot-using-java-modules
- https://www.oracle.com/ca-en/corporate/features/understanding-java-9-modules.html
- https://www.baeldung.com/java-illegal-reflective-access
- https://dzone.com/articles/java-9-modules-part-3-directives