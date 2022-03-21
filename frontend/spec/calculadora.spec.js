describe('Pruebas de la calculadora', () => {
    // describe('Ejericio 1', () => {
    //     describe('OK', () => {
    //         it('Número Aleatorio', () =>{
    //             /*Con .and.returnValue(0.5) defino que resultado va a generar el Math.random*/
    //             let spy = spyOn(Math, "random").and.returnValue(0.5);
    //             let num = Ejercicio1(100,0);
    //             expect(spy).toHaveBeenCalled();
    //             expect(num).toBeGreaterThanOrEqual(0);
    //             expect(num).toBeLessThanOrEqual(100);
    //             expect(num).toBe(50);
    //         });
    //     });
    //     /*PARA COMPROBAR ERRORES SI HAY IMPLEMENTACIÓN DE ELLOS*/ 
    //     // describe('KO', () => {
    //     //     it('Falta parámetro', () => {
    //     //         expect(() => Ejercicio1(100)).toThrow();
    //     //     })
    //     // });
    // });

    describe('Calcula', () => {
            it('Suma', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "+";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(15);
            });

            it('Resta', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "-";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(5);
            });

            it('Producto', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "*";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(50);
            });

            it('Division', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "5";
                calculadora.operandoAnterior = "10";
                calculadora.operacion = "÷";
                calculadora.calcula();

                expect(calculadora.operandoActual).toEqual(2);
            });

            it('Borrar', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "58";
                calculadora.borrar();

                expect(calculadora.operandoActual).toEqual("5");
            });

            it('Añadir Numero', () =>{
                let calculadora = new Calculadora();
                
                calculadora.operandoActual = "58";
                calculadora.anadirNumero(0);

                expect(calculadora.operandoActual).toEqual("580");
            });
    });
})