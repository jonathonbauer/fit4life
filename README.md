# Fit4Life <br/> Gym Membership Management Software

Fit4Life is a database management software used to maintain the members of a fitness center.
<br/>
It allows the user to Create, Read, Update and Delete gym Members, Managers, Cities, Locations and Amenities.

## Getting Started

To run the software simply clone the project and run the Main class in the main package.
<br/>
You will be asked to input your database information and create a user.
<br/>

## Prerequisites

You will need to have a database created and ready to go, and you will need the credentials for the server.

## Creating Records and Sample Data

When you first begin to use the software, you will need to input your City records first, followed by the Location records. 
<br/>
This will then allow you to input your Member records, as a Member record requires both a City and a Location.
<br/>
Here is some sample data to be imported into the database. You will need to import them in the order listed.
<br/>

[Cities](https://github.com/jonathonbauer/fit4life/raw/readMe/src/sampledata/cities.sql)
<br/>
[Locations](https://github.com/jonathonbauer/fit4life/raw/readMe/src/sampledata/locations.sql) 
<br/>
[Managers](https://github.com/jonathonbauer/fit4life/raw/readMe/src/sampledata/managers.sql) 
<br/>
[Members](https://github.com/jonathonbauer/fit4life/raw/readMe/src/sampledata/members.sql) 
<br/>
[Amenities](https://github.com/jonathonbauer/fit4life/raw/readMe/src/sampledata/amenities.sql)  

## Mockup

![Initialization Page](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/initialization.PNG)
![Login Page](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/login.PNG)
![View Records](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/viewMember.PNG)
![New Record](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/newMember.PNG)
![Report](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/locationReport.PNG)

## Database Design

![Database Design](https://github.com/jonathonbauer/fit4life/raw/readMe/src/images/databaseSchema.png)


## Authors

| Name             | Github                                              |                           Email     |
| -------------    | --------------------------------------------------- | ----------------------------------- |
| Jonathon Bauer   | [jonathonbauer](https://github.com/jonathonbauer)   | jonathon.bauer01@stclairconnect.ca  |
| Cody Pollard     | [CPollard187](https://github.com/CPollard187)       | cody.pollard01@stclairconnect.ca    |
| Joseph Bumbacco  | [josephbumbacco](https://github.com/josephbumbacco) | joseph.bumbacco01@stclairconnect.ca |
| Grant Norris     | [Grant-Norris](https://github.com/Grant-Norris)    | grant.norris01@stclairconnect.ca    |


## License
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
## Acknowledgments

 [Mockaroo](https://mockaroo.com/) - used to create sample data while working on the application.