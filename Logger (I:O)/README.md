## Data Analysis

This project was part of a Queen's Computer Engineering Java course. 

A highly automated production facility has been having problems with one of its robots.  Dataloggers have been employed to obtain readings of currents drawn by seven different DC servomotors in the robot.  The datalogger records current readings every second for each of the seven motors.  It records the time and these readings (in amps) into a file for 1000 seconds at a time, at the request of the operator.

The senior engineer in charge of solving the problem has had the operators collecting much data.  Since he is far too busy to do anything with the data himself (and he can't program his way out a wet paper bag...), he has asked us to handle the data analysis for him. After speaking with the junior plant electrician, you find out that these motors do not draw more than one amp when they are not running, and that they do not run well if asked to draw more than 8 amps.  The motors spend most of their time not running, with a few spaced-out pulses of operation each of which is at fairly constant current.

An appropriate analysis of the data would consist of a report, in the form of one file for each motor, summarizing the motor operations.  We decide to list the average current and time of operation for each current pulse.  For example, the report for Motor 1 in the file Motor1.csv would contain the text:

start (sec), finish (sec), current (amps)
200, 259, 3.0
610, 639, 7.021
950, 959, 2.028

The top line contains the column headers. The current listed is the average current over the time the motor is running for a single pulse. The report would also indicate if a motor did not run at all over the entire logged interval by just listing "Not used." in the file, and it would make a special note of any currents over 8 amps, with the phrase: ", ***Current Exceeded***" appended to the end of the applicable line. Currents should not be recorded to more than three significant digits after the decimal point.

A data sample of 1000 lines (one line per second) is contained this comma-delimited text file, "Logger.csv".  The file consists of 1000 sets of eight numbers.  The first number of each set is an int value for the time, which starts at zero and ends at 999 seconds for the last set of data.  The other 7 numbers are double values of current, one number each for Motors 1 to 7. We can assume that no motor will be running at time 0 and at time 999 seconds. We can assume that the data file will contain 1000 lines exactly, with each line consisting of 8 numbers separated by commas, as described above.

If we catch an exception then it is sufficient to just end your program after displaying an error message.
