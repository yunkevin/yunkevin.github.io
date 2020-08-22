---
layout: article
title: Multiple Regression Analysis
mathjax: true
show_edit_on_github: false
data_source: stats
tag: Statistics
---

Libraries
=========

``` r
library (ggplot2)
library (dplyr)
library(ggcorrplot)
library(ggpubr)
library(lubridate)
library(data.table)
library(ggrepel)
library(tidyverse)
library (ggmap)
library (glmnet)
```

Data Import & Cleaning
======================

``` r
# Reading Dataset
housing <- read.csv ("/Volumes/Macintosh\ HD\ -\ Data/RWorkspace/kc_house_data.csv")

# Data Cleaning
housing$date <- NULL
housing$id <- NULL
housing$sqft_living15 <- NULL
housing$sqft_lot15 <-NULL

# Splitting Up Dataset 
index = sample (1:nrow (housing), 0.8 * nrow (housing))
housing_train = housing [index,]
housing_test = housing [-index,]
```

The dataset is about house prices in King County, Washington State, USA
between May 2014 and May 2015. It also includes areas in Seattle.
Detailed information about the dataset can be found in the data source
link below. The aim of the project is to create models to predict future
house prices given various factors that affect house prices. I will be
creating multiple regression models and determine which model would best
fit the given dataset.

Data Source:
<a href="https://www.kaggle.com/swathiachath/kc-housesales-data" class="uri">https://www.kaggle.com/swathiachath/kc-housesales-data</a>

Overview of Data
================

Data Summary
------------

``` r
head (housing_train)
```

    ##        price bedrooms bathrooms sqft_living sqft_lot floors waterfront view
    ## 8006  550000        4      2.00        2070     9822      1          0    0
    ## 11633 948000        3      2.50        3510     9824      2          0    0
    ## 13323 440000        3      1.75        1640     8529      1          0    0
    ## 3565  372220        3      1.00        1290     5500      1          0    0
    ## 41    625000        4      2.50        2570     5520      2          0    0
    ## 14087 600000        4      2.50        3010     7953      2          0    0
    ##       condition grade sqft_above sqft_basement yr_built yr_renovated zipcode
    ## 8006          5     7       2070             0     1955            0   98006
    ## 11633         3     9       3510             0     2002            0   98075
    ## 13323         5     7       1640             0     1951            0   98155
    ## 3565          3     7        980           310     1951            0   98136
    ## 41            3     9       2570             0     2000            0   98074
    ## 14087         3     9       3010             0     2000            0   98056
    ##           lat     long
    ## 8006  47.5660 -122.140
    ## 11633 47.5635 -122.032
    ## 13323 47.7751 -122.320
    ## 3565  47.5266 -122.392
    ## 41    47.6145 -122.027
    ## 14087 47.5220 -122.190

