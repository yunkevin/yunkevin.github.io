---
layout: article
title: Geocoding
mathjax: true
show_edit_on_github: false
data_source: gis
tag: GIS
---

# Objective
1. Identify schools in Toronto that meet all of the following criteria: 
   * Within 1 km of a drinking establishment 
   * Within 1 km of a liquor store
   * In a census tract that is in the highest of the four quantiles for population density of people aged 15-19

2. Create a map that shows the following: 
   * Schools meeting the criteria 
   * Drinking establishments 
   * Liquor stores 
   * All census tracts shown as a chloropleth of population density of people aged 15-19 using four quantile classes 

# Introduction

The purpose of the assignment was to use a geographic information system (GIS) and our understanding of geocoding and vector analysis to identify schools that are more likely to have underage drinkers. The results of the analysis could be used by the police to enforce a stricter regulation on selling alcohol to underage children. The information is crucial in identifying schools that are more likely to have underage drinking in order to reduce the chances of addiction and negative health impacts. The proximity to drinking establishments and liquor shops are important in measuring the accessibility of alcohol to the students. And the population density acts a proxy to identify census tracts with a high number of teenagers who could access the nearby drinking establishments and liquor shops. 

# Methods

1. The first step of the assignment was to create an address locator. The style used was a US Dual Range as I must consider both sides of the street. The reference data used was Roads with the field map changed as instructed on the assignment instructions. 

2. Then, I used the address locator with default settings to geocode the Schools table. This was because all the fields matched up and would accomplish exactly what I would need. The result of geocoding was a 96% match rate. The remaining 4% unmatched addresses were matched through manual entry to the best of my ability. 

3. The next step was to geocode the liquor stores based on the Liquor Store table. The table was joined to Postal Codes based on POST_CODE field. Only matching records were kept as I was looking for an inner join – to only keep the addresses of liquor stores, not all postal codes. 

4. Then, I created a buffer of 1 km from each liquor store and drinking establishment. This allowed me to identify areas within 1 km of drinking establishments and liquor stores to be used later in the analysis. 

5. I began by intersecting the two buffers to create a new polygon which indicated regions that were within 1 km of both liquor stores and drinking establishments. By using Dissolve tool, I was able to erase the boundaries and create a single homogenous buffer. The choice to use the Dissolve tool was because I am not concerned finding schools within 1 km of specific drinking establishments or liquor stores. Since I was more interested in finding schools within 1 km of any drinking establishments or liquor stores in general, it made sense to make all the buffers as a single uniform polygon rather than multiple separate polygons.  This resulted in a single polygon file that had both requirements – within 1 km of drinking establishments and within 1 km of liquor stores. 

6. With this newly created buffer, I used Spatial Join between the geocoded location of schools (Target feature) and the newly created buffer (Join feature). An important parameter that I made sure to uncheck was “Keep All Target Features” – since I am looking for specific schools that are within the buffer, not a list of all points. From this, I was able to get all schools that fit both requirements 

7. I looked to download the Census Tract Population Data from CHASS. This population data is planned to be used in conjunction with CT_Toronto_2011 in order to find the population density of people aged between 15 and 19 by census tracts. I’ve also included census tract name which proved to be useful when joining tables and features later in the analysis. The specified census tract population data was downloaded as dBase and imported into ArcMap. 

8. In order to find the population density of people aged 15 to 19, the table was joined to CT_Toronto_2011 by their census tract names. I then added a new field named Population Density of the type double. Using a field calculator, I calculated the population density of people aged 15 to 19 in each census tract. 

9. I found the ranges of population density of the highest quantile (0.000436 ~ 0.003134) and selecting rows that fit the condition. I then exported those rows as a dBase table to create a separate table. I then duplicated the CT_Toronto_2011 file and joined it with the exported table – once again only keeping matching rows to achieve inner join. The original CT_Toronto_2011 was not used in order to use it for the final mapping. From this step, I got a feature class containing only the census tracts in the highest quantile for population density. 

10. By spatially joining the schools with accessibility with the newly created census tract, I found schools that fit all three requirements. 

# Discussion
The purpose of the assignment was to use a geographic information system (GIS) and our understanding of geocoding and vector analysis to identify schools that are more likely to have underage drinkers. The final map indicates locations of schools that are nearby drinking establishments and liquor stores in census tracts with high number of teenagers. The map is useful in identifying which schools both have high accessibility to alcohol and a high number of teenagers. The only difficult found in this assignment was the address matching after geocoding – since some of the address were difficult/impossible to find. Thus, the final map addresses the problem by identifying schools with high alcohol accessibility and high number of teenagers. 

# Final Map

![Geocoding Map](https://yunkevin.github.io/assets/img/gis/figure-markdown_github/GGR273_Assignment_1.jpg)