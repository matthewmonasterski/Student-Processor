
# StudentProcessor
## Overview
**StudentProcessor** is a Java program designed to read and analyze student performance data from a CSV file. The program includes a console-based interface where users can select options to view information about student scores, totals, pass/fail statistics, and other metrics.

## Features
The program provides the following functionalities:

- **Student Base Data: Displays each student's name, ID, total score, and percentage.
- **Total Score Calculation: Outputs the total score for each student.
- **Percentage Calculation: Calculates and displays the percentage score of each student.
- **Top Ten Students: Lists the top ten students based on total scores.
- **Pass/Fail Count by Subject: Shows the count of students who passed or failed in each subject.
- **Fail Count by Subject: Indicates the number of students who failed each subject.
- **Pass Percentage by Subject: Provides the pass percentage for each subject.
- **Students Failing More Than Two Subjects: Identifies students who failed more than two subjects.
- **Exit: Allows the user to exit the program.
How It Works
Data Import
The program reads student data from random_students_data.csv, which should be located in the studentProcessor directory. The file format is as follows:

- **Format: Comma-separated values (CSV)
- **Fields: Student ID, First Name, Last Name, Science Score, History Score, Mathematics Score, English Score
- **Example line in random_students_data.csv:

csv
Copy code
1234,John,Doe,75,82,68,90
Data Processing
The ReadStudents class is responsible for importing data from the CSV file. Here’s a breakdown of how it works:

File Reading: Using a Scanner, the program reads each line from the file.
Parsing Data: For each line, it extracts the individual fields (ID, name, scores) and stores them in arrays:
studentId stores IDs.
firstName and lastName store student names.
scienceScore, historyScore, mathematicsScore, and englishScore store subject scores.
Error Handling: If the file cannot be found or read, an error message is displayed.
The ReadStudents class provides getter methods (e.g., getStudentId(), getScienceScore()) to access these arrays, which the main processor class uses for data processing.

Processing and Calculating Results
The Processor class contains various methods to handle student data and output different results based on user menu selection:

ReqOne(): Calculates and displays student names, IDs, total scores, and percentage scores.
ReqTwo(): Outputs the total score of each student.
ReqThree(): Calculates the percentage score for each student.
reqfour(): Sorts and displays the top ten students based on their total scores.
Pass/Fail Methods (sciencepass(), mathpass(), etc.): Counts students passing each subject.
calcPercent(): Calculates the pass percentage for each subject.
failures(): Counts the students who failed more than two subjects.
Console-Based User Interface
The program uses a console-based menu to interact with users. Upon running the program, users are presented with a list of options. They can select an option by entering the corresponding number. For example:

Selecting "1" displays all student data.
Selecting "4" lists the top ten students.
Selecting "9" exits the program.
Each option calls a corresponding method in the Processor class to output the required information.

Installation and Usage
Clone the Repository:
bash
Copy code
git clone https://github.com/yourusername/StudentProcessor.git
Prepare the CSV File: Ensure random_students_data.csv is located in the studentProcessor directory and formatted correctly.
Compile and Run:
bash
Copy code
cd StudentProcessor
javac -d . *.java
java studentProcessor.processor
Requirements
Java 8 or later
random_students_data.csv file with appropriate student data
Example Output
When running the program, users might see outputs like:

yaml
Copy code
Options:
1- student base data
2- student total sum
3- total percentage
...
Enter option number:

Top ten students:
1. John Doe, ID: 1234, Total Score: 315
2. Jane Smith, ID: 5678, Total Score: 310
...
