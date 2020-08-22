---
layout: article
title: Digitizing and Topology
mathjax: true
show_edit_on_github: false
data_source: gis
tag: GIS
---

# Objective 

Create a map of University of Toronto - St. George Campus including the following:

* Polygons for 5 buildings on campus
  * Attribute table for the 5 buildings including name and year it was built
* Walking routes, as lines, from:
  *  Sidney Smith Building to the closest entrance of St. George Subway Station
  *  Sidney Smith Building to the closest entrance of Queen's Park Subway Station
  *  Sidney Smith Building to the closest entrance of Victoria College
* 5 places to eat on campus, with label
* Polygons for front & back campus and Queen's Park using streaming
* Polygon for Varsity Stadium

# Methods

I first created a topology for the given land use file. After connecting to the unzipped folder, I created a new geo-database so I could create a new feature dataset. When creating a topology for the land use file, I followed the instructions given in the assignment – default rank value of 1 and the two rules about having no overlaps or gaps. 
Similarly, I followed the instructions to remove the overlaps and gaps through editing the vertices. One issue that I ran into was after moving the vertices to remove the gap or the overlap, it would create a minuscule overlap along the boundaries of the polygon. I decided to solve the issue by merging those minuscule areas of overlap with the polygons to avoid error. 
As for the streaming, I first tried out streaming with default settings on Queen’s Park. And given the results, I decide to stick with the default settings as the result turned out pretty nicely. However, I do think that I should have made the settings a little less sensitive because for polygons without a boundary set by the ONrte_photo file, I found that my hands weren’t steady enough to draw the polygon as neatly as I would have liked to. However, I think that the polygon drawn for the Back Campus was still acceptable despite the streaming settings being a bit too sensitive for me. Nevertheless, because the boundaries were set using the ONrte_photo file, it was quite easy to outline the polygons using streaming. 
The boundary definition, and positional definition, was quite difficult to pin-point for buildings and places to eat on campus. For example, buildings like the Convocation Hall and Sir Sandford Fleming Building are connected to other buildings. In cases like this, I tried my best to identify the boundaries of the polygon based on the given satellite images. Similarly, it was difficult to pin-point exact positions of places to eat on campus – especially the ones within a building like Tim Hortons or Starbucks in the Medical Sciences Building. In cases like this, I also tried my best by using both satellite images and my personal experiences to extrapolate where the position of these restaurants may be. 
Lastly, for finding the routes to the nearest entrances of the subways stations and Victoria College, I decided to draw along the ONrte_photo file and only use defined roads to draw the routes. I could have used smaller trailers on campus that are not defined by the ONrte_photo file but I decided that it could create errors given the unclarity of the satellite images. For example, if I was going from Sidney Smith Hall to Victoria College, I’d mostly likely make my way to Front Campus towards Hart House and walk along Queen’s Park instead of going north and then turning right in front of Robarts Library. However, because the small roads on the campus weren’t outlined, I decided to ignore those possibilities. 

# Final Map

![Geocoding Map](https://yunkevin.github.io/assets/img/gis/figure-markdown_github/GGR273_Assignment_4.jpg)