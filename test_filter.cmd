@echo off
move filter.properties  filter-save.properties
@echo ==== columns=3, spacing=10, groups=0 ^(defaults^)> test_filter_results.txt
java Filter  < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
move filter-save.properties  filter.properties
@echo ==== columns=5, spacing=9, groups=12 ^(properties^)>> test_filter_results.txt
java Filter  < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
@echo ==== columns=7, spacing=9, groups=12 ^(properties, env var^)>> test_filter_results.txt
set CS336_COLUMNS=7
java Filter  < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
@echo ==== columns=8, spacing=9, groups=15 ^(cmd-line, env vars^)>> test_filter_results.txt
set CS336_GROUPS=15
java Filter  8  < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
@echo ====  columns=6, spacing=8, groups=20 ^(cmd-line^)>> test_filter_results.txt
java Filter  6  8  20  < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
@echo ==== columns=3, spacing=15, groups=0 ^(default, env var^)>> test_filter_results.txt
move filter.properties  filter-save.properties
set CS336_COLUMNS=
set CS336_GROUPS=
set CS336_SPACING=15
java Filter < data.txt >> test_filter_results.txt
@echo:>> test_filter_results.txt
set CS336_SPACING=
move filter-save.properties  filter.properties
pause
