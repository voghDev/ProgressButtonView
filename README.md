# ProgressButtonView
[![Build Status](https://travis-ci.org/voghDev/ProgressButtonView.svg?branch=master)](https://travis-ci.org/voghDev/ProgressButtonView)
[![GitHub license](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/voghdev/progressbuttonview/blob/master/LICENSE.txt)
<a href="http://www.methodscount.com/?lib=es.voghdev.progressbuttonview%3AProgressButtonView%3A0.7.9"><img src="https://img.shields.io/badge/Size-24 KB-e91e63.svg"/></a>


Simple CustomView that shows a Button with a ProgressBar

Installation
------------

Add this line in your *app/build.gradle*

    compile 'es.voghdev.progressbuttonview:ProgressButtonView:0.8.3'

![Screenshot][progressButtonViewScreenshot]

Usage
-----

You can add **ProgressButtonView** to your XML layouts

    <es.voghdev.progressbuttonview.ProgressButtonView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            app:hideButtonWhileLoading="true"
            app:text="@string/hello" />


You can also create it programatically

    ProgressButtonView progressButtonView = new ProgressButtonView(context);

Then turn the widget into loading mode, or switch it back to a normal button with:

    progressButtonView.showLoading();
    progressButtonView.hideLoading();

There are many attributes that you can set to customize its behaviour

    app:text="@string/hello"
    app:textSize="20sp"
    app:textColor="#ff0000"
    app:hideButtonWhileLoading="true"
    app:backgroundColorResource="@color/my_favorite_background_color"

The full list can be found in the [attrs.xml][1] styleable

![Screenshot][anotherProgressButtonViewScreenshot]

Experimental
------------

You can find isolation UI Tests for ProgressButtonView in [this experimental branch][4]. It uses novoda's espresso-support library. More info can be found in [this blogpost][5]

Developed By
------------

* Olmo Gallegos Hernández - [@voghDev][2] - [mobiledevstories.com][3]

<a href="http://twitter.com/voghDev">
  <img alt="Follow me on Twitter" src="https://image.freepik.com/iconos-gratis/twitter-logo_318-40209.jpg" height="60" width="60" />
</a>
<a href="https://www.linkedin.com/profile/view?id=91543271">
  <img alt="Find me on Linkedin" src="https://image.freepik.com/iconos-gratis/boton-del-logotipo-linkedin_318-84979.png" height="60" width="60" />
</a>

# License

    Copyright 2016 Olmo Gallegos Hernández

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

Contributing
------------

**For noobs (like me some months ago)**

    fork the project into your GitHub account
    now clone your GitHub repo for this project
    implement your changes
    commit your changes, push them into your repo
    review your code and send me a pull request if you consider it

**For not-so-noobs**

Please make sure that your changes pass both checkstyle and UI tests before submitting them

    ./gradlew checkstyle

    ./gradlew test

And with your Android device connected

    ./gradlew connectedCheck

 [progressButtonViewScreenshot]: ./screenshots/sample1.gif
 [anotherProgressButtonViewScreenshot]: ./screenshots/sample2.gif
 [1]: https://github.com/voghDev/ProgressButtonView/blob/master/ProgressButtonView/src/main/res/values/attrs.xml
 [2]: https://github.com/voghDev
 [3]: http://www.mobiledevstories.com
 [4]: https://github.com/voghDev/ProgressButtonView/tree/add_novoda_espresso_support
 [5]: https://www.novoda.com/blog/testing-views-in-isolation-with-espresso/
