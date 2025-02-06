# Repo content

This assignment has me build a filter. My work can be viewed in the "Filter.java" file. It takes input from stdin, and provides its output to stdout. The program acts as a filter, where it processes its input and provides its output continuously. 

A mistake I made when first implementing this filter, was storing the input in a list, before proceeding with processing it. This means that the filter wouldn't actually act as a filter, but it would demand all the input before proceeding. 

I fixed this problem, by ensuring that the data is immediately processed and printed to stdout. This change also reduces the space that the program requires. 