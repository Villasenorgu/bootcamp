function Ejercicio1(cad, cad2) {
  let ran = Math.floor(Math.random() * (cad - cad2)) + parseInt(cad2);
  return ran;
}

function Ejercicio2() {
  let ran = Ejercicio1(100, 0);
  let introducido;
  console.log(ran);

  for (let i = 10; i > 0; i--) {
    if (i == 10) {
      introducido = window.prompt("Intenta adivinar el numero entre 100 y 0");
    }
    if (parseInt(introducido) == parseInt(ran)) {
      return "Felicidades has acertado :)";
    } else {
      if (parseInt(introducido) > parseInt(ran)) {
        introducido = window.prompt("El número introducido es mayor que el buscado, intentalo de nuevo");
      } else {
        introducido = window.prompt("El número introducido es menor que el buscado, intentalo de nuevo");
      }
    }
  }
  return "Te quedaste sin intentos :(";
}

function Ejercicio3(vs, a) {

    let b = [];
    for(let i = 0; i<a; i++){
        b[i] = vs;
    }
    console.log(b);
}

function Ejercicio4(n) {
    let i = 2;
    let pAdded = 0;
    let np = [];
    while ( pAdded<n ) {        
        if(esPrimo(i)){
            np[pAdded] = i;
            pAdded++
        }
        i++
    }

    return np;

    function esPrimo(numero){
        for (var i = 2; i < numero; i++) {
            if (numero % i === 0) {
              return false;
            }      
          }       
          return numero !== 1;
    }
}

function Ejercicio5(nif){
    if(nif.length != 9){
        return "Esto no es un nif, no tiene el número de caracteres adecuado.";
    }
    for(let i = 0; i<nif.length-1; i++){
        if(isNaN(nif[i])){
            return "Esto no es un nif, el carácter "+nif[i] +" no es un número. Los primeros 8 caracteres deben ser números.";
        }
    }
    if(typeof nif[8] == 'number'){
        return "El último carácter debe ser una letra."
    }
    nif = nif.toUpperCase();
    if("TRWAGMYFPDXBNJZSQVHLCKE".charAt(parseInt( nif.substring(0, nif.length - 1)) % 23) 
    != nif.charAt(nif.length - 1)){
        return "El último carácter no es el que le corresponde a este NIF";
    }
    

    return "Felicidades, tu NIF es válido";

    
}

function Ejercicio6(s) {
    s = s.toLowerCase();
    s = s.trim();
    s = s.replace(/ /g,"").match(/[a-z]/gi).reverse();
    if(s.join('') !== s.reverse().join('')){
        return "No es un palíndromo";
    }
    return "Felicidades, es un palíndromo";

}