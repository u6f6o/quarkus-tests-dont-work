Reproduce: 

1. Execute `./gradlew test`
2. Actuator test should fail with: 
```
ActuatorTest > initializationError FAILED
    java.lang.RuntimeException: Internal error. The test class class com.acme.ActuatorTest should have been loaded with a QuarkusClassLoader, but instead it was loaded with jdk.internal.loader.ClassLoaders$AppClassLoader@2c854dc5. This is caused by the FacadeClassLoader not correctly identifying this class as a QuarkusTest.
        at io.quarkus.test.junit.QuarkusTestExtension.getClassLoaderFromTestClass(QuarkusTestExtension.java:337)
        at io.quarkus.test.junit.QuarkusTestExtension.ensureStarted(QuarkusTestExtension.java:631)
        at io.quarkus.test.junit.QuarkusTestExtension.beforeAll(QuarkusTestExtension.java:712)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
```
3. Change quarkusVersion in gradle.properties back to `quarkusVersion=3.21.4`
4. Execute `./gradlew test`
5. Tests should work 
