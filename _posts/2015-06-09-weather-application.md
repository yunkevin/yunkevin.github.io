---
layout: article
title: Weather Application
mathjax: true
show_edit_on_github: false
data_source: cs
tag: Computer Science
---

# Introduction 

This was a project done back in 2015 with a partner in a grade 12 computer science course. The purpose of the app was to create an application for his parent who works at an engineering company. The datasets were hourly climate data for an entire month. It consists of data such as temperature, dew point temperature, relative humidity, and many more. Because the dataset was large and complex (roughly 720 data points), the objective was to simplify the dataset into an easily digestable format that summarized key statistics. 

The program was coded in Java using object-oriented programming. The codes are available here: [Repository](https://github.com/yunkevin/yunkevin.github.io/tree/master/assets/data/weather_app/code/weather_app/src)

# Objective 

Create a tool to summarize dataset from Environment Canada consisting of:

* Dry bulb average
* Dew point average

For each range of temperatures and the number of datapoints per temperature range. 

# Discussion

The datasets are downloaded from Environment Canada. However, because the project is too old, the datasets released are in different formats to the one it was coded for back in 2015. As such, the following are test datasets to be used for demonstrating the use of the application. 

[Montreal_Data.csv](https://yunkevin.github.io/assets/data/weather_app/Montreal_150901.csv)

[Toronto_Data.csv](https://yunkevin.github.io/assets/data/weather_app/Toronto_150901.csv)

[Vancouver_Data.csv](https://yunkevin.github.io/assets/data/weather_app/Vancouver_150901.csv)

1. This is the main menu of the tool. There are numerous options to modify the dataset: temperature unit, temperature ranges for categorizing, and the hours for each day. ![Step_1](https://yunkevin.github.io/assets/img/weather_app/weather-app-s1.png)
2. This is the window that opens when "Select File" button is clicked. And as the name suggests, it's a plce to select the .csv file to be summarized. ![Step_2](https://yunkevin.github.io/assets/img/weather_app/weather-app-s2.png)
3. After loading the .csv file, you can select various options to customize the summarization. ![Step_3](https://yunkevin.github.io/assets/img/weather_app/weather-app-s3.png)
4. The summarized file is saved in the same directory as the original .csv file with the name "*filename*CONDENSED.csv". ![Step_4](https://yunkevin.github.io/assets/img/weather_app/weather-app-s4.png)
5. This is what the summarized file looks like. ![Step_5](https://yunkevin.github.io/assets/img/weather_app/weather-app-s5.png)











