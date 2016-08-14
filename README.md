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

 [1]: https://github.com/voghDev/ProgressButtonView/blob/master/ProgressButtonView/src/main/res/values/attrs.xml
 [progressButtonViewScreenshot]: ./screenshots/sample1.gif