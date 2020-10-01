# Status Monitor

## Introdcution

A [Spring Boot](https://spring.io/projects/spring-boot) service to create such HTML Status Monitor views :

<img src="https://www.dropbox.com/s/isbhvgbwr241wsc/statusmonitorv2.jpeg?raw=1" alt="Status Monitor Demo">
<br/>
<img src="https://www.dropbox.com/s/h8qrjleinlpiizo/linklist.jpeg?raw=1" alt="Link List to use Status Monitor manually">
<br/>
<img src="https://www.dropbox.com/s/ph4s0rd5efv16n7/editproperty.jpeg?raw=1" alt="How to edit a property manually">
<br/>
<img src="https://www.dropbox.com/s/8wfz7kwwp5uy3du/editlevel.jpeg?raw=1" alt="How to edit a level manually">

## What It Does

Statusmonitor is a service where you can send key-value properties via HTTP to display them in tiles, which are called sections.

A section can has sub sections, a property has always section-subsection-key-value.

Statusmonitor displays the sections in the order their properties were changed, the latest changed section is displayed in the left upper corner
and from there left to right, top down.

Statusmonitor can have any amount of pages, they are called levels.

A level has a number and a background pattern.

A section has a level and a background color

You can change the level and background color of a section while setting a property. This enables you e.g. to alert the user by putting a section to level 1 and setting its background color red.

## Showcase for Test Execution

Imagine you want to show the status of your system test execution runs.

Some are passed (green), some are ongoing (blue), some have already failed tests or finished failed (orange) and in one run a special problems occured where manual help is needed (fire brick red).

This is how your run status information could be presented :

<img src="https://www.dropbox.com/s/ian8wdq1paz71rs/showcase1.jpeg?raw=1" alt="Status Monitor For Test Execution">
<br/>

## How To Compile

`gradlew bootJar`

## How To Run

`java -jar build/libs/gradle-spring-boot-project.jar` 

## Start URL

`http://localhost:8080/links`

## Yes, So Much Documentation Is Missing ...

... please forgive me, I will add more when there is time for it ...
