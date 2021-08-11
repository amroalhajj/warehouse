# ClusteredData Warehouse

It's all about analyzing FX deals.

## Deal Format

The deal consist of the following parts:
**unique Id, Ordering Currency ISO Code, To Currency ISO Code, Deal timestamp, Deal Amount**.


## Business Logic
After accepting the deal record the system will validate structure according to **missing fields, Type format**. Then if it's valid the deal record will be saved to database.

## Technologies Used

For database I've used MySQL database, Angular for front-end application and spring boot for back-end.

## Back-End Structure

Back-end project consist of three tier which are:
- Model: which represented by the following packages:
	- com.clustered.data.warehouse.warehouse.entity
	- com.clustered.data.warehouse.warehouse.repository
- Service: which represented by com.clustered.data.warehouse.warehouse.service package that implements the business logic.
- Controller: which represented by com.clustered.data.warehouse.warehouse.adapter package that implements all Rest APIs.


## Database
Using Spring JPA Data tables will be created once the project run, you need to run this command to create the database schema:
> CREATE DATABASE `clustered_data_warehouse`;

Make sure to change the datasource properties at `application.properties` file.


