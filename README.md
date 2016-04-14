# Hotel Reservation System
Project for CS321 - George Mason University
Section 001 | Group 01

#### Updated on: April 13, 2016

## NOTE: TO RUN THIS SOFTWARE, YOU SHOULD HAVE ATLEAST JAVA 1.8 INSTALLED IN YOUR MACHINE.

## Getting the Source Code:
- Click the `Download ZIP` on the top right corner of this page.
- Extract the zip file.
- The source codes should be inside the 'Java Files' directory.

## Compiling:
- Run the Terminal(Unix) or Command Prompt(Windows).
- Go to the 'Java Files' directory.
- And then type `javac *.java` to compile the java files.

## Running the Program:
- Run RSVPCoordinator by running the following commands:
- - `java RSVPCoordinator sample-inputs/sample1.txt`.
- - `java RSVPCoordinator sample-inputs/sample2.txt`.
- - `java RSVPCoordinator sample-inputs/sample3.txt`.
- - `java RSVPCoordinator sample-inputs/sample4.txt`.


## Run down of the requirements of making reservation, checking-in, checking-out, and generating a report.
#### Reservations:
- Making a Reservation will succeed if the reservation details have the complete information it needs.
- Also, there should be no conflict of dates from other reservations.
- It checks the room as well if there is enough room that can be used for that reservation.

#### Check-In:
- Checking in a person should have a record in the database of his/her account.
- Checking in a person should have a reservation booked.
- Checking in a person should have a reservation that is not yet checked-in.
- Checking in a person should have a 0 balance and will if not.

#### Check-out
- Checking out a person should have a record in the database of his/her account.
- Checking out a person should have a reservation booked.
- Check out only if the user is checked-in.

#### Generate Report
- All Reports generated from a day, range, or all will only print out those reservations that are all paid and no balance left.


### Algorithmic Logic
Calendar: 
Constructor is the Calendar which holds the list of reservations.
checkDate: A boolean method called checkdate that checks up on a date taking in room argument and date and brings back true or false depending on if room is open or not. 
ReserverationByDateRange: A method that returns a list of reservations between a given time. This is done by taking in two different dates (making sure the the first date argument is before the second one) and getting the dates between them.

CheckIn:
Constructor: given a Reservation and creates the rsvp reservation for the class.
CheckIn: Given a Date for the reservation, checks if that reservation is not already checked in, and the balance is 0. Sets the reservation to CheckIn, set it to guaranteed check in, and set the room to occupied. 
toString: String representation of the CheckIn class. Shows the reservation ID, Customer’s name, Credit Card information, and the date the reservation is reserved until.

CheckOut:
	Constructor: Given a Reservation, creates the reservation object for the class.
CheckOut: Given a reservation, checks to see if the reservation is already checked in, and it’s the end of the reservation. Sets the check in status to false, set StayFinished to true, and set the room to unoccupied.
toString: String representation of Check out, shows the Reservation ID, and the Customer’s name only.  

CreditCard:
Constructor: The credit card is going to have name of the card, the type of card, the card number, CCV, the expiration dates, the billing addresses, and the amount that is being charged (which in the beginning will start at 00.00 as a double).
To String: Using stringBuilder the tostring is going to display all the information that was put into the constructor.

Database:
Class Variables: has variables to hold the list of Rooms, list of reservations, and list of users in the hotel system.
Constructor: initializes the list of rooms, list of reservations, and list of users as Arraylists
Mutator methods: Allows the access of each list with a get method.

Date:
Class Variables: private integers for the month, day and year for the date.
Constructor: given a month, day, and year, checks to make sure each integer is a valid      integer (0<month<13; 0<day<32;1970<year)
Mutator Methods: Allows the access to set and get the month day and year through get and set methods.
Equals: Given 2 dates (this and that) checks to see if both dates have the same month day and year and returns the boolean equivalent. 
toString: Provides a string representation of the date, showing the current month, day and year.
getDifference: first checks to see if the 2 dates that are given, equal. If they are then the difference is 0. Then checks to see if the dates are reversed, meaning if the first date given comes after the second date. Keeps track of the days between with an integer counter. while ( day1 has not passed day2) increment the counter. If they days reach the end of the month, then reset the days to 1 and increments the month. If they month reaches 13, reset the month to 1 and increment the year. If the days were reversed as previously observed, then return the negative of the count.
maxDayInMonth: returns the max number of days in a given month and year. Year is given to see if that year is a leap year.
isBefore: Given 2 days, (this and that) returns true if this is before that, false otherwise.

