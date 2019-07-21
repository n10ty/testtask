Build image
===========
docker build --tag my_testtask .

To run test
===========
docker run my_testtask:latest /bin/sh -c "mvn test"

To run local from file
======================
cd pathfinder && mvn package && java -jar target/TestTask.jar maze.txt


To run local from stdin
=======================
cd pathfinder && mvn package && java -jar target/TestTask.jar < maze.txt


Performance
===========
Algorithm has linear operation complexity:
170k ~ 3.4s
85k ~ 1.1s
