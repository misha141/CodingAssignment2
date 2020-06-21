# CodingAssignment2
Requirements
This application can be built on any framework which you are comfortable with and feel is best
suited for this.
1. You would need to create both frontend & backend APIs for this application.
2. Create a basic user registration and authentication system.
3. Create APIs using which a user can define their available slots for a particular day. Assume
that each slot is a fixed hourly slot. For example, 12:00-13:00, 13:00-14:00, etc.
4. Create frontend & APIs using which a user can book an available slot.
5. Show an error page when an unauthenticated user is trying to access the APIs.

## Basic user registration and authentication system 
<img src="Screenshots/LoginFragment.jpg" width="150" height="250">  <img src="Screenshots/Signuppage.jpg" width="150" height="250">  <img src="Screenshots/ForgetPasswordFragment.jpg" width="150" height="250">

### User Data Stored In Cloud Firestore
<img src="Screenshots/UserDataFireStore.PNG" width="700" height="250">

## MainActivity For Defining and Deleting Slots
<img src="Screenshots/mainActivity.jpg" width="150" height="250"> 

### Adding Slots
<img src="Screenshots/AddAvailableSlot.jpg" width="150" height="250">  <img src="Screenshots/CalenderClass.jpg" width="150" height="250">
<img src="Screenshots/ClockClass.jpg" width="150" height="250">  <img src="Screenshots/clockClass2.jpg" width="150" height="250">  <img src="Screenshots/AfterAddingSlot.jpg" width="150" height="250">

### Slot Information Stored in Firebase RealTime Database
<img src="Screenshots/realtimeDatabase.PNG" width="600" height="250">

### View Slot details and Perform Delete Operation
<img src="Screenshots/AvailableSlotCRUD.jpg" width="150" height="250">  <img src="Screenshots/AfterOperationSlots.jpg" width="150" height="250">

## Unauthenticated Users Denied To Access Difining Slots And Deleting Slots

<img src="Screenshots/UnauthenticatedUserAcces.jpg" width="150" height="250">