HotelSystem:
Class Variables: The hotel is going to have a unique ID int just in case the user wants to make more than one instance of a hotel. The class is going to have the name of the hotel, calender class object and database class object.
Constructor: Because this is going to be the first thing created we are going to create a new database object and a new calendar object. 
addRoom: the addRoom method is going to create and add a room into the room list which is stored in database. This method is going to take the attributes of a room which is the room number, the type of room and the pricing for it.
getRoom: This is going to pull up the room using the room number. 
deleteRoom: A boolean method that returns true if the room is deleted successfully, via use of Room name.
deleteRoom(given room id): Boolean method that find the room using the room id.  
addReservation: takes in the users object, room object, the number of occupants, a boolean of whether it’s guaranteed or not, the date, and the number of days that the user is staying to create a reservation object which is then added into the database. 
getReservationbyID: One of the ways that the reservation is going to be pulled, this one is done by using the reservation ID. 
getReservationbyCID: The reservation is pulled by a unique id that a customer is going to have.
getReservations: This method is going to pull up the reservation using the User name. 
deleteReservation: reservation is deleted by calling the name of the reservation object. If the reservation object isn’t found then it returns false.
addUser: A user object is created in this method taking in the username, password, the users name, a boolean if the user is banned, and the address of the user. 
getUser: Using the username of a person, this method pulls up the users information.
getUserByID: using the customers ID, this method pulls up the users information.
getUserByname: using the name of the customer, this method pulls up the users information.
deleteUser: Using the name of the User object, this method deletes the User from the database.
addCreditCard: This method creates a creditcard object using the user, the name on the card, the type of card, the card number, the ccv, the expiration, and the billing address. 
updateCreditCard: Instead of getting the user we get the credit card object that is already created. In this method we change the information that needs to be changed based on the new information put into the arguments which are the same as addCreditCard.
deleteCreditCard: takes in the user and the card of the user and removes the credit card, if the credit card or the user is not found then it returns false. 
generateReportAll: this returns all the reports that have occurred up till the current date.
generateReportByRange: this returns the reports between the two date arguments that are given. 
checkInReservation: This method makes it so the reservation status is checked In and the room becomes occupied by the user. 
checkOutReservation: This method makes it so the reservation status is checked out and the room becomes unoccupied.
loginUser: Takes in the username and password to verify that the user account works and returns the user information.
checkPrivilege: takes in the user and the account type to see what privileges the user has.
chargeUser: takes in the reservation argument and charges the user and puts the balance at 0. The method also changes the rooms guarantee boolean to true once the payment is complete. 
trigger6PM: when this method is called all the reservations that aren’t guaranteed will be deleted from the list of reservations. 

ProcessPayment:
processPayment: Given a credit card and an amount, if the amount is < 0 or the card given is null, then returns false, otherwise returns true.

Report:
Class Variables: Private ints to hold the number of reservations, number of single rooms reserved and number of double rooms reserved. Private double to hold the occupancy rate, and total revenue.
GenerateReportRange: Given the Hotel System, and Dates from and Date to, keeps track of the number of reservations, number of double rooms reserved, number of single rooms reserved, occupancy count, occupancy rate, and total revenue within that date range and returns that information in a report.
GenerateReportAll: Gets all reservations in the database, and keeps track of number of reservations, number of double rooms reserved, number of single rooms reserved, occupancy count, total revenue, and occupancy rate for all active reservations and returns the result in a report.
toString: String representation of report that shows all of the class variables labeled above.

Reservation:
Class Variables: variables to keep track of the dates for how long the reservation is, the room that is reserved to that room, the user that the reservation is reserved to, the rsvp ID, number of occupants in the reservation, number of nights that they will be staying, balance, the room cost, if it’s guaranteed or not, if the stay is finished, if the reservation has been checked in, and if the user is a no show (meaning they made the reservation but never checked in).
Constructor: Just initializes the above variables.
Validate Payment: calls on Process Payment to validate the payment.
toString: String representation of Reservation that shows all of the class variables in a readable format.

Room:
Class Variables: private int roomNumber, private boolean isOccupied, private boolean isDouble, private double price.
Constructor: initializes the room number, isDouble, price and sets isOccupied to false.
toString: String representation of Room that shows the class variables in a readable format.
ExecuteInstruction: Given an instruction, will print out the date, check to see which instruction exactly it is given, then execute it with the given information.

RSVPCoordinator:
Class Variables: Sets the current starting date to January 1, 2016, and holds a list of single rooms and double rooms.
Main: Adds 5 of each single room and double room. Basically, this method gets all data from the input file and parse it as an instruction. Then each instruction is passed to the executeInstructions() which will do the rest.
executeInstructions: This method does check what kind of instruction is made such as making a reservation, checking in a user, checking out a user, print management reports for single and all, trigger the day to go forward and also triggers 6pm method.
print: Just an alias for printing outputs.

User:
Class Variables: User has a user ID, account type (0 for user, 1 for staff, 2 for admin), username, password, full name, address1, address 2, city, state, zipcode, isBanned, list of credit cards (multiple credit cards can be put on one user, and their default card.
Constructor: initializes all of the class variables to the given information.
toString: String representation of User showing the user ID, user name, password, Full name and account type. 