``` r
summary (housing_train)
```

    ##      price            bedrooms        bathrooms      sqft_living   
    ##  Min.   :  80000   Min.   : 1.000   Min.   :0.500   Min.   :  370  
    ##  1st Qu.: 324950   1st Qu.: 3.000   1st Qu.:1.500   1st Qu.: 1420  
    ##  Median : 450000   Median : 3.000   Median :2.250   Median : 1920  
    ##  Mean   : 543013   Mean   : 3.374   Mean   :2.117   Mean   : 2085  
    ##  3rd Qu.: 648000   3rd Qu.: 4.000   3rd Qu.:2.500   3rd Qu.: 2560  
    ##  Max.   :7060000   Max.   :33.000   Max.   :8.000   Max.   :13540  
    ##     sqft_lot           floors        waterfront            view       
    ##  Min.   :    520   Min.   :1.000   Min.   :0.000000   Min.   :0.0000  
    ##  1st Qu.:   5038   1st Qu.:1.000   1st Qu.:0.000000   1st Qu.:0.0000  
    ##  Median :   7620   Median :1.500   Median :0.000000   Median :0.0000  
    ##  Mean   :  15440   Mean   :1.494   Mean   :0.007756   Mean   :0.2378  
    ##  3rd Qu.:  10720   3rd Qu.:2.000   3rd Qu.:0.000000   3rd Qu.:0.0000  
    ##  Max.   :1651359   Max.   :3.500   Max.   :1.000000   Max.   :4.0000  
    ##    condition         grade          sqft_above   sqft_basement   
    ##  Min.   :1.000   Min.   : 4.000   Min.   : 370   Min.   :   0.0  
    ##  1st Qu.:3.000   1st Qu.: 7.000   1st Qu.:1190   1st Qu.:   0.0  
    ##  Median :3.000   Median : 7.000   Median :1560   Median :   0.0  
    ##  Mean   :3.405   Mean   : 7.665   Mean   :1793   Mean   : 291.9  
    ##  3rd Qu.:4.000   3rd Qu.: 8.000   3rd Qu.:2220   3rd Qu.: 560.0  
    ##  Max.   :5.000   Max.   :13.000   Max.   :9410   Max.   :4820.0  
    ##     yr_built     yr_renovated        zipcode           lat       
    ##  Min.   :1900   Min.   :   0.00   Min.   :98001   Min.   :47.16  
    ##  1st Qu.:1951   1st Qu.:   0.00   1st Qu.:98033   1st Qu.:47.47  
    ##  Median :1975   Median :   0.00   Median :98065   Median :47.57  
    ##  Mean   :1971   Mean   :  85.71   Mean   :98078   Mean   :47.56  
    ##  3rd Qu.:1997   3rd Qu.:   0.00   3rd Qu.:98118   3rd Qu.:47.68  
    ##  Max.   :2015   Max.   :2015.00   Max.   :98199   Max.   :47.78  
    ##       long       
    ##  Min.   :-122.5  
    ##  1st Qu.:-122.3  
    ##  Median :-122.2  
    ##  Mean   :-122.2  
    ##  3rd Qu.:-122.1  
    ##  Max.   :-121.3

Visualization of Data
---------------------

``` r
# Correlation Plot
correlation <- cor(housing_train)
ggcorrplot(correlation, outline.color = "white", colors = c("#6D9EC1", "white", "#E46726")) + 
  labs (title = "Correlation Between Variables",
        subtitle = "Housing Price Dataset")
```
![Correlation Plot](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-4-1.png)

From the heatmap, we can see that the variable price tends to have high
correlation with sqft\_living and grade. In general, most of the
variables in the dataset are somewhat correlated to the house prices.
However, variables such as sqft\_lot, condition, and yr\_built are
evidently less correlated than other variables.

``` r
# Distributino of Each Variable
bedroom_plot <- ggplot(housing_train, aes(x = factor(1), y = bedrooms)) + 
  geom_boxplot() + 
  theme_minimal()

bathroom_plot <- ggplot(housing_train, aes(x = factor(1), y = bathrooms)) + 
  geom_boxplot() + 
  theme_minimal()

sqliving_plot <- ggplot(housing_train, aes(x = factor(1), y = sqft_living)) + 
  geom_boxplot() + 
  theme_minimal()

floors_plot <- ggplot(housing_train, aes(x = floors)) + 
  geom_bar() + 
  theme_minimal()

waterfront_plot <- ggplot(housing_train, aes(x = waterfront)) + 
  geom_bar() + 
  theme_minimal()

view_plot <- ggplot(housing_train, aes(x = view)) + 
  geom_bar() + 
  theme_minimal()

condition_plot <- ggplot(housing_train, aes(x = condition)) + 
  geom_bar() + 
  theme_minimal()

grade_plot <- ggplot(housing_train, aes(x = grade)) + 
 geom_bar() + 
  theme_minimal()

sqabove_plot <- ggplot(housing_train, aes(x = factor(1), y = sqft_above)) + 
  geom_boxplot() + 
  theme_minimal()

yrbuilt_plot <- ggplot(housing_train, aes(x = factor(1), y = yr_built)) + 
  geom_boxplot() + 
  theme_minimal()

ggarrange(bedroom_plot, bathroom_plot, nrow = 1, ncol = 2)
```

![plot_1](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-5-1.png)

