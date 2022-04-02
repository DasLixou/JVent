# JVent
A simple Java and Kotlin Library built for making it easy and fast to create Event and Subscribtion Systems. 

## Example
The Event Class:
```java
public class TestEvent {

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
    }).setPriority(EventPriority.HIGH).subscribe(i < 2);
    
    // Calling an Event with Result
    TestEvent result = JVent.call(new TestEvent("Initial Value"));
    
    // Working with the Result
    System.out.println(result.getValue()); // Prints: It works! :)
}
```

## Installation

**IMPORTANT:** Replace *VERSION* with the version you prefer.

Newest Version: 
[![](https://jitpack.io/v/LixouCanCode/JVent.svg)](https://jitpack.io/#LixouCanCode/JVent)

Gradle:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.LixouCanCode:JVent:VERSION'
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
        <version>VERSION</version>
    </dependency>
</dependencies>
```
