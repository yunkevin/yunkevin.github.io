Loading Packages
================

``` r
library(ggplot2)
library(scales)
library(forecast)
library(timeSeries)
library(timeDate)
library(tseries)
```

Importing & Overview of Data
============================

``` r
dow_index <- read.csv("/Volumes/Macintosh\ HD\ -\ Data/RWorkspace/Dow.csv")
head(dow_index)
```

    ##         Date     Open     High      Low    Close Adj.Close     Volume
    ## 1 2010-04-19 11116.91 11205.64 11016.40 11204.28  11204.28  610960000
    ## 2 2010-04-26 11205.11 11258.01 10965.38 11008.61  11008.61 1141520000
    ## 3 2010-05-03 11009.60 11177.67  9869.62 10380.43  10380.43 1527630000
    ## 4 2010-05-10 10386.18 10920.27 10386.03 10620.16  10620.16 1191910000
    ## 5 2010-05-17 10616.98 10718.86  9918.82 10193.39  10193.39 1533190000
    ## 6 2010-05-24 10193.46 10264.20  9774.48 10136.63  10136.63 1352960000

The stock that we’re going to be using for our time series analysis is
the Dow Jones Industrial Average
(<a href="https://en.wikipedia.org/wiki/Dow_Jones_Industrial_Average" class="uri">https://en.wikipedia.org/wiki/Dow_Jones_Industrial_Average</a>).
To put it simply, it’s an stock performance index of the top 30
companies in the US. The data were downloaded from Yahoo Finances
(<a href="https://finance.yahoo.com/quote/%5EDJI/" class="uri">https://finance.yahoo.com/quote/%5EDJI/</a>).

Cleaning Data
-------------

``` r
# Extracting the columns 'Date' and 'Adj.Close'
dow_date <- as.Date(dow_index$Date, format ="%Y-%m-%d")
dow <- cbind.data.frame(dow_date, dow_index$Adj.Close)
colnames(dow) <- c("Date", "Adj.Price")
```

Plot of Dow Jones Industrial Average
------------------------------------

``` r
ggplot(dow, aes(x = Date, y = Adj.Price, group = 1)) + 
  geom_line() + 
  coord_cartesian() + 
  theme_minimal() + 
  labs(title = "Prices of Dow Jones Industrial Average",
       subtitle = "From: 2010-04-21 To: 2020-04-21",
       x = "Date",
       y = "Price",
       caption = "Data source: Yahoo Finance"
       ) +
  scale_x_date(date_breaks = "6 month") +
  theme(axis.text.x=element_text(angle=40, hjust=1))
```

![Dow Plot](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-4-1.png)

The plot clearly indicates an upward trend in the stock prices since 2010. 
However, there doesn’t appear to be a definite trend or a pattern
on the plot. Like many other stock price datasets, there is a good
chance that the data is not stationary.

Analysis
========

``` r
# Stock Price from 2010-2020
dow_ts <- ts(dow$Adj.Price, start = c(2010), frequency = 52)

# Decomposing of time series in to components
components_dow <- decompose(dow_ts)
plot(components_dow)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-5-1.png)

By decomposing the time series data, we are able to observe three
components of a time series data: trend, seasonal, and random
components. The trend of the data set is an obvious upward trend. We
also note that there is a seasonal component as well as a random
component.

Testing for Stationarity
------------------------

``` r
# Dickey-Fuller Test - Checking for Stationarity 
tseries::adf.test(dow_ts, alternative = "stationary")
```

    ## 
    ##  Augmented Dickey-Fuller Test
    ## 
    ## data:  dow_ts
    ## Dickey-Fuller = -2.9342, Lag order = 8, p-value = 0.1829
    ## alternative hypothesis: stationary

``` r
# Differenced Data
diff_dow_ts <- diff(dow_ts)
plot(diff_dow_ts)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-6-1.png)

``` r
# Dickey-Fuller Test on Log-Differenced Data
tseries::adf.test(diff_dow_ts, alternative = "stationary")
```

    ## Warning in tseries::adf.test(diff_dow_ts, alternative = "stationary"): p-value
    ## smaller than printed p-value

    ## 
    ##  Augmented Dickey-Fuller Test
    ## 
    ## data:  diff_dow_ts
    ## Dickey-Fuller = -7.678, Lag order = 8, p-value = 0.01
    ## alternative hypothesis: stationary

Given the p-value from the result of the Dickey-Fuller test, we see that
the dataset is not stationary and needs adjustments. The plot of
differenced data shows a fairly consistent variance - apart from the
part at the end. As such, we decide to use differencing (of order 1) as
a method of transforming our data into a stationary one. The results of
the Dickey-Fuller test on the newly transformed data indicates that the
dataset is stationary and we’re good to go.

Choosing a Model
----------------

``` r
par(mfrow=c(1, 2))
# ACF Plot
acf(diff_dow_ts, lag.max = 52)
# PACF Plot
pacf(diff_dow_ts, lag.max = 52)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-7-1.png)

The next step is to choose a suitable model for the dataset.To do this,
we will take a look at auto-correlation function (ACF) and partial
auto-correlation function (PACF) to determine the parameters for the
ARIMA model.Given that we’ve already differenced once to make our data
set stationary, we know that our d is going to be 1. A few trends that
we should observe to identify an AR() model are sinusodal or
exponentially decaying ACF plot or a PACF plot with sharp spikes
followed by signficantly lower values. Neither of the conditions are
true which means that it is likely that our p will be equal to 0. When
identifying a MA() model, we check the opposite - sinusodal or
exponential decay of the PACF plot and an ACF plot with sharp spikes
followed by signficantly lower values. From looking at the ACF plot, we
see a spike at lag 4 followed by low values. On the PACF plot, the first
spike occurs at lag 3 which suggests that q = 3. Although we’re unsure
of whether our choices are correct, we will choose an ARIMA(0,1,3) for
now and see how it compares later on.

Building Model
--------------

``` r
# Fits dow_ts to an ARIMA model
dow_fit <- arima(dow_ts, order = c(0,1,3))

# Plots the forecast using the ARIMA model
autoplot(forecast::forecast(dow_fit))
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-8-1.png)

