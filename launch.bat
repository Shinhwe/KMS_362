@echo off
@title MapleStoryv362
set PATH=.;jdk1.8.0_333\bin;%PATH%
set CLASSPATH=.;dist\*
java -Xmx8192m -Dwzpath=wz\ server.Start
pause