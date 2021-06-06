# OrderSimulationMockUp 
Is the programming task to mock the broker where an order can be placed and get the status of an order.

***Technologies***

Spring Boot and an embeddded database H2, ide Eclipse was used with it's application properties in src/main/resources. Here you can also find the Mockorder table creation and insertion of some test data which is created and destroyed each time we deploy the app. 


***Database***

Object MockOrder is an object with id, security, order_type and status. This is mapped directly in the embedded DB by means of javax persistence API. 

***Api***

-**MockOrderRepository**: extends CRUDRepository where use of findById and save methods.

-**MockOrderService**: MockOrderRepository is used in the service layer adding methods getMockOrderStatusById and addMockOrder.

-**OrderRest**: making use of spring boot annotations 2 methods are created. One getOrderStatus and another placeOrder.


***Testing***

-**order-status/{id}**:  this can be tested simply by using the link [http://localhost:8080/order-status/1](http://localhost:8080/order-status/1) where 1 is the id of a MockOrder inserted by default in the embedded DB. This can be seen in image order-status.png.

-**place-order**: this can be tested by using Postman application. Using post with link: http://localhost:8080/place-order and body as following: {
    "authdata":{
        "security":"DE000BASF111",
        "order_type":"Buy"
    }
}. As no price is indicated 0.0 is set by default and the status is set to Pending. Id is created randombly and returned in order to get the order status. This can be seen in image place-order.png 