``` r
# Fits dow_ts to an ARIMA model according to lowest AIC, AICc, BIC value
dow_auto_fit <- auto.arima (dow_ts, d = 1)

# Plots the forecast using the ARIMA model
autoplot(forecast::forecast(dow_auto_fit))
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-8-2.png)

Here, we create two models - one is an ARIMA(0,1,3) that I’ve mentioned
before. The other model is picked automatically by auto.arima such that
the model minimizes either AIC, AICc or BIC value. In this case, we
ended up with an ARIMA(0,1,2) model.

Model Adequacy
--------------

``` r
# Creates diagonstic plots to check residuals
checkresiduals(dow_fit)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-9-1.png)

    ## 
    ##  Ljung-Box test
    ## 
    ## data:  Residuals from ARIMA(0,1,3)
    ## Q* = 123.04, df = 101, p-value = 0.06726
    ## 
    ## Model df: 3.   Total lags used: 104

First, for the ARIMA(0,1,3) model, we see that the results of the
Ljung-Box test indicates that the residuals are independently
distributed. We also note that the variance of the residuals is
relatively constant - outside of the fluctuations at the end. When it
comes to the autocorrelation of the residuals, we observe that there is
quite a bit of autocorrelation between the residuals - which is common
in many time series analysis. Lastly, the histogram is used to check the
distribution of the residuals. We can observe that the distribution of
the residuals resemble the normal distribution quite well.

``` r
# Creates diagonstic plots to check residuals
checkresiduals(dow_auto_fit)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-10-1.png)

    ## 
    ##  Ljung-Box test
    ## 
    ## data:  Residuals from ARIMA(0,1,2)
    ## Q* = 123.1, df = 102, p-value = 0.07608
    ## 
    ## Model df: 2.   Total lags used: 104

The residual diagnostics for the ARIMA(0,1,2) model is quite similar.
Passes the Ljung-Box test, relatively constant variance, some
autocorrelation between the residuals, and a distribution that follows
the normal distribution quite well. Overall, I don’t think there is a
huge difference between the ARIMA model that we chose vs. the ARIMA
model that R chose for us. The differences in their forecasts and
residual diagnostics appear to be negligible and an estimate of ARIMA
(0,1,3) was quite a reasonable one.

Alternate Data Set
==================

``` r
# Repeat of the above processes with a new data set
alt_dow_ts <- ts(dow$Adj.Price, start = c(2010), end = c(2019,12), frequency = 52)

# Dickey-Fuller Test - Checking for Stationarity 
tseries::adf.test(alt_dow_ts, alternative = "stationary")
```

    ## 
    ##  Augmented Dickey-Fuller Test
    ## 
    ## data:  alt_dow_ts
    ## Dickey-Fuller = -2.3034, Lag order = 7, p-value = 0.4497
    ## alternative hypothesis: stationary

``` r
# Differenced Data
diff_alt_dow_ts <- diff(alt_dow_ts)
plot(diff_alt_dow_ts)
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-11-1.png)

``` r
# Dickey-Fuller Test on Log-Differenced Data
tseries::adf.test(diff_alt_dow_ts, alternative = "stationary")
```

    ## Warning in tseries::adf.test(diff_alt_dow_ts, alternative = "stationary"): p-
    ## value smaller than printed p-value

    ## 
    ##  Augmented Dickey-Fuller Test
    ## 
    ## data:  diff_alt_dow_ts
    ## Dickey-Fuller = -8.2997, Lag order = 7, p-value = 0.01
    ## alternative hypothesis: stationary

``` r
# Fits alt_dow_ts to an ARIMA model according to lowest AIC, AICc, BIC value
alt_dow_auto_fit <- auto.arima (alt_dow_ts, d = 1)

# Plots the forecast using the ARIMA model
autoplot(forecast::forecast(alt_dow_auto_fit))
```

![](https://yunkevin.github.io/assets/img/ts_analysis/figure-markdown_github/unnamed-chunk-11-2.png)

Because the original analysis takes into account a massive crash in stock prices
due to COVID-19, our predictions are a bit lower than what the general
trend of stock prices would suggest. If we only take into account the
stock prices between 2010-2019, the result is significantly different. We
see that in an alternate world where COVID-19 did not exist, we would
expect the stock prices to continue climbing. Ideally, we would test our
predictions (2010-2019) against the 2010-2020 data but this process
seems quite meaningless given the sudden stock market crash. As there is
no mathematical model that can predict when a stock market crash will
happen - especially when it’s due to a pandemic.

References
==========

Hyndman, R.J., & Athanasopoulos, G. (2018) *Forecasting: principles and
practice*, 2nd edition, OTexts: Melbourne, Australia. OTexts.com/fpp2.
Accessed on April 24, 2020.
