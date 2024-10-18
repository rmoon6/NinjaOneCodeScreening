1. Please download this repo and get the app running on your machine/IDE.

2. Feel free to improve any pre-developed code. If so, please add a new IMPROVEMENTS_README.md to the project and list the 
   improvements you've made.

3. Assignment Steps:

   3.1 - Create A User
   - In the ScreeningNavHost.kt file, add a Nested Navigation Graph for the Create User flow.
   - In the Create User Navigation Graph, add three destinations in the following order: PersonalDataScreen, PersonalPreferencesScreen, and CreateUserScreen.
   - PersonalDataScreen: This screen must contain "Email" input TextField, "Password" input TextField, and a "Next" button.
      - Email TextField -> is valid with a normal format such as username@domain.com.
      - Password TextField -> is valid with at least one letter, and one number, and the minimum length is 6.
      - Next Button -> Enabled only when Email TextField and Password TextField are valid. When clicking on it, navigate to PersonalPreferencesScreen.
      - Email and Password input validation must be done in a UseCase class. Use Dagger Hilt to inject it into the ViewModel.
      - This screen must send all the inputted data to the next one.
   - PersonalPreferencesScreen: This screen contains two Single Selectable fields "Pets", "Interests", and a "Next" button.
      - Pets Selectable Field -> When clicking on it, must open the PetsBottomSheet.
         - Create PetsBottomSheet, you can rely on the InterestsBottomSheet implementation.
         - After selecting an option, the PetsBottomSheet must be closed and the selected option must be shown in the Pets Selectable Field.
         - The Pets Selectable Field is valid only when there is a selected option.
      - Interests Selectable Field -> When clicking on it, must open the InterestsBottomSheet.
         - After selecting an option, the InterestsBottomSheet must be closed and the selected option must be shown in the Interests Selectable Field.
         - The Interests Selectable Field is valid only when there is a selected option.
      - Next Button -> Enabled only when Interests Selectable Field and Pets Selectable Field are both valid. When clicking on it, navigate to CreateUserScreen.
      - This screen must send all the inputted and selected data to the next one.
   - CreateUserScreen: This screen must show all the data previously inputted/selected and a button "Create user".
      - Create User Button -> When clicked, it will do the following:
        - Save the user into a Room database for created users.
        - Navigate back to DashboardScreen, and then in the DashboardScreen, show a Snackbar with the message: "$email user created successfully.", 
          where $email is a back parameter returned from CreateUserScreen.
   
   3.2 - In the Dashboard view model, observe the users database.
   - Below the "Add New User" button, display the users in a list, or an empty database message in case there are no users.
   
   3.2 - Add Unit Tests for all classes you might find useful.

4. Please be aware that the use of Clean Architecture pattern will be evaluated.

5. Please share with us any other improvements you would've made if you had more time at a new file called 
   OTHER_IMPROVEMENTS_README.md.