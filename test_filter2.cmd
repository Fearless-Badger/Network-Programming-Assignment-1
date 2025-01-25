@echo off
move filter.properties  filter-save.properties
@echo ====  Source 1 10 10        Filter 20 1 0
java        Source 1 10 10 | java Filter 20 1 0
@echo:
@echo ====  Source 1 10 10        Filter 20 0 0
java        Source 1 10 10 | java Filter 20 0 0
@echo:
@echo ====  Source 2 10 10        Filter 20 2 0
java        Source 2 10 10 | java Filter 20 2 0
@echo:
@echo ====  Source 2 10 10        Filter 20 1 0
java        Source 2 10 10 | java Filter 20 1 0
@echo:
@echo ====  Source 3 10 10        Filter 20 3 0
java        Source 3 10 10 | java Filter 20 3 0
@echo:
@echo ====  Source 3 10 10        Filter 20 2 0
java        Source 3 10 10 | java Filter 20 2 0
@echo:
@echo ====  Source 4 10 5         Filter 5 6 0
java        Source 4 10 5  | java Filter 5 6 0
@echo:
@echo ====  Source 4 10 5         Filter 5 5 0
java        Source 4 10 5  | java Filter 5 5 0
@echo:
@echo ====  Source 4 10 5         Filter 5 4 0
java        Source 4 10 5  | java Filter 5 4 0
@echo:
@echo ====  Source 19 5 6         Filter 2 25 20
java        Source 19 5 6  | java Filter 2 25 20
move filter-save.properties  filter.properties
pause
