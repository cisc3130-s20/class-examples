#! /bin/bash

# This file shows example of using linux commands to extract information from a csv file.
# It is not a perfect solution.
# It may confuse rows with more or less commas.

# The data comes from Spotify Charts https://spotifycharts.com/


# Extract Artists column from the csv file
cat regional-us-weekly-2020-01-17--2020-01-24.csv | cut -d ',' -f3 | tr -d '"' > cat_artists_us.txt

# Extract Artists column from the csv file
cat regional-global-weekly-2020-01-17--2020-01-24.csv | cut -d ',' -f3 | tr -d '"' > cat_artists_global.txt

# Using awk
awk -F "," '{print $3 }' regional-us-weekly-2020-01-17--2020-01-24.csv | tr -d '"' > temp.txt && (head -n 2 temp.txt && tail -n +3 temp.txt | sort | uniq) > awk_artists_usSorted.txt

# using sed
sed 's/"//g' regional-us-weekly-2020-01-17--2020-01-24.csv | awk 'BEGIN {FS=","} ; {print $3}' > sed_artists.txt
