# 30 Days of Kotlin
30 Days of Kotlin with Google Developers is an initiative to improve
the understanding of Kotlin and apply it in real projects using Google
resources (`codelabs`, sessions with `Googlers`) between 7th May - 7th of June.

## Cholti | চলতি
The idea of the application is to provide Bengali (বাংলা) pronunciation of
some essentials. The chosen categories are `Words`, `Phrases`, `Colors` and `Numbers`.
Each category has 5 distinct elements that have their english and bengali script
along with the proper bengali pronunciation. The `illustrations` in app are original
artworks by two of my friends [Ritwik](https://twitter.com/RahaRitwik) and [Rajwrita](https://twitter.com/rajwrita).
The voice that you get to hear is of my friend [Puja](https://twitter.com/pleb_talks).

### Concepts implemented in the project
1. Recycler-view.
2. Data-Binding.
3. Intents.
4. Guidelines with constraint-layout.
5. Material Library.

### Details
#### Recycler-View
In the application there are five elements in each category. The elements had to be encapsulated
in cards. Each card is used from the `material library`. These cards were inflated in a view holder
and were shown with the help  of an adapter that fetched dynamic data and the recycler view. We wanted
have a pager like behaviour, hence had to make a custom class which emulates the clip behaviour. While
scrolling you will have the card centre itself.
The creators class has another recycler view set up which is `VERTICAL`. The viewholder had to changed
and the `jpg` images are loaded with a 3rd party library named `Glide`.
#### Data-Binding
With the problem of `findViewById` the application had to go through the entire view hierarchy each time
the activity is created. With the `data binding` scheme, there was generated classes out of which we could
build the view object and cache them. The accessing of view reduced the overhead and the app performance
increased drastically.
#### Intents
With the project I understood what an `implicit` and `explicit` intent means. In the `creators` page
each creator has the `twitter`, `linkedin` and `github` profiles linked. With implicit intents I had to
launch the `url` and open it in the application that can help with the Intent.
The main page leads to different in-app `activities`, which is achieved by `explicit intents`. In kotlin
the reference operator had to be used for explicit activity intents.
#### Guidelines
With the `constraint layout` I have used the `guidelines` to make the application screens
as responsive as I can. The percentage with guidelines are really helpful, which helps the widgets
to grow or shrink according to the device screen dimensions.
#### Material Library
With the application we have tried to keep it along the material design guidelines as far as possible.
The material library no only helped me in building the material cards, but also changed the shape of toast
and dialog box.