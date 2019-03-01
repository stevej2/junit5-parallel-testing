To reprouce the error, you just need to run "mvn clean install".

Here is an example output:
[INFO] --- maven-surefire-plugin:3.0.0-M3:test (default-test) @ parallel.test ---

[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TagTypeTests
[INFO] Running TagTests
testTag4
testTag1
testTag2
testTag3
testTagType1
testTagType6
testTagType2
testTagType4
testTagType3
testTagType5
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 s - in TagTests

[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.029 s - in TagTypeTests

[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
