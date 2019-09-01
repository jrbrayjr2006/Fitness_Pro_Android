# Fitness Pro

This is a mobile app for managing personal fitness.  It is the successor to the original Fitness Pro Basic app.

## Overview

This is a mobile application that is designed to integrate with a cloud based data persistence framework.  This application is designed using a Domain Driven Development (DDD) approach.  The packages and code are organized accordingly.

## Technical Details

### Navigation
A drawer navigation component is the primary top-level navigation component of the application.

#### Navigation Header
The navigation view is embedded in the layout of the payment activity.
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    ...
    ...
    <android.support.design.widget.NavigationView
        android:id="@+id/navView"
        android:layout_width="320dp"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        app:menu="@menu/drawer_view"
        app:itemTextColor="@color/drawable_selector_drawer_item"
        app:headerLayout="@layout/nav_header"/>
</android.support.v4.widget.DrawerLayout>
```
The navigation header can be accessed by referencing the `NavigationView` directly in the `Activity` class.  Once there is a reference to the `NavigationView`, it is possible to access the navigation header by calling the `getHeaderView(0)` method, provided the header is the first child view of the `NavigationView`.  Properties can now be set on the child views of navigation header view.

```java
NavigationView navView = findViewById(R.id.navView);
TextView textViewNavHeaderUsername = navView.getHeaderView(0).findViewById(R.id.textViewNavHeaderUsername);
textViewNavHeaderUsername.setText(fullUserName);
```

#### Navigation Items
The items in the navigation drawer are set via a menu resource.

### Profile Picture
This application allows the user to take a profile photo and use it as the photo for the app.

We import the `CircleImageView` to allow us to get a circular image on the screen.

The gradle dependency for this is:

```groovy
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    ...
    implementation 'de.hdodenhof:circleimageview:3.0.0'
    ...
}
```

Declare and instantiate the header image and the navigation header image objects.
```java
CircleImageView CircleImageView circleImageViewProfilePicture = navView.getHeaderView(0).findViewById(R.id.profile_image);
circleImageViewProfileImageToolbar = toolbarPayments.findViewById(R.id.profileImageToolbar);
```

Use a media intent to capture the photo.
```java
private void takePictureIntent() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
}
```

Capture the bitmap of the photo for use or storage in the app.
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmapProfilePicture = (Bitmap) extras.get("data");
        circleImageViewProfilePicture.setImageBitmap(imageBitmapProfilePicture);
        circleImageViewProfileImageToolbar.setImageBitmap(imageBitmapProfilePicture);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        imageBitmapProfilePicture.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        profilePictureByteArray = byteArrayOutputStream.toByteArray();
    }
}
```

## Testing

The Expresso framework is used for testing.  Below is a snippet of the testing dependencies.

```groovy
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    ...
    ...
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0'
    androidTestImplementation 'androidx.test:runner:1.1.0'
    androidTestImplementation 'androidx.test:rules:1.1.0'
}
```

### Unit Testing

### Integration Testing

## References

- [ViewPager with FragmentPagerAdapter](https://guides.codepath.com/android/viewpager-with-fragmentpageradapter)
- [Material Design](https://material.io/)
- [Authenticate with Firebase Using Email Link in Android](https://firebase.google.com/docs/auth/android/email-link-auth)
- [SQLite for Android](https://developer.android.com/training/data-storage/sqlite)
- [Using Room Data Persistence Library](https://developer.android.com/training/data-storage/room)
- [Take Photos](https://developer.android.com/training/camera/photobasics)
- [Control the camera](https://developer.android.com/training/camera/cameradirect)
- [Get Started with Cloud Storage on Android](https://firebase.google.com/docs/storage/android/start)
