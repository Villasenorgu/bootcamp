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

SELECT title, rental_rate, length FROM film
ORDER BY rental_rate/LENGTH DESC

