#! /usr/local/bin/python3

# Note that the location specified above is for python3 installed via brew


# Example to show parsing with python
# This is not a perfect solution

# Use the csv parsing library
import csv

f1 = "regional-us-weekly-2020-01-17--2020-01-24.csv"

artists = []        # empty array to catch artist names

with open(f1, 'r') as csvfile:
  data = csv.reader(csvfile, delimiter=',', quotechar='"')
  for line in data:
      if line[2] == " ":
        pass
      if line[2]  == "Artist": pass
    # print(line[2])    # prints 3rd col
      artists.append(line[2])

#deduplicate list
artistsFreq = {}   # empty dict to catch artist names and count occurrences

for name in sorted(artists):
  if name in artistsFreq:
    artistsFreq[name] += 1
  else:
    artistsFreq[name] = 1

for key, value in artistsFreq.items():
  print('{:^27}'.format(key) , ' \t  ' , value)
