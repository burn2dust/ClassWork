
PROJECT TITLE: Lab 10

SHARE'S DRIVE: Nicholas Kaide


PURPOSE OF PROJECT:
 
	The purpose of this project is to sort the numbers
based on their value in the linked list. The way that we
went about this is by starting off with a random list of
numbers between 0 and 200,000 (or whatever size that you 
want). The program is as worse as a Big O case.

VERSION or DATE: 1.0.0

HOW TO START THIS PROJECT:


AUTHORS: Nicholas Kaide and Renan Custodio

USER INSTRUCTIONS:
 Run the program in main and watch it go.
This program will take a random array of numbers and sort
based on the values.

_______________________________________________________

PROBLEMS THAT ARRIVED:

first problem...
- this code does not work:
if (current != firstOutOfOrder) {
  // insert firstOutOfOrder between current and trail current
  // here   \/ are the problems.
  lastInOrder.next = firstOutOfOrder.getNext();
  firstOutOfOrder.next = current;
  trailCurrent.next = firstOutOfOrder;
} // end if

the problem right now is that .next is requiring a variable
and with .getNext is returning a value.


Second Problem...
- Node firstOutOfOrder may have not been initiallized


SOLUTIONS

...to first problem
- .setNext(NODE) (NODE can be something.getNext())
 
...to second problem
- firstOutOfOrder = first;