<center>
<h1> 🏚️Restaurant Management System</h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This project is Restaurant Management System built using Spring Boot with Java.

---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---

## Data Model

The All ...ModelClass  is defined inside the model packages which has the following attributes:
   
   inside Costumber Model:-<br>
   
     Long costumberId
     String costumberEmailId
     String costumberPassword
     String costumberFirstName
     String costumberLastName
     String costumberAddress
     String costumberMobileNumber
  
   
   
  Food Model:- <br>
   
     Long foodsID
     String foodsName
     Double price

    @ManyToOne(cascade = CascadeType.ALL)
    Restaurant restaurant
  
 Restaurant Model:- <br>
   
     Long restaurantID
     String restaurantName
     String restaurantAddress
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "restaurant")
     List<Foods> foods

   
 Order Food Model:- <br>
   
  
   private Long orderId<br>

    @OneToOne
    private Restaurant restaurant

    @OneToOne
    private Foods foods

---

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## Functions used :-

### API Endpoints :-
</br>
<b> SignUp </b>

* PostMapping: /SignUp/SignIn

This endpoint makes a call to method in CostumberService class which is connected to database. In database we add a new User given through API.


* GetMapping: 

This endpoint returns AllRestaurant  through API.


* PutMapping: 

This endpoint makes a call to OrderFoodService class which is connected to database. In database Order Foods.



---
<b> addFood </b>

* PostMapping: 

This endpoint makes a call to method in FoodService class which is connected to database. In database we add a Food given through API.




---

## JpaRepository extended by Repository class , Repository class is interface Type.


I have used JpaRepository as a database to implement CRUD Operations.

---

## 📝Project Summary

I have created Restaurant Management System Project.  In this project I have used @OneToOne maping , @ManyToOne mapping and the user will have to SignUp and SignIn first then user can do all operation like.  Can get all Restaurant ,can  Order Foods etc...
