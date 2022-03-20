/* AÑADIR f a describe, it , etc... (fdescribe, fit, etc...) para no realizar los que no estés forzando*/
/* pendind('')*/

describe('Pruebas de los ejercicios', () => {
    describe('Ejericio 1', () => {
        describe('OK', () => {
            it('Número Aleatorio', () =>{
                /*Con .and.returnValue(0.5) defino que resultado va a generar el Math.random*/
                let spy = spyOn(Math, "random").and.returnValue(0.5);
                let num = Ejercicio1(100,0);
                expect(spy).toHaveBeenCalled();
                expect(num).toBeGreaterThanOrEqual(0);
                expect(num).toBeLessThanOrEqual(100);
                expect(num).toBe(50);
            });
        });
        /*PARA COMPROBAR ERRORES SI HAY IMPLEMENTACIÓN DE ELLOS*/ 
        // describe('KO', () => {
        //     it('Falta parámetro', () => {
        //         expect(() => Ejercicio1(100)).toThrow();
        //     })
        // });
    });

    describe('Ejericio 3', () => {
        describe('OK Ejercicio3', () => {
            it('Arrays', () =>{
                let num = Ejercicio3(100,5);
                expect(num).toEqual([100,100,100,100,100]);
            });
        });
    });

    describe('Ejericio 4', () => {
        describe('OK Ejercicio4', () => {
            it('Primos', () =>{
                let num = Ejercicio4(25);
                expect(num).toEqual([2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]);
            });
        });
    });

    describe('Ejericio 5', () => {
        describe('NIF OK', () => {
            it('Validador de NiF', () =>{
                let num = Ejercicio5("12345678Z");
                expect(num).toBeTrue();
            });
        });

        describe('NIF KO', () => {
            it('Validador de NiF KO', () =>{
                let num = Ejercicio5("12345678L");
                expect(num).toBeFalse();
            });
        });
    });

    describe('Ejericio 6', () => {
        describe('Palindromo OK', () => {
            it('Validador Palindromo OK', () =>{
                let num = Ejercicio6("La ruta nos aporto otro paso natural.");
                expect(num).toBeTrue();
            });
        });

        describe('Palindromo KO', () => {
            it('Validador Palindromo KO', () =>{
                let num = Ejercicio6("Este no es un palindromo.");
                expect(num).toBeFalse();
            });
        });
    });

})