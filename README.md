# AndroidArchitecture

## Layer
![Layer](https://user-images.githubusercontent.com/38560833/77888685-d3112b00-7296-11ea-8521-cf227ee78ef6.png)

### Data layer
 * Local database
 * Shared Preferences
 * Remote (Retrofit,..)
 ![image](https://user-images.githubusercontent.com/38560833/77889729-83cbfa00-7298-11ea-80d3-4c68a7026d46.png)

### Repository layer and usecase layer
 * Wrap data local & network from data layer
 * Use Interface mapper to define the way to map model from data layer to it's layer
```kotlin
interface Mapper<I,O> {
  fun map(input: I): O
}
```
![image](https://user-images.githubusercontent.com/38560833/77889866-c261b480-7298-11ea-9bdd-830afec73c76.png)

### Presentation layer
 * Activity/ViewModel use data from usecase layer to bind to view
## Multi module
![Multimodule](https://user-images.githubusercontent.com/38560833/77888728-e3c1a100-7296-11ea-8f42-7168bd20c43c.png)
