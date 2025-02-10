INSERT INTO users (user_id, name, email, password, phone_number, address, role, facebook_id, vehicle_info)
VALUES (1, 'Cesar T', 'cesar@example.com', 'password123', '123456789', '123 Main St', 'USER', NULL, NULL);

INSERT INTO restaurants (restaurant_id, name, category, owner_id, billing_info, location)
VALUES (1, 'Tasty Bites', 'FAST_FOOD', 1, 'Billing Info', '123 Restaurant St');

INSERT INTO food_items (food_item_id, name, description, price, restaurant_id, image_url)
VALUES (1, 'Cheeseburger', 'Delicious cheeseburger', 5.99, 1, 'http://example.com/burger.jpg');