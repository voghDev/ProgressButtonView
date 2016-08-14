# ProgressButtonView
Simple CustomView that shows a Button with a ProgressBar

Installation
------------

Add this line in your *app/build.gradle*

    - soon available as gradle dependency. You can download the code in the meanwhile

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

Developed By
------------

* Olmo Gallegos Hernández - [@voghDev][9] - [mobiledevstories.com][10]

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
    checkout your GitHub repo for the project
    implement your changes
    commit your changes, push them
    review your code and send me a pull request if you consider it
    **For not-so-noobs**
    Please make sure that your changes pass both checkstyle and (soon) UI tests before submitting them

 [1]: https://github.com/voghDev/ProgressButtonView/blob/master/ProgressButtonView/src/main/res/values/attrs.xml
 [progressButtonViewScreenshot]: ./screenshots/sample1.gif