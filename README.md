# DeezerApp

DeezerApp is an Android application that allows users to search for music, listen to tracks, and save favorite tunes, utilizing the Deezer API. This app embraces modern Android development practices and architectures.

## Project Screens
GENRES SCREEN | ARTİSTS SCREEN | ARTİST SCREEN | 
--- | --- | --- | 
![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/7446cc9a-1510-45d8-b1b1-4af847d08010) |![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/2435ab2e-cedf-43d8-8fa3-658826734853) |![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/222b4268-4ef8-40dc-8002-3800bc3595bf) |

TRACKS SCREEN | TRACKS SCREEN | FAVORİTES SCREEN | 
--- | --- | --- | 
![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/8178eb87-b916-4f3e-acef-afbdb1a97c8d) |![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/7ce1747a-36de-4724-9512-68c99419338b) |![Uygulama Ekran Görüntüsü](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/3209af73-a96d-4a8f-ae61-81a2fc655658) |

## Project Tech stack 

- [Kotlin](https://developer.android.com/kotlin)
 
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

- [Kotlin Coroutine](https://developer.android.com/kotlin/coroutines)
 
- [Dependency Injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

- [Navigation Component](https://developer.android.com/guide/navigation)

- [Retrofit](https://square.github.io/retrofit/)

- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

- [UseCase](https://developer.android.com/topic/architecture/domain-layer)

- [Repository](https://developer.android.com/topic/architecture/data-layer)

- [Glide ](https://github.com/bumptech/glide)

## Architecture
The application employs the principles of "Clean Architecture" and the MVVM (Model-View-ViewModel) pattern. 
The project is divided into the following modules:

![Untitled (11)](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/fd868497-ee0e-4787-877d-1d965d13845f)
#### Data Module

* This module contains the code related to the data layer of your application. This layer is responsible for accessing the application's data sources (API, database, etc.) and preparing and processing data received from these sources. The code in this module usually includes operations like retrieving data from data sources, data processing, data storage, etc. Examples of code that could be included in this module are Room database operations, Retrofit API calls, data models, etc.


![Untitled (7)](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/b45bd6ef-3d6e-4fad-a854-838bf895188a)

#### Domain Module

* This module contains the code related to the business logic of your application. This layer processes the data received from data sources and contains the code that implements the application's features. The code in this module usually includes the business logic that is specific to your application's features. Examples of code that could be included in this module are user account operations, anime data filtering operations, favorite anime lists, etc.

![Untitled (8)](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/af550895-a7e7-45f5-8d3d-80f1021cdf4e)

#### Common Module

* This module contains the common code that is used across different modules of your application. This module helps to reduce code duplication across different modules and makes your application more modular. The code in this module usually includes helper classes, general functions, etc. that are used in different parts of your application.

![Untitled (10)](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/2f568752-a3f0-4c95-936f-f1127ab67d22)

#### App

* The App module serves as the entry point of the application and is responsible for the user interface (UI). It's where all UI-related components, such as activities, fragments, view models, and custom views reside. This module is the direct interface between the user and the application, providing the means for user interactions.

![Untitled (9)](https://github.com/sahinkaradeniz/DeezerApp/assets/85341568/08493839-79e7-42cd-9fa0-e8b16bf50a78)

## API

[Deezer Api](https://developers.deezer.com/api/)


