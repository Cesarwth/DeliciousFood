#Book Aplication
* Prerequisites
  * Install Docker
  * Install Maven
  * Postman
  

* Run the application

  `mvn clean install`
  
  `docker-compose build`

  `docker-compose up`

Note: you can reach the application in POSTMAN in the next context:
  
  `http://localhost:8085/api/<resource>`

1. To create a room, use a POST method with the next body in JSON:

  `http://localhost:8085/api/room/`


Note: this is a simple example to create a room AVAILABLE:

      `{"id": 1,"room_description": "Simple","price": 50,"max_days_reservation":30,"max_stay_days": 3,"status": "AVAILABLE"}`

2. To place a reservation, use a POST method with the next body in JSON
   
   `http://localhost:8085/api/book/placeReservation/`


Note: this is a simple example to place a reservation:

       `{"reservationDescription":"Tests","dateReservation":"2021-10-14","dateCheckIn":"2021-10-20","dateCheckOut":"2021-10-22","passportNumber": "1722926282","name": "Cesar Tenemaza","phone": "0995228473","mail": "cesarwth@gmail.com","country": "Ecuador"}`

3. To modificate a reservation, use a POST method with the next body in JSON

   `http://localhost:8085/api/book/updateReservation/`


Note: this is a simple example to modify a reservation:

        `{"reservationDescription":"Tests","dateReservation":"2021-10-15","dateCheckIn":"2021-10-17","dateCheckOut":"2021-10-20","passportNumber": "1722926282","name": "Cesar Tenemaza","phone": "0995228473","mail": "cesarwth@gmail.com","country": "Ecuador"}`

4. To cancel a reservation, use a POST method with the next body in JSON

   `http://localhost:8085/api/book/cancelReservation/`


Note: this is a simple example to modify a reservation:
       `{"passportNumber": "1722926282"}`


###5. To get any resource as a response, use a GET method

 `http://localhost:8085/api/room/`
 `http://localhost:8085/api/user/`
 `http://localhost:8085/api/reservations/`


