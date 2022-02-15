·Obtener todos los actores de nombre ‘NICK’.

SELECT * FROM actor WHERE first_name = 'NICK'

·Obtener una lista con todos los distritos distintos (district en address).

SELECT district FROM address 
WHERE district IS NOT NULL
ORDER BY district

·Obtener las películas sobre agentes secretos (description contiene ‘Secret Agent’).

SELECT title, description FROM film
WHERE description LIKE '%Secret Agent%'
ORDER BY title

·Mostrar la lista de las películas mas caras (coste por minuto)

SELECT title, rental_rate, length, rental_rate/LENGTH AS precioMinuto FROM film
ORDER BY rental_rate/LENGTH DESC

·Obtener los códigos y medias de gasto de los clientes que han gastado mas de 100 en menos de 25 operaciones.

SELECT customer_id cliente, count(amount) numeroDeALquileres ,SUM(amount) total, AVG(amount) media
FROM payment
GROUP BY cliente
HAVING count(amount) < 25 AND SUM(amount) > 100

·Obtener los 5 nombres de actor más repetidos (aprox).

SELECT first_name , COUNT(first_name) repeticiones
FROM customer
GROUP BY first_name
ORDER BY repeticiones DESC
LIMIT 5

·Para felicitar el año nuevo chino se necesita el listado con los datos postales de los clientes residentes en China y Taiwan.

SELECT c.first_name, c.last_name, a.address, a.postal_code, ci.city, co.country
FROM customer AS c
INNER JOIN
(address AS a INNER JOIN city AS ci INNER JOIN country AS co ON ci.country_id = co.country_id ON a.city_id = ci.city_id)
ON c.address_id = ci.city_id
WHERE co.country LIKE 'China' OR co.country LIKE 'Taiwan'

·Mostrar los datos de las tiendas, conocidas por la ciudad y país donde están ubicadas, indicando el nombre del gerente, el numero de películas en inventario, el numero de títulos diferentes y el número de clientes atendidos.

SELECT s.store_id Tienda, s.first_name Nombre, s.last_name Apellido, ci.city Ciudad, co.country Pais, count(inv.film_id) 'Nº de Peliculas', COUNT(DISTINCT inv.film_id) 'Peliculas Diferentes', COUNT(DISTINCT cus.store_id) 'Nº de Clientes'
FROM staff AS s
INNER JOIN
(address AS a INNER JOIN city AS ci INNER JOIN country AS co ON ci.country_id = co.country_id ON a.city_id = ci.city_id)
ON s.address_id = a.address_id
INNER JOIN inventory AS inv ON s.store_id = inv.store_id
INNER JOIN customer AS cus ON s.store_id = cus.store_id
GROUP BY s.staff_id

·Obtener el listado detallado de alquileres indicando el identificador de alquiler, el titulo alquilado, las fechas de alquiler, devolución y tiempo transcurrido, nombres del cliente (nombre con apellidos), empleado (nombre con apellidos) y tienda (ciudad, país).

SELECT r.rental_id, fT.title Titulo, r.rental_date 'Fecha de alquiler', r.return_date 'Fecha de devolcuion', DATEDIFF(CURRENT_DATE,r.rental_date) AS tiempoAlquilado, cus.first_name 'Nombre de Cliente', cus.last_name 'Apellido de Cliente', sta.first_name 'Nombre Trabajador', sta.last_name 'Apellido Trabajador', ci.city 'Ciudad de la tienda', co.country 'Pais de la tienda'
FROM rental AS r
INNER JOIN
(staff AS sta INNER JOIN address AS a INNER JOIN city AS ci INNER JOIN country AS co ON ci.country_id = co.country_id ON a.city_id = ci.city_id ON a.address_id = sta.address_id)
ON r.staff_id = sta.staff_id
INNER JOIN inventory AS inv INNER JOIN film_text AS fT ON fT.film_id = inv.film_id ON inv.inventory_id = r.inventory_id
INNER JOIN customer AS cus ON r.customer_id = cus.customer_id
GROUP BY r.rental_id

·Generar la lista diaria de alquileres vencidos no devueltos para poder llamar a los clientes y pedirles que los devuelvan, para ello debe mostrar las fechas de alquiler y vencimiento, el teléfono y nombre del cliente, así como el titulo de la película, priorizando los que mas tiempo llevan vencidos.

SELECT r.rental_id, fT.title Titulo, r.rental_date 'Fecha de alquiler', r.return_date 'Fecha de devolcuion', DATEDIFF(CURRENT_DATE,r.rental_date)+' dias' AS tiempoAlquilado, cus.first_name 'Nombre de Cliente', cus.last_name 'Apellido de Cliente', a.phone 'Teléfono'
FROM rental AS r
INNER JOIN
(staff AS sta INNER JOIN address AS a INNER JOIN city AS ci INNER JOIN country AS co ON ci.country_id = co.country_id ON a.city_id = ci.city_id ON a.address_id = sta.address_id)
ON r.staff_id = sta.staff_id
INNER JOIN inventory AS inv INNER JOIN film_text AS fT ON fT.film_id = inv.film_id ON inv.inventory_id = r.inventory_id
INNER JOIN customer AS cus ON r.customer_id = cus.customer_id
GROUP BY r.rental_id
HAVING r.return_date IS NULL
ORDER BY tiempoAlquilado DESC, cus.first_name

·Elaborar el ranking de los países que más alquilan las películas de GINA DEGENERES.

SELECT actor.actor_id,actor.first_name,actor.last_name, co.country 'Pais', count(r.rental_id) AS numeroDeAlquileres 
FROM actor 
INNER JOIN film_actor AS fA INNER JOIN film AS f INNER JOIN inventory AS i INNER JOIN rental AS r INNER JOIN customer AS c INNER JOIN address AS ad INNER JOIN city AS ci INNER JOIN country AS co ON co.country_id=ci.country_id ON ci.city_id= ad.city_id ON ad.address_id=c.address_id ON c.customer_id=r.customer_id ON r.inventory_id=i.inventory_id ON i.film_id=f.film_id ON f.film_id = fA.film_id ON fA.actor_id = actor.actor_id
GROUP BY actor.actor_id, co.country
HAVING actor.first_name LIKE "GINA"
ORDER BY numeroDeAlquileres DESC