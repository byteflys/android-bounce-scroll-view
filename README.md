# About this Project

A scroll view, that supports drag out of bound, and auto bounce back

# Core Ability

- scroll out of bound
- bounce back on finger up
- max width/height
- max width/height by screen ratio

# Steps for Integration

#### 1. Dependency

```kotlin
api("io.github.hellogoogle2000:android-bounce-scroll-view:1.0.1")
```

#### 2. Apply in Xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <com.android.library.bouncescrollview.BounceScrollView
        android:id="@+id/moduleScrollView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#2200FF00"
        android:scrollbars="none"
        app:maxScreenRatioX="0.5"
        app:maxScreenRatioY="0.5">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center_horizontal"
            android:orientation="vertical">

            <ImageView
                android:layout_width="600dp"
                android:layout_height="3000dp"
                android:scaleType="fitXY"
                android:src="@drawable/ic" />
        </LinearLayout>
    </com.android.library.bouncescrollview.BounceScrollView>
</LinearLayout>
```