---
layout: article
title: GIS - Raster Analysis and Geoprocessing
mathjax: true
show_edit_on_github: false
data_source: gis
---

# Objective

Identify the best locations in the City of Toronto for buying a house based on the following criteria: 

1. Close to a major grocery store
2. Close to Lake Ontario
3. In a neighbourhood with low amount of total difference in elevation
4. In a neighbourhood with high amount of vegetation 

# Methods

1. Discuss how areas close to major grocery stores were identified. 

The first step was to use the euclidean distance tool to find the distances from each of the grocery stores. I then used reclassify to classify the distances. Because we're talking about best neighbourhoods to buy houses, I chose to isolate only areas with good accessibility rather than to keep the low accessibility areas as well. As such, I gave distances between 0~1000 a value of 10 and for the rest of the areas, a value of NoData.

2. Discuss how areas close to Lake Ontario were identified. 

The first thing I did was to isolate Lake Ontario. To do this, I reclassified the NDVI file to isolate for the class with the lowest ranges of NDVI value - giving the isolating class a value of 10 and a value of NoData for the rest. I then used the tool Region Group to identify the clusters of bodies of water. I opted to use Queen's case because I wanted the most homogeneous regions I could get so rather than limiting myself to cells directly adjacent, I used Queen's case to connect cells connected diagonally as well. 
I then used Extract by Attributes to isolate for groups with count over 2000. The number 2000 was selected by manually checking the attribute table and identifying that any region groups with less than 2000 counts were insignificant and should be ignored. The reason why there were two region groups over 2000 was due to the smaller region group representing Waterfront, the area surrounded by the shoreline and Toronto islands - which should be included as Lake Ontario. 
Given that waterfront and the rest of Lake Ontario should be homogeneous, I reclassified the file to create a single class representing all of Lake Ontario. 
As for finding the neighbourhoods in proximity to Lake Ontario, I first began by using the Euclidean Distance tool with the distance set to 2000 metres. Since proximity to Lake Ontario is either for the view of the lake or proximity to lakeside trails when buying a house, I think 2 km was a reasonable choice. Similarly, I reclassified the distance data set to set all values equal to 10 regardless of distance away from lake - since we're only concerned with if the house is within 2 km of Lake Ontario. 

3. Discuss how areas with low amount of total difference in elevation were identified. 

The first tool used was the Focal statistics tool to find the variety statistic with a 10x10 rectangular neighbourhood. I chose 10 x 10 as I wanted as much information as possible about the nearby cells and felt that smaller settings (3x3, 5x5, etc.) weren't big enough when applied in real life. In other words, I felt that smaller settings was inadequate to show the elevation variance of the entire neighbourhood. 

4. Discuss how areas with high amount of vegetation were identified. 

First, I created a NDVI file using raster calculator with the formula: 
(Float("l7_band4") - Float("l7_band3")) / (Float("l7_band4") + Float("l7_band3")). 
I then used the Reclassify tool to isolate for classes with high NDVI values. From observing the classes, I decided to only isolate for the two highest classes (Values ranging from 0.495146 - 0.780952 and 0.377049 - 0.495146). I gave a value of 10 to the two highest classes and NoData for the rest of the classes. 
I decided to isolate for the two highest NDVI value ranges because when I tried to isolate for the highest range, there weren't many areas within the boundaries that fit the criteria. As such, although the lower bound and upper bound may have a noticeable difference, I felt that just isolating for the highest range didn't give enough areas that fit the criteria. Giving the value of NoData also helped with only keeping the valid areas and especially for removing the lakes from the NDVI raster data. 
I then used Region Group tool to clean up the NDVI values. I opted for 8 neighbors as I'm dealing with vegetation and it's not always patterned according to Rook's case. I then used Extract by Attributes to isolate for areas of vegetation of over 1500 - a number picked after reading the attribute table and determining that it's high enough to be considered relatively highly vegetated. 
Then I used Euclidean Distance tool to find the distances from vegetation cells. Finally, using the Reclassify tool, I set the values for distances < 1000 as 10 and NoData for rest. 

5. Discuss and explain your choices for weighted overlay. 

Given all the raster data (Distance to Grocery/Lake Ontario/Vegetation and Consistent Elevation), I decided to use an equal weighting for the criteria. This was because when buying a house, the factors are subjective to the buyer so I believe that an equal weighting would give the most objective results. 

# Discussion 

The final result shows that there are very small areas in Toronto that satisfies all four criteria. By examining individual criteria raster data, it's reasonable to not expect big areas that fit the criteria.
The grocery distance file shows that grocery shops are fairly well distributed across Toronto, with a specific focus to central Toronto - as expected.
The DEM distance file shows that southern parts of Toronto are quite inconsistent in its elevation while the northern parts are more consistent.
The NDVI distance file shows that there aren't a lot of vegetation in southern Toronto but rather in north-western part of Toronto. 
Finally, the Lake distance file is created to only show areas within 2km of Lake Ontario. 
As such, there are very little areas for overlapping of the four criteria. I think that if I changed the weights so that DEM and Lake distances are more heavily favored towards one than the other (i.e. Lake at 0.5 and DEM at 0.1 - or vice-versa), I think I can get a lot more areas fitting the criteria. This is because the difference between the two are most pronounced. Southern Toronto showed to have inconsistent elevation which isn't fitting of the criteria yet another criteria requires the area to be within 2 km of Lake Ontario. 
As a result, the final result showed small pockets of areas in South/South-Eastern/Eastern Toronto with nothing beyond these pockets. 
Looking back, I think my classification methods were quite strict and could be loosened so I can get more results fitting the four criteria. While the produced result may be helpful for the purpose of the map - identifying good areas for house purchasing - it may produce too little options. As such, I think it might be a good idea to loosen the restrictions a bit to have a wider range of areas fitting the criteria. (Eg. Extending distance from Lake Ontario to 5 km). 

# Model Builder Diagram

 Unfortunately, the diagram is illegible but I guess I'll keep it up. 

![Geocoding Map](https://yunkevin.github.io/assets/img/gis/figure-markdown_github/GGR273_Assignment_3_model.png)

# Final Map

Although we had to include the four maps at the top to show different layers indvidually, it is hard to interpret what areas the layers are showing. For context, all four layers were centered along the shoreline of Lake Ontario. 

![Geocoding Map](https://yunkevin.github.io/assets/img/gis/figure-markdown_github/GGR273_Assignment_3.jpg)