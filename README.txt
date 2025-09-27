

Food Delivery App - Admin and User side APIs

To Order food online from the restaurants


basic rest apis : 
1. add a food item 
POST http://localhost:8080/addfooditem

body contains {
id, name, price
}

2. get all food items
GET http://localhost:8080/food

3. get food Item by id
GET http://localhost:8080/food/{id}

4. delete food by id
DELETE http://localhost:8080/food/{id}