``` r
ggarrange(sqliving_plot, floors_plot, nrow = 1, ncol = 2)
```

![plot_2](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-5-2.png)

``` r
ggarrange(waterfront_plot, view_plot, nrow = 1, ncol = 2)
```

![plot_3](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-5-3.png)

``` r
ggarrange(condition_plot, grade_plot, nrow = 1, ncol = 2)
```

![plot_4](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-5-4.png)

``` r
ggarrange(sqabove_plot, yrbuilt_plot, nrow = 1, ncol = 2)
```

![plot_5](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-5-5.png)

Here, I illustrated the distribution of each variables either through a
bar graph or a box plot. It’s clear from the box plots that there are
quite a number of outliers for many variables. For the variable
sqft\_living, we see that there are numerous outliers with signficant
differences to the mean. For the variable grade, the distribution looks
relatively similar to a normal distribution, with a slight skew to the
right.

``` r
# Setting Up Basic Map
sea_bb <- c(left = -122.5190,
            bottom = 47.1622,
            right = -121.3150,
            top = 47.7776)
seattle_map <- get_stamenmap(bbox = sea_bb, zoom = 10, maptype = "toner")

# Distribution of Houses 
ggmap(seattle_map) + 
  stat_density2d(data=housing_train, 
                 aes(x=long, y=lat, fill=..level.., alpha=..level..), 
                 geom="polygon", 
                 size=0.01, 
                 bins=20) +
  scale_alpha(range=c(0.2, 0.4), guide=FALSE) +
  labs(title = "Distribution of Houses in King County, WA, USA",
       subtitle = "Housing Price Dataset")
```

![dist_heatmap](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-6-1.png)

``` r
# Heatmap of House Prices
ggmap(seattle_map) +
  stat_summary_2d(data = housing_train, aes(x = long, y = lat, 
        z = price), fun = mean, alpha = 0.5, bins = 30) +
    scale_fill_gradient(name = "Price", low = "green", high = "red") +
  labs (title = "Housing Price Heatmap of King County, WA, USA", 
        subtitle = "Housing Price Dataset")
```

![price_heatmap](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-6-2.png)

This is a geographic heat map showing the distribution of houses and
areas of high house prices in the regions covered by the dataset. From
the first heat map, it’s evident that the majority of houses are
concentrated in the region slightly north of Seattle. The general trend
appears to be that houses are mostly concentrated in areas near bodies
of water. And as you move further away from water, the houses become
more and more dispersed.

We can see that in general, house prices are generally higher in the
northern parts of the map. The region with the highest housing prices is
just north of Bellevue. In general, the housing prices tend to be higher
in areas that are near a body of water and in the northern part of the
study area.

For clarification, the areas in black indicate bodies of water while
shades of grey indicates land based on altitude.

Analysis
========

Model Building
--------------

``` r
# Removing Unwanted Columns
housing_train$zipcode <- NULL
housing_train$lat <- NULL
housing_train$long <- NULL
housing_train$sqft_basement <- NULL

housing_test$zipcode <- NULL
housing_test$lat <- NULL
housing_test$long <- NULL
housing_test$sqft_basement <- NULL
```

