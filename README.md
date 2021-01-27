# JournalLogger - JavaFX Application
I made this app for logging journal entries for labs in CIT 496P (CSUN)

### Prerequisites
- JDK 15
- JavaFX 15 https://gluonhq.com/products/javafx/

### How to use
1. Edit journal_logger_launcher.bat. Replace the path inside the quotations with the path to the javafx lib folder on your computer.
> Example: "E:\openjfx-15.0.1_windows-x64_bin-sdk\javafx-sdk-15.0.1\lib"
2. Launch app by double clicking journal_logger_launcher.bat
3. Input Lab #, Date, Hours Completed, and Journal Entry
4. Press "SUBMIT" to save to txt file
5. Txt files are saved in folder /journalEntryData
6. Press "DISPLAY FILE LIST" to show saved files
> Note: Files in list are not clickable yet. Will set that up later
7. Files are saved in folder named "journalEntryData". Folder is created when program starts, and will be located in the project directory.
