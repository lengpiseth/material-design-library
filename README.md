Material Design Library
====================


### Description
A library that help developers creating their Android Application with Material Design.  
It offers a lot of Material Design classes easily to use like NavigationDrawerActivity that creates an Activity with a Material Design NavigationDrawer.


### Usage

**1.** Add the dependency in your build.gradle.

```groovy
dependencies {  
    compile 'com.blunderer:materialdesignlibrary:1.0.0'  
}
```

**2.** In your *values/styles.xml* file, change the parent style and add your own colorPrimary/colorPrimaryDark colors:

```xml
<style name="AppTheme" parent="@style/MaterialDesignAppCompatTheme">
    <item name="colorPrimary">@color/blue</item>
    <item name="colorPrimaryDark">@color/blue_dark</item>
</style>
```

Or if you want the Light Theme:  

```xml
<style name="AppTheme" parent="@style/MaterialDesignAppCompatTheme.Light">
    <item name="colorPrimary">@color/blue</item>
    <item name="colorPrimaryDark">@color/blue_dark</item>
</style>
```

**3.** Extends your activity by one of mine (*each activity will be in Material Design*):  

  * **Activity**  
    Your activity will be a basic activity with Material Design.

  * **ListViewActivity**  
  Your activity will contain a ListView (with or not the Material Design Pull To Refresh).

  * **NavigationDrawerActivity**  
  Your activity will contain a NavigationDrawer.

  * **ViewPagerActivity**  
  Your activity will contain a ViewPager (with or not the indicator).

  * **ViewPagerWithTabsActivity**  
  Your activity will contain a ViewPager with the tabs.

##### Example:  
```java
import com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity;

public class MyActivity extends NavigationDrawerActivity {

    @Override
    protected NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        return new NavigationDrawerTopHandler()
                .addItem(R.string.app_name, R.drawable.ic_help, new MainFragment())
                .addItem(R.string.settings, R.drawable.ic_settings, new MainFragment())
                .addSection(R.string.title_section2)
                .addItem(R.string.app_name, R.drawable.ic_help, new MainFragment())
                .addItem(R.string.settings, R.drawable.ic_settings, new MainFragment());
    }

    @Override
    protected NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler()
                .addSettings(null)
                .addHelpAndFeedback(null);
    }

    @Override
    protected int defaultNavigationDrawerItemSelectedPosition() {
        return 0;
    }

}
```


### Sample
Coming soon


### Developed by

 * Denis Mondon - <blundererandroid@gmail.com>