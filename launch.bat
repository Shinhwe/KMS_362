@echo off
@title MapleStoryv362
set CLASSPATH=.;dist\*
java -Xmx8192m -Dwzpath=wz\ server.Start
pause