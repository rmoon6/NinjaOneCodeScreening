- Not necessarily an improvement, but I upgraded kotlin and kotlinCompilerExtensionVersion for compose to fix this: https://youtrack.jetbrains.com/issue/KT-63480/IllegalAccessError-superclass-access-check-failed-class-org.jetbrains.kotlin.kapt3.base.javac.KaptJavaCompiler
- Renamed "CreateUserScreen" to "ConfirmUserCreateScreen". This way, the top level composable can be called "CreateUserScreen"
- The "Add New User" button was hovering at the very top of the screen, so I changed the dashboard composable to make it stick to the bottom. It was easier to click that way.
- Again, not necessarily an improvement, but I upgraded the compose bom to the latest to fix this: https://stackoverflow.com/questions/76078226/use-jetpack-compose-modalbottomsheet-the-offset-was-read-before-being-initializ
- Changed "InterestsBottomSheet" to be "SelectableListBottomSheet", since it's generic. I also got rid of the file for PetsBottomSheet.
- Pet and Interest are enums instead of strings
- Renamed some structures that are generally at the application level with a "ScreeningApp..." naming convention
- Added this to the manifest to make the screen play better with the keyboard: `android:windowSoftInputMode="adjustResize"`
- Re-structured the file system a bit so that the packages are organized roughly by feature
  - These could be grouped further if the app were to get bigger
- Added more distributed modules for Hilt, that are generally broken out by feature
- The route destinations for the nav graphs are now enums instead of strings