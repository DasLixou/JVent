# JVent
Event System for Java - inspired by Spigot 

## Example
The Event Class:
```java
public class TestEvent extends Event {

    private String value;

    public TestEvent(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
```
The Main Function:
```java
public static void main(String[] args) {
    // Listening to TestEvent
    new Listener(TestEvent.class, event -> {
        event.setValue("It works! :)");
    }, true); // true for autosubscription
    
    // Calling an Event with Result
    TestEvent result = Event.getHandler(TestEvent.class).call(new TestEvent("Initial Value"));
    
    // Working with the Result
    System.out.println(result.getValue()); // Prints: It works! :)
}
```

## Installation
Gradle:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.LixouCanCode:JVent:1.2.0'
}
```

Maven:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.LixouCanCode</groupId>
        <artifactId>JVent</artifactId>
        <version>1.2.0</version>
    </dependency>
</dependencies>
```