``` r
# Multiple Regression
housing_full_mod = lm(price ~ .,  data = housing_train)
summary(housing_full_mod)
```

    ## 
    ## Call:
    ## lm(formula = price ~ ., data = housing_train)
    ## 
    ## Residuals:
    ##      Min       1Q   Median       3Q      Max 
    ## -1286009  -110549    -9578    90040  4145447 
    ## 
    ## Coefficients:
    ##                Estimate Std. Error t value Pr(>|t|)    
    ## (Intercept)   6.220e+06  1.563e+05  39.790  < 2e-16 ***
    ## bedrooms     -3.820e+04  2.264e+03 -16.874  < 2e-16 ***
    ## bathrooms     4.560e+04  3.958e+03  11.520  < 2e-16 ***
    ## sqft_living   1.704e+02  5.174e+00  32.932  < 2e-16 ***
    ## sqft_lot     -2.270e-01  3.910e-02  -5.806 6.50e-09 ***
    ## floors        2.391e+04  4.204e+03   5.687 1.31e-08 ***
    ## waterfront    6.337e+05  2.072e+04  30.590  < 2e-16 ***
    ## view          4.348e+04  2.520e+03  17.255  < 2e-16 ***
    ## condition     1.873e+04  2.825e+03   6.630 3.45e-11 ***
    ## grade         1.262e+05  2.429e+03  51.958  < 2e-16 ***
    ## sqft_above   -1.381e+00  4.981e+00  -0.277    0.782    
    ## yr_built     -3.590e+03  8.013e+01 -44.798  < 2e-16 ***
    ## yr_renovated  1.839e+00  4.388e+00   0.419    0.675    
    ## ---
    ## Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1
    ## 
    ## Residual standard error: 217600 on 17264 degrees of freedom
    ## Multiple R-squared:  0.6566, Adjusted R-squared:  0.6563 
    ## F-statistic:  2751 on 12 and 17264 DF,  p-value: < 2.2e-16

``` r
# Stepwise Regression
housing_step_mod = step(lm(price~., data = housing_train), direction = "both")
```

    ## Start:  AIC=424699.8
    ## price ~ bedrooms + bathrooms + sqft_living + sqft_lot + floors + 
    ##     waterfront + view + condition + grade + sqft_above + yr_built + 
    ##     yr_renovated
    ## 
    ##                Df  Sum of Sq        RSS    AIC
    ## - sqft_above    1 3.6420e+09 8.1763e+14 424698
    ## - yr_renovated  1 8.3210e+09 8.1764e+14 424698
    ## <none>                       8.1763e+14 424700
    ## - floors        1 1.5320e+12 8.1916e+14 424730
    ## - sqft_lot      1 1.5966e+12 8.1923e+14 424732
    ## - condition     1 2.0819e+12 8.1971e+14 424742
    ## - bathrooms     1 6.2855e+12 8.2391e+14 424830
    ## - bedrooms      1 1.3485e+13 8.3111e+14 424980
    ## - view          1 1.4101e+13 8.3173e+14 424993
    ## - waterfront    1 4.4318e+13 8.6195e+14 425610
    ## - sqft_living   1 5.1363e+13 8.6899e+14 425750
    ## - yr_built      1 9.5046e+13 9.1268e+14 426598
    ## - grade         1 1.2785e+14 9.4548e+14 427208
    ## 
    ## Step:  AIC=424697.9
    ## price ~ bedrooms + bathrooms + sqft_living + sqft_lot + floors + 
    ##     waterfront + view + condition + grade + yr_built + yr_renovated
    ## 
    ##                Df  Sum of Sq        RSS    AIC
    ## - yr_renovated  1 8.3135e+09 8.1764e+14 424696
    ## <none>                       8.1763e+14 424698
    ## + sqft_above    1 3.6420e+09 8.1763e+14 424700
    ## - sqft_lot      1 1.6330e+12 8.1927e+14 424730
    ## - floors        1 1.7465e+12 8.1938e+14 424733
    ## - condition     1 2.1007e+12 8.1973e+14 424740
    ## - bathrooms     1 6.5249e+12 8.2416e+14 424833
    ## - bedrooms      1 1.3483e+13 8.3112e+14 424978
    ## - view          1 1.4550e+13 8.3218e+14 425001
    ## - waterfront    1 4.4336e+13 8.6197e+14 425608
    ## - yr_built      1 9.6324e+13 9.1396e+14 426620
    ## - sqft_living   1 9.9873e+13 9.1750e+14 426687
    ## - grade         1 1.3077e+14 9.4841e+14 427259
    ## 
    ## Step:  AIC=424696.1
    ## price ~ bedrooms + bathrooms + sqft_living + sqft_lot + floors + 
    ##     waterfront + view + condition + grade + yr_built
    ## 
    ##                Df  Sum of Sq        RSS    AIC
    ## <none>                       8.1764e+14 424696
    ## + yr_renovated  1 8.3135e+09 8.1763e+14 424698
    ## + sqft_above    1 3.6344e+09 8.1764e+14 424698
    ## - sqft_lot      1 1.6306e+12 8.1927e+14 424728
    ## - floors        1 1.7652e+12 8.1941e+14 424731
    ## - condition     1 2.1157e+12 8.1976e+14 424739
    ## - bathrooms     1 6.7220e+12 8.2436e+14 424836
    ## - bedrooms      1 1.3521e+13 8.3116e+14 424977
    ## - view          1 1.4574e+13 8.3221e+14 424999
    ## - waterfront    1 4.4581e+13 8.6222e+14 425611
    ## - sqft_living   1 9.9866e+13 9.1751e+14 426685
    ## - yr_built      1 1.0872e+14 9.2636e+14 426851
    ## - grade         1 1.3080e+14 9.4844e+14 427258

