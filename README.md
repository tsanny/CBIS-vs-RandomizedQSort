# Clustered Binary Insertion Sort Analysis

## Overview
This repository hosts the implementation and experimental analysis of the Clustered Binary Insertion Sort (CBIS), a novel sorting algorithm proposed to improve efficiency over traditional Binary Insertion Sort by reducing the number of comparisons and shifts required during the sorting process. CBIS clusters nearly identical elements before insertion, significantly enhancing performance on pre-sorted datasets.

## Experiment
The analysis compares memory usage and execution time between CBIS and Randomized Quicksort across arrays of varying sizes (small, medium, and large) and conditions (randomly sorted, reverse sorted). Results indicate CBIS performs well on pre-sorted data but shows performance decline on randomly sorted and reverse sorted arrays, especially as dataset size increases.

## Conclusion
Despite theoretical claims of average and worst-case time complexities of O(n log n), practical tests reveal CBIS underperforms compared to Randomized Quicksort in certain conditions, highlighting its best-case potential near O(n) but significant efficiency drop for non-pre-sorted data.

## Usage
- Generate random test cases by running `tc.py`
- Run both algorithms against the generated test cases by running `tester.java`

## Reference
For more on the underlying theory and methodology, see the research paper "Brownian Motus and Clustered Binary Insertion Sort: An efficient progress over traditional methods" by Shubham Goel and Ravinder Kumar, Future Generation Computer Systems, 86, pp. 266–280.
