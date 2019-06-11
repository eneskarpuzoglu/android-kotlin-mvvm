# Kotlin MVVM
Sample project that implements the MVVM architecture using Kotlin, Data Binding, RxJava2 and Android Architecture Components.


### Library reference resources:
1. Architecture Components: https://developer.android.com/topic/libraries/architecture/adding-components.html
2. RxJava2: https://github.com/ReactiveX/RxJava
3. Dagger2: https://github.com/google/dagger
4. Retrofit: https://github.com/square/retrofit

### Layers of the app:
 * Data - contains the model/business model that will be presented to the view, related classes included Reponse models, classes associated with the Room database library
 * DI - contains all the Dagger 2 injection classes.
 * UI - the actual Android UI components, Activities and ViewModels

 ## License

- Copyright 2018 © Enes Karpuzoğlu.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