``` r
summary(housing_step_mod)
```

    ## 
    ## Call:
    ## lm(formula = price ~ bedrooms + bathrooms + sqft_living + sqft_lot + 
    ##     floors + waterfront + view + condition + grade + yr_built, 
    ##     data = housing_train)
    ## 
    ## Residuals:
    ##      Min       1Q   Median       3Q      Max 
    ## -1286988  -110413    -9692    90229  4141832 
    ## 
    ## Coefficients:
    ##               Estimate Std. Error t value Pr(>|t|)    
    ## (Intercept)  6.247e+06  1.460e+05  42.788  < 2e-16 ***
    ## bedrooms    -3.823e+04  2.263e+03 -16.897  < 2e-16 ***
    ## bathrooms    4.601e+04  3.862e+03  11.914  < 2e-16 ***
    ## sqft_living  1.693e+02  3.688e+00  45.922  < 2e-16 ***
    ## sqft_lot    -2.280e-01  3.886e-02  -5.868 4.49e-09 ***
    ## floors       2.354e+04  3.856e+03   6.105 1.05e-09 ***
    ## waterfront   6.341e+05  2.067e+04  30.683  < 2e-16 ***
    ## view         4.362e+04  2.486e+03  17.543  < 2e-16 ***
    ## condition    1.858e+04  2.780e+03   6.684 2.39e-11 ***
    ## grade        1.261e+05  2.399e+03  52.555  < 2e-16 ***
    ## yr_built    -3.603e+03  7.520e+01 -47.914  < 2e-16 ***
    ## ---
    ## Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1
    ## 
    ## Residual standard error: 217600 on 17266 degrees of freedom
    ## Multiple R-squared:  0.6566, Adjusted R-squared:  0.6564 
    ## F-statistic:  3301 on 10 and 17266 DF,  p-value: < 2.2e-16

``` r
# Ridge Regression
y <- housing_train$price
x <- housing_train %>% dplyr::select (bedrooms, bathrooms, sqft_living, sqft_lot, floors, waterfront, view, condition, grade, sqft_above, yr_built, yr_renovated) %>% data.matrix()
test_x <- housing_test %>% dplyr::select (bedrooms, bathrooms, sqft_living, sqft_lot, floors, waterfront, view, condition, grade, sqft_above, yr_built, yr_renovated) %>% data.matrix()
test_y <- housing_test$price

ridge_fit <- cv.glmnet (x, y, alpha = 0)
plot(ridge_fit)
```

![ridge_fit](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-10-1.png)

``` r
optimal_lambda <- ridge_fit$lambda.min
summary (ridge_fit, s = optimal_lambda)
```

    ##            Length Class  Mode     
    ## lambda     100    -none- numeric  
    ## cvm        100    -none- numeric  
    ## cvsd       100    -none- numeric  
    ## cvup       100    -none- numeric  
    ## cvlo       100    -none- numeric  
    ## nzero      100    -none- numeric  
    ## call         4    -none- call     
    ## name         1    -none- character
    ## glmnet.fit  12    elnet  list     
    ## lambda.min   1    -none- numeric  
    ## lambda.1se   1    -none- numeric

