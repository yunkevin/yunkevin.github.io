---
layout: article
title: Remote Sensing
mathjax: true
show_edit_on_github: false
data_source: gis
---

# Objective
Create a set of four maps on one page
1. Pan-sharpened image showing Landsat bands 4,3,2 (Upper Left)
2. Pan-sharpened image showing IKONOS bands 4,3,2 (Upper Right)
3. Landsat band 6, using colour ramp "Spectrum-Full Light" shown inverted and using the DRA option (Lower Left)
4. NDVI based on Landsat 7 bands 3 and 4 

# Introduction 
Due to the assignment format being in a quiz format, there are no write-ups for the methods section. However, the responses to some of the questions will be posted under discussion. And unfortunately, there aren't any screenshots to accompany the responses. 

# Discussion

Q. *Examine the NDVI output, and describe what it shows, making sure to mention the meaning of the different colours and how you think they relate to general land cover characteristics.*

A. The result of the NDVI layer shows primarily four colours - Dark Orange, Light Orange, Light Green and Dark Green.
Areas of dark orange indicates heavy vegetation, light orange for light vegetation/light urban, light green for urban areas and dark green for bodies of water. We also note that areas with high NDVI values are areas in the green while areas in orange generally have lower NDVI value.
Because NDVI takes into account both Band 3 and 4, it allows us to differentiate areas of vegetation, urban infrastructure and bodies of water.

Q. *Change the l7_band6 symbology to the colour ramp called “Spectrum- Full Light” Check the box to Invert, and then click Apply. How is this band different from the other bands in terms of what is being sensed?*

A. Band 6 is the thermal infrared band, meaning it senses the land surface temperatures. The range of values of band 6 goes from blue(indicating low temperature) to red (indicating high temperature). So Lake Ontario has the lowest temperature according to Band 6 as indicated by the deep blue. The ravines and small areas of vegetation are indicated as having relatively low temperature with light blue. The majority of the urban area are colored yellow to show relatively high surface temperature. Lastly, there are few neighborhoods/areas indicated in red which means high surface temperature.

Q. *Use the Swipe tool to swipe back and forth between the NDVI layer and the l7_band6 layer. Describe the general relationship you see between the two layers, and explain what might be causing this relationship to exist.*

A. Although not perfect, the areas of vegetation seem to be pretty similar. For example, the red areas indicating vegetation in the NDVI layer is quite similar to areas of relatively low temperature in the I7_band6 layer. Conversely, areas indicated in blue in the NDVI layer seem to correlate with areas of relatively high/high temperatures in the band 6 layer. Of course, there are some areas that are the exception to this trend but as a whole, there is definitely a relationship between areas of vegetation and surface area temperature.

Q. *Use the Swipe tool to compare the IKONOS panchromatic band to the IKONOS near infrared band. Describe the difference in spatial resolution by providing two examples of the smallest types of objects that you can identify with each image.*

A. In the near infrared band, I am able to see pixels indicating the cars on the road. However, in the panchromatic band, the cars appear as tiny dots which I initially thought of as part of being a grainy image texture. As a whole, the band 4 image was much easier to identify roads - especially small ones in residential areas. I found that in band 5, it was difficult to identify roads in dense residential areas - i.e. In that if the roads were actually there or if it was just the clusters of houses that appeared to create a road-like feature.

# Final Map
![Geocoding Map](https://yunkevin.github.io/assets/img/gis/figure-markdown_github/GGR273_Assignment_2.jpg)