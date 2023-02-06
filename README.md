# Movie-App

- Clean architecture
- MVVM architecture
- Dependency injection
- Ahitecture Components (Lifecycle, LiveData, ViewModel, DataBinding, Navigation, Room ...)

## Setup Requirements
Obtain your key from [TMDB API](https://www.themoviedb.org/documentation/api) and replace it in the `Constants` file:

```gradle
    API_KEY = "API_KEY_VALUE"
```

```
com.asimodabas.movie_app
├── adapter       
│   ├── MovieAdapter                    
│   ├── PopularAdapter      
│   ├── SearchAdapter        
│   └── TheatersAdapter            
|
├── di                  
│   ├── AppModule        
│   └── MyApplication     
│
├── service                  
│   ├── database        
│   └── retrofit       
│
├── ui                  
│   ├── activity        
│   └── fragment        
│
├── util      
│
├── viewmodel       
│   ├── BaseViewModel                    
│   ├── DetailViewModel            
│   └── HomeViewModel    
└──
```

Libraries Used
--------------
* [Hilt][1] - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.To provide an easy way to provision different bindings to various build types (e.g. testing, debug, or release)
* [Retrofit][2] - For turns your HTTP API into a Java interface
* [RxJava][3] - RxJava is a library for composing asynchronous and event-based code by using observable sequences and functional style operators, allowing for parameterized execution via schedulers.
* [Navigation][4] - Navigating to a destination is done using a NavController, an object that manages app navigation within a NavHost. Each NavHost has its own corresponding NavController. NavController provides a few different ways to navigate to a destination, which are further described in the sections below.
* [Room][5] - The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
* [Glide][6] - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

App Images
--------------
<p align="center">
  <img src="https://user-images.githubusercontent.com/71982171/217071965-ee7929cf-e367-46e0-b100-440048b84999.gif" alt="GIF" />
</p>

MIT License

Copyright (c) 2023 Asım Odabaş

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[1]: https://developer.android.com/training/dependency-injection/hilt-android
[2]: https://square.github.io/retrofit/
[3]: https://github.com/ReactiveX/RxJava
[4]: https://developer.android.com/guide/navigation/navigation-navigate
[5]: https://developer.android.com/training/data-storage/room
[6]: https://github.com/bumptech/glide