``` r
ridge_fit$glmnet.fit
```

    ## 
    ## Call:  glmnet(x = x, y = y, alpha = 0) 
    ## 
    ##     Df    %Dev    Lambda
    ## 1   12 0.00000 261000000
    ## 2   12 0.00625 237800000
    ## 3   12 0.00686 216700000
    ## 4   12 0.00752 197400000
    ## 5   12 0.00824 179900000
    ## 6   12 0.00904 163900000
    ## 7   12 0.00990 149300000
    ## 8   12 0.01085 136100000
    ## 9   12 0.01189 124000000
    ## 10  12 0.01303 113000000
    ## 11  12 0.01428 102900000
    ## 12  12 0.01564  93790000
    ## 13  12 0.01712  85460000
    ## 14  12 0.01875  77870000
    ## 15  12 0.02052  70950000
    ## 16  12 0.02246  64650000
    ## 17  12 0.02457  58900000
    ## 18  12 0.02687  53670000
    ## 19  12 0.02938  48900000
    ## 20  12 0.03211  44560000
    ## 21  12 0.03508  40600000
    ## 22  12 0.03831  36990000
    ## 23  12 0.04182  33710000
    ## 24  12 0.04562  30710000
    ## 25  12 0.04975  27980000
    ## 26  12 0.05422  25500000
    ## 27  12 0.05905  23230000
    ## 28  12 0.06427  21170000
    ## 29  12 0.06989  19290000
    ## 30  12 0.07595  17570000
    ## 31  12 0.08246  16010000
    ## 32  12 0.08945  14590000
    ## 33  12 0.09693  13290000
    ## 34  12 0.10490  12110000
    ## 35  12 0.11350  11040000
    ## 36  12 0.12250  10060000
    ## 37  12 0.13220   9163000
    ## 38  12 0.14230   8349000
    ## 39  12 0.15310   7608000
    ## 40  12 0.16440   6932000
    ## 41  12 0.17620   6316000
    ## 42  12 0.18860   5755000
    ## 43  12 0.20150   5244000
    ## 44  12 0.21490   4778000
    ## 45  12 0.22870   4353000
    ## 46  12 0.24290   3967000
    ## 47  12 0.25750   3614000
    ## 48  12 0.27240   3293000
    ## 49  12 0.28750   3001000
    ## 50  12 0.30290   2734000
    ## 51  12 0.31830   2491000
    ## 52  12 0.33370   2270000
    ## 53  12 0.34920   2068000
    ## 54  12 0.36460   1884000
    ## 55  12 0.37980   1717000
    ## 56  12 0.39470   1565000
    ## 57  12 0.40940   1426000
    ## 58  12 0.42380   1299000
    ## 59  12 0.43780   1184000
    ## 60  12 0.45140   1078000
    ## 61  12 0.46450    982600
    ## 62  12 0.47710    895300
    ## 63  12 0.48920    815700
    ## 64  12 0.50080    743300
    ## 65  12 0.51180    677200
    ## 66  12 0.52230    617100
    ## 67  12 0.53230    562300
    ## 68  12 0.54180    512300
    ## 69  12 0.55070    466800
    ## 70  12 0.55910    425300
    ## 71  12 0.56690    387500
    ## 72  12 0.57430    353100
    ## 73  12 0.58130    321700
    ## 74  12 0.58770    293200
    ## 75  12 0.59370    267100
    ## 76  12 0.59940    243400
    ## 77  12 0.60460    221800
    ## 78  12 0.60940    202100
    ## 79  12 0.61380    184100
    ## 80  12 0.61790    167800
    ## 81  12 0.62170    152900
    ## 82  12 0.62520    139300
    ## 83  12 0.62840    126900
    ## 84  12 0.63130    115600
    ## 85  12 0.63400    105400
    ## 86  12 0.63640     96000
    ## 87  12 0.63860     87470
    ## 88  12 0.64060     79700
    ## 89  12 0.64240     72620
    ## 90  12 0.64400     66170
    ## 91  12 0.64540     60290
    ## 92  12 0.64670     54930
    ## 93  12 0.64790     50050
    ## 94  12 0.64890     45610
    ## 95  12 0.64990     41550
    ## 96  12 0.65070     37860
    ## 97  12 0.65140     34500
    ## 98  12 0.65210     31430
    ## 99  12 0.65260     28640
    ## 100 12 0.65310     26100

