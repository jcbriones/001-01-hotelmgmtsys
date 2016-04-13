# Hotel Reservation System
Project for CS321 - George Mason University
Section 001 | Group 01

#### Updated on: April 10, 2016

## Compiling:
- Run the Terminal(Unix) or Command Prompt(Windows).
- Go to the 'Java Files' directory.
- And then type `javac *.java` to compile the java files.
- And run RSVPCoordinator by running the command `java RSVPCoordinator input-file.txt`.


## Run down of the requirements of making reservation, checking-in, checking-out, and generating a report.
#### Reservations:
- Making a Reservation will succeed if the reservation details have the complete information it needs.
- Also, there should be no conflict of dates from other reservations.
- It checks the room as well if there is enough room that can be used for that reservation.
#### Check-In:
- Checking in a person should have a record in the database of his/her account.
- Checking in a person should have a reservation booked.
- Checking in a person should have a reservation that is not yet checked-in.
- Checking in a person should have a 0 balance and thus charge the user as well with the provided card or default card under the user's account.
#### Check-out
- Check out only if the user is checked-in.
- Checking out only if the user's record is also in the database.
#### Generate Report
- All Reports generated from a day, range, or all will only print out those reservations that are all paid and no balance left.