Model Predictions
-----------------

``` r
housing_full_pred <- predict (housing_full_mod, housing_test)
plot (housing_full_pred)
```

![full_pred_plot](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-11-1.png)

``` r
housing_step_pred <- predict (housing_step_mod, housing_test)
plot (housing_step_pred)
```

![stepwise_pred_plot](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-11-2.png)

``` r
housing_ridge_pred <- predict (ridge_fit, s = optimal_lambda, newx = test_x)
plot (housing_ridge_pred)
```

![ridge_pred_plot](https://yunkevin.github.io/assets/img/multiple_reg_analysis/figure-markdown_github/unnamed-chunk-11-3.png)

Model Comparisons
-----------------

``` r
RMSE <- function (error) {sqrt(mean(error^2))}
rsquare <- function(true, predicted) {
  sse <- sum((predicted - true)^2)
  sst <- sum((true - mean(true))^2)
  rsq <- 1 - sse / sst
  return (rsq)
}

# Multiple Regression
full_r_squared <- sprintf (summary(housing_full_mod)$r.squared, fmt = '%#.3f')
full_MAE = sprintf (mean(abs(housing_full_pred - housing_test$price)), fmt = '%#.3f')
full_RMSE <- sprintf (RMSE (housing_full_mod$residuals), fmt = '%#.3f')
multiple_regression_info <- c("Multiple Regression", full_RMSE, full_r_squared, full_MAE)

# Stepwise Regression
stepwise_r_squared <- sprintf (summary(housing_step_mod)$r.squared, fmt = '%#.3f')
stepwise_MAE = sprintf (mean(abs(housing_step_pred - housing_test$price)), fmt = '%#.3f')
stepwise_RMSE <- sprintf (RMSE (housing_step_mod$residuals), fmt = '%#.3f')
stepwise_regression_info <- c("Stepwise Regression", stepwise_RMSE, stepwise_r_squared, stepwise_MAE)

# Ridge Regression
ridge_r_squared <- sprintf (rsquare (test_y, housing_ridge_pred), fmt = '%#.3f')
ridge_MAE = sprintf (mean(abs(housing_ridge_pred - housing_test$price)), fmt = '%#.3f')
ridge_RMSE <- sprintf (RMSE(housing_ridge_pred - test_y), fmt = '%#.3f')
ridge_regression_info <- c("Ridge Regression", ridge_RMSE, ridge_r_squared, ridge_MAE)

# Table Formatting
columns <- c("Model", "RMSE", "R-Squared", "MAE")
final_table <- rbind (c("Model", "RMSE", "R-Squared", "MAE"), 
                      c("Multiple Regression", full_RMSE, full_r_squared, full_MAE), 
                      c("Stepwise Regression", stepwise_RMSE, stepwise_r_squared, stepwise_MAE), 
                      c("Ridge Regression", ridge_RMSE, ridge_r_squared, ridge_MAE))
final_table
```

    ##      [,1]                  [,2]         [,3]        [,4]        
    ## [1,] "Model"               "RMSE"       "R-Squared" "MAE"       
    ## [2,] "Multiple Regression" "217542.399" "0.657"     "137672.872"
    ## [3,] "Stepwise Regression" "217543.990" "0.657"     "137712.494"
    ## [4,] "Ridge Regression"    "213128.787" "0.632"     "137238.603"

From looking at the final table, we see that the stepwise regression
model had the lowest r-squared value. Albeit very close to the multiple
regression model. Given the context of the question, I will be
prioritizing RMSE as it penalizes larger errors more severely. Since I’m
trying to build a model to predict house prices, I thought it made sense
that I take larger errors more seriously. As such, out of the three
regression models, the multiple regression model appears to be
best-fitting model to the dataset. It has the lowest r-squared, RMSE,
and MAE values. Although the r-squared value is a bit lower than I would
prefer, it still is the best model out of the three.
